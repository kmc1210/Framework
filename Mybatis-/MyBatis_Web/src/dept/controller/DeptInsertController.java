package dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

/**
 * Servlet implementation class DeptInsertController
 */
@WebServlet("/dept/insert")
public class DeptInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("[doGet] 호출확인");
	
	
	req.getRequestDispatcher("/WEB-INF/views/dept/insert.jsp").forward(req, resp);	
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("[doPost] 호출확인");
		
	Dept dept = new Dept();
	
	dept.setDeptno(Integer.parseInt(req.getParameter("deptno")));
	dept.setDname(req.getParameter("dname"));
	dept.setLoc(req.getParameter("loc"));
	
	deptDao.Insert(dept);
	
	resp.sendRedirect("/dept/list");
	
	}
	
	
}
