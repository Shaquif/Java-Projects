package a6;

/**
 * A linked list-based implementation of the {@code Stack} interface.
 *
 */
public class LinkedStack implements Stack {
	// the number of elements currently on the stack
	private int size;

	// the node containing the top element of the stack
	private Node top;

	private class Node {
		// the element stored in the node
		String elem;

		// the link to the next node in the sequence
		Node next;

		Node(String elem, Node next) {
			this.elem = elem;
			this.next = next;
		}
	}

	/**
	 * Initializes an empty stack.
	 */
	public LinkedStack() {
		this.size = 0;
		this.top = null;
	}

	/**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
	@Override
	public int size() {
		return this.size;
	}

	/**
     * Pushes the specified element on to the top of this stack. Such
     * operations always succeed.
     * 
     * @param elem the element to be pushed on to the top of this stack
     * @return true
     */
	@Override
	public boolean push(String elem) {
		Node n = new Node(elem, this.top);
		this.top = n;
		this.size++;
		return true;
	}

	/**
     * Removes the element on the top of this stack and returns the element.
     * 
     * @return the top element of this stack
     * @throws RuntimeException if the stack is empty
     */
	@Override
	public String pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("popped an empty stack");
		}
		String popped = this.top.elem;
		this.top = this.top.next;
		this.size--;
		return popped;
	}
	
	/**
	 * Returns a string representation of this stack. The elements of the stack
	 * appear in the returned string in sequence starting from the top of the stack
	 * to the bottom of the stack with each element separated from the next using a
	 * newline character.
	 * 
	 * @return a string representation of this stack
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("top: ");
        if (this.size() != 0) {
        	Node n = this.top;
        	b.append(n.elem);
            for (int i = 1; i < this.size(); i++) {
            	n = n.next;
                b.append(", ");
                b.append(n.elem);
            }
        }
        b.append(" :bottom");
        return b.toString();
	}
	
	// ADD THE CONSTRUCTOR AND METHODS FROM THE ASSIGNMENT
	// BELOW THIS COMMENT.
	
	/**
	 * Initializes this stack to be a stack of size 2 having the specified top and
	 * bottom elements.
	 * 
	 * @param top the top element of this stack
	 * @param bottom the bottom element of this stack
	 */
	public LinkedStack(String top, String bottom) {
		Node bottomNode = new Node(bottom, null);
		this.top = new Node(top, bottomNode);
		this.size = 2;
	}
	
	/**
	 * Swaps the elements at the top and bottom of the stack.
	 * 
	 * <p>
	 * Does nothing if there are fewer than two elements in the stack.
	 */
	public void swapTopBottom() {
		if (this.size < 2) {
			return;
		}
		
		Node currentNode = this.top;
		Node previousNode = null;
		
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		previousNode = currentNode;
		
		String temp = top.elem;
		top.elem = previousNode.elem;
		previousNode.elem = temp;
	}
	
	/**
	 * Compares this stack to an object for equality. This stack
	 * is equal to {@code obj} if and only if {@code obj} is a
	 * {@code LinkedStack} object having the same number of elements
	 * as this stack, and all corresponding pairs of elements in 
	 * the two stacks are equal.
	 * 
	 * @param obj the object to compare
	 * @return true if the specified object is equal to this stack
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof LinkedStack)) {
			return false;
		}
		
		LinkedStack otherLinkedStack = (LinkedStack) obj;
		
		if(this.size != otherLinkedStack.size) {
			return false;
		}
		
		Node thisCurrentNode = this.top;
		Node otherCurrentNode = otherLinkedStack.top;
		
		while (thisCurrentNode != null && otherCurrentNode != null) {
			if(!thisCurrentNode.elem.equals(otherCurrentNode.elem)) {
				return false;
			}
			thisCurrentNode = thisCurrentNode.next;
			otherCurrentNode = otherCurrentNode.next;
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
		
		for(Node currentNode = top; currentNode != null; currentNode = currentNode.next) {
			hash += currentNode.elem.hashCode();
		}
		return hash;
	}
	
	public static void main(String[] args) {
	    LinkedStack stack = new LinkedStack();
	    
	    System.out.println("Initial Stack: " + stack);
	    
	    stack.push("A");
	    stack.push("D");
	    stack.push("R");
	    
	    System.out.println("Stack size: " + stack.size());
	    System.out.println("Stack elements: " + stack.toString());
	    stack.swapTopBottom();
	    System.out.println(stack);
	    
	    stack.pop();
	    
	    System.out.println("Stack after 1 pop: " + stack.toString());
	    
	    stack.pop();
	    stack.pop();
	    
	    LinkedStack stack2 = new LinkedStack();
	    
	    System.out.println("Are stacks equal? " + stack.equals(stack2));
	    
	    LinkedStack stack3 = new LinkedStack();
	    stack3.push("A");
	    System.out.println("Are stack and stack3 equal? " + stack.equals(stack3));
	    
	    System.out.println("HashCode for stack: " + stack.hashCode());
	    System.out.println("HashCode for stack: " + stack3.hashCode());
	    
	    
	}
}
