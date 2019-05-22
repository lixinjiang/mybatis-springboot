## 项目说明
> 此项目使用springboot + mybatis + jsp 技术，主要是 springboot 和 mybatis 整合的一个框架，页面技术可以根据自己需求进行更改  

### 使用说明
1. 引入jsp相关的依赖
2. 启动项目命令
> cd ...\mybatis-demo  
mvn clean spring-demo:run

### 调试和部署
> 如果像其他项目一样，直接在IDEA中通过main方法来启动项目，在访问测试的时候会出现 404 not found。  
这是因为spirngboot jsp项目需要额外进行一个设置：选择Edit Configuration选项，打开Run/Debug Configuration
，设置其Working directory 跟路径为指定到项目路径E:\IdeaProjects\mybatis-demo，然后重启就可以正常访问到页面内了  

### 在Tomcat中单独运行
1. 在pom文件中打成war包
2. 排除内嵌的tomcat依赖，避免jar包冲突
	```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<!-- 排除内置容器，排除内置容器导出成 war 包可以让外部容器运行spring-boot项目-->
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	```
3. servlet 支持  
springboot 项目必须实现SpringBootServletInitializer接口的configure()方法才能让外部容器运行Springboot项目，启动类  
同目录下创建ServletInitializer类：
	```java
	public class ServletInitializer extends SpringBootServletInitializer {
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(JspApplication.class);
		}
	}
	```
4. 打包发布  
	> mvn clean package  

5. 总结
在SpringBoot项目中集成JSP，SpringBoot支持使用内嵌的Tomcat来运行JSP，也支持将项目打包成war包部署到独立的Tomcat中。  
实际项目中推荐使用单独的Tomcat容器来部署使用JSP的项目，内嵌的Tomcat还不是很稳定，偶尔出现访问迟缓的现象。