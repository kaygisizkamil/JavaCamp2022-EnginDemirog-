package static_Methods;

public class ValidateProduct {
	public ValidateProduct() {
		/*unlike c sharp when using the static method without creating an object of the class
		 * ctr is not called so there will be no output
		 * and also java does not has static classes (at least before java 8 we learned in class
		 */
		System.out.println("Constructor cagirildi");
	}
	/*static{} bu block static degiskenlerin initializingi icin kullanilabilir*/
	
	
		public static boolean validateProduct(	Product product) {
			boolean valid;
			if(product.name.length()>=0 && product.price>0)
				valid=true;
			else 
				valid=false;
			return valid;
		}
	
}
