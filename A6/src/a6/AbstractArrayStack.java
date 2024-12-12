package a6;

import java.util.Arrays;

public abstract class AbstractArrayStack implements Stack {
	// the initial capacity of the stack
    protected static final int DEFAULT_CAPACITY = 16;
    
    // the index of the top element of the stack
	protected int top;
	
	// the array of elements
	protected String[] arr;
	
	/**
     * Initializes an empty stack.
     */
	public AbstractArrayStack() {
		this.top = -1;
		this.arr = new String[DEFAULT_CAPACITY];
	}
	
	/**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
	public int size() {
		return this.top + 1;
	}
	
	/**
	 * Initializes this stack by copying another array-based
	 * stack. After copying, this stack will have the same
	 * size, sequence of elements, and capacity as the copied
	 * stack. 
	 * 
	 * @param other the stack to copy
	 */
	protected AbstractArrayStack(AbstractArrayStack other) {
		this.top = other.top;
	
		this.arr = new String[other.arr.length];
		
		for(int i = 0; i <= this.top; i++) {
			this.arr[i] = other.arr[i];
		}
	}
	
	
	
	/**
     * Returns a string representation of this stack. The elements of the stack
     * appear in the returned string in sequence starting from the top of the
     * stack to the bottom of the stack with each element separated from the
     * next using a newline character.
     * 
     * @return a string representation of this stack
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("top: ");
        if (this.size() != 0) {
        	int i = this.size() - 1;
        	b.append(this.arr[i]);
            for (i = this.size() - 2; i >= 0; i--) {
                b.append(", ");
                b.append(this.arr[i]);
            }
        }
        b.append(" :bottom");
        return b.toString();
    }
    
    /**
     * Removes the element on the top of this stack and returns the element.
     * 
     * @return the top element of this stack
     * @throws RuntimeException if the stack is empty
     */
	@Override
    public String pop() {
        // is the stack empty?
        if (this.isEmpty()) {
            throw new RuntimeException("popped an empty stack");
        }
        // get the element at the top of the stack as type E
        String element = this.arr[this.top];
        
        // null out the value stored in the array; see explanation below why this should be done
        this.arr[this.top] = null;

        // adjust the top of stack index
        this.top--;

        // return the element that was on the top of the stack
        return element;
    }
    
    /**
     * Pushes an element onto the top of this stack if there is
     * sufficient capacity in this stack's array to store the element.
     * Does nothing and returns false if sufficient capacity is not
     * available.
     * 
     * <p>
     * An array-based stack that creates a new array when it runs
     * out of capacity should call this method after creating the
     * new array.
     * 
     * @param elem the element to push onto this stack
     * @return true if there is sufficient capacity, false otherwise 
     */
    public boolean push(String elem) {
        if (this.size() == this.arr.length) {
            return false;
        }
        this.top++;
        this.arr[this.top] = elem;
        return true;
    }
    
    /**
     * Compares this stack to an object for equality. This stack
     * is equal to {@code obj} if and only if {@code obj} is an instance of
     * {@code AbstractArrayStack} having the same number of elements
     * as this stack, and all corresponding pairs of elements in 
     * the two stacks are equal.
     * 
     * @param obj the object to compare
     * @return true if the specified object is equal to this stack
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractArrayStack)) {
            return false;
        }
        AbstractArrayStack other = (AbstractArrayStack) obj;
        
        if(this.size() != other.size()) {
        	return false;
        }
        
        for (int i = 0; i <= this.top; i++) {
        	if(!this.arr[i].equals(other.arr[i])) {
        		return false;
        	}
        }
        return true;
    }
    
    /**
     * Returns the sum of the hash codes of the strings in this
     * stack.
     * 
     * @return the sum of the hash codes of the strings in this
     * stack 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.size(); i++) {
            hash += this.arr[i].hashCode();
        }
        return hash;
    }
    
    
}
