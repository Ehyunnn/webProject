package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test01DAOimpl implements Test01DAO {

	// 3.커넥션>>user/pw >> test/hi123456,url
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public Test01DAOimpl() {
		// 2.사용선언>>드라이버연결
		// 예외처리:try~catch
		// 예외전가:throws
		try {
			Class.forName(Test01DBinfo.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Test01VO vo) {
		System.out.println("insert().....");
		int result = 0;
		try {
			// 3.커넥션>>user/pw >> test/hi123456,url
			conn = DriverManager.getConnection(Test01DBinfo.URL, Test01DBinfo.USER_ID, Test01DBinfo.USER_PW);
			System.out.println("conn successed");

			// 4.디비질의문 실행
			String sql = "insert into " + "table1(column1,column2,column3,column4,column5,column6) "
					+ "values(seq1.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getColumn2());
			pstmt.setString(2, vo.getColumn3());
			pstmt.setString(3, vo.getColumn4());
			pstmt.setString(4, vo.getColumn5());
			pstmt.setString(5, vo.getColumn6());
			// 5.반환처리
			result = pstmt.executeUpdate();
			System.out.println("result:" + result);

		} catch (SQLException e) {
			System.out.println("insert failed");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public int update(Test01VO vo) {
		System.out.println("update()....");
		int result = 0;
		System.out.println(vo.getColumn1());
		System.out.println(vo.getColumn2());
		System.out.println(vo.getColumn3());
		System.out.println(vo.getColumn4());
		System.out.println(vo.getColumn5());
		System.out.println(vo.getColumn6());

		try {
			conn = DriverManager.getConnection(Test01DBinfo.URL, Test01DBinfo.USER_ID, Test01DBinfo.USER_PW);
			System.out.println("conn successed");
			String sql = "update table1 set "
					+ "column2=?, column3=?,"
					+ "column4=?, column5=?,"
					+ "column6=? "
					+ "where column1=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getColumn2());
			pstmt.setString(2, vo.getColumn3());
			pstmt.setString(3, vo.getColumn4());
			pstmt.setString(4, vo.getColumn5());
			pstmt.setString(5, vo.getColumn6());
			pstmt.setInt(6, vo.getColumn1());
			
			result = pstmt.executeUpdate();
			System.out.println("result:"+result);
			
		} catch (SQLException e) {
			System.out.println("update failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public int delete(Test01VO vo) {
		System.out.println("delete()....");
		int result = 0;
		System.out.println(vo.getColumn1());
		try {
			conn = DriverManager.getConnection(Test01DBinfo.URL, Test01DBinfo.USER_ID, Test01DBinfo.USER_PW);
			System.out.println("conn successed");
			String sql = "delete from table1 where column1=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getColumn1());
			
			result = pstmt.executeUpdate();
			System.out.println("result:"+result);
			
		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Test01VO selectOne(Test01VO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getColumn1());
		Test01VO vo2 = new Test01VO();
		
		try {
			conn = DriverManager.getConnection(Test01DBinfo.URL, Test01DBinfo.USER_ID, Test01DBinfo.USER_PW);
			System.out.println("conn successed");
			String sql = "select * from table1 where column1=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getColumn1());
			
			rs = pstmt.executeQuery();
			System.out.println("rs:"+rs);
			while(rs.next()) {
				vo2.setColumn1(rs.getInt("column1"));
				vo2.setColumn2(rs.getString("column2"));
				vo2.setColumn3(rs.getString("column3"));
				vo2.setColumn4(rs.getString("column4"));
				vo2.setColumn5(rs.getString("column5"));
				vo2.setColumn6(rs.getString("column6"));
			}
			
		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vo2;
	}

	@Override
	public ArrayList<Test01VO> selectAll() {
		ArrayList<Test01VO> vos = 
				new ArrayList<Test01VO>();
		try {
			conn = DriverManager.getConnection(Test01DBinfo.URL, Test01DBinfo.USER_ID, Test01DBinfo.USER_PW);
			System.out.println("conn successed");
			String sql = "select * from table1 order by column1 desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("rs:"+rs);
			while(rs.next()) {
				Test01VO vo = new Test01VO();
				vo.setColumn1(rs.getInt("column1"));
				vo.setColumn2(rs.getString("column2"));
				vo.setColumn3(rs.getString("column3"));
				vo.setColumn4(rs.getString("column4"));
				vo.setColumn5(rs.getString("column5"));
				vo.setColumn6(rs.getString("column6"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return vos;
	}

}
