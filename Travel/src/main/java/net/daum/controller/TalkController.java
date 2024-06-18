package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TalkController {

	@Autowired
	@GetMapping("/Talk")
	public String talk() {
		return "/jsp/talk";
	}

}
