package kalinInceHarf;

import java.util.Scanner;

public class harfIncemi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Lütfen ünlü harf giriniz");
		//kullanýcýnýn dogru formatta yani unlu harf girdigi varsayilcacak
		char c=sc.next().toUpperCase().charAt(0);
		
		switch(c) {
			case 'A':
			case 'I':
			case 'O':
			case 'U':
				System.out.println("Kalýn ünlü");
			  break;
			  default:
				 System.out.println("Ýnce ünlü");
				 break;
			  
		}
	}

}
