package polymorphism;

public class DatabaseAdministrator extends VeriTabani{
	private  VeriTabani veriTabani;
	 public DatabaseAdministrator(VeriTabani taban) {
		this.veriTabani=taban;//newleyerek kullan�rsak ayn� nesneyi degil yeni bir objectini kullanm�s olacagiz bu kullan�m daha mant�kl�
	 }
	 public void Add() {
		 System.out.println("VeriTabani degistirmesi basariyla tamamlandi child classtan gelecek mesaj altta");
		 this.veriTabani.Yazdir();
		 
	 }
	 
	 
}
