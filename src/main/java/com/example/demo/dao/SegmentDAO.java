package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Segment;

@Repository
public class SegmentDAO {

	private EntityManager entityManager;

	@Autowired
	public SegmentDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public List<Segment> findAll() {
		Query theQuery = entityManager.createQuery("from Segment");
		List<Segment> segments = theQuery.getResultList();
		return segments;
	}

	public Segment findById(int theId) {
		Segment theSegment = entityManager.find(Segment.class, theId);
		return theSegment;
	}

	public void save(Segment theSegment) {
		Segment dbSegment = entityManager.merge(theSegment);
		theSegment.setId(dbSegment.getId());
	}

	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Segment where id=:segmentId");
		theQuery.setParameter("segmentId", theId);
		theQuery.executeUpdate();
	}

}
