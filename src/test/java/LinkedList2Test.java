import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {
    LinkedList2 linkedList = new LinkedList2();

    @Test
    void addInTail_thenListEmpty() {
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void addInTail_thenOneNode() {
        Node node = new Node(1);
        linkedList.addInTail(node);
        assertEquals(linkedList.head, node);
        assertEquals(linkedList.tail, node);
        assertNull(linkedList.tail.next);
        assertNull(linkedList.head.next);
        assertNull(linkedList.tail.prev);
        assertNull(linkedList.head.prev);
    }

    @Test
    void addInTail_thenSomeNode() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        assertEquals(linkedList.head, node);
        assertEquals(linkedList.tail, node3);

        assertNull(linkedList.head.prev);
        assertEquals(linkedList.tail.prev, node2);
        assertEquals(linkedList.head.next, node2);
        assertEquals(node2.prev, linkedList.head);
        assertEquals(node2.next, linkedList.tail);
    }

    @Test
    void find_thenEmptyList() {
        assertNull(linkedList.find(1));
    }

    @Test
    void find_thenOneNode() {
        Node node = new Node(1);
        linkedList.addInTail(node);
        assertEquals(node, linkedList.find(1));
    }

    @Test
    void find_thenOSomeNode() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        assertEquals(node, linkedList.find(1));
    }

    @Test
    void findAll_thenEmptyList() {
        List<Node> nodes = linkedList.findAll(1);
        assertTrue(nodes.isEmpty());
    }

    @Test
    void findAll_thenOneNode() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        List<Node> nodes = linkedList.findAll(1);
        assertEquals(node, nodes.get(0));
        assertEquals(1, nodes.size());
    }

    @Test
    void findAll_thenSomeNode() {
        Node node = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(2);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        linkedList.addInTail(node4);
        List<Node> nodes = linkedList.findAll(1);
        assertEquals(node, nodes.get(0));
        assertEquals(node2, nodes.get(1));
        assertEquals(node3, nodes.get(2));
        assertEquals(3, nodes.size());
    }

    @Test
    void remove_thenEmptyList() {
        assertFalse(linkedList.remove(1));
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void remove_thenOneNode() {
        Node node = new Node(1);
        linkedList.addInTail(node);
        assertTrue(linkedList.remove(1));
        assertFalse(linkedList.remove(1));
        assertNull(linkedList.find(1));
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void remove_thenSomeNode_removeFirstNode() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        assertTrue(linkedList.remove(1));
        assertFalse(linkedList.remove(1));
        assertNull(linkedList.find(1));
        assertEquals(linkedList.head, node2);
        assertEquals(linkedList.tail, node3);
        assertNull(linkedList.head.prev);
        assertNull(linkedList.tail.next);
        assertEquals(linkedList.head.next, node3);
        assertEquals(linkedList.tail.prev, node2);
    }

    @Test
    void remove_thenSomeNode_removeLastNode() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        assertTrue(linkedList.remove(3));
        assertFalse(linkedList.remove(3));
        assertNull(linkedList.find(3));
        assertEquals(linkedList.head, node);
        assertEquals(linkedList.tail, node2);
        assertEquals(linkedList.head.next, node2);
        assertEquals(linkedList.tail.prev, linkedList.head);
        assertNull(linkedList.head.prev);
        assertNull(linkedList.tail.next);
    }

    @Test
    void removeAll_thenEmptyList() {
        linkedList.removeAll(1);
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void removeAll_thenOneNode() {
        linkedList.addInTail(new Node(1));
        linkedList.removeAll(1);
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
        assertNull(linkedList.find(1));
        assertEquals(0, linkedList.findAll(1).size());
    }

    @Test
    void removeAll_thenSomeNode() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        Node node5 = new Node(1);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        linkedList.addInTail(node4);
        linkedList.addInTail(node5);
        linkedList.removeAll(1);
        assertEquals(node2, linkedList.head);
        assertEquals(node4, linkedList.tail);
        assertNull(linkedList.head.prev);
        assertNull(linkedList.tail.next);
        assertEquals(node4, linkedList.head.next);
        assertEquals(node2, linkedList.tail.prev);
        assertNull(linkedList.find(1));
        assertEquals(0, linkedList.findAll(1).size());
    }

    @Test
    void clear_thenEmptyList() {
        linkedList.clear();
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void clear_thenOneNode() {
        linkedList.addInTail(new Node(1));
        linkedList.clear();
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void clear_thenSomeNode() {
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));
        linkedList.clear();
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }


    @Test
    void count_thenEmptyList() {
        assertEquals(0, linkedList.count());
    }

    @Test
    void count_thenOneNode() {
        linkedList.addInTail(new Node(1));
        assertEquals(1, linkedList.count());
    }

    @Test
    void count_thenSomeNode() {
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));
        assertEquals(3, linkedList.count());
    }

    @Test
    void count_thenRemoveOneNode() {
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));
        linkedList.remove(1);
        assertEquals(2, linkedList.count());
    }

    @Test
    void count_thenRemoveAllNodes() {
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));
        assertEquals(5, linkedList.count());
        linkedList.removeAll(1);
        assertEquals(2, linkedList.count());
    }

    @Test
    void insertAfter_thenEmptyList() {
        Node node = new Node(1);
        linkedList.insertAfter(null, node);
        assertEquals(linkedList.head, node);
        assertEquals(linkedList.tail, node);
    }

    @Test
    void insertAfter_thenOneNode() {
        Node node = new Node(1);
        linkedList.addInTail(node);
        Node node2 = new Node(2);
        linkedList.insertAfter(node, node2);
        assertEquals(linkedList.head, node);
        assertEquals(linkedList.tail, node2);
        assertEquals(linkedList.head.next, node2);
        assertEquals(linkedList.tail.prev, node);
        assertNull(linkedList.tail.next);
        assertNull(linkedList.head.prev);
    }

    @Test
    void insertAfter_thenSomeNode_insertInTheMiddle() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        Node node4 = new Node(4);
        linkedList.insertAfter(node, node4);
        assertEquals(linkedList.head, node);
        assertEquals(linkedList.tail, node3);
        assertEquals(linkedList.head.next, node4);
        assertEquals(node4.prev, linkedList.head);
        assertEquals(node2, linkedList.tail.prev);
        assertNull(linkedList.tail.next);
        assertNull(linkedList.head.prev);
    }

    @Test
    void insertAfter_thenSomeNode_insertInTheEnd() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);
        Node node4 = new Node(4);
        linkedList.insertAfter(node3, node4);
        assertEquals(node, linkedList.head);
        assertEquals(node4, linkedList.tail);
        assertEquals(node2, linkedList.head.next);
        assertEquals(node2.prev, linkedList.head);
        assertEquals(node3.next, linkedList.tail);
        assertEquals(node3, linkedList.tail.prev);
        assertNull(linkedList.tail.next);
        assertNull(linkedList.head.prev);
    }

}