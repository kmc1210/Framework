package emp.dao;

import java.util.List;

import emp.dto.Emp;

public interface EmpDao_p {

	public  List<Emp> selectAll();

	public Emp selectInfo(Emp emp);

	public void insert(Emp emp);

	public void delete(Emp emp);

}
