package com.shopx.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.id.IncrementGenerator;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Games")
@Component
public class Game {
	
	private String gameimage;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
//	if you setting a variable unique donot set the size more than string size(225)
	@Column(name = "Name", unique = true)
	@Size(min = 1, message = "Name must have atleast 1 letter and less than 225")
	private String game_name;
	@Column(name = "Email")
	@Size(min = 1, message = "Enter proper Email")
	private String email;
	@Column(name = "Brand")
	@Size(min = 1, message = "Name must have atleast 1 letter")
	private String brand;
	@Column(name = "Platform")
	private String platform;
	@Column(name = "Rating")
	private String rating;
	@Column(name = "Category")
	private String category;
	@Column(name = "Description", length = 999999)
//	@Size(min = 1, message = "Fill in the Description")
	@NotBlank(message = "Enter Description")
	private String description;
	@Column(name = "Link", length = 999999)
//	@Size(min = 1, message = "Fill in the Link")
	@NotBlank(message = "Enter Link")
	private String link;
	@Column(name = "Quantity")
//	@NotBlank(message = "Quantity can not be blank")
	@Min(0)
	private int quantity;
	@Column(name = "Price")
//	@NotBlank(message = "Price can not be blank")
	@Min(0)
	private float price;
	@Column(name = "AdAuthority")
	private String adauthority;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getBrand() {
		return brand;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGameimage() {
		return gameimage;
	}
	public void setGameimage(String gameimage) {
		this.gameimage = gameimage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAdauthority() {
		return adauthority;
	}
	public void setAdauthority(String adauthority) {
		this.adauthority = adauthority;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", game_name=" + game_name + ", email=" + email + ", brand="
				+ brand + ", platform=" + platform + ", rating=" + rating + ", category=" + category + ", description="
				+ description + ", link=" + link + ", quantity=" + quantity + ", price=" + price + ", adauthority="
				+ adauthority + "]";
	}
	
	
	
}
