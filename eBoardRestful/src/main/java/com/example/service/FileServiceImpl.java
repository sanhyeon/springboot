package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FileDAO;
import com.example.domain.FileVO;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public void insertFile(FileVO vo) {
		fileDAO.insertFile(vo);
	}

	@Override
	public long selectId() {
		return fileDAO.selectId();
	}

	@Override
	public FileVO selectFile(FileVO vo) {
		return fileDAO.selectFile(vo);
	}

}
