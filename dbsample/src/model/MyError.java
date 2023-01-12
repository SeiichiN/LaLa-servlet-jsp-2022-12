package model;

import java.io.Serializable;

public class MyError implements Serializable {
	private String key;
	private String msg;
	
	public MyError() {}
	public MyError(String key, String msg) {
		this.key = key;
		this.msg = msg;
	}
	
	public String toString() {
		return key + ":" + msg;
	}
	public String getKey() {
		return key;
	}
	public String getMsg() {
		return msg;
	}
}
