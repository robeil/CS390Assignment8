package CS390Assignment8.prob4;

public class DoublyLinkedList {
		public int size;
		Node header;

		DoublyLinkedList(){
			header = new Node();
		}
		//adds to the end of the list
		public void addLast(String item){
			//Creating new node
			Node current = new Node();
			if(header.next == null){
				//make connection to the header.next
				current.next = null;
				current.previous = header;
				header.next = current;
				//assigning value
				current.value = item;
				size++;
			} else {
				Node temp = header.next;
			while(temp.next != null){
				temp = temp.next;
			}
			current.previous = temp;
			temp.next = current;
			current.value = item;
			current.next = null;
			size++;
			}
		}
		public boolean remove(String item){
			if(item == null) return false;
			if(header.next == null){
				return false;
			} else {
				Node current = header;
				while(current != null){
					if(item.equals(current.value) ){
						if(current.next != null) {
							current.next.previous = current.previous;
							current.previous.next = current.next;
							size--;
						} else {
							current.previous.next = null;
						}
						return true;
					}
					current = current.next;
				}
			}
			return false;
		}

		@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			toString(sb, header);
			return sb.toString();
			
		}
		private void toString(StringBuilder sb, Node n) {
			if(n==null) return;
			if(n.value != null) sb.append(" " + n.value);
			toString(sb, n.next);
		}
		
		class Node {

			String value;
			Node next;
			Node previous;

			public String toString() {
				return value == null ? "null" : value;
			}
		}
	
		public static void main(String[] args){
			DoublyLinkedList list = new DoublyLinkedList();
			list.addLast("Bob");
			list.addLast("Harry");
			list.addLast("Steve");
			System.out.println(list);
			System.out.println(list.size);
			list.remove("Harry");
			list.remove("Bob");
			list.remove("Steve");
			System.out.println(list);
			System.out.println(list.size);

		}
}
