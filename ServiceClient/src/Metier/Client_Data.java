package Metier;

public class Client_Data {
	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private String adresse;
	private String email;
	private String metier;
	private double salaire;
	private String cin;
	
	
	public Client_Data() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client_Data(int id, String nom, String prenom, String tel, String adresse, String email, String metier,
			double salaire, String cin) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		this.metier = metier;
		this.salaire = salaire;
		this.cin = cin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMetier() {
		return metier;
	}


	public void setMetier(String metier) {
		this.metier = metier;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}

			
	
	
	
}
