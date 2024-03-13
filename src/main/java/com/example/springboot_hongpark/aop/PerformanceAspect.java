package com.example.springboot_hongpark.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect // 부가 기능 주입을 위한 AOP클래스 선언
@Component
@Slf4j
public class PerformanceAspect {

    // 특정 어노테이션을 대상 지정
    @Pointcut("@annotation(com.example.springboot_hongpark.annotation.RunningTime)")
    private void enableRunningTime() {}

    // 기본 패키지의 모든 메소드
    @Pointcut("execution(* com.example.springboot_hongpark..*.*(..))")
    private void cut() {}

    // 실행 시점 설정: 두 조건을 모두 만족하는 대상을 전후로 부가 기능을 삽입
    @Around("cut() && enableRunningTime()")  // 기본패키지 하위 모든 메소드임 && 특정 어노테이션을 가지고 있는 조건
    public void loggingRunningTime(ProceedingJoinPoint joinPoint) throws Throwable{ // 대상을 실행까지 할 수 있는 joinPoint
        // 메소드 수행 전, 측정 시작
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 메소드를 수행
        Object returningObj = joinPoint.proceed();



        // 메소드 수행 후, 측정 종료 및 로깅
        String methodName = joinPoint.getSignature()
                .getName();

        stopWatch.stop();;
        log.info("{}의 총 수행 시간 => {} sec", methodName, stopWatch.getTotalTimeSeconds());
    }
}
