package com.bit.myapp.controller;

import java.util.ArrayList;
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

import com.bit.myapp.domain.FreeBoard;
import com.bit.myapp.service.FreeBoardService;

@Controller
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeService;

	FreeBoard fb = new FreeBoard();
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	List<FreeBoard> freeBoardList = new ArrayList();

	@RequestMapping(value = "/freeBoard", method = { RequestMethod.POST, RequestMethod.GET }) // POST wkfgoTdj!짤했어
	public String home(HttpServletRequest request, Model model) {

		String baseNum = request.getParameter("baseNum");
		String endNum = request.getParameter("endNum");
		int cBaseNum = Integer.parseInt(baseNum);
		int cEndNum = Integer.parseInt(endNum);

		fb.setTotalCount(freeService.postCount());
//		logger.info("총 게시물 수" + fb.getTotalCount() + ""); // 총 게시물 수를 구함

		fb.setContentNum(cEndNum - cBaseNum + 1);
		int page = fb.calPage(fb.getTotalCount(), cEndNum);
		fb.setPageNum(page);
//		logger.info("페이지: " + page + " 앤드넘" + cEndNum);

		fb.setCurrentBlock(page); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
		fb.setLastBlock(fb.getTotalCount()); // 마지막 블
		fb.prevNext(page);
		fb.setStartPage(fb.getCurrentBlock());
		fb.setEndPage(fb.getLastBlock(), fb.getCurrentBlock());

//		logger.info("총 페이지: " + fb.getPageNum());
		model.addAttribute("totalPage", fb.getPageNum()); // 총 페이지 수를 구함.

/*		logger.info("처음페이지" + fb.getStartPage());
		logger.info("커렌트블락" + fb.getCurrentBlock());
		logger.info("라스트블락" + fb.getLastBlock());
		logger.info("토탈카운트" + fb.getTotalCount());
		logger.info("contentNum" + fb.getContentNum());
		logger.info("마지막페이지" + fb.getEndPage());*/
		model.addAttribute("f", freeService.postCount());

		freeBoardList = freeService.freeBoardList(cBaseNum, cEndNum);
//		logger.info("pageNum" + page);
//		logger.info("contentNum" + fb.getContentNum());
		model.addAttribute("freeBoardList", freeBoardList);
		model.addAttribute("page", fb);
		
		model.addAttribute("baseNum", cBaseNum);
		model.addAttribute("endNum", cEndNum);
//		logger.info(cBaseNum + ", " + cEndNum);
//		logger.info(" 서비스 테스트중: \n" + freeBoardList.toString());

		return "Community/Free/board/freeBoard";
	}

	@RequestMapping(value = "/FreeWritePost", method = { RequestMethod.POST, RequestMethod.GET }) // POST
	public String insert(Model model) throws Exception {
		return "Community/Free/board/writePost";

	}

	@RequestMapping(value = "/FreeWriteView", method = { RequestMethod.POST, RequestMethod.GET }) // POST wkfgoTdj!짤했어
	public String afterInsert(HttpServletRequest request, Model model, @ModelAttribute FreeBoard insertFree) {

		freeService.insertFree(insertFree);
//		logger.info("------------------------\n실행중");
//		logger.info(insertFree.toString());

//		return "Community/Free/board/writeView";
		return "redirect:freeBoard?baseNum=1&endNum=10";
	}

	@RequestMapping(value = "/FreePostView", method = { RequestMethod.POST, RequestMethod.GET }) // POST
	public String view(Model model, HttpServletRequest request) throws Exception {

		String baseNum = request.getParameter("baseNum");
		int cBaseNum = Integer.parseInt(baseNum);
		
		freeService.freePlus(cBaseNum);
		
/*		String deleteFree = request.getParameter("deleteFree");
		logger.info("딜리트프리" + deleteFree);*/

		freeBoardList = freeService.selectFree(cBaseNum);
		model.addAttribute("freeBoardList", freeBoardList);
//		logger.info(freeBoardList.toString());
		
		
		return "Community/Free/board/postView";

	}

	@RequestMapping(value = "/deleteFree", method = { RequestMethod.POST, RequestMethod.GET })
	public String delete(Model model, HttpServletRequest request) {

		String baseNum = request.getParameter("baseNum");
		int cBaseNum = Integer.parseInt(baseNum);

//		logger.info("삭제 " + cBaseNum + "");
		freeService.deleteFree(cBaseNum);

		return "Community/Free/board/deleteFree";

	}

	@RequestMapping(value = "/updateFree", method = { RequestMethod.POST, RequestMethod.GET })
	public String update(Model model, HttpServletRequest request) {/* ,@ModelAttribute FreeBoard freeboard */

//		logger.info("되고있다 11111.");

		String baseNum = request.getParameter("baseNum");
		int cBaseNum = Integer.parseInt(baseNum);

		freeBoardList = freeService.selectFree(cBaseNum);
		model.addAttribute("freeBoardList", freeBoardList);
//		logger.info(freeBoardList.toString());

		return "Community/Free/board/updateFree";
	}

	@RequestMapping(value = "/afterUpdate", method = { RequestMethod.POST, RequestMethod.GET })
	public String afterUpdate(Model model, HttpServletRequest request,
			@ModelAttribute FreeBoard freeboard) {/* ,@ModelAttribute FreeBoard freeboard */

		String baseNum = request.getParameter("baseNum");
		int cBaseNum = Integer.parseInt(baseNum);

		String ptagName = request.getParameter("ptagName");

		String ptitle = request.getParameter("ptitle");

		String pdetail = request.getParameter("pdetail");

		freeService.updateFree(cBaseNum, ptagName, ptitle, pdetail);

		return "Community/Free/board/afterUpdate";
	}
}
