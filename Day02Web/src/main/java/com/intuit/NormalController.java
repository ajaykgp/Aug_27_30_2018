package com.intuit;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NormalController {

	
	@PostMapping("/process")
	public String processForm(@RequestParam String name, Model model) {
		model.addAttribute("msg", "Hello " + name);
		return "result";
	}

	
//	@PostMapping("/process")
//	public String processForm(@RequestParam String name, HttpSession session) {
//		session.setAttribute("msg", "Hello " + name);
//		return "result";
//	}
	
	
//	@PostMapping("/process")
//	@ResponseBody
//	public String processForm(@RequestParam String name) {
//		return "Hello " + name;
//	}
	@GetMapping("/")
	public String start() {
		return "index";
	}
}
