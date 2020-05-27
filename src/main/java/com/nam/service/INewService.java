package com.nam.service;

import com.nam.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	void delete(long[] ids);
	
}
