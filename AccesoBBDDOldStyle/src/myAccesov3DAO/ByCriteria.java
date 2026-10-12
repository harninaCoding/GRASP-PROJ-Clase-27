package myAccesov3DAO;

public interface ByCriteria<T> {
	String getCampo();
    Class<T> getEntityClass();
    public Integer getPosicion();
    
	public default String getSQl() {
		return "SELECT * FROM " + getEntityClass().getSimpleName() + " WHERE " + getCampo() + " LIKE ?";
	};
	
	public default Criteria<T> getCriteria(String value) {
		return new Criteria<T>(getSQl(), getPosicion(), value);
	};
	
}
