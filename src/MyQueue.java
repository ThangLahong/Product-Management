// Tạo class MyQueue chứa thông tin và các hành vi cơ bản của queue
public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    // Tạo constructor
    public MyQueue() {
        head = tail = null;
    }

    // Hàm kiểm tra queue rỗng
    public boolean isEmpty() {
        return (head == null);
    }

    // Hàm xóa toàn bộ sản phẩm trong queue
    public void clear() {
        head = tail = null;
    }

    // Hàm lấy thông tin sản phẩm đầu tiên trong queue
    public T front() throws Exception {
        if (isEmpty()) throw new Exception();
        return head.getInfo();
    }

    // Hàm xóa sản phẩm đầu tiên trong queue, trả về sản phẩm đã xóa
    public T deQueue() throws Exception {
        if (isEmpty()) throw new Exception();
        T item = head.getInfo();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return item;
    }

    // Hàm thêm sản phẩm vào cuối queue
    public void enQueue(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
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
