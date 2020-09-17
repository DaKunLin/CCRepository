package com.cc.core;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数字与字母转换
 * User: cc
 * Date: 2020/09/17
 * Time: 23:24
 */
public class NumberConvert {
    public List <String> convert(Integer[] nember) {
        List <String> list = new ArrayList <String>();
        //
        if (nember == null||nember.length==0) {
            System.out.println("您输入的数字不能为空");
            return list;
        }
        //手机数字所对应的数字
        String[] str = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> arrList = new ArrayList <String>(nember.length);
        for (int i = 0; i < nember.length; i++) {
            //从数组str中取出对应的字符串，如果小于10
            if(nember[i]<0||nember[i]>99){
                System.out.println("您输入的数字非法，请更换大于0小于99的数字");
                return new ArrayList <String>();
            }
            if(nember[i]<10){
                if(StringUtils.isBlank(str[nember[i]])){
                    continue;
                }
                String value = str[nember[i]];
                arrList.add(value);
            }else {
                String pointNumber = String.valueOf(nember[i]);
                for(int j=0;j<pointNumber.length();j++){
                    String code = pointNumber.substring(j,j+1);
                    String value = str[new Integer(code)];
                    if(StringUtils.isBlank(value)){
                        continue;
                    }
                    arrList.add(String.valueOf(value));
                }
            }
        }
        if(arrList.size()==0){
            System.out.println("您输入的数字需要至少有一位不是0或者1");
            return new ArrayList <String>();
        }
        list = new ArrayList <String>();
        //调用组合方法，并返回处理结果
        return combination(arrList, list, 0, "");
    }



    private List <String> combination(List<String> s, List <String> list, int index, String result) {
        //如果长度为1 直接返回指定字母 不需要排列
        if(s.size()==1){
            list.add(s.get(0));
            return list;
        }
        //切割完了直接返回
        if (result.length() == s.size()) {
            list.add(result);
            return list;
        }
        for (int i = index; i < s.size(); i++) {
            if(StringUtils.isBlank(s.get(i))){
                continue;
            }
            for (int j = 0; j < s.get(i).length(); j++) {
                //递归
                combination(s, list, i + 1, result + s.get(i).substring(j, j + 1));
            }
        }
        return list;
    }



    public static void main(String[] args) {
        NumberConvert lcd = new NumberConvert();
        //测试有0或者1情况 ，测试0在前面 1在后面情况
//        Integer[] character={0,2,1,3};
        //测试输入非数字情况(前端校验，这边例题为数组，如果传入字符串 需要校验非数字情况)
        //测试输入为空情况
//      Integer[] character=null;
        //可以测试同一个用户多次点击情况，需要增加时间间隔。
        //可以测试如果除0,1之外只有一个数字 不需要排列的情况
//      Integer[] character={0,2};   Integer[] character={1,2};
        //可以测试如果输入0,1情况
//       Integer[] character={0,1};
        //测试大于10数字情况
//        Integer[] character={22,2};
        //测试大于10数字情况 有0和1的情况
//        Integer[] character={12,0};
//        Integer[] character={11,1};
//        Integer[] character={01,1};

        Integer[] character={101,1};
        List <String> list = lcd.convert(character);
        Iterator <String> itx = list.iterator();
        while (itx.hasNext()) {
            String str = itx.next();
            System.out.println(str);
        }

    }

}
