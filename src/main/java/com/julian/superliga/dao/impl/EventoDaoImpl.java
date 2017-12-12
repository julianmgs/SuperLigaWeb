package com.julian.superliga.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.EventoDao;
import com.julian.superliga.model.Evento;

@Repository("eventoDao")
public class EventoDaoImpl extends AbstractDao<Long, Evento> implements EventoDao {

	@Override
	public Evento findById(Long id) {
		return super.findObjectById(id);
	}

	@Override
	public List<Evento> findAll() {
		return super.findAllObjects();
	}

	@Override
	public void save(Evento evento) {
		super.save(evento);
	}

	/*-
	@Override
	public void update(Evento evento) {
		super.update(evento);
	}
	 */

	@Override
	public void delete(Evento evento) {
		super.delete(evento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> findAllBySeason(int month, int year) {
		Query query = getSession()
				.createSQLQuery(
						"SELECT e FROM Evento e WHERE MONTH(e.fecha) = :month AND YEAR(e.fecha) = :year")
				.setParameter("month", month).setParameter("year", year);

		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> findAfterDate(Date fecha) {

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ge("fecha", fecha));

		return criteria.list();
	}

	/*-
	@SuppressWarnings("unchecked")
	public List<Evento> findAllBySeason(int month, int year) throws Exception {

		Query query = getEntityManager()
				.createQuery(
						"SELECT e FROM Evento e WHERE MONTH(e.fecha) = :month AND YEAR(e.fecha) = :year")
				.setParameter("month", month).setParameter("year", year);

		return query.getResultList();
	}
	 */

}
