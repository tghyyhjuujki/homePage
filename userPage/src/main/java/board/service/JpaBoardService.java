package board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BestMenu;
import board.entity.BoardEntity;
import board.entity.BookTable;
import board.entity.BookerUsers;
import board.entity.TemplateEntity;

public interface JpaBoardService {
	
//	List<BookTable> selectBookerUsersList() throws Exception;
//	List<BookTable> selectBookerUsersListStoreNum(String store_number) throws Exception;
	List<BookerUsers> selectBookerUsersList() throws Exception;
	void saveBookerUsers(BookTable bookTable, MultipartHttpServletRequest request) throws Exception;
	
	//store list
	List<BoardEntity> selectBoardList() throws Exception;
	List<BoardEntity> selectBoardListStoreNum(String storeNumber) throws Exception;
	
	//BestMenu 불러옴
	List<BestMenu> selectBestMenuList() throws Exception;
	List<BestMenu> selectBestMenuListStoreNum(String storeNumber) throws Exception;
	
	//template get post
	List<TemplateEntity> selectTemplateList() throws Exception;
	
	
	void deleteBoard(int boardIdx) throws Exception;
}
