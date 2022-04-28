//package com.bework.beworktracking.config;
//
//import com.bework.beworktracking.common.ResponseError;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component("customAccessDeniedHandler")
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");
//
//        ResponseError responseError = new ResponseError("Error",
//                "Bạn không có quyền truy cập chức năng này",
//                HttpServletResponse.SC_FORBIDDEN);
//
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        response.getWriter().write(objectMapper.writeValueAsString(responseError));
//    }
//}