package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.ShippingAddress;
import com.scm.repositery.ShippingAddressRepo;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepo shippingAddressRepo;

    @Override
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressRepo.findAll();
    }

    @Override
    public ShippingAddress getShippingAddressById(Integer id) {
        Optional<ShippingAddress> address = shippingAddressRepo.findById(id);
        return address.orElse(null);
    }

    @Override
    public List<ShippingAddress> getShippingAddressesByUserId(String userId) {
       return shippingAddressRepo.findByUserId(userId);
   // 	return null;
    }

    @Override
    public ShippingAddress createShippingAddress(ShippingAddress address) {
        return shippingAddressRepo.save(address);
    }

    @Override
    public ShippingAddress updateShippingAddress(ShippingAddress address) {
        return shippingAddressRepo.save(address);
    }

    @Override
    public void deleteShippingAddress(Integer id) {
        shippingAddressRepo.deleteById(id);
    }
}