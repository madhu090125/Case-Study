package com.eshoppingzone.produt.productservice.service;

import com.eshoppingzone.produt.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}