package com.emailotp.emailotp;

import java.util.Random;

public class OtpUtil {
    public static String generateOtp() {
        int otp = 100000 + new Random().nextInt(900000); // 6-digit OTP
        return String.valueOf(otp);
    }
}
