package com.cfh.test;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

/**
 * @描述
 * @创建人 caifenghua
 * @创建时间 2020/9/29 11:44
 */
@Controller
public class ControllerTest {

    @Autowired
    @Qualifier("ipInfoCaffeine")
    private Cache<String, Object> ipInfoCaffeine;

    @RequestMapping("/test")
    public void tets(){
        List<String> test = (List<String>) ipInfoCaffeine.getIfPresent("test");
        if (test == null) {
            ipInfoCaffeine.put("test", Stream.of("blue", "red", "yellow").collect(toList()));
            ipInfoCaffeine.put("test2", Stream.of("blue2", "red2", "yellow2").collect(toList()));
            ipInfoCaffeine.put("test3", Stream.of("blue3", "red3", "yellow3").collect(toList()));
        }

        List<String> test3 = (List<String>) ipInfoCaffeine.getIfPresent("test3");
        for (String s : test3) {
            System.out.println(s);
        }
    }

    @ResponseBody
    @RequestMapping("/test1")
    public String tets1(){
        return "hello";
    }
}
