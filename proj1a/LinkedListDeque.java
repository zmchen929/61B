public class LinkedListDeque <T> {
    //internal helper class: LinkedList Node
    //represent each node inside LinkedListDeque, including dummy node
    private static class LinkedListNode<T> {
        public T val;
        public LinkedListNode prev;
        public LinkedListNode next;

        public LinkedListNode(T value, LinkedListNode prev, LinkedListNode next){
            this.val = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private LinkedListNode<Integer> sentinel;

    //LinkedListDeque constructor
    public LinkedListDeque(){
        size = 0;
        sentinel = new LinkedListNode<>(0, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    //judge if Deque is empty
    public boolean isEmpty(){
        if(size==0){return true;}
        return false;
    }

    //Deque size
    public int size(){
        return this.size;
    }

    //add item to beginning
    public void addFirst(T x) {
        LinkedListNode<T> first = new LinkedListNode<>(x, sentinel, sentinel.next);
        if(size==0){
            sentinel.prev = first;
        }
        else{
            sentinel.next.prev = first;
        }
        sentinel.next = first;
        size += 1;
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null
    public T removeFirst(){
        if(size==0){return null;}
        else {
            LinkedListNode<T> first = sentinel.next;
            sentinel.next = sentinel.next.next;
            first.next.prev = sentinel;
            size -= 1;
            return first.val;
        }
    }

    //add item to end
    public void addLast(T x){
        LinkedListNode<T> last = new LinkedListNode<>(x, sentinel.prev, sentinel);
        if(size==0){
            sentinel.next = last;
        }
        else{
            sentinel.prev.next = last;
        }
        sentinel.prev = last;
        size += 1;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, returns null
    public T removeLast(){
        if(size==0){return null;}
        else {
            LinkedListNode<T> last = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            last.prev.next = sentinel;
            size -= 1;
            return last.val;
        }
    }

    //Prints the items in the deque from first to last, separated by a space
    public void printDeque(){
        LinkedListNode<T> temp = sentinel.next;
        int count = 0;
        while(count<size){
            System.out.print(temp.val);
            System.out.print(" ");
            temp = temp.next;
            count += 1;
        }
        System.out.println("");
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        LinkedListNode<T> temp=sentinel.next;
        if(size==0){return null;}
        else if(index>size-1){return null;}
        else{
            while(index>0){
                temp = temp.next;
                index -= 1;
            }
            return temp.val;
        }
    }

    //same as get, but use recursion
    public T getRecursive(int index){
        LinkedListNode<T> temp = sentinel.next;
        if(size<1 && index>0 ){
            return null;
        }
        else if(index==0){
            return temp.val;
        }
        else{
            sentinel=sentinel.next;
            size -= 1;
            return getRecursive(index-1);
        }
    }



}

