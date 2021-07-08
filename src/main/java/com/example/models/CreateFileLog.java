package com.example.models;

public class CreateFileLog {
	
	String name;
	String ip;
	
	public CreateFileLog() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CreateFileLog(String name, String ip) {
		super();
		this.name = name;
		this.ip = ip;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "log [name=" + name + ", ip=" + ip + "]";
	}
	
	

}
