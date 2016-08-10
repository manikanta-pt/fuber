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

import com.fuber.cab.domain.model.Asset;
@Repository
public class AssetRepository {  

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Asset save(Asset asset)
	{
		
		try {
			entityManager.persist(asset);  
			entityManager.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return asset;
	}
	
	
	public List<Asset> search(Asset asset) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Asset> createQuery = cb.createQuery(Asset.class);
		Root<Asset> assets = createQuery.from(Asset.class);
		createQuery.select(assets);
		Metamodel m = entityManager.getMetamodel();
		EntityType<Asset> Asset_ = m.entity(Asset.class);
    
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(asset.getNumber()!=null)
		{
		String name="%"+asset.getNumber().toLowerCase()+"%";
		predicates.add(cb.isNotNull(assets.get("number")));
		predicates.add(cb.like(cb.lower(assets.get(Asset_.getDeclaredSingularAttribute("number", String.class))),name));
		}
		createQuery.where(predicates.toArray(new Predicate[]{}));
		TypedQuery<Asset> query=entityManager.createQuery(createQuery);
		List<Asset> resultList = query.getResultList();
		return resultList;
		
		
		
	}


	public Asset findById(Long id) {
		return entityManager.find(Asset.class, id);
	}
	
	

	

	
}