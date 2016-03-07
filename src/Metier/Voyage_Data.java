package Metier;

public class Voyage_Data {
	private int id;
	private String city;
	private String country;
	private double price;
	private String logement;
	private String transport;
	private String saison;
	private int nb_place;
	private int nb_reste;
	private double acompte;
	
	
	
	public Voyage_Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voyage_Data(int id, String city, String country, double price, String logement, String transport,
			String saison, int nb_place, int nb_reste, double acompte) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.price = price;
		this.logement = logement;
		this.transport = transport;
		this.saison = saison;
		this.nb_place = nb_place;
		this.nb_reste = nb_reste;
		this.acompte = acompte;
	}

	public double getAcompte() {
		return acompte;
	}

	public void setAcompte(double acompte) {
		this.acompte = acompte;
	}

	public int getNb_place() {
		return nb_place;
	}

	public void setNb_place(int nb_place) {
		this.nb_place = nb_place;
	}

	public int getNb_reste() {
		return nb_reste;
	}

	public void setNb_reste(int nb_reste) {
		this.nb_reste = nb_reste;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLogement() {
		return logement;
	}
	public void setLogement(String logement) {
		this.logement = logement;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getSaison() {
		return saison;
	}
	public void setSaison(String saison) {
		this.saison = saison;
	}
		
	
	
	
}
