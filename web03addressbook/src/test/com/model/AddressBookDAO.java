package test.com.model;

import java.util.List;

public interface AddressBookDAO {

	public int insert(AddressBookVO vo);

	public int update(AddressBookVO vo);

	public int delete(AddressBookVO vo);

	public AddressBookVO selectOne(AddressBookVO vo);

	public List<AddressBookVO> selectAll();
	
	public int loginOK(AddressBookVO vo);
}
