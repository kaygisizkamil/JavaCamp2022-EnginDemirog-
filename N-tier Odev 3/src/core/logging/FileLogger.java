package core.logging;

import entities.Egitmen;
import entities.Kategori;
import entities.Kurs;

public class FileLogger implements ILogger {

	@Override
	public <T> void log(T entities) {
		// TODO Auto-generated method stub
		if(entities instanceof Kategori) {
			System.out.println(" Dosyaya loglandi "+" id= "+((Kategori) entities).getId() + " ad "
			+((Kategori) entities).getName());
		}
		else if(entities instanceof Egitmen) {
			System.out.println(" Dosyaya loglandi "+" id= "+((Egitmen) entities).getId()+" ad "
					+((Egitmen) entities).getName());
		}
		else if(entities instanceof Kurs) {
			System.out.println(" Dosyaya loglandi "+" id= "+((Kurs) entities).getId() +" ad "
					+((Kurs) entities).getName());
		}
		else System.out.println(" Dosyaya loglanmak istenen veri gecerli tipte degil DbAdmini ile görüşün");
		
	}

}
