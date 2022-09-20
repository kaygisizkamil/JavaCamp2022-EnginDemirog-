package CustomExc;

public class Bakiye {
	public int bakiye;
		public void deposit(int bakiye) {
			this.bakiye+=bakiye;
		}
		public void withdraw(int bakiye) throws YetersizBakiye {
			if(this.bakiye>=bakiye) {
				this.bakiye=getBakiye()-bakiye;
			}
			else {
				throw new YetersizBakiye("yetersiz bakiye");
			}
		}
		public int getBakiye() {
			return bakiye;
		}
		public void setBakiye(int sayi) {
			bakiye=sayi;
		}
}

