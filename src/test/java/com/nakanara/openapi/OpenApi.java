package com.nakanara.openapi;

import com.nakanara.openapi.service.OpenApiAptService;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;



/**
 * Created by nakanara on 2017-09-21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")

@Transactional
public class OpenApi {

    private Logger logger = LoggerFactory.getLogger(OpenApi.class);

    @Resource(name = "openApiAptService")
    OpenApiAptService openApiAptService;

    @Test
    public void getMonthInfo(){

        logger.info("JUNIT Start ");

        List list = openApiAptService.getMonthCollectInfo();

        logger.info("list = {}", list);

        for(Object o : list) {
            logger.info("o : {}", o);
        }

        assertNotNull(list);

    }
}
