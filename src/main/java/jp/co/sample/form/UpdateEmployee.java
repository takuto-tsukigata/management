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

	@Override
	public String toString() {
		return "UpdateEmployee [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

}
