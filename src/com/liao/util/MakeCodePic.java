package com.liao.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class MakeCodePic {
    // 字符数字
    private static char[] charArray = {'a', 'b', 'e', 'f', 'h', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', '3', '4', '5', '6', '7', '8', '9'};


    /**
     * 绘制验证码
     *
     * @param width  验证码宽度
     * @param height 验证码高度
     * @param os     图片输出流
     * @return 验证码字符
     */
    public static String makeCodePic(int width, int height, OutputStream os) {

        // 在缓存中开辟一块验证码图片空间
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 根据image获取绘图类
        Graphics g = image.getGraphics();

        // 设置画笔的颜色
        g.setColor(Color.GRAY);

        // 绘制一个矩形
        g.fillRect(0, 0, width, height);


        StringBuffer sb = new StringBuffer();
        // 随机生成 4个字符
        for (int i = 0; i < 4; i++) {

            // 随机下标
            int index = (int) (Math.random() * charArray.length);

            sb.append(charArray[index]);

        }


        // 字符串缓冲区 转成 字符串
        String str = sb.toString();

        // 修改画笔颜色
        g.setColor(Color.BLACK);

        // 设置字体大小及风格
        g.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));

        // 绘制随机字符
        g.drawString(str.substring(0, 1), 7, 22);
        g.drawString(str.substring(1, 2), 20, 20);
        g.drawString(str.substring(2, 3), 40, 21);
        g.drawString(str.substring(3, 4), 55, 20);


        // 释放画笔
        g.dispose();

        try {
            // 同那个图片流将图片写出去
            ImageIO.write(image, "JPEG", os);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str;

    }
}
