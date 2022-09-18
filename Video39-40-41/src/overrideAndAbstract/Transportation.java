package overrideAndAbstract;

public abstract class Transportation {
   abstract void transportStrategy();
   protected final void arrived() {
	   System.out.println("Urun tasimasi basariyla gereceklestirildi");
   }

}
