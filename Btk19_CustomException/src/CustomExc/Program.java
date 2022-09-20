package CustomExc;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bakiye bakiye=new Bakiye();
		bakiye.setBakiye(25);
		try {
			bakiye.withdraw(50);
		}
		catch(YetersizBakiye exception){
			System.out.println(exception.getMessage());
		}
		finally {
			System.out.println("i will work anyway");
		}
		System.out.println();
	}

}
