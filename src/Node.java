// Tạo class Node để quản lý thông tin và hành  của vi mỗi node trong danh sách
public class Node<T> {
    private T info;
    private Node<T> next;

    // default constructor
    public Node() {
    }

    // Constructor khởi tạo Node
    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this(info, null);
    }

    // Tạo các getter setter
    public T getInfo() {
        return this.info;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Result: " + info;
    }
}
