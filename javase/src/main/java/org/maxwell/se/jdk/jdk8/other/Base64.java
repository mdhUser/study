package org.maxwell.se.jdk.jdk8.other;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 22:48
 */
public class Base64 {

    public static void main(String[] args) throws IOException {

        //早期jdk加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        BASE64Decoder decoder = new BASE64Decoder();
//
//        String text="小滴课堂";
//        byte[] textByte=text.getBytes(StandardCharsets.UTF_8);
//
//        //todo 编码
//        String encodedText =encoder.encode(textByte);
//        System.out.println(encodedText);
//        //todo 解码
//        System.out.println(new String(decoder.decodeBuffer(encodedText),"UTF-8"));


        //jdk1.8 Base64加密
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        byte[] textByte = "小滴课堂".getBytes(StandardCharsets.UTF_8);
        //编码
        String encoderText = encoder.encodeToString(textByte);
        System.out.println(encoderText);
        //解码
        System.out.println(new String(decoder.decode(encoderText), "UTF-8"));


    }
}