package de.pottmeier.common;

import io.prometheus.client.Counter;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

import javax.faces.event.ActionEvent;




import java.io.Serializable;


@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;


	static final Logger logger = Logger.getLogger(HelloBean.class);


	// similar to a logger, fro mor info  see: https://github.com/prometheus/client_java
	static final Counter totalYes = Counter.build()
			.name("total_yes").help("Total requests.").register();
	static final Counter totalNo = Counter.build()
			.name("total_no").help("Total requests.").register();





	public HelloBean() {

	}



	public double getYes() {
		return totalYes.get();
	}

	public double getNo() {
		return totalNo.get();
	}

	public void sayYes(ActionEvent evt){
		logger.info("Yes chosen");
		totalYes.inc();
	}



	public void sayNo(ActionEvent evt){
		logger.info("No chosen");
		totalNo.inc();
	}




}