package com.nam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam.converter.NewConverter;
import com.nam.dto.NewDTO;
import com.nam.entity.CategoryEntity;
import com.nam.entity.NewEntity;
import com.nam.repository.CategoryRepository;
import com.nam.repository.NewRepository;
import com.nam.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId()!= null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO,oldNewEntity);
		}else {
			 newEntity = newConverter.toEntity(newDTO);
		}
		 CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		 newEntity.setCategory(categoryEntity);
		 newEntity = newRepository.save(newEntity);
		 return newConverter.toDTO(newEntity);
		
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids)	{
			newRepository.delete(item);
		}
		
	}


}
