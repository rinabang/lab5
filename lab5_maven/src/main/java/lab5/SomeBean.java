package lab5;
/** ��������� doSomething() */
interface SomeInterface{ public void doSomething(); }
/** ��������� doSomeOther() */
interface SomeOtherInterface{ public void doSomeOther(); }
/** ����� ����������� {@link SomeInterface#doSomething} ��� ������ "A" */
class SomeImpl implements SomeInterface{
	public void doSomething(){ System.out.println("A"); }
}
/** ����� ����������� {@link SomeInterface#doSomething} ��� ������ "B" */
class OtherImpl implements SomeInterface{
	public void doSomething(){ System.out.println("B"); }
}
/** ����� ����������� {@link SomeOtherInterface#doSomeOther} ��� ������ "C" */
class SODoer implements SomeOtherInterface{
	public void doSomeOther(){ System.out.println("C"); }
}
/** 
 * ����� � AutoInjectable ������
 * @author ����������� ��������� (3 ���� 3 ������)
*/
class SomeBean{
	@AutoInjectable
	private SomeInterface field1;
	@AutoInjectable
	private SomeOtherInterface field2;
	public SomeInterface field3 = new SomeImpl();
	/**
     * ����� ������ ������� �����
     */
	public void foo(){
		field1.doSomething();
		field2.doSomeOther();
		field3.doSomething();
	}
}