package com.julian.superliga.vo;

public class Mes {

	private int nroMes;
	private String nomMes;
	private String nomM;

	public Mes() {

	}

	public Mes(int nroMes, String nomMes, String nomM) {
		this.nroMes = nroMes;
		this.nomMes = nomMes;
		this.nomM = nomM;
	}

	public int getNroMes() {
		return this.nroMes;
	}

	public void setNroMes(int nroMes) {
		this.nroMes = nroMes;
	}

	public String getNomMes() {
		return this.nomMes;
	}

	public void setNomMes(String nomMes) {
		this.nomMes = nomMes;
	}

	public String getNomM() {
		return this.nomM;
	}

	public void setNomM(String nomM) {
		this.nomM = nomM;
	}

	@Override
	public String toString() {
		return this.nomMes;
	}

}
