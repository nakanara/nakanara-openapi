package com.nakanara.openapi1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by steg on 2017-06-26.
 */
@Controller
public class OpenApi1Controller {

    private Logger logger = LoggerFactory.getLogger(OpenApi1Controller.class);

    @RequestMapping("/welcome.do")
    public ModelAndView helloWorld() {
        logger.info("INFO~~~~Controller");
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }
}
