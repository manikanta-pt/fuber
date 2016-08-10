package com.fuber.cab.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.cab.domain.model.AssetMap;
import com.fuber.cab.domain.repository.AssetMapRepository;
@Service
public class AssetMapService {
	@Autowired
	AssetMapRepository assetMapRepository;
	
	@Transactional
	public AssetMap create(AssetMap assetMap)
	{
		//assetMap.getCustomer().get
		assetMapRepository.save(assetMap);
		return assetMap;
	}
	
	public List<AssetMap> findAll(AssetMap assetMap)
	{
		
		return assetMapRepository.search(assetMap);
	}

	public AssetMap findById(Long id) {
		return assetMapRepository.findById(id);
		
	}
	
}
