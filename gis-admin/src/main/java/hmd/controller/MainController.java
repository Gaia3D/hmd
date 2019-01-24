package hmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("gis")
	public String Main() {
		log.info("@@@@@ /gis");
		return "layout/main";
	}
	
	@GetMapping("test")
	public String Test() {
		log.info("@@@@@ /test");
		return "test/comm_layout";
	}
	
	@GetMapping("test2")
	public String Test2() {
		log.info("@@@@@ /test2");
		return "test/contents";
	}
	
	
}
