package com.ssm.utils;

import org.apache.shiro.codec.Hex;

import java.security.MessageDigest;
import java.util.Random;

public class PasswordUtils {
    /**
     * 生成含有随机盐的密码
     *
     * @param salt     盐值
     * @param password 密码
     * @return String
     */
    public static String generateMd5(String password,String salt) {

        return md5Hex(password + salt);
    }

    /**
     * 校验密码是否正确
     * @param password 密码
     * @param salt  盐值
     * @param passwordMd5 盐值加密后的密码
     * @return Boolean
     */
    public static boolean verify(String password, String salt, String passwordMd5) {

        return md5Hex(password + salt).equals(passwordMd5);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     * @param str 字符串
     * @return String
     */
    public static String md5Hex(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(str.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String salt = getRandomString(5);
        System.out.println(salt);

        System.out.println(generateMd5("jiangda",salt));
        System.out.println(verify("jiangda",salt,generateMd5("jiangda",salt)));
    }

}
