//package hmd.config;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.context.annotation.Configuration;
//
//import hmd.annotation.RoutingMapper;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Aspect
//@Configuration
//public class RoutingMapperAspect {
//
//	@Around("execution(* hmd..*Mapper.*(..))")
//	public Object aroundTargetMethod(ProceedingJoinPoint thisJoinPoint) {
//		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
//		Class<?> mapperInterface = methodSignature.getDeclaringType();
//		Method method = methodSignature.getMethod();
//		Parameter[] parameters = method.getParameters();
//		Object[] args = thisJoinPoint.getArgs();
//
//		RoutingMapper routingMapper = mapperInterface.getDeclaredAnnotation(RoutingMapper.class);
//        if (routingMapper != null) {
//            String userId = findRoutingKey(parameters, args);
//            Integer index = determineRoutingDataSourceIndex(userId);
//            log.debug("index: {}", index);
//            ContextHolder.set(index);
//        }
//
//        try {
//            return thisJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throw new RuntimeException(throwable);
//        } finally {
//            ContextHolder.clear();
//        }
//    }
//
//    private String findRoutingKey(Parameter[] parameters, Object[] args) {
//        for (int i = 0; i < parameters.length; i++) {
//            RoutingKey routingKey = parameters[i].getDeclaredAnnotation(RoutingKey.class);
//            if (routingKey != null) {
//                return String.valueOf(args[i]);
//            }
//        }
//        throw new RuntimeException("can't find RoutingKey");
//    }
//
//    private Integer determineRoutingDataSourceIndex(String userId) {
//        return Math.abs(userId.hashCode()) % 4;
//    }
//}
