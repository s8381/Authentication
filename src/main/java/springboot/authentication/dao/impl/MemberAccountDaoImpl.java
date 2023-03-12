package springboot.authentication.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import springboot.authentication.dao.MemberAccountDao;
import springboot.authentication.entity.MemberAccount;

import java.util.List;

public class MemberAccountDaoImpl implements MemberAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate jdbcNameTemplate;

    @Override
    public Integer insert(MemberAccount memberAccount) {
        String sql = " INSERT test_project.member_account ( "
                + " USERNAME, PASSWORD, SALT "
                + " CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME "
                + " ) "
                + " VALUE( "
                + " :username, :password, :salt "
                + " :createBy, NOW(), :updateBy, NOW() ";

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(memberAccount);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcNameTemplate.update(sql, parameterSource, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public MemberAccount findMemberAccountByUsername(String username) {
        String sql = " SELECT ID, USERNAME, PASSWORD, SALT "
                + " FROM test_project.member_account "
                + " WHERE USERNAME = ? ";

        List<MemberAccount> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MemberAccount.class), new Object[] { username });
        if(result != null && result.size() > 0){
            return result.get(0);
        }

        return null;
    }

    @Override
    public Integer update(MemberAccount memberAccount) {
        String sql = " UPDATE test_project.member_account "
                + " SET PASSWORD = :password, UPDATE_BY = :updateBy, UPDATE_TIME = NOW() "
                + " WHERE ID = :id ";

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(memberAccount);

        return jdbcNameTemplate.update(sql, parameterSource);
    }
}
