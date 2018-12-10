
package com.bit.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bit.myapp.domain.Notice;
import com.bit.myapp.domain.SearchCriteria;
import com.bit.myapp.service.NoticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Resource(name = "notice")
	NoticeService service;

	@RequestMapping("list")
	public String list(Model model, @ModelAttribute Notice notice) {
		model.addAttribute("list", service.list());
		return "Community/notice/list";
	}

	// 글쓰기 버튼 클릭시
	@RequestMapping("write")
	public String write(Model model, @ModelAttribute Notice notice) {
		// model.addAttribute("write", write);
		// model.addAttribute("write",
		// service.write(request.getParameter("noticeTitle"),
		// request.getParameter("noticePdetail")));
		// model.addAttribute("list", service.list());
		// logger.info("write");
		return "Community/notice/write";
	}

	// 글 등록 버튼 클릭시
	@RequestMapping(value = "writeView", method = RequestMethod.POST)
	public String writeView(Model model, HttpServletRequest request, @ModelAttribute Notice notice) {
		logger.info(notice.toString());
		// int noticePostNo =Integer.parseInt(request.getParameter("noticePostNo"));
		service.write(notice);
		// model.addAttribute("contentView", service.contentView(noticePostNo));

		return "redirect:list";
	}

	// 글보기
	@RequestMapping(value = "contentView")
	public String contentView(Model model, HttpServletRequest request, @ModelAttribute Notice notice) {
		// logger.info(request.getParameter("noticePostNo"));
		int noticePostNo = Integer.parseInt(request.getParameter("noticePostNo"));
		service.noticePostNvUp(noticePostNo);
		model.addAttribute("contentView", service.contentView(noticePostNo));

		return "Community/notice/contentView";
	}

	// 글수정 버튼을 눌렀때
	@RequestMapping(value = "modify")
	public String modify(Model model, HttpServletRequest request, @ModelAttribute Notice notice) {
		int noticePostNo = Integer.parseInt(request.getParameter("noticePostNo"));
		model.addAttribute("contentView", service.contentView(noticePostNo));
		return "Community/notice/modify";
	}

	// 수정했을때
	@RequestMapping(value = "modifyView", method = RequestMethod.POST)
	public String modifyView(Model model, HttpServletRequest request, @ModelAttribute Notice notice) {
		logger.info(notice.toString());
		int noticePostNo = Integer.parseInt(request.getParameter("noticePostNo"));
		model.addAttribute("contentView", service.contentView(noticePostNo));
		service.modify(notice);
		return "redirect:contentView" + "?noticePostNo=" + noticePostNo;
	}

	// 삭 제
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request, @ModelAttribute Notice notice) {
		int noticePostNo = Integer.parseInt(request.getParameter("noticePostNo"));
		service.delete(noticePostNo);
		return "redirect:list";
	}

	// 검색

	@RequestMapping(value = "search")
	public String search(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("list", service.searchList(cri)); // 전체목록에 검색페이징 기능+
		return "Community/notice/list";

	}



	// 파일 업로드

//	파일 업로드 bean의 id uploadPath

//	@Resource(name = "uploadPath")
//	String uploadPath="WEB-INF/views/upload";

	@RequestMapping("upload")
	public String upload() {
		return "Community/notice/uploadView";
	}

//	@RequestMapping(value = "uploadView", method = RequestMethod.POST)
//	public String fileUpload(@RequestParam("file") CommonsMultipartFile[] file, HttpServletRequest request) {
//		String title = request.getParameter("noticeTitle");
//		logger.info(title);
//		
//		// System.out.println(file[0].getOriginalFilename());
//		File dir = new File(uploadPath);
//		// Filedir=newFile(rootdir +"upload");
//
//		File uploadfile = new File(dir, file[0].getOriginalFilename());
//		// Fileuploadfile =isExist(dir,file[0].getOriginalFilename());
//
//		try {
//			file[0].transferTo(uploadfile);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//			return"error";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return"error";
//		}
//
//		return "redirect:list";
//	}

