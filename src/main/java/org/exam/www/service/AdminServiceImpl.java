package org.exam.www.service;

import org.exam.www.model.AdminVO;
import org.exam.www.repository.AdminDAO;
import org.exam.www.util.IdPasswordNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public AdminAuthInfo authenticate(String adm_id, String adm_pass) throws Exception {
		System.out.println("adm_id"+adm_id);
		AdminVO admin = adminDAO.selectByAdminId(adm_id);
	
        if(admin == null) {
        	System.out.println("정보가 없습니다.");
            throw new IdPasswordNotMatchingException();
        }
        
        if(!admin.matchPassword(adm_pass)) {
        	System.out.println("일치하지 않습니다.");
            throw new IdPasswordNotMatchingException();
        }
        return new AdminAuthInfo(admin.getAdm_num(), admin.getAdm_id(), admin.getAdm_name());
	}





	


		

}
