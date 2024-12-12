package a6;

/**
 * An array-based implementation of the {@code Stack} interface having an
 * upper-limit on the number of elements in the stack. The capacity of the stack
 * is established when the stack is created and cannot be changed afterwards.
 * 
 * <p>
 * Attempting to push elements onto a full stack leaves the stack unchanged and
 * results in the {@code push} method returning {@code false}.
 */

public class SmallArrayStack extends AbstractArrayStack implements Stack {

	/**
	 * Initializes this stack to have a fixed-capacity equal to
	 * the specified non-negative capacity.
	 * 
	 * @param capacity the capacity of this stack
	 * @throws IllegalArgumentException if {@code capacity < 1}
	 */
	public SmallArrayStack(int capacity) {
	    super();
	    if (capacity < 0) {
	        throw new IllegalArgumentException();
	    }
	    // to be completed by the student
	    
	    this.arr = new String[capacity];
	}
	
	/**
     * Initializes this stack by copying another array-based
     * stack. After copying, this stack will have the same
     * size, sequence of elements, and capacity as the copied
     * stack. 
     * 
     * @param other the stack to copy
     */
    public SmallArrayStack(AbstractArrayStack other) {
    	super(other);
    }
    
    /**
     * Returns the capacity of this stack.
     * 
     * @return the capacity of this stack
     */
    public int capacity() {
    	return this.arr.length;
    }
    
    public static void main(String[] args) {
	    SmallArrayStack stack = new SmallArrayStack(5);
	    
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
	    
	    SmallArrayStack stack2 = new SmallArrayStack(2);
	    
	    System.out.println("Are stacks equal? " + stack.equals(stack2));
	    
	    SmallArrayStack stack3 = new SmallArrayStack(5);
	    stack3.push("A");
	    System.out.println("Are stack and stack3 equal? " + stack.equals(stack3));
	    
	    System.out.println("HashCode for stack: " + stack.hashCode());
	    System.out.println("HashCode for stack3: " + stack3.hashCode());
	}
 
}