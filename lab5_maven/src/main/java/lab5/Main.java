package lab5;
/** 
 * ����� ��� ������������ ������ ������ Injector
 * @author ����������� ��������� (3 ���� 3 ������)
*/
public class Main {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		SomeBean obj = new SomeBean();
		Injector inj = new Injector();
		inj.inject(obj);
		obj.foo();
	}
} 