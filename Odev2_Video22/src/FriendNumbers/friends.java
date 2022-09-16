package FriendNumbers;

import java.util.Scanner;

public class friends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Lütfen 1. ve 2. sayilari giriniz");
		num1=sc.nextInt();
		num2=sc.nextInt();
		int tmp;
				if(num1>=num2)
					tmp=num1;
				else tmp=num2;
		double num1Bolen=0,num2Bolen=0;
		for(int i=1;i<=tmp;i++) {
			if(i<=num1) {
				if(num1%i==0)
					num1Bolen+=i;
			}
			if(i<=num2) {
				if(num2%i==0)
					num2Bolen+=i;
			}
		}
		num1Bolen=num1Bolen/num1;
		num2Bolen=num2Bolen/num2;
		
		System.out.println(num1Bolen);
		System.out.println(num2Bolen);
		if(Math.abs(num2Bolen-num1Bolen)<=0.0004) {
			System.out.println("Arkadas sayilar"+num1+" , "+num2);
		}
		else System.out.println("Arkadas degiller ");

	}

}
