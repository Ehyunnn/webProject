package test.com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDAOimpl implements AddressBookDAO, DBinfo {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AddressBookDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed..");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed..");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(AddressBookVO vo) {
		System.out.println("insert()....");
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		System.out.println(vo.getAddress());
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getAddress());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert failed...");
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
		return flag;
	}

	@Override
	public int update(AddressBookVO vo) {
		System.out.println("update()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		System.out.println(vo.getAddress());
		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getAddress());
			pstmt.setInt(4, vo.getNum());
			flag = pstmt.executeUpdate();

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

		return flag;
	}

	@Override
	public int delete(AddressBookVO vo) {
		System.out.println("delete()....");
		System.out.println(vo.getNum());

		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			flag = pstmt.executeUpdate();

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

		return flag;
	}

	@Override
	public AddressBookVO selectOne(AddressBookVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo.getNum());

		AddressBookVO vo2 = new AddressBookVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
				vo2.setAddress(rs.getString("address"));
				vo2.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne failed...");
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
	public List<AddressBookVO> selectAll() {
		System.out.println("selectAll()...");
		List<AddressBookVO> list = new ArrayList<AddressBookVO>();
		try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AddressBookVO vo2 = new AddressBookVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
				vo2.setAddress(rs.getString("address"));
				vo2.setWdate(rs.getDate("wdate"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			System.out.println("selectAll failed...");
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

		return list;
	}

	@Override
	public int loginOK(AddressBookVO vo) {
		System.out.println("loginOK()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getTel());
		
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(SQL_LOGIN_OK);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getTel());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				flag = 1;
			}
		} catch (SQLException e) {
			System.out.println("selectOne failed...");
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
		
		return flag;
	}

}
