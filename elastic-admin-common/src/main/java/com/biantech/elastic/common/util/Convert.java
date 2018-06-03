package com.biantech.elastic.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.biantech on 2017/6/22.
 * Time:18:00
 *
 */
public class Convert {
    /**
     * string 转换成Long数组
     *
     * @param str
     * @param splitStr
     * @return
     */
    public final static List<Integer> toIntegerList(String str, String splitStr) {
        if (str != null) {
            ArrayList<Integer> integerList = new ArrayList<Integer>();
            String[] strList = str.split(splitStr);
            for (String string : strList) {
                integerList.add(Integer.parseInt(string));
            }
            return integerList;
        }
        return null;
    }
}
