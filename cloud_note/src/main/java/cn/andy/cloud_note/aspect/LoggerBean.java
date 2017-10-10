package cn.andy.cloud_note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerBean {
	
	@Before("within(cn.andy.cloud_note.controller..*)")
	public void logController(){
		System.out.println("AOP功能注入！");
	}
	
	@Before("within(cn.andy.cloud_note.service..*)")
	public void TestAOP(){
		System.out.println("ServiceAOP 注入！");
	}
}
