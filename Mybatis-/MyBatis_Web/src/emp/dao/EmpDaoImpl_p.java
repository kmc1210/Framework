package emp.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import emp.dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpDaoImpl_p implements EmpDao_p{

	
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	private String namespace = "emp.dao.EmpDao_p.";
	
	@Override
	public List<Emp> selectAll() {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//DB조회 결과
		List<Emp> empList = sqlSession.selectList( namespace + "selectAll");
		System.out.println(empList);
		sqlSession.close();
		
		
		return empList;
	}

	@Override
	public Emp selectInfo(Emp emp) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
				
		//SQL 수행
		Emp result = sqlSession.selectOne( namespace + "selectInfo", emp);
				
		//마이바티스 객체 닫기
		sqlSession.close();
				
		return result;
	}

	@Override
	public void insert(Emp emp) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession(true);
		
		//SQL수행
		sqlSession.insert( namespace + "insert", emp);
		
		sqlSession.close();
		
	}

	@Override
	public void delete(Emp emp) {

		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession(true);
		
		//SQL수행
		sqlSession.delete( namespace + "delete", emp);
		
		sqlSession.close();
				
		
	}

}
