package POJO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestfulGetAPIDataPOJO {
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("color")
	private String color;
	
	@JsonAlias({"capacity","Capacity"})
	private String capacity;
	
	@JsonProperty("capacity GB")
    private int capacityGB; 
	
	@JsonAlias({"Screen size","screenSize"})
	private double screenSize;

	public double getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public int getCapacityGB() {
		return capacityGB;
	}

	public String getCapacity() {
		return capacity;
	}
}