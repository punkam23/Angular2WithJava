package javaee.demo.angular2.web;

import javaee.demo.angular2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yehoshuamatamorosvalverde on 26/2/17.
 */
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    protected LoginService loginService;

    @RequestMapping(value = "/rest/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> ValidateUser(String username, String password) {

        Boolean isValidUser = loginService.isValidUser(username,password) == 1 ? true :false ;

        // we want to return a JSON object so we have to conver our String to a JSON key/value compatible format
        Map<String, String> jsonMap = new HashMap<>();
        // {"content" : "Hello World"}
        jsonMap.put("content", isValidUser.toString());

        return jsonMap;
    }
}
