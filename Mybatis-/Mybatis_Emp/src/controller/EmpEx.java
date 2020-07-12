package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	
	//전역객체로 sqlSession 생성 팩토리 생성
	private  static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	public static void main(String[] args) {
		
		//mybatis 수행 객체
		SqlSession sqlSession;
		
		// DB 접속 및 SqlSession  생성 팩토리 객체
//		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		// mybatis 수행 객체 생성
		sqlSession = sqlSessionFactory.openSession(true);
		
		
		// mybatis의 mapper와 자바프로그램의 dao 인터페이스 매핑(연결)
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("------------전체 조회-------------------");
		
//		sqlSession.selectOne();
//		sqlSession.selectList();
//		sqlSession.selectMap();
//		
//		sqlSession.insert();
//		sqlSession.update();
//		sqlSession.delete();
		
		
//		sqlSession.commit();
//		sqlSession.rollback();
		
		List<Emp> list = empDao.selectAll();
		for ( Emp emp : list) {
			System.out.println(emp);
			
		}
		
//		System.out.println("-------------직원 등록-----------------");
		Emp insertEmp = new Emp();
		System.out.print("사원번호 : ");
		insertEmp.setEmpno(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("이름: ");
		insertEmp.setEname(sc.nextLine());
		
		System.out.print("일: ");
		insertEmp.setJob(sc.nextLine());
		
		System.out.print("매니저: ");
		insertEmp.setMgr(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("입사날짜(yyyy-MM-dd): ");
//		insertEmp.setHiredate(new Date());
		
		String input = sc.nextLine();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = null;
		
			try {
				hiredate = form.parse( input );
			} catch (ParseException e) {
				e.printStackTrace();
			}
		insertEmp.setHiredate( hiredate );
		
		System.out.print("연봉 : ");
		insertEmp.setSal(sc.nextInt());
		
		System.out.print("보너스: ");
		insertEmp.setComm(sc.nextInt());
		
		System.out.print("부서번호: ");
		insertEmp.setDeptno(sc.nextInt());
		
		empDao.insert( insertEmp );
		
//		sqlSession.commit();
		
//		System.out.println("----------------삽입된 데이터 조회 -----------------");
//		
//		Emp param = new Emp();
//		param.setEmpno(5003);
//		
//		Emp res2 = empDao.selectByEmpno(param);
		
		System.out.println("-------------직원번호를 이용한 조회 ---------");
		System.out.println(" :: 사원번호를  입력하세요 :: >> ");
		int empno = sc.nextInt();
		Emp emp = empDao.selectByEmpno(empno);
		System.out.println(emp);
//		
		
		System.out.println("-------------사원 정보 삭제 ---------------");
		System.out.print(" >> 삭제할 사원의 사원번호를 입력하시오 : ");
		int empnum = sc.nextInt();
		Emp empDelete = new Emp();
		empDelete.setEmpno(empnum);
		empDao.deleteByEmpno(empDelete);
		
	}
	
}
