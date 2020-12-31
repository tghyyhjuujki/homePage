package board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BoardEntity;
import board.entity.BookTable;
import board.entity.BookerUsers;

public interface JpaBoardService {
	
//	List<BookerUsers> selectBookerUsersList() throws Exception;
	void saveBookerUsers(BookerUsers bookerUsers, MultipartHttpServletRequest request) throws Exception;

	List<BoardEntity> selectBoardList() throws Exception;
	List<BoardEntity> selectBoardListStoreNum(String storeNumber) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
	
	List<BookTable> selectBookTableList() throws Exception;
	List<BookTable> selectBookTableListStoreNum(String store_number) throws Exception;
}
