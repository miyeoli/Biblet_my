package org.exam.www.service;


import org.exam.www.model.MemberVO;
import org.exam.www.repository.MemberDAO;
import org.exam.www.util.IdPasswordNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
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
	//findbyid
	@Override
	public MemberVO findById(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDAO.findById(member);
	}
	*/


		

}
