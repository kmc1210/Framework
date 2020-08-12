package dept.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dept.dto.Dept;

public interface DeptDao {

	//전체 조회
	public List<Dept> selectAll();

	//deptno 불러오기
	public Dept getDeptno(HttpServletRequest req);

	//상세 조회
	public Dept view(Dept deptno);

	public void Insert(Dept dept);

	public void delete(Dept dept);


		
}
