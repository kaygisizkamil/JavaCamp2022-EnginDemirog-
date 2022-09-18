package video29_37;

public class BaseKredi {
	public void Hesapla() {
		System.out.println("Hesaplandi");
		System.out.println(krediMiktari+" "+faizOrani+" "+ bankaIsmi);//$NON-NLS-1$
	}
	private int krediMiktari;
	private double faizOrani;
	private String bankaIsmi;
	/*public int getKrediMiktari() {
		return krediMiktari;
	}
	public void setKrediMiktari(int krediMiktari) {
		this.krediMiktari = krediMiktari;
	}
	public String getFaizOrani() {
		return faizOrani;
	}
	public void setFaizOrani(String faizOrani) {
		this.faizOrani = faizOrani;
	}
	public int getBanka›smi() {
		return banka›smi;
	}
	public void setBanka›smi(int banka›smi) {
		this.banka›smi = banka›smi;
	}*/
	public BaseKredi(int krediMiktari,int faizOrani,String bankaIsmi) {
		this.krediMiktari=krediMiktari;
		this.faizOrani=faizOrani;
		this.bankaIsmi=bankaIsmi;
	}
	public BaseKredi() {
		//for TarimKredi explicit constructorinvoke
		
	}

}
