package MukemmelSayi;

import java.util.Scanner;

public class MukSayi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hocan�n yazd�g� kodu biraz daha degistirip girileen say�ya kadar olan mukemel say�lar� listeleyen bir program yazdim
		Scanner sc=new Scanner(System.in);
		int sayi=sc.nextInt();
		int carpanToplami=0;
		for(int i=2;i<sayi;i++) {
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					carpanToplami+=j;
				}
			}
			if(carpanToplami==i) {
				System.out.println("Mukemmel bir sayi" +i);
			}
			carpanToplami=0;
			
		}
		
	}

}
