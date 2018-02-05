import javax.xml.soap.Node;
import java.io.*;

public class SLL {
	// each SLL object = header of SLL
	private Node first;
	public SLL() {
		// construct empty SLL
		this.first = null;
		// inner class
		
		private static class Node {
			private Object element;
			private Node next;
			public Node (Object elem, Node next) {
				
			}
		}
	}
}
