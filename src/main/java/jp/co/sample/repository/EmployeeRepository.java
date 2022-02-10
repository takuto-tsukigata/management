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

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Employee> Employee_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setHireDate(rs.getTimestamp("hire_date"));
		employee.setGender(rs.getString("gender"));
		employee.setImage(rs.getString("image"));
		employee.setZipCode(rs.getString("zip_code"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setMailAddress(rs.getString("mail_address"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependents_count"));

		return employee;
	};;

	public List<Employee> findAll() {
		String findAllSql = "SELECT * FROM employees ORDER BY hire_date DESC;";
		List<Employee> employeeList = template.query(findAllSql, Employee_ROW_MAPPER);
		return employeeList;
	}

	public Employee load(Integer id) {

		String loadSql = "SELECT * FROM employees WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(loadSql, param, Employee_ROW_MAPPER);
		return employee;
	}

	public void update(Employee employee) {

		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		String updateSql = "UPDATE employees SET name=:name,image=:image,"
				+ " gender=:gender,hire_date=:hireDate, mail_address=:mailAddress,"
				+ " zip_code=:zipCode, address=:address, telephone=:telephone,"
				+ " salary=:salary, characteristics=:characteristics, dependents_count=:dependentsCount"
				+ " WHERE id=:id;";
		template.update(updateSql, param);
	}
}