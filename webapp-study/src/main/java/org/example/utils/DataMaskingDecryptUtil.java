package org.example.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.example.config.DataMaskingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;

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

//    @Value("data.masking.keyMap.MK")
//    private String my = "1URT200220814160";// must be 16 length
//    @Value("data.masking.keyMap.SK")
//    private String saltKey = "123";
    private static final DataMaskingProperties properties =
        SpringUtils.getBean(DataMaskingProperties.class);
    private static SecretKeySpec sc;
    private static Cipher instance;
    static {

        sc = new SecretKeySpec(Base64Utils.encode(properties.getValue("MY").getBytes()), "AES");
        try {
            instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSalt(String password) throws UnsupportedEncodingException {
        KeyGenerator kgen = null;
        SecureRandom secureRandom = null;
        try {
            kgen = KeyGenerator.getInstance("AES");
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        return bytesToHex(enCodeFormat);
    }
    private SecretKeySpec getAES() throws UnsupportedEncodingException {
        return new SecretKeySpec(getSalt(properties.getValue("MY")).getBytes(), "AES");
    }
    public static byte[] encrypt(String origin) throws Exception{
        instance.init(Cipher.ENCRYPT_MODE, sc);
        return Base64Utils.encode(instance.doFinal(origin.getBytes("utf-8")));
    }
    public static String decrypt(String content) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] decode = Base64Utils.decode(content.getBytes());
        String s = bytesToHex(decode);
        System.out.println(s);
        instance.init(Cipher.DECRYPT_MODE, sc);
        return new String(instance.doFinal(decode), "utf-8");
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
