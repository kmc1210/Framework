package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDaoImpl_p;
import emp.dao.EmpDao_p;
import emp.dto.Emp;

/**
 * Servlet implementation class EmpListController_P
 */
@WebServlet("/emp/list_p")
public class EmpListController_P extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao_p empDao = new EmpDaoImpl_p();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("/emp/list_p [GET]");
		
		List<Emp> empList = empDao.selectAll();
		
		System.out.println(empList);
		req.setAttribute("empList", empList);

		req.getRequestDispatcher("/WEB-INF/views/emp_p/list.jsp").forward(req, resp);
		
	}
	
}
