package com.xh.investment.controller;



import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xh.investment.service.FuturesService;

@Controller
@RequestMapping("/dashboard")
public class FuturesController {
	
	@Autowired
	private FuturesService futuresService;
	
	@RequestMapping("get-future-data")  
	@ResponseBody  
	public String getFutureData(HttpServletRequest request){
		/*return "?(" + JSON.toJSONString(futuresService.getAllFutureData(), true) + ");"; */
		String tmp = "[\r\n"
			/*	+ "[713576,289692,'螺纹钢1701','2016-05-31',71,1969,'沪',1963,1954,12,1953,42,'螺纹钢',1464624000,'螺纹钢',1946,1991,1957,1962,1953]\r\n"*/
				+ "[1463961600,1946,2000,1932,1960,9241068],\r\n"  
				+ "[1464048000,1957,1981,1907,1952,10241068],\r\n"  
				+ "[1464134400,1946,1960,1957,1982,10241068],\r\n"  
				+ "[1464220800,1957,1981,1907,1952,12241068],\r\n"  
				+ "[1464307200,1946,1960,1957,1982,10241068],\r\n"  
				+ "[1464393600,1957,1981,1907,1952,16241068],\r\n"  
				+ "[1464480000,1946,1960,1957,1982,10241068],\r\n"  
				+ "[1464566400,1957,1981,1907,1952,14241068],\r\n"  
				+ "[1464624000,1946,1991,1957,1972,19241068]\r\n"
				+ "]";
/*		String tmp="[\r\n"
				+ "[1464624000,457.97,459.71,450.48,452.97,11958926]\r\n"
				+ "]";*/
		return tmp;
	}

}
