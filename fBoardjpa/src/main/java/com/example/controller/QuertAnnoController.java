package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.QueryAnnoRepository;

@Controller
public class QuertAnnoController {

	@Autowired
	private QueryAnnoRepository repo;
	
	@RequestMapping("queryAnno")
	public String queryAnno(Model m) {
		m.addAttribute("boardList", repo.queryAnnotation3("t"));
		return "/board/getBoardList";
	}
	
}
