package static_Methods;

public class ProductManaging {

	//ValidateProduct vp=new ValidateProduct();
	//validateProduct methodu static olmasayd� ustteki gibi bir kullan�m gerekirdi
	//her yeni eklemeden yeni object olusturmak gereksiz memory isgaline sebep olur
	public void add(Product pro) {
		if(ValidateProduct.validateProduct(pro)) {
			System.out.println("Urun basariyla eklendi");
		}
		else System.out.println("Something went wrong");
	}
}
