package com.bit.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bit.myapp.domain.Board;
import com.bit.myapp.domain.postComment;
import com.bit.myapp.service.AnonyBoardService;
import com.bit.myapp.service.CommentBoardService;



@Controller
public class AnonyBoardController {

	private static final Logger logger = LoggerFactory.getLogger(AnonyBoardController.class);
	@Autowired
	private AnonyBoardService aService;
	
	@Autowired
	private CommentBoardService cSerivceParam;
	
	private int pNumber;
	Date d=new Date();
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String home() {return "home";}
	
	
	@RequestMapping(value= "/anonyListPage", method = RequestMethod.GET)
	public String start(Model model,HttpServletRequest request) {
		String bStat= request.getParameter("likeBtn");
		if(bStat!=null&&bStat.equals("clicked")) {
			pNumber= Integer.parseInt(request.getParameter("postno"));
			aService.anonyLikePlus(pNumber);
		}
		model.addAttribute("postlist",aService.anonygetAllBoard());
//		return "Community/anonymous/anonyListPage";
		return "anonyListPage";
	}
	
	@RequestMapping(value="/anonyRead",method = {RequestMethod.GET, RequestMethod.POST})
	public String read(Model model, HttpServletRequest request) {
		pNumber= Integer.parseInt(request.getParameter("postno"));
		Board board=aService.anonyselectBoard(pNumber);
		aService.anonyPostnvPlus(pNumber);
		
		
		try {
			String[] imgList= board.getImgpath().split("/");
			model.addAttribute("imgs", imgList);
		}catch(NullPointerException e) {logger.info("이미지없음");}
		model.addAttribute("postContent",board);
		model.addAttribute("commentContent",cSerivceParam.getAllComments(pNumber));
		
		return "Community/anonymous/anonyReadPage";
	}
	
	@RequestMapping(value="/anonyWrite", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("nickname","pipo");
		return "Community/anonymous/anonyWritePage";
	}
	
	@RequestMapping(value="/anonyRegist",  method = {RequestMethod.GET, RequestMethod.POST})
	public String regist(HttpServletRequest request,MultipartHttpServletRequest mtRequest,Model model,@ModelAttribute Board board) throws IOException {
		List<MultipartFile> fileList = mtRequest.getFiles("files");
		String path="/images/";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String saveName;
		String imgpath="";
//		String root_path = request.getSession().getServletContext().getRealPath("/"); // 웹서비스 root 경로 
//		String attach_path = "resources\\files\\sevedImg\\";
//		logger.info(root_path+attach_path);
		if(!(fileList.isEmpty())) {
	        for (MultipartFile mf : fileList) {
	            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
	            long fileSize = mf.getSize(); // 파일 사이즈
	            logger.info("originFileName : " + originFileName);
	            logger.info("fileSize : " + fileSize);
	            
	            saveName = request.getParameter("nickname")+"_"+sdf.format(d.getTime())+"_"+originFileName;
	            imgpath+=saveName+"/";
	            try {
	                 File fileDir= new File(path);
	                 if(!fileDir.exists()){
	                    fileDir.mkdirs(); //디렉토리가 존재하지 않는다면 생성
	                   }
	                   mf.transferTo(new File(fileDir,saveName));
	            } catch (IllegalStateException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
		}
        board.setImgpath(imgpath);
		aService.anonyinsertBoard(board);
		model.addAttribute("postlist",aService.anonygetAllBoard());
		return "anonyListPage";
	}
	
	@RequestMapping(value="/modiPost")
	public String modiPost(Model model,HttpServletRequest request) {
		pNumber=Integer.parseInt(request.getParameter("postno"));
		model.addAttribute("postContent",aService.anonyselectBoard(pNumber));
		
		return "Community/anonymous/anonyModifyPage";
	}
	
	@RequestMapping(value="/modiRegistPost",method = {RequestMethod.GET, RequestMethod.POST})
	public String modiRegistPost(Model model,HttpServletRequest request,@ModelAttribute Board board) {
		aService.anonyModiBoard(board);
//		pNumber=board.getPostno();
		request.setAttribute("postno", board.getPostno());
		return "forward:/anonyRead";
	}
	
	@RequestMapping(value="/deletePost")
	public String deletePost(Model model,HttpServletRequest request) {
		logger.info("삭제");
		pNumber=Integer.parseInt(request.getParameter("postno"));
		aService.anonydeleteBoard(pNumber);
		model.addAttribute("postlist",aService.anonygetAllBoard());
		return "anonyListPage";
	}
	

	
}
