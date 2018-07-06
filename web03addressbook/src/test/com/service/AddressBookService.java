package test.com.service;

import java.util.List;

import test.com.model.AddressBookVO;

public interface AddressBookService {

	public int insert(AddressBookVO vo);

	public int update(AddressBookVO vo);

	public int delete(AddressBookVO vo);

	public AddressBookVO selectOne(AddressBookVO vo);

	public List<AddressBookVO> selectAll();
	
	public int loginOK(AddressBookVO vo);
}
