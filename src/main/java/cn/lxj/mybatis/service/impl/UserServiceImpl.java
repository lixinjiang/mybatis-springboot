package cn.lxj.mybatis.service.impl;

import cn.lxj.mybatis.bean.UserParam;
import cn.lxj.mybatis.dao.UserInfoMapper;
import cn.lxj.mybatis.pojo.UserInfo;
import cn.lxj.mybatis.result.Page;
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

	@Override
	public Page getList(UserParam userParam) {
		List<UserInfo> users = userDao.getList(userParam);
		long count = userDao.getCount(userParam);
		Page page = new Page(userParam, count, users);
		return page;
	}

	@Override
	public UserInfo getOne(Long id) {
		return userDao.getOne(id);
	}

	@Override
	public int save(UserInfo userInfo) {
		return userDao.insert(userInfo);
	}

	@Override
	public int updateUser(UserInfo userInfo) {
		return userDao.update(userInfo);
	}

	@Override
	public int delete(Long id) {
		return userDao.delete(id);
	}
}
