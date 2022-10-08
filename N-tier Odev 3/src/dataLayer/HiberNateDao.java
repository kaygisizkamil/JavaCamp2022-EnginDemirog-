package dataLayer;

import entities.Egitmen;
import entities.Kategori;
import entities.Kurs;

public  class HiberNateDao implements IDatabaseDao {

	@Override
	public <T> void Add(T thing) {
		// TODO Auto-generated method stub
		if(thing instanceof Egitmen) {
			System.out.println(((Egitmen) thing).getId()+" id'li "+ ((Egitmen) thing).getName()+" hibernate"
					+ " teknolojisi ile database eklendi");
		}
		else if(thing instanceof Kategori) {
			System.out.println(((Kategori) thing).getId()+" id'li  "+ ((Kategori) thing).getName()+" hibernate"
					+ " teknolojisi ile database eklendi");
		}
		else if(thing instanceof Kurs) {
			System.out.println(((Kurs) thing).getId()+" id'li "+ ((Kurs) thing).getName()+" hibernate"
					+ " teknolojisi ile database eklendi");
		}
		else System.out.println("Something went wrong please meet with ur IIS");
		
		
		
	}
	
		
}
