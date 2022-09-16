package video19;

import java.util.Scanner;

public class AsalMi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Sayi asal mi hesaplayacagýz sayi giriniz: ");
		int sayi=sc.nextInt();
		boolean asalMi=true;
		if(sayi<=1)asalMi=false;
		
		for(int i=2;i<sayi;i++) {
			if(sayi==2 ) {
				asalMi=true;
			}
			if(sayi%i==0) {
				asalMi=false;
			}
		}
		if(asalMi)
			System.out.println("Asal");
		else
			System.out.println("Asal degil");
		
		System.out.println("Simdi de faktoriyel hesaplayalim");
		sayi=sc.nextInt();
		int faktoriyel=1;
		for(int i=sayi;i>=1;i--) {
		    faktoriyel*=i;
		}
		System.out.println(faktoriyel);

		}while(true);
	}

}
