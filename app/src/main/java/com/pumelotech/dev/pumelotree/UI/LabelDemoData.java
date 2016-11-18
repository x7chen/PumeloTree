package com.pumelotech.dev.pumelotree.ui;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/18.
 */
public class LabelDemoData {

    static public int[] gImage_Z = { /* 0X01,0X01,0X28,0X01,0X80,0X00, */

            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X03, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X00, 0X0F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFC, 0X00, 0X00, 0X00, 0X07, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF8, 0XFF, 0XFD, 0XFF, 0XFF, 0XFF, 0X80, 0X00, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF0, 0XF8, 0XFC, 0XFF, 0XFF, 0XFF, 0X00, 0X00, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XC0, 0XF0, 0XFC, 0XFF, 0XFF, 0XFF, 0X00, 0X00, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X04, 0XE0, 0XF9, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFC, 0X1C, 0XC4, 0XF9, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XF0, 0X7C, 0X09, 0XF9, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X01, 0XF0, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XE1, 0XFC, 0X39, 0XF9, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X07, 0XFC, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XF7, 0XF8, 0XF9, 0XFB, 0XFF, 0XFF, 0XFF, 0X00, 0X18, 0X07, 0XFE, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XE1, 0XF9, 0XF3, 0XFF, 0XFF, 0XFF, 0X00, 0X7C, 0X07, 0XFF, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XC7, 0XF9, 0XF3, 0XFF, 0XFF, 0XFF, 0X01, 0XF8, 0X07, 0XFF, 0X80, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XDF, 0XF9, 0XF3, 0XFF, 0XFF, 0XFF, 0X83, 0XF8, 0X03, 0XFF, 0X80, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X87, 0XF8, 0X01, 0XFF, 0X80, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XCF, 0XF0, 0X00, 0XFF, 0X80, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X1F, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF,
            0XFF, 0XE0, 0X00, 0X00, 0X00, 0X3F, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X07, 0XFF, 0XFF, 0XFF,
            0XFF, 0XE0, 0X00, 0X00, 0X00, 0X3F, 0XFF, 0XFF, 0XFF, 0XFC, 0X00, 0X00, 0X0F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X01, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X0F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X3E, 0X7E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFC, 0X1F, 0XFE, 0X1F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X1F, 0XFC, 0X0F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X0F, 0XFC, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X0F, 0XFC, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X0F, 0XFE, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X00, 0X0F, 0XFE, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X0F, 0XFE, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X07, 0XFE, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X07, 0XFE, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X07, 0XFE, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X03, 0XFE, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X80, 0X03, 0XFC, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XC0, 0X01, 0XFC, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XC0, 0X00, 0X78, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XC0, 0X00, 0X00, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XC0, 0X00, 0X00, 0X03, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XC0, 0X00, 0X00, 0X03, 0XFF, 0XFF,
            0XFF, 0XE0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XC0, 0X00, 0X00, 0X07, 0XFF, 0XFF,
            0XFF, 0XE0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XE0, 0X00, 0X00, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XE0, 0X00, 0X00, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XE0, 0X00, 0X00, 0X07, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XE0, 0X00, 0X00, 0X0F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XF0, 0X00, 0X00, 0X0F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XF0, 0X00, 0X00, 0X0F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XF0, 0X00, 0X00, 0X1F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XF8, 0X00, 0X00, 0X1F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XF8, 0X00, 0X00, 0X3F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XFC, 0X00, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XFE, 0X00, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XFE, 0X00, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X03, 0XFF, 0X00, 0X03, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X0F, 0XFF, 0XC0, 0X07, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X3F, 0XFF, 0XF0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XF9, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X0F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X03, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XF9, 0XF9, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XF9, 0XF9, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XF9, 0XF9, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XF9, 0XF9, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0X00, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF,
            0XFF, 0XF9, 0XC0, 0X0C, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XC0, 0X0C, 0XFF, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0XDE, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0X8E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X03, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0X0E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X0F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0X6E, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X10, 0XE4, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0XE4, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X94, 0XF1, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X03, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0XF1, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0XF1, 0XFF, 0XFF, 0XFF, 0XFF, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0XF1, 0XFF, 0XFF, 0XFF, 0XFC, 0X00, 0X00, 0X0F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X1C, 0XE1, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X07, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X1C, 0X8C, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0X1C, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0X3E, 0X7F, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X9C, 0XFE, 0X7F, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XC0, 0X0C, 0XFE, 0X3F, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XC0, 0X0C, 0XFF, 0X3F, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XFF, 0XFC, 0XFF, 0X7F, 0XFF, 0XFF, 0X80, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X1F, 0XE0, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0XFF, 0XFF, 0XFF, 0X80, 0X7F, 0XFC, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFE, 0X7F, 0XFF, 0XFF, 0X80, 0X7F, 0XFF, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFC, 0X7F, 0XFF, 0XFF, 0X80, 0X7F, 0XFF, 0X80, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFC, 0XFF, 0XFF, 0XFF, 0X80, 0X3F, 0XFF, 0XC0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X1C, 0XF8, 0XFF, 0XFF, 0XFF, 0X80, 0X1F, 0XFF, 0XC0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X1C, 0XF9, 0XFF, 0XFF, 0XFF, 0X80, 0X07, 0XFF, 0XC0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XF1, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0XFF, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XF3, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XE3, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XE7, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XCF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X8F, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X1F, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X3F, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X7F, 0XFF, 0XFF, 0XFF, 0XFC, 0X00, 0X00, 0X07, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0X00, 0X00, 0X0F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0X80, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X3F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFC, 0X03, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0X9F, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XCF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XC7, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X03, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XE7, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XF3, 0XFF, 0XFF, 0XFF, 0XFF, 0X00, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XF1, 0XFF, 0XFF, 0XFF, 0XFC, 0X00, 0X00, 0X0F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF9, 0XCF, 0X3C, 0XF9, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X07, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X1C, 0XF8, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XF8, 0X00, 0X1C, 0XFC, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFC, 0X7F, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFE, 0X7F, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFC, 0XFE, 0X7F, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X1F, 0XE0, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X7F, 0XFC, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X7F, 0XFF, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X7F, 0XFF, 0X80, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X3F, 0XFF, 0XC0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X1F, 0XFF, 0XC0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X07, 0XFF, 0XC0, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0XFF, 0X00, 0X3F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XC0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X00, 0X7F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF0, 0X00, 0X00, 0X00, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X01, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X00, 0X00, 0X03, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFC, 0X00, 0X00, 0X07, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X00, 0X00, 0X0F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0X80, 0X00, 0X1F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XE0, 0X00, 0X7F, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFC, 0X03, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X01, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X01, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFB, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0XCF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XAF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0X6F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF8, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0XDF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0X6F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0X6F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0X6F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X01, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X01, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0X8F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF6, 0X7F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF1, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFB, 0XDF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF6, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF6, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF9, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF7, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0X8F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF6, 0X7F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XF1, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X1F, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X01, 0XF7, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF8, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFE, 0X00, 0X01, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF9, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF6, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF6, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF6, 0XEF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XF9, 0X1F, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
            0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF, 0XFF,
    };
    static public ArrayList<GoodsInfo> DemoData = new ArrayList<>(10);
    static String[] goodsName = {
            "鲜鸡蛋",
            "苹果",
            "香蕉",
            "桔子",
            "西红柿",
            "玉米",
            "黄瓜",
            "茄子",
            "西瓜",
            "五常东北大米 新米好吃"
    };
    static {
        for (int i = 0; i < 10; i++) {
            GoodsInfo goods = new GoodsInfo();
            goods.Name = goodsName[i];
            goods.Package = "包装：散";
            goods.Unit = "单位：500克";
            goods.Price = "￥"+ String.format(Locale.CHINA,"%1.2f",new Random().nextFloat()*10);
            goods.Identifier = "1234567890123"+i;
            goods.Supervisor = "周红";
            goods.Origin = "产地：江西";
            DemoData.add(goods);
        }

    }
}
