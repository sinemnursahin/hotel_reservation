package com.hotelprject.hotelproject.controller;

import com.hotelprject.hotelproject.model.Admin;
import com.hotelprject.hotelproject.service.AdminService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private AdminService adminService; // AdminService'i inject ediyoruz

    // Admin login sayfası
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "adminLogin"; // Admin login sayfasına yönlendirir
    }

    // Admin login işlemi
    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam String email,
                             @RequestParam String password,
                             HttpSession session,
                             Model model) {

        // Sadece admin@gmail.com ve admin123 ile giriş yapılmasına izin veriyoruz
        if ("admin@gmail.com".equals(email) && "admin123".equals(password)) {
            // Admin bulunduysa, session'a admin ismini kaydet
            session.setAttribute("loggedInAdmin", email);
            return "redirect:/admin/panel"; // Admin paneline yönlendir
        } else {
            // Giriş başarısızsa hata mesajı ekler
            model.addAttribute("loginError", "Email veya şifre yanlış. Lütfen tekrar deneyin!");
            return "adminLogin"; // Admin login sayfasını tekrar göster
        }
    }

    // Admin paneli sayfası
    @GetMapping("/admin/panel")
    public String adminPanel(HttpSession session, Model model) {
        // Giriş yapan adminin adını view'a gönder
        String adminName = (String) session.getAttribute("loggedInAdmin");
        if (adminName == null) {
            return "redirect:/admin/login"; // Eğer admin giriş yapmamışsa login sayfasına yönlendir
        }
        model.addAttribute("loggedInAdmin", adminName);
        return "adminPanel"; // "adminPanel" view'ına yönlendirir
    }

    // Admin çıkışı
    @PostMapping("/admin/logout")
    public String adminLogout(HttpSession session) {
        // Session'dan admin bilgisini temizle
        session.invalidate();
        return "redirect:/admin/login"; // Giriş sayfasına yönlendir
    }

    // Kullanıcıları yönetme sayfası (örnek)
    @GetMapping("/admin/manage-users")
    public String manageUsers() {
        return "manageUsers"; // Manage Users sayfasına yönlendir
    }

    // Rezervasyonları yönetme sayfası (örnek)
    @GetMapping("/admin/manage-reservations")
    public String manageReservations() {
        return "manageReservations"; // Manage Reservations sayfasına yönlendir
    }
}