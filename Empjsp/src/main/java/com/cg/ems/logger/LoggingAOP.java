package com.cg.ems.logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.cg.ems.exception.EmployeeMaintainceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class LoggingAOP {
	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	 
	private ObjectMapper mapper = new ObjectMapper();

	@Before("execution(* com.cg.ems.service.EmpService..*(..))")
	public void controllerLogging(JoinPoint joint) throws EmployeeMaintainceException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}

	@AfterReturning(pointcut = "execution(*  com.cg.ems.service.EmpService..*(..))", returning = "result")
	public void serviceSetterMethodLogging(JoinPoint joint, Object result) throws EmployeeMaintainceException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}
	}

	@Before("execution(* com.cg.ems.service.DeptService..*(..))")
	public void DepartmentLogging(JoinPoint joint) throws EmployeeMaintainceException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}

	@AfterReturning(pointcut = "execution(*  com.cg.ems.service.DeptService..*(..))", returning = "result")
	public void DepartmentSetterMethodLogging(JoinPoint joint, Object result) throws EmployeeMaintainceException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}
	}


	@Before("execution(* com.cg.ems.service.GradeService..*(..))")
	public void Grademaster(JoinPoint joint) throws EmployeeMaintainceException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}

	@AfterReturning(pointcut = "execution(*  com.cg.ems.service.GradeService..*(..))", returning = "result")
	public void grademaster(JoinPoint joint, Object result) throws EmployeeMaintainceException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}
	}
}

