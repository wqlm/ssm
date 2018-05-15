package com.wqlm.ssm.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 提供常用的几种hash算法
 */
public class HashAlgorithm {

    public static final String MD5 = "MD5";
    public static final String SHA256 = "SHA-256";
    public static final String SHA512 = "SHA-512";


    /**
     * 使用MD5散列
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        return hash(str, MD5);
    }


    /**
     * 使用SHA256散列
     *
     * @param str
     * @return
     */
    public static String sha256(String str) {
        return hash(str, SHA256);
    }


    /**
     * 使用SHA512散列
     *
     * @param str
     * @return
     */
    public static String sha512(String str) {
        return hash(str, SHA512);
    }


    /**
     * hash算法
     *
     * @param str  字符串
     * @param type 算法类型
     * @return
     */
    private static String hash(final String str, final String type) {
        // 返回值
        String hashCode = null;

        // 是否是有效字符串
        if (str == null || str.length() == 0) {
            return null;
        }

        try {
            // 传入加密类型，创建加密对象
            MessageDigest messageDigest = MessageDigest.getInstance(type);
            // 传入要加密的字符串
            messageDigest.update(str.getBytes());
            // 得到加密结果
            byte bytes[] = messageDigest.digest();

            StringBuffer hexCode = new StringBuffer();

            // 遍历bytes
            for (byte b : bytes) {
                // 0xff & 将 byte 转换成0-256的int，toHexString 将 10进制int 转换成 16进制
                String hexStr = Integer.toHexString(0xff & b);
                if (hexStr.length() == 1) {
                    //如果这个16进制数小于F，就在前面补零
                    hexCode.append('0');
                }
                hexCode.append(hexStr);
            }
            // 得到16进制加密結果
            hashCode = hexCode.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashCode;
    }

}
