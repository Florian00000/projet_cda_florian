package com.example.it_training_back.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class StaticMethods {

    public static String saveImage(String base64Image) throws IOException {
        String base64Data = base64Image.split(",")[1]; // Extraire la partie après "data:image/jpeg;base64,"
        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

        String directory = "public/images/";
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + ".png";
        File file = new File(directory + fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(decodedBytes);
        }

        return "/images/" + fileName;
    }
}
