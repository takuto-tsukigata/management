package jp.co.sample.form;

public class UpdateEmployee {

	private String id;
	private String deoendentsCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeoendentsCount() {
		return deoendentsCount;
	}

	public void setDeoendentsCount(String deoendentsCount) {
		this.deoendentsCount = deoendentsCount;
	}

	@Override
	public String toString() {
		return "UpdateEmployee [id=" + id + ", deoendentsCount=" + deoendentsCount + "]";
	}

}
