package org.exam.www.model;


public class AppraisalVO {

	private int appraisal_num;
	private int book_status_num;
	private int star;
	private String book_comment;
	private String co_prv;
	
	
	public AppraisalVO() {}
	
	public AppraisalVO(int book_status_num, int star, String book_comment, String co_prv) {
		this.book_status_num=book_status_num;
		this.star=star;
		this.book_comment=book_comment;
		this.co_prv=co_prv;
		
	}
	
	public int getAppraisal_num() {
		return appraisal_num;
	}
	public void setAppraisal_num(int appraisal_num) {
		this.appraisal_num = appraisal_num;
	}
	public int getBook_status_num() {
		return book_status_num;
	}
	public void setBook_status_num(int book_status_num) {
		this.book_status_num = book_status_num;
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
	public String getCo_prv() {
		return co_prv;
	}
	public void setCo_prv(String co_prv) {
		this.co_prv = co_prv;
	}
	@Override
	public String toString() {
		return "AppraisalVO [appraisal_num=" + appraisal_num + ", book_status_num=" + book_status_num + ", star=" + star
				+ ", book_comment=" + book_comment + ", co_prv=" + co_prv + "]";
	}
	
	
	




	


	
}
