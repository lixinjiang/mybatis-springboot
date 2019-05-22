package cn.lxj.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * WebcomController
 * description
 * create class by lxj 2019/5/22
 **/
@Controller
public class WebcomController {
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello world");
		return "welcome";
	}
}