package com.fuber.cab.web.view;

import java.util.List;

import com.fuber.cab.domain.model.Asset;

public class AssetResult extends Result{
	private List<Asset> assets;

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	 

}
