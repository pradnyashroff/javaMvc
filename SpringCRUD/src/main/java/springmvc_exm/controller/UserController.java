package springmvc_exm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc_exmService.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(){
		  ModelAndView model = new ModelAndView("user/user_page");
		  
		  List list = userservice.ListAlluser();
		  model.addObject("listUser", list);
		  
		  return model;
		 }
		 
}
