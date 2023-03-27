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

}
