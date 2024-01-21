package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.config.DataMaskingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author : Str2ke
 * @date : 2024/1/21 上午2:26
 * @Desc :
 */
@Slf4j
public class DataMaskingDecryptUtil {

    @Value("data.masking.keyMap.MK")
    private static String my = "1URT200220814160";// must be 16 length

    public static byte[] encrypt(String origin) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(my.getBytes(), "AES"));
        return instance.doFinal(origin.getBytes("utf-8"));
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte[] encrypt = DataMaskingDecryptUtil.encrypt("123");
        System.out.println(bytesToHex(encrypt));
    }
}
