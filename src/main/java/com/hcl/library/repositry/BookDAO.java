package com.hcl.library.repositry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.library.beans.Book;
import com.hcl.library.util.DBConnection;
import com.hcl.library.util.UserDefinedException;

public class BookDAO {

	// Inserting the values
	public int addDetails(Book b) throws UserDefinedException {
		Connection con = DBConnection.getConnection();
		PreparedStatement psstmt = null;
		int n = 0;
		try {
			if (!searchById(b.getId())) {
				String insertvalues = "insert into book values(?,?,?,?)";
				psstmt = con.prepareStatement(insertvalues);
				psstmt.setInt(1, b.getId());
				psstmt.setString(2, b.getTitle());
				psstmt.setString(3, b.getAuthor());
				psstmt.setInt(4, b.getPrice());
				n = psstmt.executeUpdate();
			} else {
				throw new UserDefinedException("Book ID already exsits.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(psstmt);
		}
		return n;
	}

	// display details
	public List<Book> display() {
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Book> ls = new ArrayList<Book>();
		try {

			String str = "select id,title,author,price from book";
			stmt = con.prepareStatement(str);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getInt("price"));
				ls.add(b);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}

		return ls;

	}
	// Delete details

	public void deleteBook(int id) throws UserDefinedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			if (searchById(id)){
				Connection con = DBConnection.getConnection();
				String sql = "delete from book where id =?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			}
			else {
				throw new UserDefinedException("Cannot delete as book id doesnotExists");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {		
			closeStatement(ps);
		}
	}

	// Updateprice

	public void updateBook(Book book) throws UserDefinedException {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = null;
		try {
				if (searchById(book.getId())) {
				String sql = "update book set title=? ,author=?, price=? where id=?";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, book.getTitle());
				ps.setString(2, book.getAuthor());
				ps.setInt(3, book.getPrice());
				ps.setInt(4, book.getId());
				ps.executeUpdate();
			}else {
				throw new UserDefinedException("Book Id doesn't exsits.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {		
			closeStatement(ps);
			
		}
	}
	
	
	
	//search
	public List<Book> searchBook(int id) {
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Book> ls = new ArrayList<Book>();
			
			String str = "select id,title,author,price from book where id=?";
			try {
				stmt = con.prepareStatement(str);
				stmt.setInt(1,id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Book b = new Book();
					b.setId(rs.getInt("id"));
					b.setTitle(rs.getString("title"));
					b.setAuthor(rs.getString("author"));
					b.setPrice(rs.getInt("price"));
					ls.add(b);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {		
				closeStatement(stmt);
				closeResultSet(rs);
			}
		return ls;
	}

	// search by Title
	public boolean searchById(int id) {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM book WHERE id = ?");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			int n1 = 0;
            while ( rs.next() ) {
                n1 = rs.getInt(1);
            }
            if ( n1 > 0 ) {
               return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {		
			closeStatement(ps);
			closeResultSet(rs);
		}
        return false; 
	}
	
	public void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void closeStatement(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
