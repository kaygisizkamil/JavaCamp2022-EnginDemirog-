package interfacePolymorphism;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManageDatabase mdb=new ManageDatabase(new Oracle());
		mdb.add();
		ManageDatabase mdb2=new ManageDatabase(new MySql());
		mdb2.add();
	}

}
