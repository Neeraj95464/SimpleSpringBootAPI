package com.ynmio.SpringBootAPI.controller;

import com.ynmio.SpringBootAPI.model.Book;
import com.ynmio.SpringBootAPI.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookServices bookServices;
    @GetMapping("/")
    public String homePage(){
        return "This is Home Page ";
    }
    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookServices.getBookList();
    }
    @GetMapping("/book/{id}")
    public Optional<Book> getSingleBook(@PathVariable("id") int id){
        return bookServices.getBookById(id);
    }
    @PostMapping("/book")
    public void addBook(@RequestBody Book book){
        bookServices.addBook(book);
    }
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookServices.deleteBookById(id);
    }
    @PutMapping("/book/{id}")
    public void updateBookById(@RequestBody Book book, @PathVariable("id") int id){
        bookServices.updateBookById(book,id);
    }
}
