package com.spring.training.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.training.board.dto.BoardDto;
import com.spring.training.board.service.BoardService;

@Controller // 스프링 컨트롤러는 @Controller를 명시하여야 한다.
public class BoardController {

	@Autowired							// DI(의존성 주입) : BoardService객체를 IoC컨테이너에서 생성하여 주입시킴
	private BoardService boardService;
	
	// value에는 url 주소를 명시한다.
	// method는 url 요청 방법을 명시한다. ( 생략할 경우 GET , POST를 모두 처리한다. )
	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET)
	public String boardWrite() throws Exception {
		return "board/bWrite"; // servlet-context.xml파일 규칙대로 포워딩 시킬 jsp파일을 작성한다.
	}
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.POST)
	public String boardWrite(BoardDto bdto) throws Exception {
		boardService.insertBoard(bdto);
		//return "board/bList";
		return "redirect:boardList";
		
		/*
		 *
		 * 	특정 페이지로 리다이렉트시키는 방법은 "redirect:경로" 와 같은 형태로 간단하다.
		 *	jsp 페이지로 이동하는 방법과 url로 리다이렉트하는 방법의 차이점은 중요하므로 잘 기억하여야 한다.
		 *	 
		 *		jsp로 이동하는 경우 : 순수하게 페이지만 이동  
		 *		redirect하는 경우   : 해당 url에 있는 모든 로직을 수행한후 페이지 이동.
		 *
		 */
		
	}
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String main() {
		return "board/bMain";
	}
	
	
	@RequestMapping(value="/boardList" , method=RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		
		/*
		 * 
		 * Controller에서 View 데이터 전송 방법
		 * 
		 * 1) 메서드의 매개변수에서 Model객체를 생성한다.
		 * 2) addAttribute("속성",값) 메서드를 통하여 데이터를 전송한다.
		 * 
		 * */
		
		model.addAttribute("boardList" , boardService.getBoardList());
		return "board/bList";
		
	}
	
	@RequestMapping(value="boardInfo" , method=RequestMethod.GET)
	public String boardInfo(@RequestParam("num") int num , Model model) throws Exception {
		
		/*
		 *  @RequestParam("매개변수명") 변수타입 변수명
		 * */
	
		model.addAttribute("bdto" , boardService.getOneBoard(num));
		
		return "board/bInfo";
		
	}
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.GET)
	public String boardUpdate(@RequestParam("num") int num , Model model) throws Exception {
		model.addAttribute("bdto" , boardService.getOneBoard(num));
		return "board/bUpdate";
	}
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.POST) 
	public String boardUpdate(BoardDto bdto , Model model) throws Exception {
		
		if (boardService.updateBoard(bdto))  model.addAttribute("success" , true);
		else								 model.addAttribute("success" , false);
		
		return "board/bUpdatePro";
		
	}

	
	@RequestMapping(value = "/boardDelete" , method=RequestMethod.GET)
	public String boardDeleteForm(@RequestParam("num") int num , Model model) throws Exception{
		
		model.addAttribute("bdto", boardService.getOneBoard(num));
		
		return "board/bDelete";
		
	}
	
	@RequestMapping(value = "/boardDelete" , method=RequestMethod.POST)
	public String boardDelete(Model model , BoardDto bdto) throws Exception{
		
		if (boardService.deleteBoard(bdto))  model.addAttribute("success",true);
		else 								 model.addAttribute("success",false);
		
		return "board/bDeletePro";
		
	}
	
	
	
	
	
}
