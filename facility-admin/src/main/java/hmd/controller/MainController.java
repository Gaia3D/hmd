package hmd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hmd.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request, Model model) {

        return "/index";
    }
}
