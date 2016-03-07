package dao;

import java.util.List;

import Metier.Client_Data;

public interface ClientInterfaceDao {
	int add(Client_Data d);
	List<Client_Data> getall();
	Client_Data get(int id);
	Client_Data getbycin(String cin);
	int delete(int id);
	int deletebycin(String cin);
	boolean exist(int id);
	boolean existbycin(String cin);
}
