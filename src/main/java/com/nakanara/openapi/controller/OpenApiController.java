package com.nakanara.openapi.controller;

import com.nakanara.openapi.service.OpenApiAptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by steg on 2017-06-26.
 */
@Controller
public class OpenApiController {

    private Logger logger = LoggerFactory.getLogger(OpenApiController.class);

    @Resource(name = "openApiAptService")
    private OpenApiAptService openApiAptService;

    @RequestMapping("/welcome.do")
    public ModelAndView helloWorld() {
        logger.info("INFO~~~~Controller");
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";

        openApiAptService.getLocationCode();
        return new ModelAndView("welcome", "message", message);
    }

    @RequestMapping("collectionApt.do")
    public ModelAndView collectionAptDeal(){
        logger.info("Start Collection");
        openApiAptService.startOpenApi_AptDeal();
        openApiAptService.startOpenApi_AptRant();
        String message = "Start Collection";
        return new ModelAndView("welcome", "message", message);
    }
}
