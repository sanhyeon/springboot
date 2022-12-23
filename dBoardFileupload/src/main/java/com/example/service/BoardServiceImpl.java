package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.dao.FileDAO;
import com.example.domain.BoardVO;
import com.example.domain.FileVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 개수 : "+ list.size());
		return list;
	}

	@Override
	public HashMap getBoard(BoardVO vo) {
		boardDAO.updateCnt(vo);
		HashMap result = boardDAO.getBoard(vo);
		System.out.println("[BoardService] 상세보기");
		return result;
	}

	@Override
	public void saveBoard(BoardVO bvo, FileVO fvo) {
		// fileDAO 입력
		if(fvo!=null) {
			fileDAO.insertFile(fvo);
			bvo.setFileId(fileDAO.selectId());
		}
		// 그 pk를 가져와서 다시 board에 입력
		boardDAO.saveBoard(bvo);
		System.out.println("[BoardService] 새 글 등록");

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		System.out.println("[BoardService] 글 삭제");
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		System.out.println("[BoardService] 글 수정");
	}

}
