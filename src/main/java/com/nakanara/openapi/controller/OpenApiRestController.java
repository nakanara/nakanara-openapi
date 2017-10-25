package com.nakanara.openapi.controller;

import com.nakanara.openapi.apt.dao.TbRtmsDao;
import com.nakanara.openapi.service.OpenApiAptService;
import com.nakanara.rdb.ResultDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nakanara on 2017-06-30.
 */
@RestController
@Transactional
public class OpenApiRestController {

    private Logger logger = LoggerFactory.getLogger(OpenApiRestController.class);

    @Resource(name = "openApiAptService")
    private OpenApiAptService openApiAptService;

    @RequestMapping(value= "/getAptList.do", method = RequestMethod.GET, produces = "application/json")
    public ResultDao getAptList(){

        ResultDao resultDao = openApiAptService.getAptList();

        return resultDao;
    }



}
