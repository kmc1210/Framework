package emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDaoImpl_p;
import emp.dao.EmpDao_p;
import emp.dto.Emp;
import web.dao.EmpDao;

/**
 * Servlet implementation class EmpInsertController_P
 */
@WebServlet("/emp/insert_p")
public class EmpInsertController_P extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao_p empDao = new EmpDaoImpl_p();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[GET]확인");
		
		
		req.getRequestDispatcher("/WEB-INF/views/emp_p/insert.jsp").forward(req, resp);
		
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("[POST] 확인");
	
	Emp emp = new Emp();
	
	emp.setEmpno(Integer.parseInt(req.getParameter("empno")));
	emp.setEname(req.getParameter("ename"));
	emp.setJob(req.getParameter("job"));
	
	empDao.insert(emp);
	
	resp.sendRedirect("/emp/list_p");
	
	
	}
	
	
}
