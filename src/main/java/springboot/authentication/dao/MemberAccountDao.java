package springboot.authentication.dao;

import springboot.authentication.entity.MemberAccount;

public interface MemberAccountDao {
    Integer insert(MemberAccount memberAccount);
    MemberAccount findMemberAccountByUsername(String username);
    Integer update(MemberAccount memberAccount);
}
