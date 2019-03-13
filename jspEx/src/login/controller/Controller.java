package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	String doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}