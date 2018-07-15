package com.xu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xu.entity.User;
import com.xu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 跳转到登录界面
	 * @return
	 */
	@RequestMapping("/toLogin.action")
	public String toLogin() {
		return "/login.jsp";  // 转向登录界面
	}
	
	/**
	 * 登录
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/login.action")
	public String login(User user, Model model, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		List<User> userList = userService.find(map);
		if (userList != null && userList.size() > 0) {
			request.getSession().setAttribute("user", userList.get(0));
			return "/home.jsp"; // 转向主页
		}
		model.addAttribute("errorMsg", "登录失败！ 账号或密码错误"); // 错误信息
		return "/login.jsp";
	}
	
	/**
	 * 跳转到注册界面
	 * @return
	 */
	@RequestMapping("/toRegister.action")
	public String toRegister() {
		return "/register.jsp";
	}
	
	@RequestMapping("/register.action")
	public String register(User user, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 查找账号是否已经被注册
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", user.getUsername());
		List<User> userList = userService.find(map);
		if (userList != null) {
			// 账号已经被注册
			model.addAttribute("errorMsg", "注册失败，用户名已存在");
			return "/register.jsp";
		}
		user.setUserId(UUID.randomUUID().toString()); // 为用户设置UUID主键
		userService.Insert(user);
		model.addAttribute("notice", "注册成功！ 请进行登录！");
		return "/login.jsp";
	}
}
