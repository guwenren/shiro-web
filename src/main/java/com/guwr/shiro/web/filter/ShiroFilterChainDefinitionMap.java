package com.guwr.shiro.web.filter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by   guwr
 * Project_name shiro-web
 * Path         com.guwr.shiro.web.filter.ShiroFilterChainDefinitionMap
 * Date         2017/4/2
 * Time         17:17
 * Description
 */
public class ShiroFilterChainDefinitionMap {

    public Map<String, String> getFilterChainDefinitionMap() {
        System.out.println("ShiroFilterChainDefinitionMap.getFilterChainDefinitionMap");
        Map<String, String> finitionMap = new LinkedHashMap<>();
        finitionMap.put("/login", "anon");
        finitionMap.put("/**", "authc");
        return finitionMap;
    }
}
