package com.julian.superliga.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.julian.superliga.dao.inter.PuntosJugadorEventoDao;
import com.julian.superliga.model.Evento;
import com.julian.superliga.model.Jugador;
import com.julian.superliga.model.PuntosJugadorEvento;

@Repository("puntosJugadorEventoDao")
public class PuntosJugadorEventoDaoImpl extends AbstractDao<Long, PuntosJugadorEvento>
		implements PuntosJugadorEventoDao {

	@Override
	public PuntosJugadorEvento findById(Long id) {

		return super.findObjectById(id);
	}

	@Override
	public List<PuntosJugadorEvento> findAll() {

		return super.findAllObjects();
	}

	@Override
	public void save(PuntosJugadorEvento pje) {
		super.save(pje);
	}

	/*-
	@Override
	public void update(PuntosJugadorEvento pje) {
		super.update(pje);
	}
	 */

	@Override
	public void delete(PuntosJugadorEvento pje) {
		super.delete(pje);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PuntosJugadorEvento> findBySeason(int year, int month) {

		java.sql.Date fechaDesde = createFechaDesde(year, month);
		java.sql.Date fechaHasta = createFechaHasta(year, month);

		List<Object[]> result = getSession()
				.createCriteria(PuntosJugadorEvento.class)
				.createAlias("evento", "evento")
				.add(Restrictions.between("evento.fecha", fechaDesde, fechaHasta))
				.addOrder(Order.desc("puntos"))
				.setProjection(
						Projections.projectionList()
								//.add(Projections.property("id"))
								//.add(Projections.groupProperty("id"))
								.add(Projections.groupProperty("jugador"))
								//.add(Projections.property("evento"))
								.add(Projections.count("evento"))
								.add(Projections.sum("puntos"), "puntos")).list();

		List<PuntosJugadorEvento> lista = new ArrayList<PuntosJugadorEvento>();
		PuntosJugadorEvento punto;
		for (Object[] pje : result) {
			punto = new PuntosJugadorEvento();
			//punto.setId((long) pje[0]);
			punto.setJugador((Jugador) pje[0]);
			//punto.setEvento((Evento) pje[2]);
			punto.setEventosJugados((int) (long) pje[1]);
			punto.setPuntos((int) (long) pje[2]);
			lista.add(punto);
		}

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PuntosJugadorEvento> findBySemestre(int year, int semestre) {

		int month = 1;
		if (semestre != 1) {
			month = 7;
		}

		java.sql.Date fechaDesde = createFechaDesde(year, month);
		java.sql.Date fechaHasta = createFechaHasta(year, month + 6);

		List<Object[]> result = getSession()
				.createCriteria(PuntosJugadorEvento.class)
				.createAlias("evento", "evento")
				.add(Restrictions.between("evento.fecha", fechaDesde, fechaHasta))
				.addOrder(Order.desc("puntos"))
				.setProjection(
						Projections.projectionList()
								//.add(Projections.property("id"))
								//.add(Projections.groupProperty("id"))
								.add(Projections.groupProperty("jugador"))
								//.add(Projections.property("evento"))
								.add(Projections.count("evento"))
								.add(Projections.sum("puntos"), "puntos")).list();

		List<PuntosJugadorEvento> lista = new ArrayList<PuntosJugadorEvento>();
		PuntosJugadorEvento punto;
		for (Object[] pje : result) {
			punto = new PuntosJugadorEvento();
			//punto.setId((long) pje[0]);
			punto.setJugador((Jugador) pje[0]);
			//punto.setEvento((Evento) pje[2]);
			punto.setEventosJugados((int) (long) pje[1]);
			punto.setPuntos((int) (long) pje[2]);
			lista.add(punto);
		}

		return lista;
	}

	private java.sql.Date createFechaDesde(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return new java.sql.Date(cal.getTime().getTime());
	}

	private java.sql.Date createFechaHasta(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 31);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return new java.sql.Date(cal.getTime().getTime());
	}
}
