package cn.lxj.mybatis.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ServletInitializer
 * description  让外部容器运行 SpringBoot项目
 * create class by lxj 2019/5/22
 **/
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MybatisDemoApplication.class);
	}
}