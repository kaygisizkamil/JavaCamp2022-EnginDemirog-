package overrideAndAbstract;

public class TransportOrganizator {
            Transportation tp;
            public void getTasima() {
            	System.out.println(tp.getClass());
            	tp.transportStrategy();;
            }

}
