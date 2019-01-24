package hmd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hmd.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login/")
public class LoginController {

	/**
	 * 로그인
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login")
	public String index(HttpServletRequest request, Model model) {
		
		UserInfo loginForm = new UserInfo();
		model.addAttribute("loginForm", loginForm);
		
		return "/login/login";
	}
}
