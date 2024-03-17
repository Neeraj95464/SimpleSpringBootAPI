package com.ynmio.SpringBootAPI.dao;

import com.ynmio.SpringBootAPI.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findById(int id);
}
