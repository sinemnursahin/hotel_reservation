package com.hotelprject.hotelproject.service;

import com.hotelprject.hotelproject.model.Admin;
import java.util.Optional;

public interface AdminService {
    Optional<Admin> findByEmailAndPassword(String email, String password);
    Admin saveAdmin(Admin admin);
    Optional<Admin> findById(Long id);
}