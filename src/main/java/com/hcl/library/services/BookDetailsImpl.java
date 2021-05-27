package com.hcl.library.services;

import java.util.List;

import com.hcl.library.beans.Book;
import com.hcl.library.repositry.BookDAO;
import com.hcl.library.util.UserDefinedException;

public class BookDetailsImpl implements IBookDetails {

	Book e=new Book();
	BookDAO bd=new BookDAO();
	@Override
	public int addDetails(Book b) throws UserDefinedException {
		
		return bd.addDetails(b);
	}

	@Override
	public List<Book> display() {
		
		return bd.display();
	}

	@Override
	public void updateBook(Book b) throws UserDefinedException {
		bd.updateBook(b);	
	}

	public void deleteBook(int id ) throws UserDefinedException {
			bd.deleteBook(id);
	}

	@Override
	public List<Book> searchBook(int id) {
		// TODO Auto-generated method stub
		return bd.searchBook(id);
	}

}
