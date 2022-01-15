import java.util.EmptyStackException;

// Tạo class MyStack chứa thông tin và các hành vi cơ bản của stack
public class MyStack<T> {
    private Node<T> head;

    // Tạo constructor
    public MyStack() {
        head = null;
    }

    // Hàm kiểm tra stack rỗng
    public boolean isEmpty() {
        return (head == null);
    }

    // Hàm xóa toàn bộ sản phẩm trong stack
    public void clear() {
        head = null;
    }

    // Hàm thêm sản phẩm vào stack
    public void push(T item) {
        head = new Node<T>(item, head);
    }

    // Hàm đọc thông tin sản phẩm trên cùng của stack
    public T top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return head.getInfo();
    }

    // Hàm xóa sản phẩm trên cùng của stack, trả về sản phẩm đã xóa
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        T item = head.getInfo();
        head = head.getNext();
        return item;
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
