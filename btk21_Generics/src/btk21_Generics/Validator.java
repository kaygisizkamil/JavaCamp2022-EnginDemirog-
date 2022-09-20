package btk21_Generics;

public class Validator {
	public <T extends IEntity> void validate(T entity) {
		System.out.println(entity.getClass().getSimpleName());
	}

}
