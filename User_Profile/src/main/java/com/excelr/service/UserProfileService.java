package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.model.Address;
import com.excelr.model.Order;
import com.excelr.model.Product;
import com.excelr.model.UserProfile;
import com.excelr.repo.UserProfileRepository;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getUserProfile(String email) {
        return userProfileRepository.findByEmail(email);
    }

    public UserProfile updateUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public List<Order> getOrderHistory(String email) {
        UserProfile userProfile = userProfileRepository.findByEmail(email);
        return userProfile.getOrderHistory();
    }

    public List<Product> getWishlist(String email) {
        UserProfile userProfile = userProfileRepository.findByEmail(email);
        return userProfile.getWishlist();
    }

    public List<Address> getAddressBook(String email) {
        UserProfile userProfile = userProfileRepository.findByEmail(email);
        return userProfile.getAddressBook();
    }
}
