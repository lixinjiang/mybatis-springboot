package cn.lxj.mybatis.controller;

import cn.lxj.mybatis.bean.UserParam;
import cn.lxj.mybatis.pojo.UserInfo;
import cn.lxj.mybatis.result.Page;
import cn.lxj.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

	@RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
	public List getAllUsers() {
		return userService.findAllUser();
	}

	@RequestMapping("/getList")
	public Page<UserInfo> getList(UserParam userParam) {
		Page page = userService.getList(userParam);
		return page;
	}

	@RequestMapping("/getUser")
	public UserInfo getUser(Long id) {
		UserInfo userInfo = userService.getOne(id);
		return userInfo;
	}

	@RequestMapping("/addUser")
	public void saveUser(UserInfo userInfo) {
		int save = userService.save(userInfo);
		if (save == 1) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
	}

	@RequestMapping("/updateUser")
	public void update(UserInfo userInfo) {
		int update = userService.updateUser(userInfo);
		if (update == 1) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		int delete = userService.delete(id);
		if (delete == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
}