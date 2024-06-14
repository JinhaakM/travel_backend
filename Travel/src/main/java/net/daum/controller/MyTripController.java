package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyTripController {// MyTrip Controller
	@GetMapping("/mytrip")
	public String My_Trip() {
		return "jsp/my_trip";
	}
}
