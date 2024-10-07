import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {
    public static void main(String[] args){


        if(args.length != 1){

            System.out.println("no inputted file");
            return;
        }


        String fileName = args[0];

        File file = new File(fileName);

        Scanner scan;

        try{
            scan = new Scanner(file);

        } catch (FileNotFoundException e){

            System.out.println("File not found");
            return;
        }

        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter list type (i-int, d-double, s-string): ");

        String listType = inputScanner.nextLine();

        DoublyLinkedList<?> list = null;

        switch(listType){

        case"i":
            listType = "Integer";
            break;

        case"d":
            listType = "Double";
            break;


        case"s":
            listType = "String";
            break;

        default:
            System.out.println("Input not valid");
            return;
        }

// initializes list of type inputted by user
        if(listType == "Integer"){
            DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
            while(scan.hasNextInt()){

                intList.insertItem(scan.nextInt());
            }
            list = intList;
        } else if(listType == "Double"){

            DoublyLinkedList<Double> doubleList = new DoublyLinkedList<>();
            while(scan.hasNextDouble()){

                doubleList.insertItem(scan.nextDouble());
            }
            list = doubleList;
        } else if(listType == "String"){

            DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
            while(scan.hasNext()){

                stringList.insertItem(scan.next());
            }
            list = stringList;
        }



        scan.close();

        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete subsection");
        System.out.println("(s) - Swap alternate");
        System.out.println("(q) - Quit");

        Scanner scanner = new Scanner(System.in);

        boolean cont = true;


        // command handling
        while(cont){

            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            if(command.equals("p")){

                System.out.print("The list is: ");
                list.printList();
            } else if(command.equals("q")){

                System.out.println("Exiting the program...");
                cont = false;
            } else if(command.equals("t")){

                System.out.print("The reverse list is: ");
                list.printReverse();
            } else if(command.equals("l")){

                System.out.print("The length is: ");
                list.length();
                System.out.println();
            } else if(command.equals("i")){

                System.out.print("The list is: ");
                list.printList();

                if(listType == "Integer"){

                    System.out.print("Enter a number to insert: ");

                    int intValue = scanner.nextInt();
                    scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<Integer> intList = (DoublyLinkedList<Integer>) list;
                    intList.insertItem(intValue);



                } else if(listType == "Double"){

                    System.out.print("Enter a number to insert: ");

                    double doubleValue = scanner.nextDouble();
                    scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<Double> doubleList = (DoublyLinkedList<Double>) list;
                    doubleList.insertItem(doubleValue);

                } else if(listType == "String"){

                    System.out.print("Enter a string to insert: ");

                    String stringValue = scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<String> stringList = (DoublyLinkedList<String>) list;
                    stringList.insertItem(stringValue);

                } else {

                    System.out.println("Invalid response");
                    return;
                }

                System.out.print("The list is: ");
                list.printList();
                list.reverseList();
                System.out.print("The reverse list is: ");
                list.printList();
                list.reverseList();


            } else if(command.equals("d")){

                System.out.print("The list is: ");
                list.printList();

                if(listType == "Integer"){

                    System.out.print("Enter a number to delete: ");

                    int intValue = scanner.nextInt();
                    scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<Integer> intList = (DoublyLinkedList<Integer>) list;
                    intList.deleteItem(intValue);
                } else if(listType == "Double"){

                    System.out.print("Enter a number to delete: ");

                    double doubleValue = scanner.nextDouble();
                    scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<Double> doubleList = (DoublyLinkedList<Double>) list;
                    doubleList.deleteItem(doubleValue);
                } else if(listType == "String"){

                    System.out.print("Enter a string to delete: ");

                    String stringValue = scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<String> stringList = (DoublyLinkedList<String>) list;

                    stringList.deleteItem(stringValue);
                }

                System.out.print("The list is: ");
                list.printList();

                System.out.print("The reverse list is: ");
                list.reverseList();
                list.printList();
                list.reverseList();

            }else if(command.equals("b")) {

                if(listType == "Integer"){

                    System.out.print("Enter lower bound: ");
                    int lower = scanner.nextInt();

                    System.out.print("Enter upper bound: ");
                    int upper = scanner.nextInt();

                    scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<Integer> intList = (DoublyLinkedList<Integer>) list;

                    System.out.print("Original list: ");
                    list.printList();

                    intList.deleteSubsection(lower, upper);

                } else if(listType == "Double"){

                    System.out.print("Enter lower bound: ");
                    double lower = scanner.nextDouble();

                    System.out.print("Enter upper bound: ");
                    double upper = scanner.nextDouble();

                    scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<Double> doubleList = (DoublyLinkedList<Double>) list;

                    System.out.print("Original list: ");
                    list.printList();

                    doubleList.deleteSubsection(lower, upper);


                } else if(listType == "String") {

                    System.out.print("Enter lower bound: ");
                    String lower = scanner.nextLine();

                    System.out.print("Enter upper boundL ");
                    String upper = scanner.nextLine();

                    @SuppressWarnings("unchecked")

                    DoublyLinkedList<String> stringList = (DoublyLinkedList<String>) list;

                    System.out.print("Original list: ");
                    list.printList();

                    stringList.deleteSubsection(lower, upper);

                }

                System.out.print("The modified list: ");
                list.printList();

                System.out.print("The reverse list: ");
                list.reverseList();
                list.printList();
                list.reverseList();

            } else if(command.equals("r")){

                list.reverseList();
                list.printList();
            } else if(command.equals("s")){

                System.out.print("Original list: ");
                list.printList();

                list.swapAlternate();

                System.out.print("Modified list: ");
                list.printList();

                System.out.print("Reverse list: ");
                list.reverseList();
                list.printList();
                list.reverseList();

            }

        }



// Testing


 /*

 <Double> doubleList = new
        DoublyLinkedList<>();
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();

        doubleList.insertItem(12.2);
        doubleList.insertItem(12.1);
        doubleList.insertItem(22.0);

        stringList.insertItem("Movie");
        stringList.insertItem("Igloo");
        stringList.insertItem("Party");

        stringList.deleteItem("Party");
        stringList.deleteItem("somethig");



        doubleList.printList();
        stringList.printList();

        */


        /*
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();


        intList.insertItem(25);
        intList.insertItem(50);
        intList.insertItem(35);
        intList.insertItem(15);
        intList.insertItem(22);
        intList.insertItem(10);
        intList.insertItem(12);
        intList.insertItem(4);
        intList.insertItem(18);
        intList.insertItem(24);

        intList.printList();
        intList.length();

        //intList.deleteSubsection(55,62);
        //intList.reverseList();
        intList.swapAlternate();


        intList.printList();

        */

    }
}
