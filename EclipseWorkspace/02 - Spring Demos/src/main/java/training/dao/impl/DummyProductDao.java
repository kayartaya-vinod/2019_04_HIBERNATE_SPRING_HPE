package training.dao.impl;

import training.dao.DaoException;
import training.dao.ProductDao;

public class DummyProductDao implements ProductDao {

	@Override
	public int count() throws DaoException {
		return -50;
	}

}
