package com.hcl.library.services;
import java.util.List;

import com.hcl.library.beans.Book;
import com.hcl.library.util.UserDefinedException;
public interface IBookDetails
{
		public int addDetails(Book b) throws UserDefinedException;
		public List<Book> display();
		public void updateBook(Book b) throws UserDefinedException;
		public void deleteBook(int id ) throws UserDefinedException;
		public List<Book> searchBook(int id);
}
