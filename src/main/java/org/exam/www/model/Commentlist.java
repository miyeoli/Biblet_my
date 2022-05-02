package org.exam.www.model;

public class Commentlist {
	
	private String isbn;
	private int star;
	private String book_comment;
	private String mem_id;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getBook_comment() {
		return book_comment;
	}
	public void setBook_comment(String book_comment) {
		this.book_comment = book_comment;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "CommentlistCommand [isbn=" + isbn + ", star=" + star + ", book_comment=" + book_comment + ", mem_id="
				+ mem_id + "]";
	}
	
	
	

}
