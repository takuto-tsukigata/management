package jp.co.sample.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployee;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute
	public UpdateEmployee setUpdateEmployeeForm() {
		return new UpdateEmployee();
	}

	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Integer IntegerId = Integer.valueOf(id);
		Employee employee = employeeService.showDetail(IntegerId);
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	@RequestMapping("/update")
	public String update(@Validated UpdateEmployee form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			Employee employee = employeeService.showDetail(Integer.valueOf(form.getId()));
			model.addAttribute("employee", employee);
			return "employee/detail";
		}
		Employee employee = employeeService.showDetail(Integer.valueOf(form.getId()));
		employee.setName(form.getName());
		employee.setGender(form.getGender());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			employee.setHireDate(dateFormat.parse(form.getHireDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setMailAddress(form.getMailAddress());
		employee.setZipCode(form.getZipCode());
		employee.setAddress(form.getAddress());
		employee.setTelephone(form.getTelephone());
		employee.setSalary(Integer.parseInt(form.getSalary()));
		employee.setCharacteristics(form.getCharacteristics());
		employee.setDependentsCount(Integer.valueOf(form.getDependentsCount()));
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
}
