package com.cfh.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 caifenghua
 * @创建时间 2020/9/29 11:37
 */
@Component
public class Config {

    @Bean("ipInfoCaffeine")
    public Cache<String, Object> ipInfoCaffeine() {
        return Caffeine.newBuilder()
                .maximumSize(2)
                .build();
    }
}
