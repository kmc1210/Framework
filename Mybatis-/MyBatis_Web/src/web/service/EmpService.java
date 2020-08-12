package web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Emp;

public interface EmpService {

	public List<Emp> getList();

	
	
	public Emp view (Emp empno);



	public Emp getEmpno(HttpServletRequest req);
}
