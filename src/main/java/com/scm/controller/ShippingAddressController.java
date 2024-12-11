package com.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.ShippingAddressService;
import com.scm.entity.ShippingAddress;

@RestController
@RequestMapping("/api/shipping-addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    // GET all shipping addresses
    @GetMapping
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressService.getAllShippingAddresses();
    }

    // GET shipping address by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShippingAddress> getShippingAddressById(@PathVariable Integer id) {
        ShippingAddress address = shippingAddressService.getShippingAddressById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET all shipping addresses for a specific user
    @GetMapping("/user/{userId}")
    public List<ShippingAddress> getShippingAddressesByUserId(@PathVariable String userId) {
        return shippingAddressService.getShippingAddressesByUserId(userId);
    }
  // POST create a new shipping address
    @PostMapping
    public ResponseEntity<ShippingAddress> createShippingAddress(@RequestBody ShippingAddress address) {
        ShippingAddress createdAddress = shippingAddressService.createShippingAddress(address);
        return ResponseEntity.ok(createdAddress);
    }
    // PUT update a shipping address
    @PutMapping("/{id}")
    public ResponseEntity<ShippingAddress> updateShippingAddress(@PathVariable Integer id, @RequestBody ShippingAddress address) {
        address.setId(id);
        ShippingAddress updatedAddress = shippingAddressService.updateShippingAddress(address);
        if (updatedAddress != null) {
            return ResponseEntity.ok(updatedAddress);
        } else {
            return ResponseEntity.notFound().build();
        } }

    // DELETE a shipping address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingAddress(@PathVariable Integer id) {
        shippingAddressService.deleteShippingAddress(id);
        return ResponseEntity.noContent().build();
    }
}
