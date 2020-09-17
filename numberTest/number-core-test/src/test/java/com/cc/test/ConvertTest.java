package com.cc.test;

import com.cc.core.NumberConvert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 数字与字母转换测试
 * User: cc
 * Date: 2020/09/17
 * Time: 23:24
 */
public class ConvertTest {

    NumberConvert numberConvert = new NumberConvert();
    /**
     * 测试输入字符为空或为null的情况
     */
    @Test
    public void test1(){
        Integer[] character=null;
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }
    /**
     * 测试输入字符为非法的情况
     * 注意这边用的integer数组 前端Js校验非数字的非法情况
     * js能实时告知用户输入的格式问题
     */
    @Test
    public void test2(){
        Integer[] character={100,0};
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }

    /**
     * 测试全部输入0或者1的情况
     */
    @Test
    public void test3(){
        Integer[] character={0,1};
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }

    /**
     * 测试输入部分0或者1 且除了0或者1 只有一个有效数字的情况
     */
    @Test
    public void test4(){
        Integer[] character={0,5};
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }

    /**
     * 测试输入部分0或者1 且除了0或者1 大于一个有效数字的情况
     */
    @Test
    public void test5(){
        Integer[] character={1,5,6};
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }

    /**
     * 测试大于9的数字情况且全部为0或者1
     */
    @Test
    public void test6(){
        Integer[] character={11,01,00};
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }

    /**
     * 测试大于9的数字情况且含有0或者1
     */
    @Test
    public void test7(){
        Integer[] character={11,23,01};
        List<String> list = numberConvert.convert(character);
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }
    }

    /**
     * 测试类
     * @author DK.Lin
     * @since 2020/09/17
     */
    @Test
    public void test9() {
        for (int i = 1; i < 10; i++) {
            test8(i);
        }
    }

    public void test8(int i) {
        Integer[] integers = new Integer[i];
        int ran;
        for (int j=0; j<i; j++) {
            ran = (int) (Math.random()*10);
            System.out.print(ran);
            integers[j] = new Integer(ran);
        }
        System.out.print("    ");
        List<String> list = numberConvert.convert(integers);
        System.out.print("size:"+list.size());
        System.out.print("    ");
        Iterator<String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.print(str);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
