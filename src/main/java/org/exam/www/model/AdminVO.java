package org.exam.www.model;


public class AdminVO {
	//ADMINISTRATOR
	private int adm_num; //sequence.nextval로 넣을 것
	private String adm_name;
	private String adm_id;
	private String adm_pass;
	private String adm_email;
	private String adm_authstatus;
	private String securitycode;
	
	public AdminVO() {}
	
	public AdminVO(String adm_name, String adm_id, String adm_pass, String adm_email, String adm_authstatus, String securitycode) {
		this.adm_name=adm_name;
		this.adm_id=adm_id;
		this.adm_pass=adm_pass;
		this.adm_email=adm_email;
		this.adm_authstatus=adm_authstatus;
		this.securitycode=securitycode;
		
	}
	
	
	
	public int getAdm_num() {
		return adm_num;
	}

	public void setAdm_num(int adm_num) {
		this.adm_num = adm_num;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}

	public String getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}

	public String getAdm_pass() {
		return adm_pass;
	}

	public void setAdm_pass(String adm_pass) {
		this.adm_pass = adm_pass;
	}

	public String getAdm_email() {
		return adm_email;
	}

	public void setAdm_email(String adm_email) {
		this.adm_email = adm_email;
	}

	public String getAdm_authstatus() {
		return adm_authstatus;
	}

	public void setAdm_authstatus(String adm_authstatus) {
		this.adm_authstatus = adm_authstatus;
	}

	public String getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}
	
	
	
	

	@Override
	public String toString() {
		return "AdminVO [adm_num=" + adm_num + ", adm_name=" + adm_name + ", adm_id=" + adm_id + ", adm_pass="
				+ adm_pass + ", adm_email=" + adm_email + ", adm_authstatus=" + adm_authstatus + ", securitycode="
				+ securitycode + "]";
	}

	//비번 일치 여부
    public boolean matchPassword(String pw) {
        return this.adm_pass.equals(pw);
    }
	

	
	
	

	
}
