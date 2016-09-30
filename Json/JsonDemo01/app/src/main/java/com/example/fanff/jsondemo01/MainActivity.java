package com.example.fanff.jsondemo01;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.List;
import java.util.Map;

import httputil.HttpUtils;
import json.JsonUtils;
import service.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button person, persons, liststring, listmap;
    private String path = "http://192.168.1.104:8080/JsonProject/servlet/JsonServlet";
    private String jsonContent = "", url_path="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        person = (Button) this.findViewById(R.id.btn_person);
        persons = (Button) this.findViewById(R.id.btn_persons);
        liststring = (Button) this.findViewById(R.id.btn_listString);
        listmap = (Button) this.findViewById(R.id.btn_listmap);
        person.setOnClickListener(this);
        persons.setOnClickListener(this);
        liststring.setOnClickListener(this);
        listmap.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_person:
                url_path = path + "?flag=person";
                jsonContent = HttpUtils.getJsonContent(url_path);// 获取json字符串
                Person person = JsonUtils.getPerson("person", jsonContent);// 解析json字符串
                //Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_SHORT).show();
                System.out.println(url_path);
                System.out.println(person.toString());
                break;
            case R.id.btn_persons:
                url_path = path + "?flag=persons";
                jsonContent = HttpUtils.getJsonContent(url_path);
                List<Person> persons = JsonUtils.getPersons("persons", jsonContent);
                System.out.println(persons.toString());
                break;
            case R.id.btn_listString:
                url_path = path + "?flag=liststring";
                jsonContent = HttpUtils.getJsonContent(url_path);
                List<String> list = JsonUtils.getList("liststring", jsonContent);
                System.out.println(list.toString());
                break;
            case R.id.btn_listmap:
                url_path = path + "?flag=listmap";
                jsonContent = HttpUtils.getJsonContent(url_path);
                List<Map<String, Object>> listmap = JsonUtils.listKeyMaps("listmap", jsonContent);
                System.out.println(listmap.toString());
                break;
        }
    }
}
