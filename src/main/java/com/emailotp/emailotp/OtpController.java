package com.emailotp.emailotp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OtpController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        String otp = OtpUtil.generateOtp();
        emailService.sendOtpEmail(email, otp);
        // Optionally, store OTP temporarily in cache (e.g., Redis)
        return ResponseEntity.ok("OTP sent to " + email);
    }
}
