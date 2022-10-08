package business;

import java.util.ArrayList;
import java.util.List;

import core.logging.ILogger;
import dataLayer.IDatabaseDao;
import entities.Egitmen;
import entities.Kurs;

public class EgitmenManager {
	IDatabaseDao _egitmenDao;
	List<ILogger>_log;
	static List<Egitmen>egitmenlerTmp=null;
		public EgitmenManager(IDatabaseDao _egitmenDao,List<ILogger>_log) {
				this._egitmenDao=_egitmenDao;
				this._log=_log;
				egitmenlerTmp=new ArrayList<>();
			
		}
		public void add(Egitmen egitmen) throws Exception {
			
			boolean isMatch = egitmenlerTmp.stream().anyMatch(i-> i.name == egitmen.name);
			if(!isMatch) {
				_egitmenDao.Add(egitmen);
				egitmenlerTmp.add(egitmen);
			}
			else //duplicationun onune gecmek icin 
				System.out.println("Ayni isme ait kayitli egitmen database veya hibernate kayit yapilmadi");

		//	_egitmenDao.Add(egitmen);
			for(ILogger logger :_log) {
				logger.log(egitmen);
			}
			
		}

}
