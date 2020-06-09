import java.util.*;
public class ArrayListStack<T> implements StackInterface<T>{
	protected ArrayList<T> elements;
	
	public ArrayListStack(){
		elements = new ArrayList<T>();
	}
	public void push(T element){
		elements.add(element);
	}
	public void pop() {
		if(!isEmpty()){
			elements.remove(elements.size()-1);
		}
	
	}
	public T top(){
		T topOfStack = null;
		if(!isEmpty()){topOfStack = elements.get(elements.size()-1);}
		return topOfStack;
	}
	public boolean isEmpty(){
		return(elements.size()==0);
	}
	public boolean isFull(){
		return false;
	}
}
