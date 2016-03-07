package dao;

import java.util.List;

import Metier.Voyage_Data;

public interface VoyageInterfaceDao {
	void add(Voyage_Data d);
	List<Voyage_Data> getall();
	Voyage_Data get(int id);
	int delete(int id);
	int reserver(int id,int nb);
	int annuler_reservation(int id,int nb);
	boolean exist(int id);
}
