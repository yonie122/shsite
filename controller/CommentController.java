package com.bit.myapp.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.myapp.domain.postComment;
import com.bit.myapp.service.CommentBoardService;



@Controller
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentBoardService cService;
	
	private postComment pComment;
	private HashMap<String, Integer> dNumData;
	private int pNumber;
	private int cNumber;
	
	//1.댓글 입력
	@RequestMapping(value="/commentInsert", method =RequestMethod.POST)
	public String commentInsert(Model model,HttpServletRequest request, @RequestParam("cDetail")String cDetail, @RequestParam("cpostno")int cpostno ) {
		pComment= new postComment();
		pComment.setPostno(cpostno);
		pComment.setCuser("test");
		pComment.setCdetail(cDetail);
		cService.insertComment(pComment);
		return "forward:/anonyRead?postno="+cpostno;
	}
	
	//2.댓글 삭제
	@RequestMapping(value="/commentDelete", method=RequestMethod.GET)
	public String commentDelete(Model model,@RequestParam int postno,@RequestParam int commentno) {
		try {
			dNumData=new HashMap<String,Integer>();
			dNumData.put("postno", postno);
			dNumData.put("commentno", commentno);
			cService.deleteComment(dNumData);
		}catch(NullPointerException e) {
			e.getMessage();
			logger.info(postno+","+commentno);
		}
		
		model.addAttribute("searchlist",cService.getAllComments(pNumber));
		return "forward:/anonyRead?postno="+postno;
	}
	
	//3.댓글 추천


	
}
;