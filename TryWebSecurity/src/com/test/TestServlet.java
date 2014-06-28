package com.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private final String userName = "test";
	private final String pwd = "test";

	public void doPost( HttpServletRequest request, HttpServletResponse response){
		System.out.println(" in do Post");
		try{
			String authHeader= "" + request.getHeader("Authorization");
			System.out.println(" authHeader : "+authHeader);
			if (authHeader.length() > 6) {
				String usernpass= TestServletHelper.b64decode(authHeader.substring(6));
				System.out.println(" usernpass : "+usernpass);
				int colonIndex= usernpass.indexOf(":");
				if (colonIndex >= 0) {
					String uname=usernpass.substring(0,colonIndex);
					String password=usernpass.substring(colonIndex+1);
					System.out.println(" uname : "+uname);
					System.out.println(" password : "+password);
					if(userName.equals(uname) && pwd.equals(password)){
						System.out.println("........ U r authenticated.....");
					}else{
						response.setHeader("WWW-Authenticate","Basic realm=\"" + "prasenjit" + "\"");
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
					}
				}else{
					response.setHeader("WWW-Authenticate","Basic realm=\"" + "prasenjit" + "\"");
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}else{
				response.setHeader("WWW-Authenticate","Basic realm=\"" + "prasenjit" + "\"");
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response){
		System.out.println(" in do Get");
		try{
			String authHeader= "" + request.getHeader("Authorization");
			System.out.println(" authHeader : "+authHeader);
			if (authHeader.length() > 6) {
				String usernpass= TestServletHelper.b64decode(authHeader.substring(6));
				System.out.println(" usernpass : "+usernpass);
				int colonIndex= usernpass.indexOf(":");
				if (colonIndex >= 0) {
					String uname=usernpass.substring(0,colonIndex);
					String password=usernpass.substring(colonIndex+1);
					System.out.println(" uname : "+uname);
					System.out.println(" password : "+password);
					if(userName.equals(uname) && pwd.equals(password)){
						System.out.println("........ U r authenticated.....");
					}else{
						response.setHeader("WWW-Authenticate","Basic realm=\"" + "prasenjit" + "\"");
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
					}
				}else{
					response.setHeader("WWW-Authenticate","Basic realm=\"" + "prasenjit" + "\"");
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}else{
				response.setHeader("WWW-Authenticate","Basic realm=\"" + "prasenjit" + "\"");
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
