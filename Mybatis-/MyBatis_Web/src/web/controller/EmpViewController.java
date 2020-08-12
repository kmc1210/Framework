package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Emp;
import web.service.EmpService;
import web.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpViewController
 */
@WebServlet("/emp/view")
public class EmpViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService = new EmpServiceImpl();	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 얻기 - name="empno"
		
		Emp empno = empService.getEmpno(req);
//		int empno = Integer.parseInt(req.getParameter("empno"));
		System.out.println("EmpDetailController - " + empno);
		
		
		// 상세보기 조회결과
		Emp view = empService.view(empno);
		
		
		// 조회결과 MODEL 값 전달
		req.setAttribute("view", view);
		
		
		//VIEW 지정 포워드
		req.getRequestDispatcher("/WEB-INF/views/emp/view.jsp").forward(req, resp);
		
	}
	
}
