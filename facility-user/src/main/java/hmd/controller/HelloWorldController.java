//package hmd.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import hmd.domain.Bus;
//import hmd.domain.User;
//import hmd.service.BusService;
//import hmd.service.FacilityService;
//import hmd.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Controller
//@RequestMapping("/login/")
//public class HelloWorldController {
//
//	@Autowired
//	private FacilityService facilityService;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private BusService busService;
//	
//	/**
//	 * 모든 서비스 요청에 대한 이력
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "login")
//	public String index(HttpServletRequest request, Model model) {
//		log.info("------------ bus count = {}", busService.getBusTotalCount(new Bus()));
//		
//		userService.insertUser(new User());
//		
//		return "/login/login";
//	}
//}
