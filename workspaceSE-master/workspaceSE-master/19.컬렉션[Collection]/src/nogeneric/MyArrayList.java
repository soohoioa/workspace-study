package nogeneric;

public class MyArrayList {
	private Object[] elementData;
	private int size;
	
	 
	public MyArrayList() {
		elementData = new Object[0];
		size = elementData.length;
	}
	
	public int size() {
		return size;
	}
	
	public void add(Object element) {
		Object[] tempElementData = new Object[elementData.length+1]; // 한개만 증가
		for(int i = 0; i < elementData.length; i++) {
			tempElementData[i] = elementData[i];
		}
		tempElementData[tempElementData.length -1] = element;
		this.elementData = tempElementData;
		this.size = elementData.length;
	}
	
	public Object get(int index) {
		return elementData[index];
	}
	
	
}
