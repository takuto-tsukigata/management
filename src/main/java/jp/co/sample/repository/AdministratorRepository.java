package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/** 管理者をDBに登録 */
	public void insert(Administrator administrator) {

		String insertSql = "INSERT INTO administrators(name,mailAddress,password) VALUES(:name,:mailAddress,:password)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", administrator.getName())
				.addValue("mailAddress", administrator.getMailAddress())
				.addValue("password", administrator.getPassword());
		template.update(insertSql, param);
	}

	public Administrator findByMailAddressAndPassword(String mailAddress, String pasword) {
		String sql = "SELECT id,name,mailAddress,password FROM administratorss WHERE mailAddress=:mailAddress AND password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("pasword",
				pasword);
		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		if (administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}
}
