package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Metier.Voyage_Data;

public class VoyageDao implements VoyageInterfaceDao {
	private DaoFactory daofactory;

	public VoyageDao(DaoFactory daofactory) {
		super();
		this.daofactory = daofactory;
	}

	@Override
	public void add(Voyage_Data d) {
		Connection connexion=null;
		PreparedStatement preparedStatement=null;
		try {
			connexion=daofactory.getConnexion();
			String query="INSERT INTO voyage(city,country,price,logement,transport,saison,nb_place,nb_reste,acompte) VALUES (?,?,?,?,?,?,?,?,?);";
			preparedStatement=connexion.prepareStatement(query);
			preparedStatement.setString(1, d.getCity());
			preparedStatement.setString(2, d.getCountry());
			preparedStatement.setDouble(3, d.getPrice());
			preparedStatement.setString(4, d.getLogement());
			preparedStatement.setString(5, d.getTransport());
			preparedStatement.setString(6, d.getSaison());
			preparedStatement.setInt(7, d.getNb_place());
			preparedStatement.setInt(8, d.getNb_reste());
			preparedStatement.setDouble(9, d.getAcompte());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Voyage_Data> getall() {
		List<Voyage_Data> list=new ArrayList<Voyage_Data>();
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from voyage;";
			result=statement.executeQuery(query);
			while(result.next())
			{
				 int id=result.getInt("id");
				 String city=result.getString("city");
				 String country=result.getString("country");
				 double price=result.getDouble("price");
				 String logement=result.getString("logement");
				 String transport=result.getString("transport");
				 String saison=result.getString("saison");
				 int nb_reste=result.getInt("nb_reste");
				 int nb_place=result.getInt("nb_place");
				 double acompte=result.getDouble("acompte");
				list.add( new Voyage_Data(id,city,country,price,logement,transport,saison,nb_place,nb_reste,acompte));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Voyage_Data get(int id) {
		Connection connexion;
		Statement statement;
		ResultSet result=null;
		Voyage_Data data=new Voyage_Data();
		try {
			connexion=daofactory.getConnexion();
			statement=connexion.createStatement();
			String query="select * from voyage where id="+id+";";
			result=statement.executeQuery(query);
			while(result.next())
			{
				 String city=result.getString("city");
				 String country=result.getString("country");
				 double price=result.getDouble("price");
				 String logement=result.getString("logement");
				 String transport=result.getString("transport");
				 String saison=result.getString("saison");
				 int nb_reste=result.getInt("nb_reste");
				 int nb_place=result.getInt("nb_place");
				 double acompte=result.getDouble("acompte");
				data= new Voyage_Data(id,city,country,price,logement,transport,saison,nb_place,nb_reste,acompte);
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
			String query="delete from voyage where id="+id+";";
			preparedStatement=connexion.prepareStatement(query);
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int reserver(int id,int nb) {
		Connection connexion=null;
		PreparedStatement preparedStatement=null;
		int i=0;
		try {
			connexion=daofactory.getConnexion();
			String query="Update voyage set nb_reste=nb_reste-"+nb+" where id="+id+";";
			preparedStatement=connexion.prepareStatement(query);
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int annuler_reservation(int id,int nb) {
		Connection connexion=null;
		PreparedStatement preparedStatement=null;
		int i=0;
		try {
			connexion=daofactory.getConnexion();
			String query="Update voyage set nb_reste=nb_reste+"+nb+" where id="+id+";";
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
			String query="select * from voyage where id="+id+";";
			result=statement.executeQuery(query);
			return result.next();		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
}
