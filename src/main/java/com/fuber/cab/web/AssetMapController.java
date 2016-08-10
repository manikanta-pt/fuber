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

import com.fuber.cab.domain.model.AssetMap;
import com.fuber.cab.domain.service.AssetMapService;
import com.fuber.cab.domain.service.AssetService;
import com.fuber.cab.domain.service.CustomerService;
import com.fuber.cab.web.view.AssetMapResult;
import com.fuber.cab.web.view.Result;

@RestController
public class AssetMapController {
	@Autowired
	private AssetMapService assetMapService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/assetMap/create",method=RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })
    public Result create(@RequestBody AssetMap assetMap,BindingResult error )
    {
		Result result=new Result();
		assetMap.setCustomer(customerService.findAll(assetMap.getCustomer()).get(0));
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to Assign Vehicle");
			result.setErorMessage(error.toString());
			
		}
		assetMapService.create(assetMap);
		result.setStatus("Success");
		result.setMessage("Vehicle "+assetMap.getAsset().getNumber()+" Assigned  Successfully to "+assetMap.getCustomer().getName());
		return result;
		
    }
	
	@RequestMapping(value="/assetMap/search",method=RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })
    public AssetMapResult search(@RequestBody AssetMap assetMap,BindingResult error )
    {
		AssetMapResult result=new AssetMapResult();
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to add AssetMap");
			result.setErorMessage(error.toString());
			
		}
		
		result.setAssetMaps(assetMapService.findAll(assetMap));
		result.setStatus("Success");
		return result;
		
    }
	
	@RequestMapping(value="/assetMap/view/{id}",method=RequestMethod.GET, consumes = { "application/json" },produces = { "application/json" })
    public AssetMapResult search(@PathVariable Long id,BindingResult error )
    {
		AssetMapResult result=new AssetMapResult();
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to add AssetMap");
			result.setErorMessage(error.toString());
			
		}
		
		AssetMap assetMapById = assetMapService.findById(id);
		List<AssetMap> assetMaps=new ArrayList<AssetMap>();
		assetMaps.add(assetMapById);
		result.setAssetMaps(assetMaps);
		result.setStatus("Success");
		return result;
		
    }
	
	
	
}
