package com.ynmio.SpringBootAPI.services;
import com.ynmio.SpringBootAPI.dao.BookRepository;
import com.ynmio.SpringBootAPI.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServices {
    @Autowired
    BookRepository bookRepository;

//    private List<Book> bookList=new ArrayList<>();
//
//    public BookServices() {
//        bookList.add(new Book(1,"Python","Neeraj"));
//        bookList.add(new Book(2,"java","Shiva"));
//        bookList.add(new Book(3,"c++","Shivani"));
//        bookList.add(new Book(4,"javaScript","Raj"));
//        bookList.add(new Book(5,"html","Vikash"));
//        bookList.add(new Book(6,"cobul","Akash"));
//    }
    public List<Book> getBookList(){
//        if(bookList.size()<=0){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.of(Optional.of(bookList));
        return (List<Book>) this.bookRepository.findAll();
    }
    public Optional<Book> getBookById(Integer id){
//       Book singleBook = bookList.stream().filter(book -> book.getId()==id).findFirst().get();
//        return singleBook;
         Optional<Book> book= this.bookRepository.findById(id);
         return book;
    }
    public void addBook(Book book){
//        bookList.add(book);
        bookRepository.save(book);
    }
    public void deleteBookById(Integer id){
//        bookList= bookList.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());

        bookRepository.deleteById(id);
    }
    public void updateBookById( Book updatedBook,Integer id){
//        bookList=bookList.stream().map(book->{
//            if(book.getId()==id){
//                book.setBookName(updatedBook.getBookName());
//                book.setAuthor(updatedBook.getAuthor());
//            }return book;
//        }).collect(Collectors.toList());

        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }
}
