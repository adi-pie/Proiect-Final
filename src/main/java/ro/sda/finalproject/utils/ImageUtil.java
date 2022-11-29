package ro.sda.finalproject.utils;


import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

public class ImageUtil {
    public String getImageData(byte[] byteData) {
        return Base64.getMimeEncoder().encodeToString(byteData);
    }
}


