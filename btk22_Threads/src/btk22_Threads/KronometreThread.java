package btk22_Threads;

public class KronometreThread implements Runnable {

	private Thread thread;
	private String threadName;
	public KronometreThread(String threadName) {
		this.threadName=threadName;
		System.out.println("Olusturuluyor"+threadName);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Olusturuluyor" +threadName);
		try {
			for(int i=0;i<100;i++) {
				System.out.println(threadName +" " +i);
				Thread.sleep(250);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Thread kesildi " +threadName);
		}
		System.out.println("Thread bitti");
		
	}
	public void basla() {	
		if(thread==null) {
			thread=new Thread(this,threadName);
		}
		thread.start();
		System.out.println("Thread basladi"+threadName);
	}

}
