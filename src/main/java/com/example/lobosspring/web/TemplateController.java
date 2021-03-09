package com.example.lobosspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
	@RequestMapping("/doodlejump")
	public String doodleJump(){
		return "doodlejump";
	}

	@RequestMapping("/experimental")
	public String experimental(){
		return "experimental";
	}

	@RequestMapping("/runningblock")
	public String runningBlock(){
		return "runningblock";
	}
}
