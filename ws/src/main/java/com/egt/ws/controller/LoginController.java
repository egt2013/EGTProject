package com.egt.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 16/10/2556
 * Time: 11:26 น.
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {
    @Autowired
    public MessageSource messageSource;

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Spring Security Hello World");
        return "hello";

    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";

    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        //String errormessage = resources.getMessage("login.error", null, null);
        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "logout";

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String welcomeAdmin(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Spring Security - ROLE_ADMIN");
        return "hello";

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(ModelMap model) {

        return "403";

    }
}
