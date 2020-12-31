package board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import board.entity.BookTable;

public interface JpaBookTableRepository extends CrudRepository<BookTable, Integer>{
	List<BookTable> findAllByOrderByIdDesc();
	List<BookTable> findAllByStoreNumber(String store_number);
	
	@Query("SELECT file FROM BookTable file WHERE storeNumber = :storeNumber AND bookDate = :bookDate")
	List<BookTable> findBookDate(@Param("storeNumber") String storeNumber, @Param("bookDate") String bookDate);
	
	@Query("SELECT file FROM BookTable file WHERE storeNumber = :storeNumber AND bookDate >= :bookDate1 AND bookDate <= :bookDate2")
	List<BookTable> findBookWeek(@Param("storeNumber") String storeNumber, @Param("bookDate1") String bookDate1
			, @Param("bookDate2") String bookDate2);
	
	@Query("SELECT file FROM BookTable file WHERE storeNumber = :storeNumber AND bookMonth = :bookMonth")
	List<BookTable> findBookMonth(@Param("storeNumber") String storeNumber, @Param("bookMonth") String bookMonth);

}
