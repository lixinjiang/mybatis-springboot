package cn.lxj.mybatis.service;

import cn.lxj.mybatis.bean.UserParam;
import cn.lxj.mybatis.pojo.UserInfo;
import cn.lxj.mybatis.result.Page;

import java.util.List;

/**
 * IUserService
 * description
 * create class by lxj 2019/5/21
 **/
public interface IUserService {
	List findAllUser();

	Page getList(UserParam userParam);

	UserInfo getOne(Long id);

	int save(UserInfo userInfo);

	int updateUser(UserInfo userInfo);

	int delete(Long id);

}
