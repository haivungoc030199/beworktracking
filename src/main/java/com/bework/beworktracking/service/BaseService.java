package com.bework.beworktracking.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.lang.Long.parseLong;

@Service
public class BaseService {

    public Long getCurrentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) details;
            Map<String, Object> dataMap = (Map<String, Object>) oauthDetails.getDecodedDetails();
            return parseLong(dataMap.get("rfr_id").toString());
        }
        return null;
    }

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) details;
            Map<String, Object> dataMap = (Map<String, Object>) oauthDetails.getDecodedDetails();
            return dataMap.get("rfr_id").toString();
        }
        return null;
    }

    public String getCountryCode() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) details;
            Map<String, Object> dataMap = (Map<String, Object>) oauthDetails.getDecodedDetails();
            return dataMap.get("country_code").toString();
        }
        return null;
    }
}
