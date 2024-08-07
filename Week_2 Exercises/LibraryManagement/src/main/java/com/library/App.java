package com.library;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceObj=context.getBean("bookService",BookService.class);
        BookRepository bookRepoObj=context.getBean("bookRepository",BookRepository.class);
        
        //test configuration
        bookServiceObj.testBookService();
        bookRepoObj.testBookRepo();
      
    }
}
