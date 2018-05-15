package com.wqlm.ssm.common.util;

import java.util.Random;

/**
 * 随机数
 */
public class RandomCode {

    /**
     * 生成n位随机码
     * @param size
     * @return
     */
    public static String getRandomCode(int size) {
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer(size);
        for (int i = 0; i <size ; i++) {
            //得到一个 0到str.length() 的随机数，包括0，不包括 str.length()，次例中为 [0,61]
            int subscript = new Random().nextInt(str.length());
            //获取 string 指定下标的字符
            char ch = str.charAt(subscript);
            sb.append(ch);
        }
        return sb.toString();
    }

}
