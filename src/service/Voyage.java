package service;

import java.util.List;

import Metier.Voyage_Data;
import dao.DaoFactory;
import dao.VoyageDao;

public class Voyage implements VoyageInterface{

	@Override
	public void add(String city, String country, double price, String logement, String transport, String saison,
			int nb_place, int nb_reste, double acompte) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		voyageDao.add(new Voyage_Data(0,city,country,price,logement,transport,saison,nb_place,nb_reste,acompte));
		
	}

	@Override
	public List<Voyage_Data> getall() {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.getall();
	}

	@Override
	public Voyage_Data get(int id) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.get(id);
	}

	@Override
	public int delete(int id) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.delete(id);
	}

	@Override
	public int reserver(int id,int nb) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.reserver(id,nb);
	}

	@Override
	public int annuler_reservation(int id,int nb) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.annuler_reservation(id,nb);
	}

	@Override
	public String get_city(int id) {
		return this.get(id).getCity();
	}

	@Override
	public String get_country(int id) {
		return this.get(id).getCountry();
	}

	@Override
	public String get_transport(int id) {
		return this.get(id).getTransport();
	}

	@Override
	public String get_logement(int id) {
		return this.get(id).getLogement();
	}

	@Override
	public String get_saison(int id) {
		return this.get(id).getSaison();
	}

	@Override
	public double get_price(int id) {
		return this.get(id).getPrice();
	}

	@Override
	public double get_acompte(int id) {
		return this.get(id).getAcompte();
	}

	@Override
	public int get_nb_reste(int id) {
		return this.get(id).getNb_reste();
	}

	@Override
	public int get_nb_place(int id) {
		return this.get(id).getNb_place();
	}

	@Override
	public boolean exist(int id) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		VoyageDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.exist(id);
	}



}
