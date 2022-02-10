package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UpdateEmployee {

	/** 従業員ID */
	@Pattern(regexp = "^[0-9]$", message = "IDは整数で入れてください")
	private String id;

	/** 扶養人数 */
	@Pattern(regexp = "^[0-5]$", message = "扶養人数は5人までです")
	private String dependentsCount;

	private String name;
	private String gender;
	private String hireDate;
	private String mailAddress;
	private String zipCode;
	private String address;
	private String telephone;
	private String salary;
	private String characteristics;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	@Override
	public String toString() {
		return "UpdateEmployee [id=" + id + ", dependentsCount=" + dependentsCount + ", name=" + name + ", gender="
				+ gender + ", hireDate=" + hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode
				+ ", address=" + address + ", telephone=" + telephone + ", salary=" + salary + ", characteristics="
				+ characteristics + "]";
	}
	
	

}
