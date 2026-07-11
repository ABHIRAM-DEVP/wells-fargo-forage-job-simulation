package com.investmentAdvisor.Backend.interceptor;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BusinessHoursInterceptor implements HandlerInterceptor {

    private static final DayOfWeek[] BUSINESS_DAYS = {
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY
    };

    private static final LocalTime BUSINESS_START = LocalTime.of(9, 0);
    private static final LocalTime BUSINESS_END = LocalTime.of(17, 0);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalTime now = LocalTime.now();
        DayOfWeek today = java.time.LocalDate.now().getDayOfWeek();
        boolean withinBusinessHours = java.util.Arrays.asList(BUSINESS_DAYS).contains(today)
                && !now.isBefore(BUSINESS_START)
                && !now.isAfter(BUSINESS_END);
        if (!withinBusinessHours) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Access restricted to business hours");
            return false;
        }
        return true;
    }
}
