package web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import web.dao.EmpDao;
import web.dto.Emp;

public class EmpServiceImpl implements EmpService{

	
	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	private EmpDao empDao;
	
	
	
	@Override
	public List<Emp> getList() {
	
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		
		//Mapper 를 이용한 DAO 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		// 전체 리스트 조회
		List<Emp> list = empDao.selectAll();
		
//		sqlSession.commit();
//		sqlSession.rollback();
//		
//		sqlSession.close();
		
		return list;
	}



	@Override
	public Emp view(Emp empno) {
		SqlSession sqlSession = factory.openSession();
		
		
		empDao = sqlSession.getMapper(EmpDao.class);
		
		
		Emp emp = empDao.selectEmpByEmpno(empno);
		
		return emp;
	}



	@Override
	public Emp getEmpno(HttpServletRequest req) {
		
		
		//Emp 객체 생성
//		Emp empno = new Emp();
		
//		empno 가져오기
		String param = req.getParameter("empno");
		
		int empno = 0;
		
		if(param!=null && !"".equals(param)) {
			
			empno = Integer.parseInt(param);
		}
		Emp res = new Emp();
		res.setEmpno(empno);
		
		return res;
	}

}
