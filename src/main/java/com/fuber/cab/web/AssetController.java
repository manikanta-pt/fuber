package com.fuber.cab.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuber.cab.domain.model.Asset;
import com.fuber.cab.domain.service.AssetService;
import com.fuber.cab.web.view.AssetResult;
import com.fuber.cab.web.view.Result;

@RestController
public class AssetController {
	@Autowired
	private AssetService assetService;
	
	@RequestMapping(value="/asset/create",method=RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })
    public Result create(@RequestBody Asset asset,BindingResult error )
    {
		Result result=new Result();
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to add Asset");
			result.setErorMessage(error.toString());
			
		}
		assetService.create(asset);
		result.setStatus("Success");
		result.setMessage("Asset "+asset.getNumber()+" Added Successfully");
		return result;
		
    }
	
	@RequestMapping(value="/asset/search",method=RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })
    public AssetResult search(@RequestBody Asset asset,BindingResult error )
    {
		AssetResult result=new AssetResult();
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to add Asset");
			result.setErorMessage(error.toString());
			
		}
		
		result.setAssets(assetService.findAll(asset));
		result.setStatus("Success");
		return result;
		
    }
	
	@RequestMapping(value="/asset/view/{id}",method=RequestMethod.GET, consumes = { "application/json" },produces = { "application/json" })
    public AssetResult search(@PathVariable Long id )
    {
		AssetResult result=new AssetResult();
		
		Asset assetById = assetService.findById(id);
		List<Asset> assets=new ArrayList<Asset>();
		assets.add(assetById);
		result.setAssets(assets);
		result.setStatus("Success");
		return result;
		
    }
	
	
	
}
