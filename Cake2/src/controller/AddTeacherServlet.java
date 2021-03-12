package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DepartmentService;
import data.TeacherService;
import model.Department;
import model.Teacher;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacher")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		Teacher teach = new Teacher();
		teach.setName(name);
		if(new TeacherService().insertTeacher(teach))
		{
			
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('�����Ҩ���������');");
			   out.println("location='ShowTeacher';");
			   out.println("</script>");
		}
		else {
			response.sendRedirect("ShowTeacher");
		}
	}

}
