package test.com.service;

import java.util.ArrayList;

import test.com.model.Test01VO;

public interface Test01Service {
	public int insert(Test01VO vo);

	public int update(Test01VO vo);

	public int delete(Test01VO vo);

	public Test01VO selectOne(Test01VO vo);

	public ArrayList<Test01VO> selectAll();
}
