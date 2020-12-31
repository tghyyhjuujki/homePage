package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BoardEntity;
import board.entity.BookTable;
import board.entity.BookerUsers;
import board.repository.JpaBoardRepository;
import board.repository.JpaBookTableRepository;
import board.repository.JpaBookerUsersRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {
	
	@Autowired
	JpaBoardRepository jpaBoardRepository;
	
	@Autowired
	JpaBookerUsersRepository jpaBookerUsersRepository;
	
	@Autowired
	JpaBookTableRepository jpaBookTableRepository;
	
	// 	save = insert, update
	@Override
	public void saveBookerUsers(BookerUsers bookerUsers, MultipartHttpServletRequest request) throws Exception {	
		jpaBookerUsersRepository.save(bookerUsers);		
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//store list
	@Override
	public List<BoardEntity> selectBoardList() throws Exception {
		return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
	}
	@Override
	public List<BoardEntity> selectBoardListStoreNum(String storeNumber) throws Exception {
		return jpaBoardRepository.findAllByStoreNumber(storeNumber);
	}
	
	//book table
	@Override
	public List<BookTable> selectBookTableList() throws Exception {
		return (List<BookTable>) jpaBookTableRepository.findAll();
	}
	
	@Override
	public List<BookTable> selectBookTableListStoreNum(String store_number) throws Exception {
		return jpaBookTableRepository.findAllByStoreNumber(store_number);
	}

}
