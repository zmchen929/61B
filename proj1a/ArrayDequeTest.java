public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the array, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        lld1.addFirst("front_again");
        passed = checkSize(4, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");
        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        lld1.addLast(20);
        lld1.addLast(30);
        lld1.addFirst(5);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        System.out.println(lld1.removeFirst());//should print 5
        System.out.println(lld1.removeFirst());//should print 10
        System.out.println(lld1.removeLast());//should print 30
        System.out.println(lld1.removeLast());//should print 20
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        lld1.addLast(60);
        System.out.println(lld1.removeLast());//should print 60
        System.out.println(lld1.removeLast());//should print null

        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void extendTest() {

        System.out.println("Running extend test.");
        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        //
        lld1.addFirst(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addFirst(5);
        lld1.addFirst(6);
        lld1.addLast(7);
        lld1.addLast(8);
        System.out.println("Printing out deque: ");//6 5 1 2 3 4 7 8
        lld1.printDeque();
        //lld1.printTest();
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
        System.out.println(lld1.getNextfirst());
        System.out.println(lld1.getNextlast());

        lld1.addFirst(9);
        lld1.addLast(10);
        lld1.addFirst(11);
        lld1.addFirst(12);
        System.out.println("Printing out deque: ");//12 11 9 6 5 1 2 3 4 7 8 10
        lld1.printDeque();
        //lld1.printTest();
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
        passed = checkSize(12, lld1.size()) && passed;
        System.out.println(lld1.getNextfirst());
        System.out.println(lld1.getNextlast());


        printTestStatus(passed);
    }

    public static void shrinkTest() {

        System.out.println("Running extend test.");
        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addFirst(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addFirst(5);
        lld1.addFirst(6);
        lld1.addLast(7);
        lld1.addLast(8);
        System.out.println("Printing out deque: ");//6 5 1 2 3 4 7 8
        lld1.printDeque();
        lld1.addFirst(9);
        lld1.addLast(10);
        lld1.addFirst(11);
        lld1.addFirst(12);
        lld1.addFirst(13);
        lld1.addFirst(14);
        lld1.addFirst(15);
        lld1.addFirst(16);
        lld1.addLast(17);
        lld1.addFirst(18);
        System.out.println("Printing out deque: ");//18 16 15 14 13 12 11 9 6 5 1 2 3 4 7 8 10 17
        lld1.printDeque();
        System.out.println(lld1.getNextfirst());
        System.out.println(lld1.getNextlast());
        System.out.println("array capacity is: "+lld1.itemlen());//32
        for(int i=0; i<10; i++){
            lld1.removeLast();
        }
        System.out.println("Printing out deque: ");//18 16 15 14 13 12 11 9
        lld1.printDeque();
        System.out.println(lld1.getNextfirst());
        System.out.println(lld1.getNextlast());
        System.out.println("array capacity is: "+lld1.itemlen());//32

        lld1.removeFirst();
        System.out.println("Printing out deque: ");//16 15 14 13 12 11 9
        lld1.printDeque();
        System.out.println("array capacity is: "+lld1.itemlen());//16

        for(int i=0; i<7; i++){
            lld1.removeLast();
        }
        System.out.println("Printing out deque: ");//null
        lld1.printDeque();
        System.out.println("array capacity is: "+lld1.itemlen());//16
        boolean passed = checkEmpty(true, lld1.isEmpty());
        printTestStatus(passed);

    }




    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        //addIsEmptySizeTest();
        //addRemoveTest();
        //extendTest();
        shrinkTest();
    }



}
