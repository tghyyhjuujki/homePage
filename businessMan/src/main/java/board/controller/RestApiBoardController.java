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
@RestController
@CrossOrigin(origins = "*")
public class RestApiBoardController {
	
	@Autowired
	private JpaBoardService jpaBoardService;
	
	@RequestMapping(value = "/api/store_list", method = RequestMethod.GET)
	public List<BoardEntity> openBoardList() throws Exception {
		//System.out.println("hi");
		return jpaBoardService.selectBoardList();
	}
	
	@RequestMapping(value = "/api/store_list/users/{userId}", method = RequestMethod.GET)
	public List<BoardEntity> openBoardListUserId(@PathVariable("userId") String userId) throws Exception {
		return jpaBoardService.selectBoardListUserId(userId);
	}
	
	@RequestMapping(value = "/api/store_list/{storeNumber}", method = RequestMethod.GET)
	public List<BoardEntity> openBoardListStoreNum(@PathVariable("storeNumber") String storeNumber) throws Exception {
		return jpaBoardService.selectBoardListStoreNum(storeNumber);
	}
	
	@RequestMapping(value = "/api/store_list", method = RequestMethod.POST)
	public void saveBoard(@RequestBody BoardEntity board) throws Exception {
		jpaBoardService.saveFirstBoard(board);
	}
	
	//best menu
	@RequestMapping(value = "/api/best_menu", method = RequestMethod.GET)
	public List<BestMenu> openBestMenuList() throws Exception {
		return jpaBoardService.selectBestMenuList();
	}
	@RequestMapping(value = "/api/best_menu", method = RequestMethod.POST)
	public void saveBestMenu(@RequestBody BestMenu bestMenu) throws Exception {
		jpaBoardService.saveBestMenu(bestMenu);
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
	@RequestMapping(value = "/api/template", method = RequestMethod.POST)
	public void saveTemplate(@RequestBody TemplateEntity templateEntity) throws Exception {
		jpaBoardService.saveTemplate(templateEntity);
	}
	
	//users
	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public List<BookerUsers> openBookerUsersList() throws Exception {
		return jpaBoardService.selectBookerUsersList();
	}
	
	//book table
	@RequestMapping(value = "/api/book_table", method = RequestMethod.GET)
	public List<BookTable> openBookTableList() throws Exception {
		return jpaBoardService.selectBookTableList();
	}
	
	@RequestMapping(value = "/api/book_table/{store_number}", method = RequestMethod.GET)
	public List<BookTable> openBookTableListStoreNum(@PathVariable("store_number") String store_number) throws Exception {
		return jpaBoardService.selectBookTableListStoreNum(store_number);
	}
	
	@RequestMapping(value = "/api/book_table/{store_number}/{bookDate}", method = RequestMethod.GET)
	public List<BookTable> openBookTableListStoreNumBookDate(@PathVariable("store_number") String store_number
			,@PathVariable("bookDate") String bookDate) throws Exception {
		return jpaBoardService.selectBookTableListStoreNumBookDate(store_number, bookDate);
	}
	
	@RequestMapping(value = "/api/book_table/{store_number}/{bookDate1}/{bookDate2}", method = RequestMethod.GET)
	public List<BookTable> openBookTableListStoreNumWeek(@PathVariable("store_number") String store_number
			,@PathVariable("bookDate1") String bookDate1, @PathVariable("bookDate2") String bookDate2) throws Exception {
		return jpaBoardService.selectBookTableListStoreNumBookWeek(store_number, bookDate1, bookDate2);
	}
	
	@RequestMapping(value = "/api/book_table/book/{store_number}/{bookMonth}", method = RequestMethod.GET)
	public List<BookTable> openBookTableListStoreNumBookMonth(@PathVariable("store_number") String store_number
			,@PathVariable("bookMonth") String bookMonth) throws Exception {
		return jpaBoardService.selectBookTableListStoreNumBookMonth(store_number, bookMonth);
	}

}
