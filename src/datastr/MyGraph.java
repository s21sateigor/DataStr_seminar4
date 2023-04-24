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
	
	//addVertice
	public void addVertice(T inputElement) throws Exception {
		if(inputElement == null) {
			throw (new Exception("It is not real vertice!"));
		}
		
		//verify if vertice is not already in graph
		/*for(int i = 0; i < elementCounter; i++) {
			if(graphElements[i].getElement().equals(inputElement)) {
				throw (new Exception("Vertice is already in graph"));
			}
		}*/
		
		if(searchVertice(inputElement) > -1) {
			throw (new Exception("Vertice is already in graph"));
		}
		
		
		if(isFull()) {
			increaseArray();
		}
		
		MyVerticeNode newVertice = new MyVerticeNode(inputElement);
		graphElements[elementCounter] = newVertice;
		elementCounter++;
		
		//optimisation
		//graphElements[elementCounter++] = new MyVerticeNode(inputElement);
		
	
	}
		
	//addEdge
	public void addEdge(T elementFrom, T elementTo, float edgeWeigth) throws Exception {
		
		if(elementFrom==null || elementTo == null || edgeWeigth <= 0) {
			throw (new Exception("Incorect arguments"));
		}
		
		int indexOfElementFrom = searchVertice(elementFrom);
		int indexOfElementTo = searchVertice(elementTo);
		
		//TODO add vertice if it is not found in graph
		if(indexOfElementFrom < 0 || indexOfElementTo < 0) {
			throw (new Exception("One or both vertices are not in graph"));
		}
		
		MyEdgeNode newNode = new MyEdgeNode(indexOfElementTo, edgeWeigth);
		//if it is as first edge
		if(graphElements[indexOfElementFrom].getFirstEdge()==null) {
			graphElements[indexOfElementFrom].setFirstEdge(newNode);
		}
		else
		{
			MyEdgeNode temp = graphElements[indexOfElementFrom].getFirstEdge();
			
			while(temp.getNext()!=null) {
				temp = temp.getNext();
			}
			
			temp.setNext(newNode);
			 
		}
		
		
		
	}
	
	private int searchVertice(T inputElement) {
		
		for(int i = 0; i < elementCounter ;i++) {
			if(graphElements[i].getElement().equals(inputElement)) {
				//return index of element
				return i;
			}
		}
		
		return -1;
	}
	


	public void print() throws Exception {
		//TODO 1. verification if it is isEmpty;
		if(isEmpty()){
			throw (new Exception("Graph is empty and not possible to print it!"));
		}
		//TODO 2. for loop for vertices and print each vertice;

		for(int i = 0; i < elementCounter; i++){
			System.out.print(graphElements[i].getElement() + " --> ");

			//TODO 2.1. while loop for edges and print each edge of tje specific vertice

			MyEdgeNode tempEdgeNode = graphElements[i].getFirstEdge();
			while(tempEdgeNode != null){
				T verticeTo = (T) graphElements[tempEdgeNode.getIndexOfVertice()].getElement();
				System.out.println(verticeTo + "( " + tempEdgeNode.getWeigth() + " km);");
				tempEdgeNode = tempEdgeNode.getNext();
			}
			System.out.println();
		}
	}

	public void makeEmpty() {
		elementCounter = 0;
		arraySize = DEFAULT_ARRAY_SIZE;
		graphElements = new MyVerticeNode[arraySize];
		System.gc();
	}
	
	
	//print
	//makeEmpty
	
	
	//TODO
	//removeVertice
	//removeEdge
	//changeEdge
	
	
	

}
