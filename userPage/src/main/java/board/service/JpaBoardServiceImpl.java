package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BestMenu;
import board.entity.BoardEntity;
import board.entity.BookTable;
import board.entity.BookerUsers;
import board.entity.TemplateEntity;
import board.repository.JpaBestMenuRepository;
import board.repository.JpaBoardRepository;
import board.repository.JpaBookTableRepository;
import board.repository.JpaBookerUsersRepository;
import board.repository.JpaTemplateRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {
	@Autowired
	JpaBoardRepository jpaBoardRepository;
	
	@Autowired
	JpaBookTableRepository jpaBookTableRepository;
	
	@Autowired
	JpaBookerUsersRepository jpaBookerUsersRepository;
	
	@Autowired
	JpaBestMenuRepository jpaBestMenuRepository;
	
	@Autowired
	JpaTemplateRepository jpaTemplateRepository;
	
	//store list
	@Override
	public List<BoardEntity> selectBoardList() throws Exception {
		return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
	}
	@Override
	public List<BoardEntity> selectBoardListStoreNum(String storeNumber) throws Exception {
		return jpaBoardRepository.findAllByStoreNumber(storeNumber);
	}

	// 	save = insert, update
	@Override
	public void saveBookerUsers(BookTable bookTable, MultipartHttpServletRequest request) throws Exception {
		jpaBookTableRepository.save(bookTable);		
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<BookerUsers> selectBookerUsersList() throws Exception {
		return jpaBookerUsersRepository.findAllByOrderByIdDesc();
	}
	
	//BestMenu
	@Override
	public List<BestMenu> selectBestMenuList() throws Exception {
		return jpaBestMenuRepository.findAllByOrderByIdDesc();
	}
	@Override
	public List<BestMenu> selectBestMenuListStoreNum(String storeNumber) throws Exception {
		return jpaBestMenuRepository.findAllByStoreNumber(storeNumber);
	}
	
	//Template
	@Override
	public List<TemplateEntity> selectTemplateList() throws Exception {
		return jpaTemplateRepository.findAllByOrderByIdDesc();
	}	
}
