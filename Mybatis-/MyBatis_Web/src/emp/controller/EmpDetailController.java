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
 * Servlet implementation class EmpDetailController
 */
@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao_p empDao = new EmpDaoImpl_p();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("/emp/detail [GET] 호출");
		
	String param = req.getParameter("empno");
	int empno = 0;
	if( param != null && !"".equals(param)) {
		empno = Integer.parseInt(param);
	}
	Emp emp = new Emp();
	emp.setEmpno(empno);
	
	Emp result = empDao.selectInfo(emp);
	
	System.out.println(result);
	
	//MODEL 값 저장
	req.setAttribute("result", result);
	
	//VIEW 포워딩
	req.getRequestDispatcher("/WEB-INF/views/emp_p/detail.jsp").forward(req, resp);
	
	}
	
}
