package business;

import java.util.List;

import core.logging.ILogger;
import dataLayer.IDatabaseDao;
import entities.Kurs;

public class KursManager {
	IDatabaseDao _kursDao;
	static List<ILogger>_log;
		public KursManager(IDatabaseDao _kursDao,List<ILogger>_log) {
				this._kursDao=_kursDao;
				this._log=_log;
			
		}
		public void add(Kurs kurs) throws Exception {
			if(kurs.getFiyat()<=0) {
				throw new Exception("Kurs fiyati kucuk olamaz");
			}
			_kursDao.Add(kurs);
			for(ILogger logger :_log) {
				logger.log(kurs);
			}
			
		}
}
