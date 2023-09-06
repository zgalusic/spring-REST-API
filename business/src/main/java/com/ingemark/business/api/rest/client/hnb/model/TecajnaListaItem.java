package com.ingemark.business.api.rest.client.hnb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TecajnaListaItem{

	@JsonProperty("drzava_iso")
	private String drzavaIso;

	@JsonProperty("prodajni_tecaj")
	private String prodajniTecaj;

	@JsonProperty("drzava")
	private String drzava;

	@JsonProperty("valuta")
	private String valuta;

	@JsonProperty("datum_primjene")
	private String datumPrimjene;

	@JsonProperty("kupovni_tecaj")
	private String kupovniTecaj;

	@JsonProperty("srednji_tecaj")
	private String srednjiTecaj;

	@JsonProperty("sifra_valute")
	private String sifraValute;

	@JsonProperty("broj_tecajnice")
	private String brojTecajnice;

	public void setDrzavaIso(String drzavaIso){
		this.drzavaIso = drzavaIso;
	}

	public String getDrzavaIso(){
		return drzavaIso;
	}

	public void setProdajniTecaj(String prodajniTecaj){
		this.prodajniTecaj = prodajniTecaj;
	}

	public String getProdajniTecaj(){
		return prodajniTecaj;
	}

	public void setDrzava(String drzava){
		this.drzava = drzava;
	}

	public String getDrzava(){
		return drzava;
	}

	public void setValuta(String valuta){
		this.valuta = valuta;
	}

	public String getValuta(){
		return valuta;
	}

	public void setDatumPrimjene(String datumPrimjene){
		this.datumPrimjene = datumPrimjene;
	}

	public String getDatumPrimjene(){
		return datumPrimjene;
	}

	public void setKupovniTecaj(String kupovniTecaj){
		this.kupovniTecaj = kupovniTecaj;
	}

	public String getKupovniTecaj(){
		return kupovniTecaj;
	}

	public void setSrednjiTecaj(String srednjiTecaj){
		this.srednjiTecaj = srednjiTecaj;
	}

	public String getSrednjiTecaj(){
		return srednjiTecaj;
	}

	public void setSifraValute(String sifraValute){
		this.sifraValute = sifraValute;
	}

	public String getSifraValute(){
		return sifraValute;
	}

	public void setBrojTecajnice(String brojTecajnice){
		this.brojTecajnice = brojTecajnice;
	}

	public String getBrojTecajnice(){
		return brojTecajnice;
	}
}