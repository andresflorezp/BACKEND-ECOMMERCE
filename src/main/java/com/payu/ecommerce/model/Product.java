/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Product.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The id
	 */
	@Id
	@GeneratedValue
	@Column(name = "IdProduct")
	private Long id;

	/**
	 * The name
	 */
	private String name;

	/**
	 * The category
	 */
	private String category;

	/**
	 * The description
	 */
	private String description;

	/**
	 * The price
	 */
	private Double price;


	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Cart> carts = new ArrayList<Cart>();

	/**
	 * @param name
	 * @param category
	 * @param description
	 * @param price
	 */
	public Product(String name, String category, String description, Double price) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;

	}

	/**
	 * The empty constructor
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the carts
	 */
	public List<Cart> getCarts() {
		return carts;
	}

	/**
	 * @param carts
	 */
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	/**
	 * The representational string of the class Product
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + "]";
	}

}
