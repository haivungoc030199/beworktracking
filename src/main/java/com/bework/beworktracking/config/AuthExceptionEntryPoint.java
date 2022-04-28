//package com.bework.beworktracking.config;
//
//import com.bework.beworktracking.common.ResponseError;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException)
//            throws  ServletException {
//
//    	ResponseError responseError = new ResponseError("Error", authException.getMessage(), HttpServletResponse.SC_UNAUTHORIZED);
//
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(response.getOutputStream(), responseError);
//        } catch (Exception e) {
//            throw new ServletException();
//        }
//    }
//}