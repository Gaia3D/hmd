package hmd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hmd.domain.Facility;
import hmd.domain.User;
import hmd.persistence.oracle.UserMapper;
import hmd.persistence.postgresql.FacilityMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/hello/")
public class HelloWorldController {

	@Autowired
	private FacilityMapper facilityMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 모든 서비스 요청에 대한 이력
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index.do")
	public String index(HttpServletRequest request, Model model) {
		User user = new User();
//		log.info("@@ ---- user count = {} ", userMapper.getUserTotalCount(user));
//		log.info("@@ ---- facility count {} ", facilityMapper.getFacilityTotalCount(new Facility()));
		return "/hello/index";
	}
}
