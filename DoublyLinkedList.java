public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    private NodeType<T> tail;



    // inserts items into the doubly linked list
    public void insertItem(T item){

        NodeType<T> node = new NodeType<T>(item);
        NodeType<T> curr = head;

        if(head == null){

            head = node;
            tail = node;
            return;
        }

        if(curr.info.compareTo(node.info) > 0){

            node.next = curr;
            curr.back = node;
            head = node;
        } else if(curr.info.compareTo(node.info) == 0){
            System.out.println("cannot insert duplicates");
            return;
        } else {

            while(curr.next != null){

                if(curr.info.compareTo(node.info) == 0){
                    System.out.println("cannot insert duplicates");
                    return;
                }

                if(curr.next.info.compareTo(node.info) > 0){
                    break;
                }

                curr = curr.next;
            }

            node.next = curr.next;
            node.back = curr;

            if(curr.next != null){
                curr.next.back = node;
            } else {
                tail = node;
            }

            curr.next = node;

        }
    }

    // prints the list
    public void printList(){

        NodeType<T> curr = head;

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        while(curr != null){
            System.out.print(curr.info + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    // prints the reverse of the list
    public void printReverse(){

        NodeType<T> curr = tail;

        if(tail == null){
            System.out.println("list is empty");
            return;
        }

        while(curr.back != null){

            System.out.print(curr.info + " ");
            curr = curr.back;
        }

        if(curr != null){
            System.out.print(curr.info);
        }


        System.out.println();
    }


    // delets the inputted item from the list
    public void deleteItem(T item){

        if(head == null){

            System.out.println("list is emtpy");
            return;
        }

        NodeType<T> curr = head;


        while(curr != null && curr.info.compareTo(item) != 0) {

            curr = curr.next;
        }

        if(curr == null){

            System.out.println("item not found in the list");
            return;
        }

        if(curr == head){

            head = head.next;

            if(head != null){
                head.back = null;
            } else {
                tail = null;
            }
        } else if(curr == tail){

            tail = tail.back;

            if(tail != null){

                tail.next = null;
            } else {
                head = null;
            }
        } else {

            curr.back.next = curr.next;
            curr.next.back = curr.back;
        }
    }

    // returns the lenght of the list
    public int length(){

        if(head == null){

            System.out.println("List is empty");
            return 0;
        }

        NodeType<T> curr = head;

        int length = 0;

        while(curr != null){

            length++;
            curr = curr.next;
        }

        System.out.print(length);
        return length;
    }


    // deletes an inputted subsection from the list
    public void deleteSubsection(T lower, T upper){


        NodeType<T> curr = head;

        boolean range = false;


        if(head == null){
            System.out.println("List is emtpy");
            return;
        }

        while(curr != null){

            if(curr.info.compareTo(lower) >= 0 && curr.info.compareTo(upper) <= 0) {

                NodeType<T> delete = curr;
                curr = curr.next;
                deleteItem(delete.info);
                range = true;
            } else {
                curr = curr.next;
            }
        }

        if(!range){
            System.out.println("no nodes in specified range");
        }
    }



    // reverses the list
    public void reverseList(){

        if(head == null || head.next == null){
            return;
        }

        NodeType<T> curr = head;
        NodeType<T> temp = null;


        while(curr != null){

            temp = curr.back;
            curr.back = curr.next;
            curr.next = temp;
            curr = curr.back;
        }


        if(temp != null){
            head = temp.back;
        }

    }

    // swaps the nodes with those adjecent
    public void swapAlternate(){

        if(head == null || head.next == null){
            return;
        }

        NodeType<T> curr = head;


        while(curr != null && curr.next != null){

            NodeType<T> first = curr;
            NodeType<T> second = curr.next;

            first.next = second.next;
            second.back = first.back;


            if(first.back != null){
                first.back.next = second;
            } else {
                head = second;
            }

            second.next = first;
            first.back = second;

            curr = first.next;

            if(curr != null){
                curr.back = first;
            }

        }
    }
}
