package com.mycode.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycode.models.Person;

/**
 * 进行Json收发过程中的对应对象转换，即提供Json中的value
 * @author FanFF
 *
 */
public class JsonService {

	public JsonService() {
		super();
	}
	
	/**value是字符串
	 * {key:value, key:value,...}
	 * {"address":"beijing","id":1001,"name":"jack"}
	 * @return
	 */
	public Person getPerson() {
		Person person = new Person(1001, "jack", "beijing");
		return person;
	}
	
	/**value是数组[],数组又是{key:value}
	 * {key:[{key:value},{key:value},...]}
	 * [{"address":"beijing","id":1001,"name":"Smith"},{"address":"shanghai","id":1002,"name":"David"}]
	 * @return
	 */
	public List<Person> getlistPerson() {
		List<Person> list = new ArrayList<Person>();
		Person person1 = new Person(1001, "Smith", "beijing");
		Person person2 = new Person(1002, "David", "shanghai");
		list.add(person1);
		list.add(person2);
		return list;
	} 
	
	/**
	 * {key:[value,value,value...]}
	 * {"person":["beijing","shanghai","guangzhou"]}
	 * @return
	 */
	public List<String> getListString() {
		List<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("shanghai");
		list.add("guangzhou");
		return list;
	}
	
	/**
	 * {key:[{key:value , key:value,...},{key:value, key:value...}]}
	 * {"person":[{"id":1001,"address":"beijing","name":"Smith"},{"id":1002,"address":"David","name":"rose"}]}
	 * @return
	 */
	public List<Map<String, Object>> getListMaps() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 1001);
		map1.put("name", "Smith");
		map1.put("address", "beijing");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 1002);
		map2.put("name", "David");
		map2.put("address", "David");
		list.add(map1);
		list.add(map2);
		return list;
	}
	
}
