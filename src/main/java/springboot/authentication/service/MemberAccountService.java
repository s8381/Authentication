package springboot.authentication.service;

import springboot.authentication.entity.Member;

public interface MemberService {

    Integer insert(Member member);
    Member findMemberByMaId(String maId);
}
