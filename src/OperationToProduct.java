import java.io.*;
import java.util.Scanner;

// Tạo class OperationToProduct chứa các phương thức thức biểu diễn chức năng của chương trình
public class OperationToProduct {
    Scanner sc = new Scanner(System.in);

    public int index(Product p, MyList<Product> list) {
        return 1;
    }

    /*
     * Hàm tạo sản phẩm mới
     * Yêu cầu nhập vào thông tin sản phẩm mới và trả về sản phẩm mới
     */
    public Product createProduct() {
        Product newProduct = new Product();
        System.out.print("Input new ID: ");
        newProduct.setBCode(sc.next());
        System.out.print("Input Product's name: ");
        newProduct.setTitle(sc.next());
        System.out.print("Input Product's quantity: ");
        newProduct.setQuantity(sc.nextInt());
        System.out.print("Input Product's price: ");
        newProduct.setPrice(sc.nextDouble());
        return newProduct;
    }

    /*
     * Hàm đọc dữ liệu từ file
     * Cắt ghép chuỗi dữ liệu đọc được và đưa vào mảng
     * Trả về mảng chứa thông tin sản phẩm
     */
    public String[] getAllItemsFromFile(String fileName) throws Exception {
        String result = "";
        String[] arr;
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        int i;
        // Đọc tất cả dữ liệu từ file và lưu vào biến result
        while ((i = fr.read()) != -1) {
            result += (char) i;
        }
        fr.close();

        // Thông báo nếu file trống, trả về mảng trống
        if (result.equals("")) {
            System.out.println("File is empty!\n");
            arr = new String[0];
            return arr;
        }

        // Cắt ghép chuỗi để đưa vào mảng
        String newResult = "";
        for (int j = 0; j < result.length(); j++) {
            if (result.charAt(j) == ' ') {
                continue;
            }
            if (result.charAt(j) == '|' || result.charAt(j) == '\n') {
                newResult += " ";
                continue;
            }
            newResult += result.charAt(j);
        }
        arr = newResult.split(" ");
        System.out.println();
        System.out.println("\tID\t|\tTitle\t|\tQuantity\t|\tPrice");
        System.out.println("    -----------------------------------------");
        return arr;
    }

    // Hàm đọc thông tin từ file và lưu vào linked list
    public void getAllItemsFromFile(String fileName, MyList<Product> list) throws Exception {
        // Gọi hàm đọc thông tin từ file
        String[] arr = getAllItemsFromFile(fileName);
        // Xóa linked list
        list.clear();
        // Duyệt qua mảng để lấy toàn bộ thông tin và thêm sản phẩm vào linked list
        for (int t = 0; t < arr.length; t++) {
            Product newProduct = new Product();
            newProduct.setBCode(arr[t]);
            t++;
            newProduct.setTitle(arr[t]);
            t++;
            newProduct.setQuantity(Integer.parseInt(arr[t]));
            t++;
            newProduct.setPrice(Double.parseDouble(arr[t]));
            // Thêm sản phẩm vào cuối linked list
            list.insertToTail(newProduct);
        }
        // Hiển thị thông tin toàn bộ sản phẩm trong linked list
        System.out.println(list);
        System.out.println("    -----------------------------------------");
        System.out.println("    Successfully!\n\n");
    }

    // Hàm đọc thông tin từ file và lưu vào stack
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws Exception {
        // Gọi hàm đọc thông tin từ file
        String[] arr = getAllItemsFromFile(fileName);
        // Xóa stack
        stack.clear();
        // Duyệt qua mảng để lấy toàn bộ thông tin và thêm sản phẩm vào stack
        for (int t = 0; t < arr.length; t++) {
            Product newProduct = new Product();
            newProduct.setBCode(arr[t]);
            t++;
            newProduct.setTitle(arr[t]);
            t++;
            newProduct.setQuantity(Integer.parseInt(arr[t]));
            t++;
            newProduct.setPrice(Double.parseDouble(arr[t]));
            // Thêm sản phẩm vào trên cùng stack
            stack.push(newProduct);
        }
        // Hiển thị thông tin toàn bộ sản phẩm trong stack
        System.out.println(stack);
        System.out.println("    -----------------------------------------");
        System.out.println("    Successfully!\n\n");
    }

    // Hàm đọc thông tin từ file và lưu vào queue
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws Exception {
        // Gọi hàm đọc thông tin từ file
        String[] arr = getAllItemsFromFile(fileName);
        // Xóa queue
        queue.clear();
        // Duyệt qua mảng để lấy toàn bộ thông tin và thêm sản phẩm vào queue
        for (int t = 0; t < arr.length; t++) {
            Product newProduct = new Product();
            newProduct.setBCode(arr[t]);
            t++;
            newProduct.setTitle(arr[t]);
            t++;
            newProduct.setQuantity(Integer.parseInt(arr[t]));
            t++;
            newProduct.setPrice(Double.parseDouble(arr[t]));
            // Thêm sản phẩm vào queue
            queue.enQueue(newProduct);
        }
        // Hiển thị thông tin toàn bộ sản phẩm trong queue
        System.out.println(queue);
        System.out.println("    -----------------------------------------");
        System.out.println("    Successfully!\n\n");
    }

