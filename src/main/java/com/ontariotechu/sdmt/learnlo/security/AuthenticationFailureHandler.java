package com.ontariotechu.sdmt.learnlo.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.entity.ErrorResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;

import java.io.IOException;

@Slf4j
public class AuthenticationFailureHandler {
    public void formatResponse(HttpServletResponse response, String errorMessage) throws IOException {
        response.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatusCode.valueOf(response.getStatus()), errorMessage != null ? errorMessage : "Access Denied", null, null);
        StringBuilder responseBody = new StringBuilder();
        try{
            responseBody.append(mapper.writeValueAsString(errorResponse));
        }
        catch (JsonProcessingException ex){
            log.error(ex.getMessage());
        }
        response.getWriter().write(responseBody.toString());

    }
}
