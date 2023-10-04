package model;

public class Car {
	
	private Long id;
	private String carImage;
	private String model;
	private String price;
	private String power;
	private String topSpeed;
	private Integer numberOfSeats;
	private String brand;
	private Integer stock;
	public Car(String carImage, String model, String price, String power, String topSpeed, Integer numberOfSeats,
			String brand, Integer stock) {
		super();
		this.carImage = carImage;
		this.model = model;
		this.price = price;
		this.power = power;
		this.topSpeed = topSpeed;
		this.numberOfSeats = numberOfSeats;
		this.brand = brand;
		this.stock = stock;
	}
	public Car(Long id, String carImage, String model, String price, String power, String topSpeed,
			Integer numberOfSeats, String brand, Integer stock) {
		super();
		this.id = id;
		this.carImage = carImage;
		this.model = model;
		this.price = price;
		this.power = power;
		this.topSpeed = topSpeed;
		this.numberOfSeats = numberOfSeats;
		this.brand = brand;
		this.stock = stock;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carImage=" + carImage + ", model=" + model + ", price=" + price + ", power=" + power
				+ ", topSpeed=" + topSpeed + ", numberOfSeats=" + numberOfSeats + ", brand=" + brand + ", stock="
				+ stock + "]";
	}
	
	
	
}