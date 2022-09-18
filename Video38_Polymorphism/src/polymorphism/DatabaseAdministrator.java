package polymorphism;

public class DatabaseAdministrator extends VeriTabani{
	private  VeriTabani veriTabani;
	 public DatabaseAdministrator(VeriTabani taban) {
		this.veriTabani=taban;//newleyerek kullanýrsak ayný nesneyi degil yeni bir objectini kullanmýs olacagiz bu kullaným daha mantýklý
	 }
	 public void Add() {
		 System.out.println("VeriTabani degistirmesi basariyla tamamlandi child classtan gelecek mesaj altta");
		 this.veriTabani.Yazdir();
		 
	 }
	 
	 
}
