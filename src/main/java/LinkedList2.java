import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node fondNode = find(_value);
        if (fondNode != null) {
            if (head != null && head.next == null) {
                this.head = null;
                this.tail = null;
                return true;
            }
            if (fondNode == head) {
                this.head = fondNode.next;
                this.head.prev = null;
                return true;
            }
            if (fondNode == tail) {
                this.tail = fondNode.prev;
                this.tail.next = null;
                return true;
            }
            fondNode.prev.next = fondNode.next;
            fondNode.next.prev = fondNode.prev;
            return true;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node iterNode = this.head;
        while (iterNode != null) {
            if (iterNode.value == _value)
                remove(_value);
            iterNode = iterNode.next;
        }

    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        Node iterNode = this.head;
        int i = 0;
        while (iterNode != null) {
            i++;
            iterNode = iterNode.next;
        }
        return i;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            if (this.head == null && this.tail == null) {
                this.head = _nodeToInsert;
                this.tail = _nodeToInsert;
            } else {
                _nodeToInsert.next = this.head;
                this.head.prev = _nodeToInsert;
                this.head = _nodeToInsert;
            }
        } else {
            Node fondNodeAfter = find(_nodeAfter.value);
            if (fondNodeAfter == this.tail) {
                _nodeToInsert.prev = this.tail;
                this.tail.next = _nodeToInsert;
                this.tail = _nodeToInsert;
            } else {
                _nodeToInsert.next = fondNodeAfter.next;
                _nodeToInsert.prev = fondNodeAfter;
                fondNodeAfter.next = _nodeToInsert;
            }
        }
    }

    private boolean isSingleNode() {
        return head != null && head.next == null;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
