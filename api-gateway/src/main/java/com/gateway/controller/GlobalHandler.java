package com.gateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GlobalHandler extends AbstractErrorController{

	  public GlobalHandler(ErrorAttributes errorAttributes) {
	      super(errorAttributes);
	  }

	  @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ResponseBody
	  public Map<String, Object> handleError(HttpServletRequest request) {
	      Map<String, Object> errorAttributes = super.getErrorAttributes(request, true);
	      return errorAttributes;
	  }

	  @Override
	  public String getErrorPath() {
	      return "/error";
	  }
	  
	  @RequestMapping(value = "/service/auth")
	  public String getApiDoc() {
		  return "redirect:/v2/api-docs";
	  }

}
