package model;

public class BuyingList {
	
	private Long id;
	private String email;
	private String model;
	public BuyingList(String email, String model) {
		super();
		this.email = email;
		this.model = model;
	}
	public BuyingList(Long id, String email, String model) {
		super();
		this.id = id;
		this.email = email;
		this.model = model;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
