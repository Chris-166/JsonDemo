package com.mycode.test;


import java.util.List;

import com.mycode.domain.JsonService;
import com.mycode.models.Person;
import com.mycode.utils.JsonTools;

public class Test {
	public static void main(String[] args) {
		JsonService jsonervice = new JsonService();
		/*String msg1 = "";
		Person person = jsonervice.getPerson();
		msg1 = JsonTools.createJsonString("person", person);
		System.out.println(msg1);*/
		/*String msg2 = "";
		List person2 = jsonervice.getlistPerson();
		msg2 = JsonTools.createJsonString("person", person2);
		System.out.println(msg2);*/		
		/*String msg3 = "";
		List person3 = jsonervice.getListString();
		msg3 = JsonTools.createJsonString("person", person3);
		System.out.println(msg3);*/
		
		String msg4 = "";
		List person4 = jsonervice.getListMaps();
		msg4 = JsonTools.createJsonString("person", person4);
		System.out.println(msg4);
		
	}
}
