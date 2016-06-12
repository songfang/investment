package com.xh.investment.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class SpringWiredBean implements BeanFactoryPostProcessor {

	@Autowired
	private BeanFactory beanFactory;

	public SpringWiredBean() {

	}

	private static SpringWiredBean instance;
	static {
		instance = new SpringWiredBean();
	}

	public Object getBeanById(String beanId) {
		return beanFactory.getBean(beanId);
	}

	public static SpringWiredBean getInstance() {
		return instance;
	}

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		this.beanFactory = beanFactory;
		
	}

}
