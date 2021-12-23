package lab5;
/** Интерфейс doSomething() */
interface SomeInterface{ public void doSomething(); }
/** Интерфейс doSomeOther() */
interface SomeOtherInterface{ public void doSomeOther(); }
/** Класс реализующий {@link SomeInterface#doSomething} как печать "A" */
class SomeImpl implements SomeInterface{
	public void doSomething(){ System.out.println("A"); }
}
/** Класс реализующий {@link SomeInterface#doSomething} как печать "B" */
class OtherImpl implements SomeInterface{
	public void doSomething(){ System.out.println("B"); }
}
/** Класс реализующий {@link SomeOtherInterface#doSomeOther} как печать "C" */
class SODoer implements SomeOtherInterface{
	public void doSomeOther(){ System.out.println("C"); }
}
/** 
 * Класс с AutoInjectable полями
 * @author Суховеркова Екатерина (3 курс 3 группа)
*/
class SomeBean{
	@AutoInjectable
	private SomeInterface field1;
	@AutoInjectable
	private SomeOtherInterface field2;
	public SomeInterface field3 = new SomeImpl();
	/**
     * Метод вызова функций полей
     */
	public void foo(){
		field1.doSomething();
		field2.doSomeOther();
		field3.doSomething();
	}
}
