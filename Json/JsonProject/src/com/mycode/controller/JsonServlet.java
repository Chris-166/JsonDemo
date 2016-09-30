package com.mycode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycode.domain.JsonService;
import com.mycode.utils.JsonTools;

public class JsonServlet extends HttpServlet {

	private JsonService service;
	
	public JsonServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String jsonString = "";
		String flag = request.getParameter("flag");
		if ("person".equals(flag)) {
			// {"person":{"address":"beijing","id":1001,"name":"jack"}}
			jsonString = JsonTools.createJsonString("person", service
						.getPerson());
		}else if ("persons".equals(flag)) {
			// {"persons":[{"address":"beijing","id":1001,"name":"Smith"},{"address":"shanghai","id":1002,"name":"David"}]}
			jsonString = JsonTools.createJsonString("persons", service
						.getlistPerson());
		}else if ("liststring".equals(flag)) {
			// {"liststring":["beijing","shanghai","guangzhou"]}
			jsonString = JsonTools.createJsonString("liststring", service
						.getListString());
		}else if ("listmap".equals(flag)) {
			// {"listmap":[{"id":1001,"address":"beijing","name":"Smith"},{"id":1002,"address":"David","name":"David"}]}
			jsonString = JsonTools.createJsonString("listmap", service
						.getListMaps());
		}else{
			jsonString = "Json格式不正确";
		}

		out.println(jsonString);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		service = new JsonService();
	}

}
