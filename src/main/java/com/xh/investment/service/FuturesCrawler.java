package com.xh.investment.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.investment.crawler.HttpUtils;
import com.xh.investment.dao.FuturesMapper;
import com.xh.investment.domain.Futures;

@Service
public class FuturesCrawler {  

	private static Logger logger = Logger.getLogger(FuturesCrawler.class);
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

	@Autowired
	private FuturesMapper futureMapper;

	@PostConstruct
	public void init() {
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String message = HttpUtils.doGet("http://hq.sinajs.cn/list=RB1701");
				Futures futures = new Futures();
				try {
					futures = parseFutures(message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(futures!=null)
					futureMapper.insert(futures);
					logger.info("write data to mysql successful.");
			}
		}, 5, 300, TimeUnit.SECONDS);
	}

	public Futures parseFutures(String message) throws Exception {
		if ("".equals(message) || message == null) {
			logger.info("no data");
			return null;
		}
		Futures futures = new Futures();
		String[] futuresData = message.split("=");
		if (!"".equals(futuresData[1]) || futuresData[1] != null) {
			String[] futuresFiled = futuresData[1].split(",");
			futures.setCode(futuresFiled[0]);
			futures.setName(futuresFiled[16]);
			futures.setJys(futuresFiled[15]);
			futures.setType(futuresFiled[16]);
			futures.setDate(futuresFiled[17]);
			futures.setKpj(Double.valueOf(futuresFiled[2]));
			futures.setZgj(Double.valueOf(futuresFiled[3]));
			futures.setZdj(Double.valueOf(futuresFiled[4]));
			futures.setZrsp(Double.valueOf(futuresFiled[5]));
			futures.setMj(Double.valueOf(futuresFiled[6]));
			futures.setMaij(Double.valueOf(futuresFiled[7]));
			futures.setZxj(Double.valueOf(futuresFiled[8]));
			futures.setJsj(Double.valueOf(futuresFiled[9]));
			futures.setZrjs(Double.valueOf(futuresFiled[10]));
			futures.setMl(Double.valueOf(futuresFiled[11]));
			futures.setMal(Double.valueOf(futuresFiled[12]));
			futures.setCcl(Double.valueOf(futuresFiled[13]));
			futures.setCjl(Double.valueOf(futuresFiled[14]));
			
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(futuresFiled[17]);
			long unixTimestamp = date.getTime()/1000;
			futures.setTime(String.valueOf(unixTimestamp));
		}
		return futures;
	}  
}
