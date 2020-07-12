package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	public List<Emp> selectAll();

	public void insert(Emp insertEmp);

	public Emp selectByEmpno(int empno);

	public void deleteByEmpno(Emp emp);
	
	
}
