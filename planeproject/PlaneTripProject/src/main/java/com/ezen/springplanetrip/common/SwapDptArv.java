package com.ezen.springplanetrip.common;

import java.util.ArrayList;
import java.util.List;

public class SwapDptArv {
	public static List<String> changeValue(String dpt, String arv) {
		List<String> result = new ArrayList<String>();
		String tmp = "";
		tmp = dpt;
		dpt = arv;
		arv = tmp;
		
		result.add(dpt);
		result.add(arv);
		return result;
	}
}
