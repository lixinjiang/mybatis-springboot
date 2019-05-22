package cn.lxj.mybatis.controller;

import cn.lxj.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 * description
 * create class by lxj 2019/5/21
 **/
@RestController
@RequestMapping(value = {"/user"})
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
	public List getAllUsers() {
		return userService.findAllUser();
	}
}