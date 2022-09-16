package odev2;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.String;


public class Program {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		String coolStart="JAVA KAMPI BAÞLIYOR";
		// foreach ile iterate etmek icin kullanilav-bilir char c :chars <- char [] chars=coolStart.toCharArray();
		
		for(int i=0;i<=coolStart.length();i++) {
			if(i==coolStart.length()) {
				System.out.println("\nHerkese baþarýlar");
				break;
			}
			else {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.print(coolStart.charAt(i));
			}
		}
		char c;
		 do{			
			System.out.println("Lütfen menüden seçim yapýn -(Cikis icin C yi tuslayin)");
			System.out.println("1)En büyük sayýyý bul");
			System.out.println("2)String uzerinde islemler yapýn");
			System.out.println("3)Üniversitedeki dersinizin geçme kalma durumunu hesaplayýn");
			c = sc.next().trim().charAt(0);
			switch(c){
			case '1':
					int []a=new int[3];
					System.out.println("Lütfen hesaplamak istediginiz 3 sayiyi giriniz ");
					 for(int i=0;i<3;i++) {
						a[i]=sc.nextInt(); 
						sc.nextLine();
					 }
					 if(a[0]>=a[1] && a[1]>=a[2]) 
						 System.out.println("En buyuk sayi "+ a[0]);
					 else if(a[1]>=a[0] && a[0]>=a[2])
						 System.out.println("En buyuk sayi "+ a[1]);
					 else if(a[2]>=a[1] && a[1]>=a[0])
						 System.out.println("En buyuk sayi "+ a[2]);
					 //else gerek yok>= kullanýldýgý icin baska ihtimal yok
					
				break;
			case '2':				
				   String tmp=""; 
				 
				   System.out.println("1)Cumlenin harflerini buyut\n2)Sonuna kelime ekle\n3)Bosluklari sil");
				   int control=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Duzenlenecek kelime-cumleyi giriniz ");	
				  
					  tmp=sc.nextLine();
				   //stringler immutable oldugu icin good practice için kopyasý uzerinde calismaliyiz concat kullanýrsak ekleme yapmaz vs
				   String output;
				   if(control==1) {
					   output=tmp.substring(0, tmp.length()).toUpperCase();
					   System.out.println(output);
				   }
				   else if(control==2) {
					   System.out.println("Eklenecek kelimeyi girin");
					   String tmp2=sc.nextLine();
					   output=tmp.concat(tmp2);
					   System.out.println(output);					   
				   }
				   else if(control==3) {
					   output=tmp.replaceAll("\\s","");//  \\s tek boslugu ifade eder butun bosluklarý "" ile degistirerek bosluk silinir
					   System.out.println(output);
				   }
				break;
			case '3':
				System.out.println("Katalog üzerinden harf notu hesaplanacaktir");System.out.println("Vize notunuzu girin: ");
				double vizeP=sc.nextDouble(); 
				System.out.println("Final notunuzu girin: "); double finalP=sc.nextDouble(); sc.nextLine();//clear theinput buff
				double ortalama=vizeP*35/100+finalP*65/100;
				String ort;
					if(ortalama<65) {
						ort="cc";
						System.out.println("Kaldiniz g.o ortalamaniz: " +ortalama);
					}
					else {
						System.out.println("Gectiniz tebrikler ortalama: "+ortalama);
					}
					
				
		     	break;
			case 'c':System.out.println("Tekrar bekleriz");
			    break;
		     default :System.out.println("Geçersiz seçim yaptýnýz tekrar deneyin");
		        break;
		  	}
		}while( c!='c' &&  c!='C');
		
		
	
		
		
		// TODO Auto-generated method stub
		
	}

}
