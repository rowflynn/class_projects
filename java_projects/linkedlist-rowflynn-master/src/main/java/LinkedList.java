class Node {
    Object obj;
    Node next;

    public Node() {
        obj = null;
    }

    public Node(Object obj) {
        this.obj = obj;
    }

    public String toString() {
        return obj.toString();
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = tail = null;
    }

    /**
     * This method returns the print representation of the list.
     * 
     * @return the print representation of the list.
     */
    public String toString() {
        String out = "";
        for (Node n = head; n != null; n = n.next)
            out += n.obj + " ";

        return out;
    }

    /**
     * This method returns the number of elements in this list.
     * 
     * @return the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * This method adds an Object to the end of the LinkedList.
     * 
     * @param obj it can be of any type - super cool stuff.
     */
    public void add(Object obj) {
        Node node = new Node(obj);

        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * The method returns the found object based on the passed index.
     * It throws an Exception saying that you messed up, and you gotta fix it.
     * Starts at 0 but supports negatives and wraps the index around within
     * the limits of the list.
     * 
     * @param index the index of the object to be returned.
     * @return the object at the index.
     */
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.obj;
    }

    /**
     * Removes the first matched object and
     * returns the position of the removed object
     * from the LinkedList.
     * 
     * @param obj represents the object the user wants to remove
     * @return position of the removed object
     */
    public int remove(Object obj) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.obj.equals(obj)) {
                remove(index);
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    /**
     * Removes the object given its position and
     * returns the removed object (not Node) from the LinkedList.
     * 
     * @param position represents the position of the object
     *                 to be removed
     * @return the item that was removed
     */
    public Object remove(int position) {
        Node temp = head;
        if (position < 0) {
            return -1;
        } else if (position == 0) {
            Object rtrn = head.obj;
            head = head.next;
            size--;
            return rtrn;
        } else {
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        Node rtrn = temp.next;
        temp.next = temp.next.next;
        size--;
        return rtrn.obj;
        }
    }

    /**
     * Adds the object given its position in the LinkedList.
     * 
     * @param obj      represents the object to be added
     * @param position represents the position of the object
     *                 to be added in the LinkedList
     */
    public void add(Object obj, int position) {
        Node temp = head;
        Node node = new Node(obj);

        if (position < 0) {
            System.out.println("Invalid input");
        }else if (size == 0) {
            add(obj);
        }else if (position == 0) {
            node.obj = head.obj;
            head.obj = obj;
            node.next = head.next;
            head.next = node;
            size++;
        } else {
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            node.next=temp.next;
            temp.next=node;
            size++;
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add("Hello");
        list.add("World");
        list.add("!");
        list.remove("Hello");
        list.remove("World");
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        list.remove(0);
        list.remove(0);
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        list.add("!");
        list.remove(3);
        list.remove(3);
        
        System.out.println(list.toString());
        System.out.println(list.size());
    }
}
