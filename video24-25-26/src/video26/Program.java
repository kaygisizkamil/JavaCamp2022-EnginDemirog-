package video26;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[]=new String [] {"Ankara","Adana","Antalya","Afyon"};
		print(arr);
		//randStrAdd(arr);
		//isEquall(arr);
		//String kelime="merhaba" seklinde atama yaparak tekrar deneyip farký görebilirsiniz
		String kelime=new String("merhaba");
		deneme(kelime);
	
	}	
	public static void print(String... kelimeler) {
		for(String tmp:kelimeler) {
			System.out.print(tmp+" ");
		}
		System.out.println("\n\n");
	}
	public static void randStrAdd(String kelime[]) {
		String tmp="merhaba";
		for(int i=0;i<kelime.length;i++) {
			kelime[i]=tmp;
			System.out.println(kelime[i]);
		}

	}
	public static void deneme(String kelime) {
		//equals icerigi == ayný zamand adresi de kontrol eder
		String tmp=kelime;
		if(tmp==kelime) {
			System.out.println("esit");
		}
		else System.out.println("esit degil");
		if(tmp.equals(kelime)) {
			System.out.println("esit");
		}
		else System.out.println("esit degil");
		tmp="merhaba";
		System.out.println("Ayni atamayi yaptiktan sonra");
		if(tmp==kelime) {
			System.out.println("esit == tmp codu" +tmp.hashCode()+" parametreden gelen stringin hashcodu" +kelime.hashCode());
		}
		//burada esit degile girmesinin sebebi icerik ayni bile olsa string immutable oldugu icin degistirme sonunda yeni bir string olusturuldu
		else System.out.println("esit != degil  tmp codu" +tmp.hashCode()+" parametreden gelen stringin hashcodu" +kelime.hashCode());
		if(tmp.equals(kelime)) {
			System.out.println("esit(.equals) tmp codu" +tmp.hashCode()+" parametreden gelen stringin hashcodu" +kelime.hashCode());
		}
		else System.out.println("esit(.equals) degil tmp codu" +tmp.hashCode()+" parametreden gelen stringin hashcodu" +kelime.hashCode());
	}
	public static void isEquall(String kelime[]) {
		String[] tmp=new String [] {"Ankara","Adana","Antalya","Afyon"};
		/* compare them as an object. arraylerde bunu kullanmak dogru degil*/
		if(Arrays.equals(kelime,tmp)) {
			System.out.println("Esit1");
		}
		else System.out.println("Esit degil1");
		String[] tmp2=kelime;
		if(Arrays.deepEquals(kelime,tmp2)) {
			System.out.println("Esit");
		}
		else System.out.println("Esit degil");
		tmp2[0]="Ankara";
		tmp2[1]="Adana";
		tmp2[2]="Antalya";
		tmp2[3]="Afyon";
		if(Arrays.deepEquals(kelime,tmp2)) {
			System.out.println("Esit");
		}
		else System.out.println("Esit degil");
		
	}
}
	
