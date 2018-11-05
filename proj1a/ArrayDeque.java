public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
        nextfirst = 0;
        nextlast = 1;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public int size(){
        return size;
    }
    public int itemlen(){
        return items.length;
    }

    public int getNextfirst(){
        return nextfirst;
    }
    public int getNextlast(){ return nextlast; }


    private void extend(int capacity) {
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, nextfirst+1, a, 1, items.length-nextfirst-1);
        System.arraycopy(items, 0, a, items.length-nextfirst, nextlast);
        nextfirst = 0;
        nextlast = size+1;
        items = a;
    }

    private void shrink() {
        T[] a = (T []) new Object[items.length/2];
        if(nextfirst<nextlast){
            System.arraycopy(items, nextfirst+1, a, 1, size);
            nextfirst = 0;
            nextlast = size+1;
        }
        else{
            System.arraycopy(items, nextfirst+1, a, 1, items.length-nextfirst-1);
            System.arraycopy(items, 0, a, items.length-nextfirst, nextlast);
            nextfirst = 0;
            nextlast = size+1;
        }
        items = a;
    }

    public void addFirst(T x){
        if(size==items.length){
            extend(items.length*2);
        }
        items[nextfirst] = x;
        if(nextfirst==0){
            nextfirst = items.length-1;
        }
        else{
            nextfirst = nextfirst-1;
        }
        size += 1;
    }

    public T removeFirst(){
        T result;
        if(size==0){return null;}

        if(nextfirst==items.length-1){
            result = items[0];
            nextfirst = 0;
        }
        else{
            result = items[nextfirst+1];
            nextfirst = nextfirst+1;
        }
        size -= 1;
        while(size<0.25*items.length && items.length>16){
            shrink();
        }
        return result;
    }

    public void addLast(T x){
        if(size==items.length){
            extend(items.length*2);
        }
        items[nextlast] = x;
        if(nextlast==items.length-1){
            nextlast = 0;
        }
        else{
            nextlast = nextlast+1;
        }
        size += 1;
    }

    public T removeLast(){
        T result;
        if(size==0){return null;}

        if(nextlast==0){
            result = items[items.length-1];
            nextlast = items.length-1;
        }
        else{
            result = items[nextlast-1];
            nextlast = nextlast-1;
        }
        size -= 1;
        while(size<0.25*items.length && items.length>16){
            shrink();
        }
        return result;
    }

    public void printDeque(){
        int count = 0;
        int i;

        if(nextfirst == items.length-1){
            i = 0;
        }
        else{
            i =nextfirst+1;
        }

        while(count<size){
            System.out.print(items[i]);
            System.out.print(" ");
            count += 1;
            if(i==items.length-1){
                i = 0;
            }
            else{
                i = i+1;
            }
        }
        System.out.println(" ");
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        return items[index];
    }

    public void printTest(){
        for(int i=0; i<items.length;i++){
            System.out.print(items[i]);
        }
        System.out.println(" ");
    }

}
