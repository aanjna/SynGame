package com.syn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syn.dao.IUserDao;
import com.syn.model.User;
import com.syn.utils.SynExceptionHAndler;


@RestController
@RequestMapping(value = "user")
public class UserCtrl {
	final static Logger logger = Logger.getLogger(UserCtrl.class);

	@Autowired
	@Qualifier("userDaoImpl")
	public IUserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody User user, HttpSession session)
			throws SynExceptionHAndler {

		String result = "";
		User userBo =null;

		try {
			if (user != null) {
			
			userBo= userDao.getData(user);
			System.out.println("response value::::::::::::" + userBo);
			}
			result = "{\"status\":\"success\", \"message\" : \"user login successfully.\"}";

		} catch (SynExceptionHAndler meh) {
			result = "{\"status\":\"falure\", \"message\" : \"invalid username and password.\"}";

		} catch (Exception e) {
			result = "{\"status\":\"falure\", \"message\" : \"Contact Admin\"}";
		}

		return result;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.setAttribute("currentUser", null);
	}
}
