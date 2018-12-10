package com.bit.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp.service.CommentBoardService;
import com.bit.myapp.service.SearchBoardService;



@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private SearchBoardService searchSerivce;
	
	@RequestMapping(value="/allSearchControl", method=RequestMethod.GET)
	public String allSearchControl(Model model,HttpServletRequest request) {
		String sTxt="%"+request.getParameter("sTxt")+"%";
		model.addAttribute("searchlist",searchSerivce.allSearchBoard(sTxt));
		return "Search/searchOutput";
	}
	

	
}
