package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class Address {
	
	////////// Properties
	@NotNull()
	@Size(min=5, max=50)
	private int addressId;
	@NotNull()
	@Size(min=5, max=50)
	private String street;
	@NotNull()
	@Size(min=5, max=50)
	private String street2;
	@NotNull()
	@Size(min=5, max=50)
	private String city;
	@NotNull()
	@Size(min=5, max=50)
	private String state;
	
	private int postalCode;
	@NotNull()
	@Size(min=5, max=50)
	private String addressType;
	
	////////// Constructors
	public Address() {
		super();
	}

	public Address(int addressId, String street, String street2, String city, String state, int postalCode,
			String addressType) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.addressType = addressType;
	}
	
	////////// Getters and Setters
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	////////// ToString Method
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", street2=" + street2 + ", city=" + city
				+ ", state=" + state + ", postalCode=" + postalCode + ", addressType=" + addressType + "]";
	}
}
