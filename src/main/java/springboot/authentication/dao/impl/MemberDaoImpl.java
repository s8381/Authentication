package springboot.authentication.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import springboot.authentication.dao.MemberDao;
import springboot.authentication.entity.Member;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate jdbcNameTemplate;

    @Override
    public Integer insert(Member member){
        String sql = " INSERT test_project.member_account ("
                + " USERNAME, PASSWORD, SALT, "
                + " CREATED_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME "
                + " ) "
                + " VALUE ( "
                + " :username, :password, :salt, "
                + " :createdBy, NOW(), :updateBy, NOW() "
                + " ) ";

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(member);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcNameTemplate.update(sql, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Member findMemberByMaId(String maId){
        String sql = " SELECT  "
                + " ID, USERNAME, PASSWORD, SALT  "
                + " FROM test_project.member_account "
                + " WHERE MA_ID = ? ";

        List<Member> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Member.class), new Object[] {maId});
        if(result != null && result.size() > 0){
            return result.get(0);
        }

        return null;
    }

    @Override
    public Integer update(Member member){
        String sql = "UPDATE test_project.member SET "
                + " ID_NUMBER = :idNumber, BIRTHDAY = :birthday, PHONE = :phone, C_ID = :cId, D_ID = :dId, ADDRESS = :address, "
                + " UPDATE_BY = :updateBy, UPDATE_TIME = NOW() "
                + " WHERE MA_ID = :maId ";

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(member);
        return jdbcNameTemplate.update(sql, parameterSource);
    }
}
