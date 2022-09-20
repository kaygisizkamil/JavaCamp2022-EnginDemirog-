package btk21_Generics;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validator validator=new Validator();
		Customer customer =new Customer();
		
		validator.validate(customer);
		validator.validate(new Product());
		//bu sekilde hangi tipten urun validate edildigini gorebiliriz

	}

}
