/*
package com.bework.beworktracking.service;

import com.bework.beworktracking.common.constants.Consts;
import com.bework.beworktracking.contract.*;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserService {
    private static final String TOKEN_URL = "http://localhost:9001/oauth/token";

    public Object login(LoginContract loginContract, boolean isFromLIM) {
        CloseableHttpClient client = HttpClients.createDefault();
        int status = 0;
        HttpPost httpPost = new HttpPost(TOKEN_URL);
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", loginContract.getCountryCode() + ":" + loginContract.getUsername() + ":" + isFromLIM));
            params.add(new BasicNameValuePair("password", loginContract.getPassword()));
            params.add(new BasicNameValuePair("grant_type", "password"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            UsernamePasswordCredentials creds = new UsernamePasswordCredentials("beeduClient", "beeduSecret");
            httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

            CloseableHttpResponse response = client.execute(httpPost);
            Gson gson = new Gson();
            System.out.println("Login response: " + response.toString());
            if (response.getStatusLine().getStatusCode() == 200) {
                OauthResponseContract oauthResponse = gson.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"),
                        OauthResponseContract.class);
                client.close();
                return oauthResponse;
            } else {
                status = response.getStatusLine().getStatusCode();

                try {
                    OauthResponseErrorContract oauthResponseErrorContract = gson.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"),
                            OauthResponseErrorContract.class);

                    if (oauthResponseErrorContract != null && (Consts.USER_LOCKED.equals(Integer.valueOf(oauthResponseErrorContract.getError_description())) ||
                            Consts.USER_DELETED.equals(Integer.valueOf(oauthResponseErrorContract.getError_description())))) {
                        return Integer.valueOf(oauthResponseErrorContract.getError_description());
                    }
                } catch (Exception e) {
                }
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return status;
    }

}
*/
