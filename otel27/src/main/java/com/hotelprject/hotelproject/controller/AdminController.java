package com.hotelprject.hotelproject.controller;

import com.hotelprject.hotelproject.model.Admin;
import com.hotelprject.hotelproject.model.HotelUser;
import com.hotelprject.hotelproject.model.dto.ReservationDto;
import com.hotelprject.hotelproject.model.enums.UserRole;
import com.hotelprject.hotelproject.repository.HotelUserRepository;
import com.hotelprject.hotelproject.service.AdminService;
import com.hotelprject.hotelproject.service.HotelUserService;
import com.hotelprject.hotelproject.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService; // AdminService'i inject ediyoruz
    private final HotelUserService hotelUserService;
    private final ReservationService reservationService;

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

        Optional<HotelUser> adminUserOptional = hotelUserService.findAdminUserByEmailAndPassword(email, password);

        if (adminUserOptional.isPresent()) {
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
    public String manageUsers(Model model) {

        model.addAttribute("users", hotelUserService.findAll());
        return "manage-users"; // Manage Users sayfasına yönlendir
    }

    // Rezervasyonları yönetme sayfası (örnek)
    @GetMapping("/admin/manage-reservations")
    public String manageReservations(Model model) {


        List<ReservationDto> reservationDtoList = reservationService.findAllReservations()
                .stream()
                .map(r -> ReservationDto.builder()
                        .id(r.getId())
                        .fullName(r.getUserInfo())
                        .roomNumber(r.getRoom().getId())
                        .checkInDate(r.getReservationDate())
                        .checkOutDate(r.getEndDate())
                        .totalPrice(r.getRoom().getPrice() * (ChronoUnit.DAYS.between(r.getReservationDate(), r.getEndDate())))
                        .status(r.getStatus())
                        .build())
                .toList();

        model.addAttribute("reservations", reservationDtoList);
        return "manage-reservations"; // Manage Reservations sayfasına yönlendir
    }
}