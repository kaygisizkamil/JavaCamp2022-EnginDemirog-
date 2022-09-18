package interfacePolymorphism;

public class Oracle implements IDatabase {
		/*public int add() {
			System.out.println("Oracle ekle");
			return 5;
			return type lar aynýysa bu sekilde bir override izin verilmez
		}*/

		@Override
		public void add() {
			// TODO Auto-generated method stub
			System.out.println("Oracle eklendi");
			
		}
}
