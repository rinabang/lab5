package lab5;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;
/** 
 * ����� ��� ������ AutoInjectable ����� � ����� ������
 * @author ����������� ��������� (3 ���� 3 ������)
*/
public class Injector {
	/** ���� � ���� � ����� properties */
	public static final String path = "SomeBean.properties";
	/**
     * ����� ������ AutoInjectable �����
     * @param obj - ������ ������ ������
     * @return ���������� ������ ����� �� ������ � ������������������� ������
     */
	@SuppressWarnings("deprecation")
	public <T> T inject(T obj) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			Annotation a = f.getAnnotation(AutoInjectable.class);
			f.setAccessible(true);
			if (a != null){
				Properties prop = new Properties();
				try {
					FileInputStream fileInputStream = new FileInputStream(path);
		            prop.load(fileInputStream);
					String className = prop.getProperty(f.getType().toString().replace("interface ", ""));
					f.set(obj, Class.forName(className).newInstance());
		        } catch (IOException e) {
		            System.out.println("������ �������� �����: " + path);
		            e.printStackTrace();
		        }
			}
		}
		return obj;
	}
}