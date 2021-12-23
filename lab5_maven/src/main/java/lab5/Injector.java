package lab5;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;
/** 
 * Класс для поиска AutoInjectable полей в любом классе
 * @author Суховеркова Екатерина (3 курс 3 группа)
*/
public class Injector {
	/** Поле с путём к файлу properties */
	public static final String path = "SomeBean.properties";
	/**
     * Метод поиска AutoInjectable полей
     * @param obj - объект любого класса
     * @return возвращает объект этого же класса с инициализированными полями
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
		            System.out.println("Ошибка открытия файла: " + path);
		            e.printStackTrace();
		        }
			}
		}
		return obj;
	}
}
