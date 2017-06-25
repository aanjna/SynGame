package com.syn.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syn.dao.ISynGameDao;
import com.syn.model.SynGame;

@RestController
@RequestMapping(value = "syngame")
public class SynGameController {

	final static Logger logger = Logger.getLogger(SynGameController.class);

	@Autowired
	@Qualifier("synGameDaoImpl")
	public ISynGameDao synGameDao;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<SynGame> getGame(HttpSession session,
			HttpServletResponse response) throws Exception {
		List<SynGame> sg = synGameDao.getSynGame();
		System.out.println("games display list::::::::::::" + sg);
		return sg;
	}

}
