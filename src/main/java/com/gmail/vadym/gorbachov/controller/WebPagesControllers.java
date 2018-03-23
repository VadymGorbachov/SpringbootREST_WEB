package com.gmail.vadym.gorbachov.controller;

import java.util.*;
import com.gmail.vadym.gorbachov.entity.Check;
import com.gmail.vadym.gorbachov.entity.User;
import com.gmail.vadym.gorbachov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WebPagesControllers {
	public WebPagesControllers() {
	}

	@Autowired
	private UserService userService;
	private final String log = "admin";
	private final String pass = "java";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "index";
	}
	
	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	    public String index(@RequestParam("login") String login,
							@RequestParam("password") String password,
							Model model) {
	        System.out.println("Index");
	if((login.equals(log))&&(password.equals(pass))){
	Collection<User> listUsers = userService.getAllUsers();
    model.addAttribute("list",listUsers);
	return "user__list";
}
	return  "index_wrong";
	}

    @RequestMapping(value = "/crud/del", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestBody List<Check> checks, Model model) {
        System.out.println("/crud/del");

        for(Check chk: checks){
            System.out.println(chk.toString());
            if(chk.getOk().equals("ok")){
                userService.removeUserById(chk.getId());
            }
        }
        Collection<User> listUsers = userService.getAllUsers();
        model.addAttribute("list",listUsers);
        return "user__list";
    }
}
