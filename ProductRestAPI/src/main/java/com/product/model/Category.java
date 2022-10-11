package com.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NegativeOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	private String productCategory;
	private Integer discount;
	private Integer GST;
	private Integer deliveryCharge;

}
