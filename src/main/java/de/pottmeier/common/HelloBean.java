package de.pottmeier.common;

import io.prometheus.client.Counter;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

import javax.faces.event.ActionEvent;




import java.io.Serializable;


@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;


	// similar to a logger, fro mor info  see: https://github.com/prometheus/client_java
	static final Counter totalYes = Counter.build()
			.name("total_yes").help("Total requests.").register();
	static final Counter totalNo = Counter.build()
			.name("total_no").help("Total requests.").register();




	private Boolean choice;


	public HelloBean() {

	}



	public double getYes() {
		return totalYes.get();
	}

	public double getNo() {
		return totalNo.get();
	}

	public void sayYes(ActionEvent evt){
		this.choice = Boolean.TRUE;
		totalYes.inc();
	}



	public void sayNo(ActionEvent evt){
		this.choice = Boolean.FALSE;
		totalNo.inc();
	}




}