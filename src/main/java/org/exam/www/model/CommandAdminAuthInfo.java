package org.exam.www.model;
//세션 유지
public class CommandAdminAuthInfo {
	private int adm_num;
	private String adm_id;
	private String adm_name;
	
	public CommandAdminAuthInfo(int adm_num, String adm_id, String adm_name) {
		this.adm_num = adm_num;
		this.adm_id = adm_id;
		this.adm_name = adm_name;
	}

	public int getAdm_num() {
		return adm_num;
	}

	public void setAdm_num(int adm_num) {
		this.adm_num = adm_num;
	}

	public String getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}

	
	
	




}