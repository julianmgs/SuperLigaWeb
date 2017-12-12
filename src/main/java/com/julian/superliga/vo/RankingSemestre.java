package com.julian.superliga.vo;

public class RankingSemestre {

	private int semestre;
	private int anio;

	public RankingSemestre() {
	}

	public RankingSemestre(int semestre, int anio) {
		this.semestre = semestre;
		this.anio = anio;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
}
