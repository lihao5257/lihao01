package com.lee.demo.shortlink.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lee.demo.polo.ShortLink;
import com.lee.demo.shortlink.service.ShortenerServiceI;

@Controller
@RequestMapping("/link") 
public class ShortenerControl {
	
	@Resource
	private ShortenerServiceI service;
	
	@RequestMapping("/shortLink")
	public String lookup(HttpServletRequest request,Model model) {
		ShortLink shortLink = new ShortLink();
	    String originalUrl = service.lookup(request.getParameter("key"));
	    shortLink.setOriginalUrl(originalUrl);
        model.addAttribute("shortLink", shortLink);  
        return "showUrl";  
	}
}
