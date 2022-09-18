package overrideAndAbstract;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransportOrganizator admin=new TransportOrganizator();
        admin.tp=new CarryUsingPlane();
        if(admin.tp!=null) {//bu sekilde bir kontrol mantikli olabilir gerekli mi emin degilim
        	admin.getTasima();
        }
        admin.tp=new CarryUsingShip();//admin icinde getClass methoduyla detaylo bilgi edinebiliriz CarryUsingPlane'in override ettigini kanýtlar
        admin.getTasima();
	}

}
