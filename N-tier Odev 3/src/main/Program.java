package main;

import java.util.ArrayList;
import java.util.List;

import business.EgitmenManager;
import business.KategoriManager;
import business.KursManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.ILogger;
import dataLayer.HiberNateDao;
import dataLayer.JcdbDao;
import entities.Egitmen;
import entities.Kategori;
import entities.Kurs;

public class Program {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
			
			List<ILogger>_logging=new ArrayList<>();
			_logging.add(new FileLogger());
			_logging.add(new DatabaseLogger());
			//id kullanilmasinin sebebi jcdb'de normalde gerekli olmasi good practice
			//asagidaki id kullanimi gerekli degil gosterim amacli
			Kurs kurs=new Kurs(1,"Java ile oop",1321);
			Egitmen egitmen=new Egitmen(10,"Engin Demirog");
			Kategori kategori=new Kategori(1,"Frontend");
			
			//lets manage 'em!
			
			KursManager kursM=new KursManager(new HiberNateDao(),_logging);
			EgitmenManager egitmenM=new EgitmenManager(new JcdbDao(),_logging);
			KategoriManager kategoriM=new KategoriManager(new JcdbDao(),_logging);
	
			
			kursM.add(kurs);		
			kategoriM.add(kategori);
			egitmenM.add(egitmen);
			
			//tekrar ekleme kısmında database 'de duplicate yapmiyor ama dosyaya loglama yapiyor
			//ekstra parametre ile true false gonderilirek loglama yapilmayabilir
			//ama bazı durumlarda her sekilde loglama yapilmasini isteriz 
			Kategori kategori2=new Kategori(1,"Frontend");			
			kategoriM.add(kategori2);
			kategoriM.add(kategori);
			
	}

}
