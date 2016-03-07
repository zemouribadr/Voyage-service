package service;

import java.util.List;

import Metier.Client_Data;

public interface ClientInterface {
	int add(int id, String nom, String prenom, String tel, String adresse, String email, String metier,
			double salaire, String cin);
	List<Client_Data> getall();
	Client_Data get(int id);
	Client_Data getbycin(String cin);
	int delete(int id);
	int deletebycin(String cin);
	boolean exist(int id);
	boolean existbycin(String cin);
	String get_nom(int id);
	String get_prenom(int id);
	String get_email(int id);
	String get_adresse(int id);
	String get_tel(int id);
	String get_metier(int id);
	double get_salaire(int id);
	String get_cin(int id);
	int get_id_bycin(String cin);
	String get_nom_bycin(String cin);
	String get_prenom_bycin(String cin);
	String get_email_bycin(String cin);
	String get_adresse_bycin(String cin);
	String get_tel_bycin(String cin);
	String get_metier_bycin(String cin);
	double get_salaire_bycin(String cin);
}
