package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamDemoServlet
 */
@WebServlet(urlPatterns = "/initparam", initParams = @WebInitParam(name = "location", value = "InitParamLocationValue"))
public class InitParamDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String location = null;
	private String location_context = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init method is invoked");
		this.location = config.getInitParameter("location");
		this.location_context = config.getServletContext().getInitParameter("location");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitParamDemoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("Int param location is :" + this.location);
		pw.println("Context param location is :"+this.location_context);
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
