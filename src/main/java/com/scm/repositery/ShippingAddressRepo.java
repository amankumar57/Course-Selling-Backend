package com.scm.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.ShippingAddress;

public interface ShippingAddressRepo extends JpaRepository<ShippingAddress, Integer> {

	
	 // Find all addresses by a specific user
    List<ShippingAddress> findByUserId(String userId);

    // Optionally, find by city or postal code
    List<ShippingAddress> findByCity(String city);
    List<ShippingAddress> findByPostalCode(String postalCode);
}
