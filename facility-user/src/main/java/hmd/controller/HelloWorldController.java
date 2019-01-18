package hmd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hmd.domain.Facility;
import hmd.domain.User;
import hmd.service.FacilityService;
import hmd.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/hello/")
public class HelloWorldController {

	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 모든 서비스 요청에 대한 이력
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index.do")
	public String index(HttpServletRequest request, Model model) {
		userService.insertUser(new User());
		
		return "/hello/index";
	}
}
