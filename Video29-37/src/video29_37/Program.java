package video29_37;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LikeInterface notInterface=new LikeInterface();
		notInterface.Hesapla(new AskerKredi(5,55,"ziraat"));
		//ustteki satirrda dikkat edilmesi gereken sey baseClassin hesapla methodu cagirildi ondan inherit edilenin degil
		//notInterface.Hesapla(new TarimKredi());
	}

}
