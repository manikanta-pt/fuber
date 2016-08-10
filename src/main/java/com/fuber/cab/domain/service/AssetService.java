package com.fuber.cab.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.cab.domain.model.Asset;
import com.fuber.cab.domain.repository.AssetRepository;
@Service
public class AssetService {
	@Autowired
	AssetRepository assetRepository;
	
	@Transactional
	public Asset create(Asset asset)
	{
		assetRepository.save(asset);
		return asset;
	}
	
	public List<Asset> findAll(Asset asset)
	{
		
		return assetRepository.search(asset);
	}

	public Asset findById(Long id) {
		return assetRepository.findById(id);
		
	}
	
}
