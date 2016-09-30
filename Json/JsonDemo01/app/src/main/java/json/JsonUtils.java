package json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import service.Person;

/**
 * 完成对json数据的解析
 * Created by FanFF on 2016/2/3.
 */
public class JsonUtils {
    public JsonUtils() {
    }

    /**
     *例如：{"person":{"address":"beijing","id":1001,"name":"jack"}}
     * @param key 即 person
     * @param jsonString 即{"person":{"address":"beijing","id":1001,"name":"jack"}}
     * @return
     */
    public static Person getPerson(String key, String jsonString){
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);// 通过jsonString创建jsonobject
            JSONObject personObject = jsonObject.getJSONObject(key);// 通过key获取value对象
            // 通过key获取的value设置Person对象的各个属性字段
            person.setId(personObject.getInt("id"));
            person.setName(personObject.getString("name"));
            person.setAddress(personObject.getString("address"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }

    /**
     * {"persons":[{"address":"beijing","id":1001,"name":"Smith"},{"address":"shanghai","id":1002,"name":"David"}]}
     * @param key
     * @param jsonString
     * @return
     */
    public static List<Person> getPersons(String key, String jsonString){
        List<Person> list = new ArrayList<Person>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(key);// json数组
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObjectTemp = jsonArray.getJSONObject(i);
                Person person = new Person();
                person.setId(jsonObjectTemp.getInt("id"));
                person.setName(jsonObjectTemp.getString("name"));
                person.setAddress(jsonObjectTemp.getString("address"));
                list.add(person);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * {"liststring":["beijing","shanghai","guangzhou"]}
     * @param key
     * @param jsonString
     * @return
     */
    public static List<String> getList(String key, String jsonString){
        List<String> list = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            for (int i = 0; i < jsonArray.length(); i++){
                String msg = jsonArray.getString(i);
                list.add(msg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * {"listmap":[{"id":1001,"address":"beijing","name":"Smith"},{"id":1002,"address":"David","name":"David"}]}
     * @param key
     * @param jsonString
     * @return
     */
    public static List<Map<String, Object>> listKeyMaps(String key, String jsonString) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObjectTemp = jsonArray.getJSONObject(i);
                Map<String, Object> map = new HashMap<String, Object>();
                Iterator<String> iterator = jsonObjectTemp.keys();
                while (iterator.hasNext()){
                    String json_key = iterator.next();
                    Object json_value = jsonObjectTemp.get(json_key);
                    if (json_value == null){
                        json_value = "";
                    }
                    map.put(json_key, json_value);
                }
                list.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