    // Hàm thêm sản phẩm mới vào cuối linked list
    public void addLast(MyList<Product> list) {
        list.insertToTail(createProduct());
        System.out.println("\nSuccessfully!\n\n");
    }

    // Hàm hiển thị thông tin toàn bộ sản phẩm trong linked list
    public void displayAll(MyList<Product> list) {
        System.out.println("\tID\t|\tTitle\t|\tQuantity\t|\tPrice");
        System.out.println("    -----------------------------------------");
        System.out.println(list);
        System.out.println("    -----------------------------------------\n\n");
    }

    // Hàm ghi thông tin toàn bộ sản phẩm trong linked list vào file
    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws Exception {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        Node<Product> current = list.getHead();
        while (current != null) {
            fw.write("    " + current.getInfo().getBCode() + "    |");
            fw.write("    " + current.getInfo().getTitle() + "    |");
            fw.write("    " + current.getInfo().getQuantity() + "    |");
            fw.write("    " + current.getInfo().getPrice());
            fw.write("\n");
            current = current.getNext();
        }
        fw.close();
        System.out.println("\nSuccessfully!\n\n");
    }

    // Hàm tìm kiếm sản phẩm trong linked list theo mã sản phẩm
    public void searchByCode(MyList<Product> list) {
        System.out.print("Input the ID to search: ");
        String ID = sc.next();
        Node<Product> current = list.getHead();
        while (current != null) {
            if (current.getInfo().getBCode().equals(ID)) {
                System.out.println(current + "\n");
                return;
            }
            current = current.getNext();
        }
        // Hiển thị -1 nếu sản phẩm cần tìm không tồn tại
        System.out.println("-1\n\n");
    }

    // Hàm xóa sản phẩm trong linked list theo mã sản phẩm
    public void deleteByCode(MyList<Product> list) {
        // Thông báo nếu linked list rỗng
        if (list.isEmpty()) {
            System.out.println("List is empty!\n\n");
            return;
        }
        System.out.print("Input the ID to delete: ");
        String ID = sc.next();
        Node<Product> current = list.getHead();
        Node<Product> prev = null;
        // Nếu sản phẩm cần xóa là head thì xóa head
        if (current.getInfo().getBCode().equals(ID)) {
            list.setHead(current.getNext());
            System.out.println("Deleted!\n\n");
            return;
        }
        while (current != null && !current.getInfo().getBCode().equals(ID)) {
            prev = current;
            current = current.getNext();
        }
        // Thông báo nếu sản phẩm cần xóa không tồn tại
        if (current == null) {
            System.out.println("Product does not exists!\n\n");
            return;
        }
        // Xóa sản phẩm tìm được
        prev.setNext(current.getNext());
        System.out.println("Deleted!\n\n");
    }

    /*
     * Hàm sắp xếp sản phẩm theo mã sản phẩm
     * Sử dụng thuật toán Quick sort
     */
    public void sortByCode(MyList<Product> list) {
        MyList<Product> l1 = new MyList<>();
        MyList<Product> l2 = new MyList<>();
        Node<Product> tag, p;
        if (list.getHead() == list.getTail()) {
            return;
        }
        tag = list.getHead();
        list.setHead(list.getHead().getNext());
        tag.setNext(null);
        while (list.getHead() != null) {
            p = list.getHead();
            list.setHead(list.getHead().getNext());
            p.setNext(null);
            if (p.getInfo().getBCode().compareTo(tag.getInfo().getBCode()) < 0) {
                l1.insertToHead(p.getInfo());
            } else {
                l2.insertToHead(p.getInfo());
            }
        }
        sortByCode(l1);
        sortByCode(l2);
        if (l1.getHead() != null) {
            list.setHead(l1.getHead());
            l1.getTail().setNext(tag);
        } else {
            list.setHead(tag);
        }
        tag.setNext(l2.getHead());
        if (l2.getHead() != null) {
            list.setTail(l2.getTail());
        } else {
            list.setTail(tag);
        }
    }

    /*
     * Hàm biểu diễn số lượng của sản phẩm đầu tiên trong linked list bằng mã nhị phân
     * Sử dụng phương pháp đệ quy
     */
    public void convertToBinary(int i) {
        if (i == 0) {
            System.out.print(0);
            return;
        }
        convertToBinary(i / 2);
        System.out.print(i % 2 + "");
    }

    // Hàm xóa sản phẩm trong linked list theo index
    public void deleteAtPosition(MyList<Product> list, int position) {
        // Thông báo nếu linked list rỗng
        if (list.isEmpty()) {
            System.out.println("List is empty!\n\n");
            return;
        }
        // Xóa sản phẩm ở vị trí đầu tiên
        if (position == 0) {
            list.setHead(list.getHead().getNext());
            System.out.println("Deleted!\n\n");
            return;
        }
        // Thông báo nếu vị trí lớn hơn độ dài linked list
        if (position > list.length() - 1) {
            System.out.println("Position does not exists!\n\n");
            return;
        }
        Node<Product> current = list.getHead();
        Node<Product> prev = null;
        // Tìm sản phẩm cần xóa
        for (int i = 0; i < position; i++) {
            prev = current;
            current = current.getNext();
        }
        // Xóa sản phẩm tìm được
        prev.setNext(current.getNext());
        System.out.println("Deleted!\n\n");
    }
}
