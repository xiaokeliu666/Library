package com.xliu.controller;

import com.xliu.pojo.Books;
import com.xliu.service.BookService;
import com.xliu.util.ReadExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
//    调Service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

//    查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";

    }

//    跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

//    添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks",books);
        return "updateBook";
    }

    @RequestMapping("/updatebook")
    public String updateBook(Books books) {
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        List<Books> books = bookService.queryBookByName(queryBookName);
        model.addAttribute("list",books);
        return "allBook";
    }

//    @RequestMapping("/decBook")
//    public String decBook(String bookName) {
//        bookService.decBookByName(bookName);
//        return "redirect:/book/allBook";
//    }
    @RequestMapping("/batchAdd")
    public String batchAdd(MultipartFile file) throws IOException, InvalidFormatException {

       String originalFileName = file.getOriginalFilename();
       String myPath = "D:\\fileupload\\"+originalFileName;
       file.transferTo(new File(myPath));

       XSSFWorkbook wb = new XSSFWorkbook(new File(myPath));

       XSSFSheet xssfSheet = wb.getSheetAt(0);

       if (xssfSheet != null) {
           for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
               XSSFRow xssfRow = xssfSheet.getRow(rowNum);
//               System.out.println(xssfRow.getCell(0).getStringCellValue()
//                       +(int)xssfRow.getCell(1).getNumericCellValue()
//                       +xssfRow.getCell(2).getStringCellValue());
               Books books = new Books();
               books.setBookName(xssfRow.getCell(0).getStringCellValue());
               books.setBookCounts((int)xssfRow.getCell(1).getNumericCellValue());
               books.setDetail(xssfRow.getCell(2).getStringCellValue());
               bookService.addBook(books);

//               bookService.addBook(new Books(xssfSheet.getRow(rowNum).getCell(0).getStringCellValue(),
//                       (int)xssfSheet.getRow(rowNum).getCell(1).getNumericCellValue(),
//                       xssfSheet.getRow(rowNum).getCell(2).getStringCellValue()))
//               for (int colNum = 0; colNum <= 2; colNum++) {
//                   XSSFRow xssfrow = xssfSheet.getRow(rowNum);
//                   System.out.println(xssfrow.getCell(colNum));
//               }
           }
       }

        return "redirect:/book/allBook";
    }
}