//	
//	@RequestMapping(value="uploadView", method=RequestMethod.POST)
//	public ModelAndView uploadView(@RequestParam MultipartFile file, ModelAndView mav) throws Exception{
//		
//		logger.info("파일 업로드");
//		
//		logger.info("파일 이름 :"+file.getOriginalFilename());
//		logger.info("파일크기 : "+file.getSize() );
//		logger.info("컨텐트 타입 : " +file.getContentType());
//		
//		String savedName= file.getOriginalFilename();
//		
//		File target = new File(uploadPath, savedName);
//		
//		FileCopyUtils.copy(file.getBytes(), target);
//
//		mav.setViewName("uploadView");
//		mav.addObject("savedName", savedName);
//		
//		
//		return mav;
//	}

//	@RequestMapping("search")
//	public ModelAndView search(@RequestParam(defaultValue="titleAcontent") String searchOption, @RequestParam(defaultValue="") String keyword) {
//		List<Notice> searchList = service.list(searchOption, keyword);
//		
//		int count = service.countPost(searchOption, keyword);
//		
//		ModelAndView mav = new ModelAndView();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("searchList", searchList);
//		map.put("count", count);
//		map.put("searchOption", searchOption);
//		map.put("keyword", keyword);
//		
//		mav.addObject("map", map);
//		mav.setViewName("contentView");
//		
//		return mav;
//		
//	}
//	
//	

//	// Ajax 파일 업로드
//	@RequestMapping(value = "/upload", method = RequestMethod.GET)
//	public String uploadAjaxGET() {
//		return "upload/uploadAjax";
//	}
//
//	// Ajax 파일 업로드 produces는 한국어를 정상적으로 전송하기 위한 속성
//	@ResponseBody
//	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public ResponseEntity<String> uploadAjaxPOST(MultipartFile file) throws Exception {
//
//		logger.info("originalName:" + file.getOriginalFilename());
//		logger.info("size:" + file.getSize());
//		logger.info("contentType:" + file.getContentType());
//
//		// String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
//
//		// HttpStatus.CREATED : 리소스가 정상적으로 생성되었다는 상태코드.
//		// return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.CREATED);
//		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
//				HttpStatus.CREATED);
//	}
//
//	// 화면에 저장된 파일을 보여주는 컨트롤러 /년/월/일/파일명 형태로 입력 받는다.
//	// displayFile?fileName=/년/월/일/파일명
//	@ResponseBody
//	@RequestMapping(value = "/upload/displayFile", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
//
//		InputStream in = null;
//		ResponseEntity<byte[]> entity = null;
//
//		logger.info("File name: " + fileName);
//
//		try {
//			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
//
//			MediaType mType = MediaUtils.getMediaType(formatName);
//
//			HttpHeaders headers = new HttpHeaders();
//
//			in = new FileInputStream(uploadPath + fileName);
//
//			if (mType != null) {
//				headers.setContentType(mType);
//			} else {
//				fileName = fileName.substring(fileName.indexOf("_") + 1);
//				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//				headers.add("Content-Disposition",
//						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
//			} // else
//
//			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
//		} finally {
//			in.close();
//		}
//
//		return entity;
//	}// displayFile
//
//	// 업로드된 파일 삭제 처리
//	@ResponseBody
//	@RequestMapping(value = "/upload/deleteFile", method = RequestMethod.POST)
//	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
//
//		logger.info("delete file:" + fileName);
//
//		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
//
//		MediaType mType = MediaUtils.getMediaType(formatName);
//
//		if (mType != null) {
//			String front = fileName.substring(0, 12);
//			String end = fileName.substring(14);
//			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
//		} // if
//
//		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
//
//		return new ResponseEntity<String>("deleted", HttpStatus.OK);
//
//	}

}