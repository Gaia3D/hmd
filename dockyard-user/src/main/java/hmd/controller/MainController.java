package hmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/dock")
	public String User() {
		log.info(">>>>> /dock");
		return "index";
	}
}
