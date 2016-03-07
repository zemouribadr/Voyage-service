package service;

import java.util.List;

import Metier.Client_Data;
import dao.ClientDao;
import dao.DaoFactory;

public class Client implements ClientInterface{

	@Override
	public int add(int id, String nom, String prenom, String tel, String adresse, String email, String metier,
			double salaire, String cin) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.add(new Client_Data(id,nom,prenom,tel,adresse,email,metier,salaire,cin));
		
	}

	@Override
	public List<Client_Data> getall() {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.getall();
	}

	@Override
	public Client_Data get(int id) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.get(id);
	}

	@Override
	public Client_Data getbycin(String cin) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.getbycin(cin);
	}

	@Override
	public int delete(int id) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.delete(id);
	}

	@Override
	public int deletebycin(String cin) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.deletebycin(cin);
	}

	@Override
	public boolean exist(int id) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.exist(id);
	}

	@Override
	public boolean existbycin(String cin) {
		DaoFactory daofactory=DaoFactory.getInsatnce();
		ClientDao voyageDao=daofactory.getVoyageDao();
		return voyageDao.existbycin(cin);
	}


	@Override
	public String get_nom(int id) {
		return get(id).getNom();
	}

	@Override
	public String get_prenom(int id) {
		return get(id).getPrenom();
	}

	@Override
	public String get_email(int id) {
		return get(id).getEmail();
	}

	@Override
	public String get_adresse(int id) {
		return get(id).getAdresse();
	}

	@Override
	public String get_tel(int id) {
		return get(id).getTel();
	}

	@Override
	public String get_metier(int id) {
		return get(id).getMetier();
	}

	@Override
	public double get_salaire(int id) {
		return get(id).getSalaire();
	}

	@Override
	public String get_cin(int id) {
		return get(id).getCin();
	}

	@Override
	public int get_id_bycin(String cin) {
		return getbycin(cin).getId();
	}

	@Override
	public String get_nom_bycin(String cin) {
		return getbycin(cin).getNom();
	}

	@Override
	public String get_prenom_bycin(String cin) {
		return getbycin(cin).getPrenom();
	}

	@Override
	public String get_email_bycin(String cin) {
		return getbycin(cin).getEmail();
	}

	@Override
	public String get_adresse_bycin(String cin) {
		return getbycin(cin).getAdresse();
	}

	@Override
	public String get_tel_bycin(String cin) {
		return getbycin(cin).getTel();
	}

	@Override
	public String get_metier_bycin(String cin) {
		return getbycin(cin).getMetier();
	}

	@Override
	public double get_salaire_bycin(String cin) {
		return getbycin(cin).getSalaire();
	}

	
}
