package com.ssm.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxUtils<T> {
    private Map<String, Object> map = new HashMap<String, Object>();

    public static final Integer SUCCESS_CODE = 1;
    public static final Integer ERROR_CODE = -1;

    public AjaxUtils(Integer code, String msg, List<T> data) {
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
    }

    public AjaxUtils(Integer code, String msg, Object data) {
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
    }

    public Map<String, Object> run() {
        return map;
    }
}
