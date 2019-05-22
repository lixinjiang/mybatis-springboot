package cn.lxj.mybatis.user;

import cn.lxj.mybatis.bean.UserParam;
import cn.lxj.mybatis.dao.UserInfoMapper;
import cn.lxj.mybatis.demo.MybatisDemoApplication;
import cn.lxj.mybatis.pojo.UserInfo;
import cn.lxj.mybatis.result.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserTest
 * description
 * create class by lxj 2019/5/22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisDemoApplication.class)
@ActiveProfiles("dev")
public class UserTest {
	@Resource
	private UserInfoMapper userm;

	@Test
	public void testPage() {
		UserParam userParam = new UserParam();
		userParam.setCurrentPage(0);//0 是第一页，1 是第二页 依次类推
		List<UserInfo> users = userm.getList(userParam);
		int count = userm.getCount(userParam);
		Page page = new Page(userParam, count, users);
		System.out.println("page=" + page);
	}
}
