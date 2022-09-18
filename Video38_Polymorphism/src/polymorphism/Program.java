package polymorphism;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseAdministrator dbAdmin=new DatabaseAdministrator(new MangoDb());
		dbAdmin.Add();
		
		VeriTabani veriTabani=new Oracle();
		//casting ile base'de olmayan feature'i kullanabiliriz
		((Oracle) veriTabani).Ekstra();//??
		
		/*alttaki ifade compile time'da hata vermezken runtime'da hata verir
		VeriTabani db=new VeriTabani();
		Oracle oracle=new Oracle();
		oracle=(Oracle)db;*/
		/*
		 * child'i parenta atasaniz bile exclusive methodlarina erismek icin casting kullanmalisiniz
		 
		VeriTabani db=new VeriTabani();
		Oracle oracle=new Oracle();
		db=oracle;
		((Oracle) db).Ekstra();*/
		DatabaseAdministrator[] db={new DatabaseAdministrator(new MangoDb()),new DatabaseAdministrator(new Oracle())};
		for(DatabaseAdministrator tmp: db) {
			//tmp.Yazdir(); base classdaki yazdir methodu cagrilir neden ??
			tmp.Add();
		}
		
		
		
		
		

	}

}
