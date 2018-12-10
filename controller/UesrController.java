package com.bit.myapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp.domain.UserInfo;
import com.bit.myapp.service.UserService;



@Controller
public class UesrController {
	private static final Logger logger = LoggerFactory.getLogger(UesrController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/signupform")
	public String signupform(Model model,@ModelAttribute("userinfo")UserInfo userinfo) throws Exception {
		//userService.selectUser("kjs11");
		//System.out.println("select userInfo:"+ userinfo.getUserid() + userinfo.getUserpw()+ userinfo.getNickname());
		/*System.out.println("일루오냐");*/
		return "Community/User/signupform";
	}

	@RequestMapping(value="/signupresult", method = RequestMethod.POST)
	public String signupresult(Model model,@ModelAttribute("userinfo")UserInfo userinfo) throws Exception {
		
		userService.insertUser(userinfo);
		logger.info("userinfo");
		model.addAttribute("UserInfo",userinfo);
		return "Community/User/signupresult";
	
}
	/*로그인을 하는 폼 화면 */
	@RequestMapping("/loginform")
	public String loginform(Model model)  throws Exception{
		logger.info("123");
		
		return "Community/User/loginform";
		}
	
	/*로그인 버튼 클릭시 로그인을 처리하는부분 */
	//@SuppressWarnings("unused")
	@SuppressWarnings("null")
	@RequestMapping("/loginprocess")
	public String loginprocess(UserInfo userinfo, HttpSession session ) throws Exception{
		
		String returnURL = "";
		
		if(session.getAttribute("login") != null) { //기존에 login이란 세션값이 존재한다면  기존값을 제거해준다. 초기화
			session.removeAttribute("login");
		}
		//로그인 성공하면 UserInfo객체를 반환한다.
		UserInfo vo = userService.login(userinfo);
		
		
		if (vo !=null) { // 로그인성공시 메인화면으로 이동
			session.setAttribute("login", vo);
			returnURL ="home";
			logger.info("일루가자" + vo.getNickname());
		}else { //로그인 실패한경우 로그인화면으로 이동시킴
			

			returnURL ="redirect:loginform";


		}
		
		logger.info(returnURL);
		return returnURL;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
		

	
	

}
