package entities;

public class Kurs {
	
	public Kurs(int id, String name, int fiyat) {
		this.id = id;
		this.name = name;
		this.fiyat = fiyat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	public int id;
	public String name;
	public int fiyat;
	

}
