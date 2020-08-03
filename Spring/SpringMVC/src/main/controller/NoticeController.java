package com.kh.welcome.board.controller;

import java.io.File;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.welcome.board.model.service.NoticeService;
import com.kh.welcome.board.model.vo.Notice;
import com.kh.welcome.member.model.vo.Member;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/board/boardform.do")
	public String boardForm() {
		return "board/boardForm";
		
	}
	//추후에 수정될 메소드
	@RequestMapping("/notice/noticeupload.do")
	 public ModelAndView noticeUpload(
	         //다중파일 업로드임으로
	         //여러개의 MultipartFile을 담기 위한 List 생성
	         @RequestParam List<MultipartFile> files
	         , HttpSession session, Notice notice) {
	      ModelAndView mav = new ModelAndView();
	         
	      String root = session.getServletContext().getRealPath("/");
	      System.out.println(root);
	      Member sessionMember = (Member) session.getAttribute("logInInfo");
	      
	      if(sessionMember != null) {
	    	  //게시글 작성자에 해당 회원의 아이디
	    	  notice.setUserId(sessionMember.getUserId());
	      
	      }else {
	    	  //로그인한 회원이 아니라면 비회원으로 등록
	    	  notice.setUserId("비회원");
	      }
	      noticeService.insertNotice(notice, files, root);
	      //notice/noticelist.do로 다시 요청
	      mav.setViewName("redirect:/notice/noticelist.do");
	         return mav;
	      
	      }
	
	@RequestMapping("/notice/noticelist.do")
	public ModelAndView noticeList(
			
			
			//@RequestParam
			//required : 필수파라미터 여부 지정(default 값은 true)
			//defaultValue : 파라미터가 없을 때 기본값으로 지정할 값
			
			@RequestParam(required=false, defaultValue="1")int cPage) {
		
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 10;
		Map<String, Object> commandMap = noticeService.selectNoticeList(cPage, cntPerPage);
		//paging 객체를 paging이라는 키로 담아서 보낸다.
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("noticeData", commandMap);
		mav.setViewName("board/boardList");
		
		return mav;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@RequestMapping("/notice/noticedetail.do")
	public ModelAndView noticeDetail(int nIdx) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> commandMap = noticeService.selectNoticeDetail(nIdx);
		//해당 게시글이 존재하는지 여부 판단
		//반환되는 Map은 null일 수 없다.
		//Map안의 notice객체가 null인지 여부로 판단.
		if(commandMap.get("notice") != null) {
			mav.addObject("data", commandMap);
			mav.setViewName("board/boardView");
		}else {
			mav.addObject("alertMsg", "해당게시물이 존재하지 않습니다.");
			mav.addObject("url", "board/boardList");
			mav.setViewName("common/result");
		}
		
		return mav;
		
	}
	
//	public ModelAndView noticeUpload(
//			//다중파일 업로드임으로
//			//여러개의 MultipartFile을 담기 위한 List 생성	
//			@RequestParam List<MultipartFile> files,
//			HttpSession session) {
//			ModelAndView mav = new ModelAndView();
//			//파일업로드를 위한 절대경로 변환
//			String root = session.getServletContext().getRealPath("/");
//			
//			//MultipartFile 예외처리
//			//사용자가 게시글만 작성하고 파일업로드는 하지 않을 경우
//			//사용자가 첨부한 파일이 없어도 List<MultipartFile>의 size()가 1로 잡힌다.
//			//이때 첨부한 파일의 이름은 공백이다.
//			if(!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {
//				
//				
//				for(MultipartFile mf : files) {
//					String savePath = root + "resources/upload";
//					System.out.println(savePath);
//					
//					//transferTo 메서드의 매개변수에 넣어 줄
//					// 빈 파일 객체를 저장할 경로 + 사용자가 등록한 파일 이름으로 생성
//					
//					File fileData = new File(savePath + "/" + mf.getOriginalFilename());
//					
//					try {
//						//빈 파일 객체에 사용자가 등록한 파일을 덮어쓴다.
//						mf.transferTo(fileData);
//					} catch (IllegalStateException | IOException e) {
//						e.printStackTrace();
//					}
//				}
//				
//			}
//			
//			return mav;
//	}
	
}
