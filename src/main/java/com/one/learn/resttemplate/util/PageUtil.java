package com.one.learn.resttemplate.util;

import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {

    public static RowBounds  getRowBounds(Integer  pageNo,Integer  pageSize,Integer  total){
        //返回结果集
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("total", total);
        //总页数
        int totalpage = (total + pageSize - 1) / pageSize;
        resultMap.put("totalpage", totalpage);
        //数据的起始行
        int offset = (pageNo - 1) * pageSize;
       return new RowBounds(offset, pageSize);
    }
}
