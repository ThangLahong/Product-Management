import java.util.Scanner;

// Tạo class AS2_Main để tạo menu và thực hiện các chức năng của chương trình
public class AS2_Main {
    // Hàm hiển thị Menu
    public static void showMenu() {
        System.out.println("+-----------------------------------------+");
        System.out.println("|  Choose one of this options:            |");
        System.out.println("|  Product list:                          |");
        System.out.println("|  1. Load data from file and display     |");
        System.out.println("|  2. Input & add to the end              |");
        System.out.println("|  3. Display data                        |");
        System.out.println("|  4. Save product list to file           |");
        System.out.println("|  5. Search by ID                        |");
        System.out.println("|  6. Delete by ID                        |");
        System.out.println("|  7. Sort by ID                          |");
        System.out.println("|  8. Convert to Binary                   |");
        System.out.println("|  9. Load to stack and display           |");
        System.out.println("|  10. Load to queue and display          |");
        System.out.println("|  11. Delete tail                        |");
        System.out.println("|  12. Insert new product after position  |");
        System.out.println("|  13. Delete at position                 |");
        System.out.println("|  Exit:                                  |");
        System.out.println("|  0. Exit                                |");
        System.out.println("+-----------------------------------------+");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choose;
        String fileName = "data.txt";
        MyList<Product> list = new MyList<Product>();
        MyStack<Product> stack = new MyStack<Product>();
        MyQueue<Product> queue = new MyQueue<Product>();
        OperationToProduct otp = new OperationToProduct();
        // Dùng vòng lặp while yêu cầu chọn chức năng
        while (true) {
            showMenu();
            System.out.print("\nChoice = ");
            choose = sc.nextInt();
            if (choose == 0) {
                break;
            }
            // Dùng switch case thực hiện chức năng tương ứng
            switch (choose) {
                case 1:
                    System.out.println("Load data from file and display");
                    otp.getAllItemsFromFile(fileName, list);
                    break;
                case 2:
                    System.out.println("Input & add to the end");
                    otp.addLast(list);
                    break;
                case 3:
                    System.out.println("Display data");
                    otp.displayAll(list);
                    break;
                case 4:
                    System.out.println("Save product list to file");
                    otp.writeAllItemsToFile(fileName, list);
                    break;
                case 5:
                    System.out.println("Search by ID");
                    otp.searchByCode(list);
                    break;
                case 6:
                    System.out.println("Delete by ID");
                    otp.deleteByCode(list);
                    break;
                case 7:
                    System.out.println("Sort by ID");
                    otp.sortByCode(list);
                    System.out.println("\nSuccessfully!\n\n");
                    break;
                case 8:
                    System.out.println("Convert to Binary");
                    int quantity = list.getHead().getInfo().getQuantity();
                    System.out.print("Quantity = " + quantity + " => (");
                    otp.convertToBinary(quantity);
                    System.out.print(")\n\n");
                    break;
                case 9:
                    System.out.println("Load to stack and display");
                    otp.getAllItemsFromFile(fileName, stack);
                    break;
                case 10:
                    System.out.println("Load to queue and display");
                    otp.getAllItemsFromFile(fileName, queue);
                    break;
                case 11:
                    System.out.println("Delete tail");
                    list.deleteTail();
                    break;
                case 12:
                    System.out.println("Insert new product after position");
                    System.out.print("Position? ");
                    //int position = sc.nextInt();
                    list.insertAfterPosition(sc.nextInt(), otp.createProduct());
                    break;
                case 13:
                    System.out.println("Delete at position");
                    System.out.print("Input position to delete: ");
                    otp.deleteAtPosition(list, sc.nextInt());
                    break;
                default:
                    System.out.println("***Invalid. Please choice again!***\n\n");
            }
        }
    }
}
