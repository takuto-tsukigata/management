package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hireDate"));
		employee.setMailAddress(rs.getString("mailAddress"));
		employee.setZipCode(rs.getString("zipCode"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristic(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependentsCount"));
		return employee;
	};
	@Autowired
	private NamedParameterJdbcTemplate template;

	public List<Employee> findAll() {
		String sql = "SELECT id,name,image,gender,hireDate,mailAddress,zipCode,address,telephone,salary,characteristics,dependentsCount"
				+ " FROM employees ORDER BY hireDate DESC";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return employeeList;

	}

	public Employee load(Integer id) {
		String sql = "SELECT id,name,image,gender,hireDate,mailAddress,zipCode,address,telephone,salary,characteristics,dependentsCount"
				+ " FROM employees WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
}
