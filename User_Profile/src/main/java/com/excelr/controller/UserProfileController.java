package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.Address;
import com.excelr.model.Order;
import com.excelr.model.Product;
import com.excelr.model.UserProfile;
import com.excelr.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/profile/{email}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String email) {
        UserProfile userProfile = userProfileService.getUserProfile(email);
        return ResponseEntity.ok(userProfile);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile updatedProfile = userProfileService.updateUserProfile(userProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/order-history/{email}")
    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable String email) {
        List<Order> orderHistory = userProfileService.getOrderHistory(email);
        return ResponseEntity.ok(orderHistory);
    }

    @GetMapping("/wishlist/{email}")
    public ResponseEntity<List<Product>> getWishlist(@PathVariable String email) {
        List<Product> wishlist = userProfileService.getWishlist(email);
        return ResponseEntity.ok(wishlist);
    }

    @GetMapping("/address-book/{email}")
    public ResponseEntity<List<Address>> getAddressBook(@PathVariable String email) {
        List<Address> addressBook = userProfileService.getAddressBook(email);
        return ResponseEntity.ok(addressBook);
    }
}
