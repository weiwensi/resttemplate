package com.one.learn.resttemplate.util;

import com.one.learn.resttemplate.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 暂时无用
 */

public class RestTemplateUtil {

    private RestTemplate restTemplate;

    /**
     * get请求 没有参数
     *
     * @param tClass
     * @param url
     * @param <T>
     * @return
     */
    public <T> T getForObject(Class<T> tClass, String url) {
        return restTemplate.getForObject(url, tClass);
    }

    /**
     * 返回带状态码的ResponseEntity对象
     *
     * @param url    请求url
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> tClass) {
        return restTemplate.getForEntity(url, tClass);
    }

    /**
     * 通过exchange  get或者post请求  支持请求头的设置  返回指定的类型
     *
     * @param url
     * @param header
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> getByExchange(String url, MultiValueMap header, Class<T> tClass) {
        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Object> requestEntity = new HttpEntity<>(header);
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, tClass);
    }


    /**
     * String url = "http://localhost:8080/product/get_product2?id={id}";
     * get请求携带path参数  通过可变形参传参
     *
     * @param url
     * @param tClass
     * @param v
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> getForEntityByPathVariable(String url, Class<T> tClass, Object... v) {
        return restTemplate.getForEntity(url, tClass, v);
    }


    /**
     * String url = "http://localhost:8080/product/get_product2?id={id}";
     * * get请求携带path参数  通过map传参
     *
     * @param url
     * @param tClass
     * @param uriVariables
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> getForEntityByPathVariable(String url, Class<T> tClass, Map<String, String> uriVariables) {
        return restTemplate.getForEntity(url, tClass, uriVariables);
    }

    /**
     * 正常post请求  接收有RequestBody
     * httpEntity示例：HttpEntity<Product> request = new HttpEntity<>(new Product(2, "Macbook", BigDecimal.valueOf(10000)), header);
     *
     * @param url
     * @param httpEntity
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> postByExchange(String url, HttpEntity httpEntity, Class<T> tClass) {
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, tClass);
    }

    /**
     * delete请求
     *
     * @param url
     * @param uriVariables demo:
     *                     String url = "http://localhost:8080/product/delete/{id}";
     *                     restTemplate.delete(url, 101);
     */
    public void delete(String url, Object... uriVariables) {
        restTemplate.delete(url, uriVariables);
    }

    /**
     * put 请求
     *
     * @param url
     * @param header
     * @param paramStr
     */
    public <T> void put(String url, MultiValueMap<String, String> header, String paramStr, Class<T> tClass) {
        Map<String, ?> variables = new HashMap<>();
        header.put(HttpHeaders.CONTENT_TYPE, Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
        //Product product = new Product(101, "iWatch", BigDecimal.valueOf(2333));

        //String productStr = "id=" + product.getId() + "&name=" + product.getName() + "&price=" + product.getPrice();
        HttpEntity<String> request = new HttpEntity<>(paramStr, header);
        restTemplate.put(url, request);
    }

    //获取对象的所有字段拼接的值

    /**
     * //         Product product = new Product(101, "iWatch", BigDecimal.valueOf(2333));
     * //String productStr = "id=" + product.getId() + "&name=" + product.getName() + "&price=" + product.getPrice();
     */
    public  static String getClassAllFieldStr(Object object) {
        Class<?> tClass = object.getClass();
        StringBuffer result = new StringBuffer();
        try {
            //当前类的所有属性
            Field[] declaredFields = tClass.getDeclaredFields();
            //遍历属性 得到属性名
            for (Field field : declaredFields) {
                //属性名
                String fieldName = field.getName();
                //如果是用于序列化的直接过滤掉
                if ("serialVersionUID".equals(fieldName)) {
                    continue;
                }
                Object objectResult=null;
                objectResult= field.get(object);
                field.setAccessible(true);
                result.append(fieldName).append("=").append(Optional.ofNullable(objectResult).orElse(0));
            }
            return result.toString();
        }catch (Exception e){
            throw new RuntimeException("参数组装异常");
        }
    }
}
