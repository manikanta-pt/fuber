package com.fuber.cab.domain.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.cab.domain.model.AssetMap;
@Repository
public class AssetMapRepository {  

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public AssetMap save(AssetMap assetMap)
	{
		
		try {
			entityManager.persist(assetMap);  
			entityManager.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return assetMap;
	}
	
	
	public List<AssetMap> search(AssetMap assetMap) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AssetMap> createQuery = cb.createQuery(AssetMap.class);
		Root<AssetMap> assetMaps = createQuery.from(AssetMap.class);
		createQuery.select(assetMaps);
		Metamodel m = entityManager.getMetamodel();
		EntityType<AssetMap> AssetMap_ = m.entity(AssetMap.class);
    
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(assetMap.getAsset().getNumber()!=null)
		{
		String name="%"+assetMap.getAsset().getNumber().toLowerCase()+"%";
		predicates.add(cb.isNotNull(assetMaps.get("number")));
		predicates.add(cb.like(cb.lower(assetMaps.get(AssetMap_.getDeclaredSingularAttribute("asset.number", String.class))),name));
		}
		createQuery.where(predicates.toArray(new Predicate[]{}));
		TypedQuery<AssetMap> query=entityManager.createQuery(createQuery);
		List<AssetMap> resultList = query.getResultList();
		return resultList;
		
		
		
	}


	public AssetMap findById(Long id) {
		return entityManager.find(AssetMap.class, id);
	}
	
	

	

	
}