package test;

import util.MyTool;

public class FormatDateTest {

	public static void main(String[] args) {
		String _dateText = "";
		MyTool tool = new MyTool();
		String dateText = tool.formatDate(_dateText);
		System.out.println(dateText);
	}

}
