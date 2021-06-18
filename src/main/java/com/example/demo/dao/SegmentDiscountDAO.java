package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SegmentDiscount;

@Repository
public class SegmentDiscountDAO {

	private EntityManager entityManager;

	@Autowired
	public SegmentDiscountDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public List<SegmentDiscount> findAll() {
		Query theQuery = entityManager.createQuery("from SegmentDiscount");
		List<SegmentDiscount> segmentDiscounts = theQuery.getResultList();
		return segmentDiscounts;
	}

	public SegmentDiscount findById(int theId) {
		SegmentDiscount theSegmentDiscount = entityManager.find(SegmentDiscount.class, theId);
		return theSegmentDiscount;
	}

	public void save(SegmentDiscount theSegmentDiscount) {
		SegmentDiscount dbSegmentDiscount = entityManager.merge(theSegmentDiscount);
		theSegmentDiscount.setId(dbSegmentDiscount.getId());
	}

	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from SegmentDiscount where id=:segmentDiscountId");
		theQuery.setParameter("segmentDiscountId", theId);
		theQuery.executeUpdate();
	}

}
