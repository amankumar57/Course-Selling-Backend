package com.scm.Service;

import java.util.List;

import com.scm.entity.ShippingAddress;

public interface ShippingAddressService {
	
	List<ShippingAddress> getAllShippingAddresses();

    ShippingAddress getShippingAddressById(Integer id);

    List<ShippingAddress> getShippingAddressesByUserId(String userId);

    ShippingAddress createShippingAddress(ShippingAddress address);

    ShippingAddress updateShippingAddress(ShippingAddress address);

    void deleteShippingAddress(Integer id);

}
