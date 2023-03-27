package datastr;

public class MyGraph<T> {
	private MyVerticeNode[] graphElements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;

	// no-args kontruktors
	public MyGraph() {
		graphElements = new MyVerticeNode[arraySize];
	}

	// args konstruktors
	public MyGraph(int inputArraySize) {
		if (inputArraySize > 0) {
			arraySize = inputArraySize;
		}

		graphElements = new MyVerticeNode[arraySize];
	}
	
	//TODO isFull, isEmpty, howManyElements and increaseArray
	public boolean isEmpty() {
		return (elementCounter == 0);
	}

	public boolean isFull() {
		return (elementCounter == arraySize);
	}

	public int howManyElements() {
		return elementCounter;
	}

	// 1. create a definition of function increaseArray
	private void increaseArray() {
		// 2. calculate the new size of the new array
		int newArraySize = (arraySize > 100) ? (int) (arraySize * 1.5) : arraySize * 2;

		// 3. create the new array
		MyVerticeNode[] newElements =  new MyVerticeNode[newArraySize];
		// 4. copy all elements from the old array to the new array
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = graphElements[i];
		}
		// 5. change reference to the new array and it's size
		graphElements = newElements;
		arraySize = newArraySize;
	}
	
	
	
	

}
