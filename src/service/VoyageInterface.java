package service;

import java.util.List;

import Metier.Voyage_Data;

public interface VoyageInterface {
	void add( String city, String country, double price, String logement, String transport,
			String saison, int nb_place, int nb_reste, double acompte);
	List<Voyage_Data> getall();
	Voyage_Data get(int id);
	int delete(int id);
	int reserver(int id,int nb);
	int annuler_reservation(int id,int nb);
	String get_city(int id);
	String get_country(int id);
	String get_transport(int id);
	String get_logement(int id);
	String get_saison(int id);
	double get_price(int id);
	double get_acompte(int id);
	int get_nb_reste(int id);
	int get_nb_place(int id);
	boolean exist(int id);
}
