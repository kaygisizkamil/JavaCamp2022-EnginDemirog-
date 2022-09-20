package CustomExc;

public class YetersizBakiye extends Exception {
	String message;
	
  public YetersizBakiye(String message) {
	  this.message=message;
  }
  @Override
  public String getMessage() {
	  return this.message;
  }
}
