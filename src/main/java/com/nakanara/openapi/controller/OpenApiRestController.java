package com.nakanara.openapi.controller;

import com.nakanara.openapi.apt.dao.RTMSDao;
import com.nakanara.openapi.service.OpenApiAptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by steg on 2017-06-30.
 */
@RestController
public class OpenApiRestController {

    private Logger logger = LoggerFactory.getLogger(OpenApiRestController.class);

    @Resource(name = "openApiAptService")
    private OpenApiAptService openApiAptService;

    @RequestMapping(value= "/getAptList.do", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> getAptList(){

        List<RTMSDao> list = openApiAptService.getAptList();

        Map<String, Object> m = new HashMap<>();
        m.put("result", list);
        return m;
    }



}
