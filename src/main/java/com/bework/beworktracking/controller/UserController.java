/*
package com.bework.beworktracking.controller;

import com.bework.beworktracking.contract.*;
import com.bework.beworktracking.service.BaseService;
import com.bework.beworktracking.service.PreAuthorizeService;
import com.bework.beworktracking.service.UserService;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService baseService;

    @Autowired
    private PreAuthorizeService preAuthorizeService;

    @Autowired
    private ResourceServerTokenServices resourceServerTokenServices;

    private static final Logger logger = LoggerFactory.getLogger(com.bework.controller.UserController.class);

    @RequestMapping()
    public String sayHello(){
        return " xin chào"+ env.getProperty("server.port");
    }

    */
/**
     * @api {post} /user/login Login
     * @apiName Login
     * @apiGroup User
     *
     * @apiParam (Request body) {String} username Username
     * @apiParam (Request body) {String} password Đã mã hóa bcrypt
     * @apiParam (Request body) {String} countryCode Mã quốc gia
     *
     * @apiExample Example usage:
     *	body:
     *	{
     *		"username":"0987654321",
     *		"password":"$2a$10$LcAXGD3IHuvB3YW1l3oKlu3bgsTI8leCqbvL76/b2ZTfSOGg9PN3e",
     *		"countryCode":"+84"
     *	}
     *
     * @apiSuccess {String} access_token Access token.
     * @apiSuccess {String} refresh_token Refresh token.
     *
     * @apiSuccessExample Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *     		"status": "Success",
     *		    "message": "Login success",
     *		    "data": {
     *		        "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIwOTg3NzY2NjY4Iiwic2NvcGUiOlsiYmVlZHVTY29wZSJdLCJyZnJfaWQiOjUxLCJleHAiOjE1NjMzMDQ5NTIsImF1dGhvcml0aWVzIjpbIlJPTEVfUEFSRU5UIl0sImp0aSI6IjdkZWRlODI4LTIzMjgtNDA4My1hNTE1LTQ4M2E5OWQ1NmU0OSIsImNsaWVudF9pZCI6ImJlZWR1Q2xpZW50In0.JZ4s-3GkISNDt9tIFRnTfjOLBG7PCraFWo1D-P6bfKI",
     *		        "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIwOTg3NzY2NjY4Iiwic2NvcGUiOlsiYmVlZHVTY29wZSJdLCJyZnJfaWQiOjUxLCJhdGkiOiI3ZGVkZTgyOC0yMzI4LTQwODMtYTUxNS00ODNhOTlkNTZlNDkiLCJleHAiOjE1NjU4NTM3NTIsImF1dGhvcml0aWVzIjpbIlJPTEVfUEFSRU5UIl0sImp0aSI6IjJkZjdjOTExLWVlYTQtNGMzZC04NmMwLWI2MWNlYTIzZWVlNCIsImNsaWVudF9pZCI6ImJlZWR1Q2xpZW50In0.0D4NXMQQP_uT7AgEelFZdyIWfhyAjzX6w3Rp5L4EXF4"
     *				"id": 51,
     *				"avatar": null,
     *				"firstName": null,
     *				"gender": null,
     *				"lastName": null,
     *				"status": null,
     *				"username": "0987766668",
     *				"fullName": "Cô giáo Hằng Nga 1",
     *				"countryCode": "+84",
     *				"role": "PARENT"
     *		    }
     *     }
     *//*

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody LoginContract loginContract) {
        try {
            Object result = userService.login(loginContract, false);
            if(result instanceof OauthResponseContract) {
                ObjectMapper objectMapper = new ObjectMapper();
                Jwt jwt = JwtHelper.decode(((OauthResponseContract)result).getAccess_token());

                Map<String, Object> claims = objectMapper.readValue(jwt.getClaims(), Map.class);
                Long id = ((Integer) claims.get("rfr_id")).longValue();
                ArrayList<String> role = (ArrayList<String>) claims.get("authorities");

                UserInfoContract userInfoContract = userService.getUserInfo(id, role.get(0).replace("ROLE_", ""), loginContract.isWithRole(), null);
                LoginResponseContract loginResponseContract = getLoginResponseContract((OauthResponseContract)result, userInfoContract);

                return ResponseEntity.ok(new Response("Success","Login success", loginResponseContract));
            }else {
                return new ResponseEntity<>(new ResponseError("Error", "Login error", (int)result), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseError(e.getMessage()));
        }
    }
}
*/
