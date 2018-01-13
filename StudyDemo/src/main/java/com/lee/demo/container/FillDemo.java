package com.lee.demo.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.ls.LSInput;

public class FillDemo {

	public static void main(String[] args){
		List<String> list = new ArrayList<>(32);
		list.add("Chine");
		list.add("UK");
		list.add("USA");
		boolean list02 = Collections.addAll(list, "Poland");
	}
}
