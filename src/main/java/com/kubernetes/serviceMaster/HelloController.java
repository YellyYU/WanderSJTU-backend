package com.kubernetes.serviceMaster;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bambihui on 2019/6/26.
 */
@Controller
@ComponentScan(basePackages = "com.kubernetes.serviceMaster")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "Welcome to Wander SJTU!";
    }


    @RequestMapping(value = "login", method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "map", method= RequestMethod.GET)
    public String map(){
        return "map";
    }

    @RequestMapping(value = "/entrance", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String entrance(@RequestBody(required = true) User user) {

        JSONObject s = new JSONObject();
        if (user.getUser().equals("admin") && user.getPwd().equals("123456")) {
            s.put("msg","success");
        }
        else{
            s.put("msg","failure");
        }
        return s.toJSONString();
    }

//    @RequestMapping(value = "/story", method = RequestMethod.GET, consumes = "application/json")
//    @ResponseBody
//    public String story() {
//        JSONArray result = new JSONArray();
//        for (int i = 0; i < list.size(); i++) {
//            Story obj = list.get(i);
//            JSONObject s = new JSONObject();
//            s.put("name", obj.getName());
//            s.put("location",obj.getLocation());
//            s.put("story",obj.getStory());
//            result.add(s);
//        }
//        return result.toJSONString();
//    }
}

