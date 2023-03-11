package springboot.authentication.service.impl;

import springboot.authentication.entity.Member;
import springboot.authentication.service.MemberService;

public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;
    @Override
    public Integer insert(Member member){
        return memberDao.insert(member);
    }

    @Override
    public Member findMemberByMaId(String maId){
        return memberDao.findMemberByMaId(maId);
    }

}
