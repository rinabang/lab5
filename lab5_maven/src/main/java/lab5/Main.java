package lab5;
/** 
 * Класс для демонстрации работы класса Injector
 * @author Суховеркова Екатерина (3 курс 3 группа)
*/
public class Main {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		SomeBean obj = new SomeBean();
		Injector inj = new Injector();
		inj.inject(obj);
		obj.foo();
	}
} 