package com.example.qrcodegenerate.controller;

import com.example.qrcodegenerate.generator.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author * Sunnatullayev Mahmudnazar *  * qrCodeGenerate *  * 10:05 *
 */

@Controller
public class MainController {
//    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

    @GetMapping("/")
    public String getQRCode(Model model){

        byte[] image = new byte[0];

        // Generate and Return Qr Code in Byte Array
        image = QRCodeGenerator.getQRCodeImage(UUID.randomUUID().toString(),250,250);

        // Generate and Save Qr Code Image in static/image folder
//        QRCodeGenerator.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);

        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }
}
