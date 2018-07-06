package test.com.model;

public interface DBinfo {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER_ID = "addr";
	String USER_PW = "hi123456";
	
	String SQL_INSERT = "insert into "
			+ "addressbook(num,name,tel,address) "
			+ "values(seq_addr.nextval,?,?,?)";
	
	String SQL_UPDATE = "update addressbook set "
			+ "name=?,tel=?,"
			+ "address=?,wdate=sysdate "
			+ "where num=?";
	
	String SQL_DELETE = "delete from addressbook "
			+ "where num=?";
	
	String SQL_SELECT_ONE = "select * from addressbook "
			+ "where num=?";
	
	String SQL_LOGIN_OK = "select * from addressbook "
			+ "where num=? and tel=?";
	
	String SQL_SELECT_ALL = "select * from addressbook "
			+ "order by num desc";
}
