import java.util.Scanner;

public class DiziIslemleri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] myArr=new int[7];
		Scanner sc=new Scanner(System.in);
		System.out.println("Lütfen islem yapilacak arrayi giriniz");
		for(int i=0;i<myArr.length;i++) {
			myArr[i]=sc.nextInt();
		}
		System.out.println("Yapmak istediginiz islemi seciniz\n2)En cok ve en az tekrar eden elemani bulma\n"
				+"3)Dizideki elemanlarin toplamini bulma\n 3)Diziyi buyukten kucuge siralama: ");
		int secim=sc.nextInt();
		//fonksiyon kullanarak cok daha rahat olarak en cok tekrar eden elementi bulabiliriz ama derslerde
		//henuz methodlar islenmedigi icin bu sekilde yapiyorum
		//iki boyutlu dizide tutmak daha verimli olabilirdi her dizinin tekrar sayisini diger bir dizide tutarakcozume ulasiyorum
		int []elemanTekrarSayisi=new int[7];
		if(secim==1) {
			for(int i=0;i<myArr.length;i++) {
				for(int j=0;j<myArr.length;j++) {
					if(myArr[j]==myArr[i]) {
						elemanTekrarSayisi[i]+=1;
					}
				}
			}
			int tmp=0,max;
			max=elemanTekrarSayisi[0];
			  for(int j=0;j<myArr.length;j++) {
				  if(max<elemanTekrarSayisi[j]) {
					  //tmp=elemanTekrarSayisi[j];
					  max=elemanTekrarSayisi[j];
					  tmp=j;
				  }
			  }
			  System.out.println("En cok tekrar eden eleman " +tmp+". eleman " +myArr[tmp]+" tekrar sayisi "+max);
			
		}
		else if(secim==2) {
			int toplam=0;
			for(int a : myArr) {
				toplam+=a;
			}
			System.out.println("Toplam ="+toplam);
		}
		else if(secim==3) {
			//bubble sort algo kullandým daha verimli algoritmalar da var ama method kullanmadan kodu cok karmasiklastirabilir.
			//bubble sortun nasýl calýstýgýna wikipediadan goz atabilirsiniz
			int tmp;
			for(int i=0;i<myArr.length;i++) {
				for(int j=0;j<myArr.length-i-1;j++) {
					if(myArr[j+1]>myArr[j]) {
						tmp=myArr[j];
						myArr[j]=myArr[j+1];
						myArr[j+1]=tmp;
						//ustteki isleme swapping-yer degistirme denir sonraki eleman oncekinden buyukse yer degistiriyorum
					}
				}
			}
			for(int k:myArr) {
				System.out.print(k+" ");
			}
		}
	}

}
