package test.com.service;

import java.util.List;

import test.com.model.AddressBookDAO;
import test.com.model.AddressBookDAOimpl;
import test.com.model.AddressBookVO;

public class AddressBookServiceImpl implements AddressBookService {
	AddressBookDAO dao;

	public AddressBookServiceImpl() {
		System.out.println("AddressBookServiceImpl()..");
		dao = new AddressBookDAOimpl();
	}

	@Override
	public int insert(AddressBookVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(AddressBookVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(AddressBookVO vo) {
		return dao.delete(vo);
	}

	@Override
	public AddressBookVO selectOne(AddressBookVO vo) {
		return dao.selectOne(vo);
	}

	@Override
	public List<AddressBookVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int loginOK(AddressBookVO vo) {
		return dao.loginOK(vo);
	}

}
