package cn.andy.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/*
 * 性能审计
 */
@Component
@Aspect
public class AuditBean {
	
	@Around("within(cn.andy.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point){
		
		Object obj=null;
		
		try {
			long before=System.currentTimeMillis();
					
			obj=point.proceed();
			long after=System.currentTimeMillis();
			String str=point.getSignature().toString();
			System.out.println(str+"耗时"+(after-before));
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		return obj;
	}
}
