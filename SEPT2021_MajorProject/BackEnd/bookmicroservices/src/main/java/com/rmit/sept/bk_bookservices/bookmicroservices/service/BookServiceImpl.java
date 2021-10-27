package com.rmit.sept.bk_bookservices.bookmicroservices.service;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rmit.sept.bk_bookservices.bookmicroservices.model.Book;
import com.rmit.sept.bk_bookservices.bookmicroservices.repository.BookRepository;
import com.rmit.sept.bk_bookservices.bookmicroservices.service.IPageService;
import com.rmit.sept.bk_bookservices.bookmicroservices.service.IService;

@Service
public class BookServiceImpl implements IService<Book>, IPageService<Book> {

	@Autowired
	private BookRepository bookRepository;
	
	//Gets all books
	@Override
	public Collection<Book> findAll() {
		return (Collection<Book>) bookRepository.findAll();
	}

	//Gets books matching search query
	@Override
	public Page<Book> findAll(Pageable pageable, String searchText) {
		return bookRepository.findAllBooks(pageable, searchText);
	}

	//Creates pagable of books (5 books)
	@Override
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);			
	}

	//Gets book by ID
	@Override
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	//Updates book object
	@Override
	public Book saveOrUpdate(Book book) {
		return bookRepository.save(book);
	}

	//Deletes book by id, pops notification
	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			bookRepository.deleteById(id);
			jsonObject.put("message", "Book deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	//Clears Book Repository 
	public void deleteAllBooks() {
		if(bookRepository.count() > 0) {
			bookRepository.deleteAll();
		}
	}

}
