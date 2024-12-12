package a6;

import java.util.Arrays;

/**
 * An array-based implementation of the {@code Stack} interface
 * having no upper-limit on the number of elements in the stack.
 *
 */
public class ArrayStack extends AbstractArrayStack implements Stack {

	
	
	/**
     * Initializes an empty stack.
     */
	public ArrayStack() {
		super();
	}
	
	/**
	 * Initializes this stack by copying another array-based
	 * stack. After copying, this stack will have the same
	 * size, sequence of elements, and capacity as the copied
	 * stack. 
	 * 
	 * @param other the stack to copy
	 */
	public ArrayStack(AbstractArrayStack other) {
	    super(other);
	}
	
	
	@Override
	public boolean push(String elem) {
	    // do we need to resize the array?
	    if (this.size() == this.arr.length) {
	        this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
	    }
	    // call AbstractArrayStack.push to push the element
	    return super.push(elem);
	}
    
	 public static void main(String[] args) {
		    ArrayStack stack = new ArrayStack();
		    
		    System.out.println("Initial Stack: " + stack);
		    
		    stack.push("A");
		    stack.push("D");
		    stack.push("R");
		    
		    System.out.println("Stack size: " + stack.size());
		    System.out.println("Stack elements: " + stack.toString());
		    
		    stack.pop();
		    
		    System.out.println("Stack after 1 pop: " + stack.toString());
		    
		    stack.pop();
		    stack.pop();
		    
		    ArrayStack stack2 = new ArrayStack();
		    
		    System.out.println("Are stacks equal? " + stack.equals(stack2));
		    
		    ArrayStack stack3 = new ArrayStack();
		    stack3.push("A");
		    System.out.println("Are stack and stack3 equal? " + stack.equals(stack3));
		    
		    System.out.println("HashCode for stack: " + stack.hashCode());
		    System.out.println("HashCode for stack3: " + stack3.hashCode());
		}
	
}