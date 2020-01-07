package com.gkrath.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gkrath.dao.UserDao;
import com.gkrath.entities.User;
import com.gkrath.enums.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserProfileService {
    private Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    @Autowired
    UserDao userDao;

    public Map<String, Object> saveUserProfile(String request) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> requestMap = mapper.readValue(request, Map.class);
        Map<String, Object> params = (Map) requestMap.get("params");

        Map<String, Object> response = new HashMap<>();
        
        try {
        	if(params != null) {
		        User user = new User();
		        user.setFirst_name((String) params.get("first_name"));
		        user.setLast_name((String) params.get("last_name"));
		        user.setMobile((String) params.get("mobile"));
		        user.setEmail((String) params.get("email"));
		        user.setGender((String) params.get("gender"));
		        user.setAddress((String) params.get("address"));
		        user.setZip_code((String) params.get("zip_code"));
		        user.setCity((String) params.get("city"));
		        user.setCountry((String) params.get("country"));
		        user.setJob_title((String) params.get("job_title"));
		        user.setCompany_name((String) params.get("company_name"));
		        userDao.save(user);
		        response.put("status",Status.ApiStatus.OK.toString());
		        response.put("msg", "Profile Saved Successfully!!!");
        	}else {
        		response.put("status",Status.ApiStatus.FAIL.toString());
		        response.put("msg", "Profile Params Required.");
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Exception occurred :{} for getUserProfile request: {}", ex, request);
            response.put("status",Status.ApiStatus.FAIL.toString());
            response.put("msg", "Something went wrong! Try Again.");
        }

        return response;
    }
    
    public Map<String, Object> getUserProfile(String request) throws IOException {
    	 Map<String, Object> response = new HashMap<>();
    	 
    	 ObjectMapper mapper = new ObjectMapper();
         Map<String, Object> requestMap = mapper.readValue(request, Map.class);
         Map<String, Object> params = (Map) requestMap.get("params");
         try {
         	if(params != null) {
         		String mobile = (String) params.get("mobile");
         		if(mobile != null && !mobile.equals("")) {
	         		User user = userDao.findByMobile(mobile);
	         		if(user != null) {
	         			response.put("data",user);
	         		}else {
	         			response.put("data","");
	         			response.put("msg", "No User Found.");
	         		}
	         		response.put("status",Status.ApiStatus.OK.toString());
         		}else {
         			response.put("status",Status.ApiStatus.FAIL.toString());
    		        response.put("msg", "Valid Mobile Number Required.");
         		}
         	}else {
        		response.put("status",Status.ApiStatus.FAIL.toString());
		        response.put("msg", "Profile Params Required.");
        	}
         }catch (Exception ex) {
             ex.printStackTrace();
             logger.error("Exception occurred :{} for getUserProfile request: {}", ex, request);
             response.put("status",Status.ApiStatus.FAIL.toString());
             response.put("msg", "Something went wrong! Try Again.");
         }
    	 
    	 return response;
    }

}
