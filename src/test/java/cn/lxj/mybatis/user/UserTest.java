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

	@Test
	public void testUser()  {
		//增加
		userm.insert(new UserInfo("aa","13012345678"));
		//删除
		int count=userm.delete(29l);
		UserInfo user = userm.getOne(1l);
		//修改
		userm.update(user);
		//查询
		List<UserInfo> users = userm.findAllUser();
	}

	@Test
	public void testInsert()  {
		userm.insert(new UserInfo("aa", "a123456"));
		userm.insert(new UserInfo("bb", "b123456"));
		userm.insert(new UserInfo("cc", "b123456"));

//		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() {
		List<UserInfo> users = userm.findAllUser();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println("users list is :"+users.toString());
		}
	}


	@Test
	public void testUpdate() {
		long id=1l;
		UserInfo user = userm.getOne(id);
		if(user!=null){
			System.out.println(user.toString());
			userm.update(user);
//			Assert.assertTrue(("neo".equals(userMapper.getOne(id).getNickName())));
		}else {
			System.out.println("not find user id="+id);
		}
	}


	@Test
	public void testDelete() {
		int count=userm.delete(29l);
		if(count>0){
			System.out.println("delete is sucess");
		}else {
			System.out.println("delete if failed");
		}
	}
}
