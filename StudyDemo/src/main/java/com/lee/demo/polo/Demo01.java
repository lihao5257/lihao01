package com.lee.demo.polo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo01 {

    private Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public Integer retrieve(Integer key) {
        return cache.computeIfAbsent(key, this::compute);
    }

    private Integer compute(Integer value) {
        // 模拟代价很高的计算
        return value;
    }
StringBuilder
}
