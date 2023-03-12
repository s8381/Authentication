package springboot.authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.authentication.dao.MemberDao;
import springboot.authentication.entity.MemberAccount;
import springboot.authentication.service.MemberAccountService;

public class MemberAccountServiceImpl implements MemberAccountService {

    @Autowired
    private MemberDao memberDao;
    @Override
    public Integer insert(MemberAccount memberAccount){
        return memberDao.insert(memberAccount);
    }

    @Override
    public MemberAccount findMemberByMaId(String maId){
        return memberDao.findMemberByMaId(maId);
    }

}
