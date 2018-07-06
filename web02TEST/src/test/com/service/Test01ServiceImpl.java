package test.com.service;

import java.util.ArrayList;

import test.com.model.Test01DAO;
import test.com.model.Test01DAOimpl;
import test.com.model.Test01VO;

public class Test01ServiceImpl implements Test01Service{

	public Test01DAO dao;
	
	public Test01ServiceImpl() {
		System.out.println("Test01Service()...");
		dao = new Test01DAOimpl();
	}

	@Override
	public int insert(Test01VO vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(Test01VO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(Test01VO vo) {
		return dao.delete(vo);
	}

	@Override
	public Test01VO selectOne(Test01VO vo) {
		return dao.selectOne(vo);
	}

	@Override
	public ArrayList<Test01VO> selectAll() {
		return dao.selectAll();
	}
}
