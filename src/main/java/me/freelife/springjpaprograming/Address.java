package me.freelife.springjpaprograming;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String street;
	private String city;
	private String state;
	private String zipCode;
}
