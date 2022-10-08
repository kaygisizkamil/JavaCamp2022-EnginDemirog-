package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import core.logging.ILogger;
import dataLayer.IDatabaseDao;
import entities.Kategori;
import entities.Kurs;

public class KategoriManager {
	IDatabaseDao _kategoriDao;
	List<ILogger>_log;
	static List<Kategori>kategoriTmp;
		public KategoriManager(IDatabaseDao _kategoriDao,List<ILogger>_log) {
				this._kategoriDao=_kategoriDao;
				this._log=_log;
				kategoriTmp=new ArrayList<>();
			
		}
		public void add(Kategori kategori) {
		
			boolean isMatch =  kategoriTmp.stream().anyMatch(i-> i.getName() == kategori.getName());
			if(!isMatch) {
				_kategoriDao.Add(kategori);
				kategoriTmp.add(kategori);
			}
			else //duplicationun onune gecmek icin 
				System.out.println("Ayni isme ait kayitli egitmen database veya hibernate kayit yapilmadi");
			
			for(ILogger logger :_log) {
				logger.log(kategori);
			}
			
		}
}
