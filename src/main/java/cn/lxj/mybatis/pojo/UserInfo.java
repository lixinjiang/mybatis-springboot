package cn.lxj.mybatis.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {

    private Integer userid;

    private String username;

    private String phone;

    private Integer sex;
}