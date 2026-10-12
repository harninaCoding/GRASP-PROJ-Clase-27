package myAccesov3DAO;

public class Criteria<T> {
	
	private String sql;
	private int order;
	private String value;
	
	public Criteria(String sql, int order, String value) {
		super();
		this.sql = sql;
		this.order = order;
		this.value = value;
	}
	
	public String getSql() {
		return sql;
	}
	public int getOrder() {
		return order;
	}
	public String getValue() {
		return value;
	}

	

}
