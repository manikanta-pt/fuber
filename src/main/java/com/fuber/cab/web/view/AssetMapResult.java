package com.fuber.cab.web.view;

import java.util.List;

import com.fuber.cab.domain.model.AssetMap;

public class AssetMapResult extends Result{
	private List<AssetMap> assetMaps;

	public List<AssetMap> getAssetMaps() {
		return assetMaps;
	}

	public void setAssetMaps(List<AssetMap> assetMaps) {
		this.assetMaps = assetMaps;
	}
	 

}
