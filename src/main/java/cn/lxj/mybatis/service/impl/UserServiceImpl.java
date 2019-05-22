package cn.lxj.mybatis.service.impl;

import cn.lxj.mybatis.dao.UserInfoMapper;
import cn.lxj.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * description
 * create class by lxj 2019/5/21
 **/
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserInfoMapper userDao;

	@Override
	public List findAllUser() {
		return userDao.findAllUser();
	}
}
