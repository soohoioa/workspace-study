package generic;

public class MyArrayList <E> { 
	// 클래스옆에 인자를받을수있다 -> 식별자 선언해줄수있다.외부로부터 받아옴.타입따로없음 < > 를사용
	// 제네릭(Generic)이란 "타입을 일반화"하는 것
	// 제네릭(Generic)은 클래스 내부에서 정하는 것이 아닌 사용자 호출에 의해 타입이 지정되는 것
	// 즉, 특정 타입의 변수형에 지정되는 것이 아닌 필요에 의해 여러 가지를 타입(Integer, String 등)을 사용하고 싶을 경우 사용
	// 제네릭 타입은 파라미터가 아닌 클래스 및 인터페이스
	private Object[] elementData;
	private int size;
	
	 
	public MyArrayList() {
		elementData = new Object[0];
		size = elementData.length;
	}
	
	public int size() {
		return size;
	}
	
	public void add(E element) {
		Object[] tempElementData = new Object[elementData.length+1]; // 한개만 증가
		for(int i = 0; i < elementData.length; i++) {
			tempElementData[i] = elementData[i];
		}
		tempElementData[tempElementData.length -1] = element;
		this.elementData = tempElementData;
		this.size = elementData.length;
	}
	
	public E get(int index) {
		return (E)this.elementData[index];
	}
	/*
	제네릭(Generic) : 일반적인
	데이터 형식에 의존하지 않고, 
	하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록 하는 방법
	 */
	
}
