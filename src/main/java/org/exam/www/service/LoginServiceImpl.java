package org.exam.www.service;

import org.exam.www.exception.AuthstatusException;
import org.exam.www.exception.IdPasswordNotMatchingException;
import org.exam.www.exception.NullException;
import org.exam.www.model.AdminVO;
import org.exam.www.model.CommandAdminAuthInfo;
import org.exam.www.model.CommandLogin;
import org.exam.www.model.MemberVO;
import org.exam.www.repository.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;

	//일반 로그인
	@Override
	public CommandLogin authenticate(String mem_id, String mem_pass, int authstatus) throws Exception {
		MemberVO member = loginDAO.selectById(mem_id);
        if(member == null) {
        	System.out.println("null");
        	throw new IdPasswordNotMatchingException();
        }
        if(!member.matchPassword(mem_pass)) {
        	System.out.println("비번 일치 여부");
            throw new IdPasswordNotMatchingException();
        }
        if(member.getAuthstatus() == 0) {
			throw new AuthstatusException();
		}
        return new CommandLogin();
    }

	//관리자 로그인
	@Override
	public CommandAdminAuthInfo adminauthenticate(String adm_id, String adm_pass) throws Exception {
		AdminVO admin = loginDAO.selectByAdminId(adm_id);
        if(admin == null) {
        	System.out.println("정보가 없습니다.");
            throw new IdPasswordNotMatchingException();
        }
        
        if(!admin.matchPassword(adm_pass)) {
        	System.out.println("일치하지 않습니다.");
            throw new IdPasswordNotMatchingException();
        }
        return new CommandAdminAuthInfo(admin.getAdm_num(), admin.getAdm_id(), admin.getAdm_name());
	}

	





	


		

}
