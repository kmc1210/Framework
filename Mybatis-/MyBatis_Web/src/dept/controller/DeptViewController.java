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
 * Servlet implementation class DeptViewController
 */
@WebServlet("/dept/view")
public class DeptViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String param = req.getParameter("deptno");
//		int deptno = 0;
//		if( param != null && !"".equals(param)) {
//			deptno = Integer.parseInt(param);
//		}
//		Dept dept  = new Dept();
//		dept.setDeptno(deptno);
		
		System.out.println("/dept/view [doGet] 호출");
		//상세정보 조회 결과 얻기
		//Dept result = deptDao.selectInfo(dept);
		
		Dept deptno = deptDao.getDeptno(req);
		
		System.out.println("호출 부서" + deptno);
		
		//Dept view = deptDao.view(result);
		Dept view = deptDao.view(deptno);
		
		
		System.out.println(view);
		//MODEL 값 저장
		req.setAttribute("view", view);

		
		//VIEW포워딩
		req.getRequestDispatcher("/WEB-INF/views/dept/view.jsp").forward(req, resp);
	}
	
}
