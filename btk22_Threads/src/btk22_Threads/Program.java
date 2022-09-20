package btk22_Threads;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	KronometreThread t1=new KronometreThread("thread1");
	KronometreThread t2=new KronometreThread("thread2");
	KronometreThread t3=new KronometreThread("thread3");
	t1.basla();
	t2.basla();
	t3.basla();

	}

}
