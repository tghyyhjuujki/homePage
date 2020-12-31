package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.entity.BestMenu;
import board.entity.BoardEntity;
import board.entity.BookTable;
import board.entity.BookerUsers;
import board.entity.TemplateEntity;
import board.service.JpaBoardService;

// @RestController = @Controller + @ResponseBody
// 요청 처리 결과를 JSON 형식의 데이터를 포함한 응답 본문으로 전송 
@CrossOrigin(origins = "*") 
@RestController
public class RestApiBoardController {
	
	@Autowired
	private JpaBoardService jpaBoardService;
	
	//store list
	@RequestMapping(value = "/api/store_list", method = RequestMethod.GET)
	public List<BoardEntity> openBoardList() throws Exception {
		return jpaBoardService.selectBoardList();
	}
	@RequestMapping(value = "/api/store_list/{storeNumber}", method = RequestMethod.GET)
	public List<BoardEntity> openBoardListStoreNum(@PathVariable("storeNumber") String storeNumber) throws Exception {
		return jpaBoardService.selectBoardListStoreNum(storeNumber);
	}

//	// @RequestBody --> 요청 파라미터가 HTTP 본문에 포함되어 있음
//	//                  POST, PUT 방식을 처리할 때 사용
	@RequestMapping(value = "/api/book_table", method = RequestMethod.POST)
	public void saveBoard(@RequestBody BookTable bookTable) throws Exception {
		jpaBoardService.saveBookerUsers(bookTable, null);
	}
	
	//users
	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public List<BookerUsers> openBookerUsersList() throws Exception {
		return jpaBoardService.selectBookerUsersList();
	}
	
	//best menu
	@RequestMapping(value = "/api/best_menu", method = RequestMethod.GET)
	public List<BestMenu> openBestMenuList() throws Exception {
		return jpaBoardService.selectBestMenuList();
	}
	@RequestMapping(value = "/api/best_menu/{storeNumber}", method = RequestMethod.GET)
	public List<BestMenu> openBestMenuStoreNum(@PathVariable("storeNumber") String storeNumber) throws Exception {
		return jpaBoardService.selectBestMenuListStoreNum(storeNumber);
	}
	
	//template
	@RequestMapping(value = "/api/template", method = RequestMethod.GET)
	public List<TemplateEntity> openTemplate() throws Exception {
		return jpaBoardService.selectTemplateList();
	}
}
