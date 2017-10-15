/*package mf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mf.pojo.UserCenter;
import mf.service.DemoService;

@Controller
public class DemoController {

	@Autowired  DemoService  demoService;
	@RequestMapping("/")
	public void getUserById(){
		int userId=10;
		UserCenter user = demoService.getUserById(userId);
		System.out.println(user.getNickname());
		
	}
}
*/