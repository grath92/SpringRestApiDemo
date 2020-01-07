package com.gkrath.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gkrath.dao.UserDao;
import com.gkrath.enums.Status;
import com.gkrath.services.UserProfileService;


@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    UserDao merchantDao;
	
	@Autowired
    UserProfileService userProfileService;
	
	@Autowired
	Environment env;
	
	@RequestMapping(value="/test")
	public String test() {
		return "Ok, Working...";
	}
	
	@RequestMapping(value="/api/save_user_details")
	public String saveUserDetails(@RequestBody String request) throws JsonProcessingException{
		
		logger.info("Save User Profile request:{}", request);
		Map<String, Object> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            response = userProfileService.saveUserProfile(request);
            return mapper.writeValueAsString(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Exception occurred :{} for getUserProfile request: {}", ex, request);
            response.put("status",Status.ApiStatus.FAIL.toString());
            response.put("msg", "Something went wrong! Try Again.");
            return mapper.writeValueAsString(response);
        }
	}
	
	@RequestMapping(value="/api/get_user_details")
	public String getUserDetails(@RequestBody String request) throws JsonProcessingException{
		
		logger.info("Save User Profile request:{}", request);
		Map<String, Object> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            response = userProfileService.getUserProfile(request);
            return mapper.writeValueAsString(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Exception occurred :{} for getUserProfile request: {}", ex, request);
            response.put("status",Status.ApiStatus.FAIL.toString());
            response.put("msg", "Something went wrong! Try Again.");
            return mapper.writeValueAsString(response);
        }
	}
}
