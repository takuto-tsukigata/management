package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {
	private final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);
	@Autowired
	private NamedParameterJdbcTemplate template;

	public List<Employee> findAll() {

		String sql = "SELECT id,name,image,gender,hireDate,mailAddress,zipCode,address,telephone,salary,characteristics "
				+ "FROM employees ORDER BY hireDate";

		List<Employee> employeeList = template.query(sql.toString(), EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}

	public Employee load(Integer id) {
		String sql = "SELECT id,name,image,gender,hireDate,mailAddress,zipCode,address,telephone,salary,characteristics FROM employees WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql.toString(), param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}

	public void update(Employee employee) {

		String sql = "UPDATE employees SET name = :name,image = :image,gender = :gender,hireDate = :hireDate,mailAddress = :mailAddress,zipCode = :zipCodetelephone = :telephone,salary = :salarycharacteristics = :characteristics WHERE id = :id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		template.update(sql.toString(), param);

	}
}