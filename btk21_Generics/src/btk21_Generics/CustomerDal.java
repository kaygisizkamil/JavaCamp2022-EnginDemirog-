package btk21_Generics;
/*
public class CustomerDal implements IEntityRepository {

	@Override
	public void add(Object Entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object Entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object Entity) {
		// TODO Auto-generated method stub
		
	}
	
Hangi nesne icin implement edecegimizi eklemeyi unutursak ustteki gibir bir implementation ortaya cýkar parametreleri obje olur bu istemedigimiz
birseydir
}*/
public class CustomerDal implements IEntityRepository<Customer>{

	@Override
	public void add(Customer Entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer Entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer Entity) {
		// TODO Auto-generated method stub
		
	}
	
}