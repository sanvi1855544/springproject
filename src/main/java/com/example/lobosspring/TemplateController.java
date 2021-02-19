package com.example.lobosspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
	@RequestMapping("/doodlejump")
	public String DoodleJump(){
		return "doodlejump";
	}

	@RequestMapping("/textbox")
	public String Textbox(){
		return "textbox";
	}

	@RequestMapping("/upvote")
	public String Upvote(){
		return "upvote";
	}

	@RequestMapping("/login")
	public String Login(){
		return "login";
	}

	@RequestMapping("/register")
	public String Register(){
		return "register";
	}
}
