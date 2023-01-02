package model;

import java.io.Serializable;

public class MyError implements Serializable {
	private static final long serialVersionUID = 1L;
	private String key;
	private String msg;
	
	public MyError() {}
	public MyError(String key, String msg) {
		if (key == null || key.length() == 0) {
			throw new IllegalArgumentException("keyには文字が必要です。");
		}
		if (msg == null || msg.length() == 0) {
			throw new IllegalArgumentException("エラーメッセージがありません。");
		}
		this.key = key;
		this.msg = msg;
	}

	public String getKey() {
		return key;
	}

	public String getMsg() {
		return msg;
	}
	
}
