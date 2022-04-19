package org.exam.www.model;


public class MemberVO {

	private int mem_num;//sequence.nextval로 넣을 것
	private String mem_id;
	private String mem_pass;
	private String mem_email;
	private String mem_name;
	private String authstaus;
	

	public MemberVO() {}
	
	public MemberVO(String mem_id,String mem_pass,String mem_email,String mem_name,String authstaus) {
		this.mem_id=mem_id;
		this.mem_pass=mem_pass;
		this.mem_email=mem_email;
		this.mem_name=mem_name;
		this.authstaus=authstaus;
	}
	
	
	
	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getAuthstaus() {
		return authstaus;
	}

	public void setAuthstaus(String authstaus) {
		this.authstaus = authstaus;
	}

	@Override
	public String toString() {
		return "UserVO [mem_num=" + mem_num + ", mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_email="
				+ mem_email + ", mem_name=" + mem_name + ", authstaus=" + authstaus + "]";
	}
	
	//비번 일치 여부
    public boolean matchPassword(String pw) {
        return this.mem_pass.equals(pw);
    }





	


	
}
