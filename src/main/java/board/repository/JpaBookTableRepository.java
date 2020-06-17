package board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import board.entity.BookTable;

public interface JpaBookTableRepository extends CrudRepository<BookTable, Integer>{
	List<BookTable> findAllByOrderByIdDesc();
	List<BookTable> findAllByStoreNumber(String store_number);
}
