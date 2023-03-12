package springboot.authentication.dao;

import springboot.authentication.entity.Member;
import springboot.authentication.entity.MemberAccount;

public interface MemberDao {

    Integer insert(Member member);
    Member findMemberByMaId(String maId);
    Integer update(Member member);
}
