package lab5;
import org.junit.Assert;
import org.junit.Test;
/** 
 * ����, ����������� ��� ������ � ����������� �������
 * @author ����������� ��������� (3 ���� 3 ������)
*/
public class InjectorTest {

	@Test
	public void InjectorTest() throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		Injector inj = new Injector();
		SomeBean obj2 = new SomeBean();
		String expected = obj2.getClass().getName();
		String actual = inj.inject(obj2).getClass().getTypeName();
		Assert.assertEquals(expected, actual);
	}
}