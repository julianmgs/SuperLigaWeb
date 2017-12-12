package com.julian.superliga.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.JugadorDao;
import com.julian.superliga.model.Jugador;

@Repository("jugadorDao")
public class JugadorDaoImpl extends AbstractDao<Long, Jugador> implements JugadorDao {

	@Override
	public Jugador findById(Long id) {
		return super.findObjectById(id);
	}

	@Override
	public List<Jugador> findAll() {
		return super.findAllObjects();
	}

	@Override
	public void save(Jugador jugador) {
		super.save(jugador);
	}

	/*-
	@Override
	public void update(Jugador jugador) {
		super.update(jugador);
	}
	 */

	@Override
	public void delete(Jugador jugador) {
		super.delete(jugador);
	}

	@Override
	public Jugador findByDci(String dci) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("dci", dci));
		return (Jugador) criteria.uniqueResult();

	}

}
