package com.ocean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConcurrentTest extends HttpServlet {
	PrintWriter output;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username;
		response.setContentType("text/html; charset=UTF-8");
		username = request.getParameter("username");
		output = response.getWriter();
		try {
			Thread.sleep(5000); // Ϊ��ͻ���������⣬��������һ����ʱ
		} catch (InterruptedException e) {
		}
		output.println("�û���:" + username + "<BR>");
	}
}
