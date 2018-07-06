package test.com.model;

import java.util.ArrayList;

public interface Test01DAO {

	public int insert(Test01VO vo);

	public int update(Test01VO vo);

	public int delete(Test01VO vo);

	public Test01VO selectOne(Test01VO vo);

	public ArrayList<Test01VO> selectAll();
}
