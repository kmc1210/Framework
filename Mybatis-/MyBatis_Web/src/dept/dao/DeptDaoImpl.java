package dept.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	private String namespace = "dept.dao.DeptDao.";
	
	@Override
	public List<Dept> selectAll() {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//DB조회 결과
		List<Dept> deptList = sqlSession.selectList( namespace + "selectAll");
		
//		sqlSession.commit();
//		sqlSession.clearCache();
		sqlSession.close();
		
		return deptList;
	}

	@Override
	public Dept getDeptno(HttpServletRequest req) {

		String param = req.getParameter("deptno");
		
		int deptno=0;
		
		if(param!=null && !"".equals(param)) {
			
			deptno = Integer.parseInt(param);
		}
		
		Dept res = new Dept();
		res.setDeptno(deptno);
		return res;
	}

	@Override
	public Dept view(Dept deptno) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//SQL 수행
		Dept view = sqlSession.selectOne( namespace + "view", deptno);
		
		//마이바티스 객체 닫기
		sqlSession.close();
		
		//결과 반환
		return view;
	}

	@Override
	public void Insert(Dept dept) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession(true);
		
		//SQL수행
		sqlSession.insert( namespace + "insert", dept);
		
		sqlSession.close();
	}

	@Override
	public void delete(Dept dept) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession(true);
		
//		int res = sqlSession.
		
		//SQL수행
		sqlSession.delete( namespace + "delete", dept);
		
		sqlSession.close();
		
	}


}
