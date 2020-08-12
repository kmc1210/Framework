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

/**
 * Servlet implementation class EmpDeleteController
 */
@WebServlet("/emp/delete")
public class EmpDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private EmpDao_p empDao = new EmpDaoImpl_p();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Emp emp = new Emp();
		
		req.getParameter("empno");
		emp.setEmpno(Integer.parseInt(req.getParameter("empno")));
		
		empDao.delete(emp);
		
		resp.sendRedirect("/emp/list_p");
		
	}
	

}
