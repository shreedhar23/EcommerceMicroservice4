/**
 * 
 */
package com.learn.microservices.ecommerce.customer.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

/**
 * @author Mallige
 *
 */
@Entity
@Table(name="CUSTOMER_DETAILS")
public @Data class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerFirstName;
	private String customerLastName;
	private Date dateOfBirth;
	//@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	/*@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
    private Set<Address> address;*/
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private Set<Address> address;

}
