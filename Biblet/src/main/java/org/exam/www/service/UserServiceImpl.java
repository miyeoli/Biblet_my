package org.exam.www.service;


import org.exam.www.model.MemberVO;
import org.exam.www.repository.MemberDAO;
import org.exam.www.util.IdPasswordNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
//아이디와 비번 일치 시 AuthInfo 객체 생성
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private MemberDAO memberDAO;


	@Override
	public AuthInfo authenticate(String mem_id, String mem_pass) throws Exception {
		MemberVO member = memberDAO.selectById(mem_id);
        if(member == null) {
            throw new IdPasswordNotMatchingException();
        }
        if(!member.matchPassword(mem_pass)) {
            throw new IdPasswordNotMatchingException();
        }
        return new AuthInfo(member.getMem_num(), member.getMem_id(), member.getMem_name());
    }
	
	/*
	public AuthInfo authenticate(String mem_id, String mem_pass) {
		MemberVO member = (MemberVO) memberDAO.selectById(mem_id);
		//member가 null일 경우 
		if(member == null) {
			throw new IdPasswordMatchingException();
		}
		//비번 일치 여부 확인
		if(!member.matchPassword(mem_pass)) {
			throw new IdPasswordMatchingException();
		}
		return new AuthInfo(member.getMem_num(), member.getMem_id(), member.getMem_name());
	}
	*/


	/*
	@Override
	public String loginCheck(MemberVO user, HttpSession session) {
		String mem_name = memberDAO.loginCheck(user);
		 if (mem_name != null) { // 세션 변수 저장
		  session.setAttribute("mem_id", user.getMem_id());
		  session.setAttribute("mem_name", mem_name);
		}
		 return mem_name; 
	}
	*/
		 
		

}
