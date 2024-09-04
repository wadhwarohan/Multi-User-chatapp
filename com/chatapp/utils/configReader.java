package com.chatapp.utils;

import java.util.ResourceBundle;

public class configReader {
private static ResourceBundle rb= ResourceBundle.getBundle("config");
public static String getvalue(String key) {
	return rb.getString(key);
}
}
