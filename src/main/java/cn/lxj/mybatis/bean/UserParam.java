package cn.lxj.mybatis.bean;

import lombok.Data;

/**
 * UserParam
 * description
 * create class by lxj 2019/5/22
 **/
@Data
public class UserParam extends PageParam{
	private String userName;
	private String phone;
	private Integer sex;
}
