package com.xliu.service;

import com.xliu.mapper.BookMapper;
import com.xliu.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{
//    service调dao层：组合Dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook(Map<String,Integer> map) {
        return bookMapper.queryAllBook(map);
    }

    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

//    public int decBookByName(String bookName) {
//        return bookMapper.decBookByName(bookName);
//    }


}
