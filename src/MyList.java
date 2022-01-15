// Tạo class MyList chứa thông tin và hành vi cơ bản của một danh sách móc nối
public class MyList<T> {
    private Node<T> head;
    private Node<T> tail;

    // default constructor
    public MyList() {
    }

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    // Tạo các getter setter
    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    // Hàm tính độ dài của linked list
    public int length() {
        int length = 0;
        Node<T> current = this.head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    // Hàm thêm sản phẩm vào đầu linked list
    public void insertToHead(T item) {
        this.head = new Node<T>(item, this.head);
    }

    // Hàm thêm sản phẩm vào cuối linked list
    public void insertToTail(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) {
            this.head = this.tail = newNode;
            return;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    // Hàm thêm sản phẩm vào vị trí bất kỳ
    public void insertAfterPosition(int position, T item) {
        if (position > length() - 1) {
            position = length() - 1;
        }
        Node<T> current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        Node<T> nextNode = current.getNext();
        Node<T> temp = new Node<T>(item, nextNode);
        current.setNext(temp);
        System.out.println("Successfully!\n\n");
    }

    // Hàm xóa sản phẩm cuối linked list
    public void deleteTail() {
        Node<T> current = this.head;
        for (int i = 0; i < length() - 2; i++) {
            current = current.getNext();
        }
        current.setNext(null);
        System.out.println("Deleted!\n\n");
    }

    // Hàm xóa toàn bộ sản phẩm trong linked list
    public void clear() {
        this.head = this.tail = null;
    }


    @Override
    public String toString() {
        String result = "";
        Node<T> current = this.head;
        while (current != null) {
            result += current.getInfo();
            current = current.getNext();
        }
        return result;
    }
}
