package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Metier.Client_Data;

public class ClientDao implements ClientInterfaceDao {
	private DaoFactory daofactory;

	public ClientDao(DaoFactory daofactory) {
		super();
		this.daofactory = daofactory;
	}

	@Override
	public int add(Client_Data d) {
		Connection connexion=null;
		PreparedStatement preparedStatement=null;
		int i=0;
		try {
			connexion=daofactory.getConnexion();
			String query="INSERT INTO client(nom,prenom,tel,adresse,email,metier,salaire,cin) VALUES (?,?,?,?,?,?,?,?);";
			preparedStatement=connexion.prepareStatement(query);
			preparedStatement.setString(1, d.getNom());
			preparedStatement.setString(2, d.getPrenom());
			preparedStatement.setString(3, d.getTel());
			preparedStatement.setString(4, d.getAdresse());
			preparedStatement.setString(5, d.getEmail());
			preparedStatement.setString(6, d.getMetier());
			preparedStatement.setDouble(7, d.getSalaire());
			preparedStatement.setString(8, d.getCin());
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return getbycin(d.getCin()).getId();
		
	}

	@Override
	public List<Client_Data> getall() {
		List<Client_Data> list=new ArrayList<Client_Data>();
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from client;";
			result=statement.executeQuery(query);
			while(result.next())
			{
				int id=result.getInt("id");
				String nom=result.getString("nom");
				String prenom=result.getString("prenom");
				String tel=result.getString("tel");
				String adresse=result.getString("adresse");
				String email=result.getString("email");
				String metier=result.getString("metier");
				double salaire=result.getDouble("salaire");
				String cin=result.getString("cin");
				list.add( new Client_Data(id,nom,prenom,tel,adresse,email,metier,salaire,cin));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Client_Data get(int id) {
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		Client_Data data=new Client_Data();
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from client where id="+id+";";
			result=statement.executeQuery(query);
			while(result.next())
			{
				String nom=result.getString("nom");
				String prenom=result.getString("prenom");
				String tel=result.getString("tel");
				String adresse=result.getString("adresse");
				String email=result.getString("email");
				String metier=result.getString("metier");
				double salaire=result.getDouble("salaire");
				String cin=result.getString("cin");
				data= new Client_Data(id,nom,prenom,tel,adresse,email,metier,salaire,cin);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public int delete(int id) {
		
		Connection connexion=null;
		PreparedStatement preparedStatement=null;
		int i=0;
		try {
			connexion=daofactory.getConnexion();
			String query="delete from client where id="+id+";";
			preparedStatement=connexion.prepareStatement(query);
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Client_Data getbycin(String cin) {
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		Client_Data data=new Client_Data();
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from client where cin='"+cin+"';";
			result=statement.executeQuery(query);
			while(result.next())
			{
				int id=result.getInt("id");
				String nom=result.getString("nom");
				String prenom=result.getString("prenom");
				String tel=result.getString("tel");
				String adresse=result.getString("adresse");
				String email=result.getString("email");
				String metier=result.getString("metier");
				double salaire=result.getDouble("salaire");
				data= new Client_Data(id,nom,prenom,tel,adresse,email,metier,salaire,cin);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public int deletebycin(String cin) {
		Connection connexion=null;
		PreparedStatement preparedStatement=null;
		int i=0;
		try {
			connexion=daofactory.getConnexion();
			String query="delete from client where cin='"+cin+"';";
			preparedStatement=connexion.prepareStatement(query);
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean exist(int id) {
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from client where id="+id+";";
			result=statement.executeQuery(query);
			return result.next();		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean existbycin(String cin) {
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from client where cin='"+cin+"';";
			result=statement.executeQuery(query);
			return result.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	

	
}
