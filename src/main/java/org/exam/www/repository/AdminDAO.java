package org.exam.www.repository;

import org.exam.www.model.AdminVO;


public interface AdminDAO {
	
	public AdminVO selectByAdminId(String adm_id);


}
