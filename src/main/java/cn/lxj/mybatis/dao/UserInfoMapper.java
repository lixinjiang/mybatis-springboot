package cn.lxj.mybatis.dao;

import cn.lxj.mybatis.bean.UserParam;
import cn.lxj.mybatis.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	List findAllUser();

	List<UserInfo> getList(UserParam userParam);

	Integer getCount(UserParam userParam);
}