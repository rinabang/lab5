package lab5;
import org.junit.Assert;
import org.junit.Test;
/** 
 * Тест, проверяющий тип метода и переданного объекта
 * @author Суховеркова Екатерина (3 курс 3 группа)
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
