package com.xh.investment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashBoardController {
	
	@RequestMapping("pie")
	public String pieDisplay(HttpServletRequest request){
		return "html/pie";
	}
	
	@RequestMapping("map")
	public String mapDisplay(HttpServletRequest request){
		return "html/map";
	}
	
	@RequestMapping("stock")
	public String stockDisplay(HttpServletRequest request){
		return "html/stock";
	}
	
	@RequestMapping("column")
	public String columnDisplay(HttpServletRequest request){
		return "html/column";
	}

	@RequestMapping("candlestick")
	public String candlestickDisplay(HttpServletRequest request){
		return "html/candlestick";
	}
	
}
