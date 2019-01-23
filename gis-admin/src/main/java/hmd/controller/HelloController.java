package hmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/gis")
public class HelloController {

	@GetMapping("/hello")
	public String Hello() {
		log.info("@@@@@ /gis/hello");
		return "gis";
	}
}
