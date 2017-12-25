package com.neo.gyl.privilege.annotation;

import java.lang.reflect.Method;

public class AnnoactionParser {
	public static String parse(Class targetClass, String methodName) throws Exception{
		String accessMethodName = "";
		Method method  = targetClass.getMethod(methodName);
		if(method.isAnnotationPresent(Permission.class)){
			Permission permission = method.getAnnotation(Permission.class);
			accessMethodName = permission.name();
		}
		
		return accessMethodName;
	}
}
