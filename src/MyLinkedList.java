public class MyLinkedList<E> {
    private int size;

    private Node<E> top;

    MyLinkedList() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (top == null && size == 0);
    }

    public boolean add(E obj) {
        if (top == null) {
            top = new Node<E>(obj);
        } else {
            Node<E> buf = top;

            while (buf.next != null)
                buf = buf.next;

            Node<E> addNode = new Node<E>(obj);
            addNode.prev = buf;
            buf.next = addNode;
        }
        size++;
        return true;
    }

    public boolean remove (E obj) {
        if (top == null)
            return false;
        Node<E> buf = top;

        while (buf.next != null && !buf.value.equals(obj))
            buf = buf.next;

        if (buf.value.equals(obj)) {
            if (buf.prev != null) {
                buf.prev.next = buf.next;
            } else {
                top = top.next;
            }
            if (buf.next != null)
                buf.next.prev = buf.prev;
            size--;
            return true;
        }
        return false;
    }

    public void clear() {
        Node<E> buf = top;

        while (buf != null) {
            buf.prev = null;
            buf.value = null;
            top = buf;
            buf = buf.next;
            top.next = null;
        }
        top = null;
        size = 0;
    }

    public boolean equals(Object o) {
        boolean eq = false;
        if (o instanceof MyLinkedList) {

            if (top == null ^ ((MyLinkedList) o).top == null)
                return false;
            if (top == null)
                return true;

            if (size != ((MyLinkedList) o).size)
                return eq;
            eq = true;
            Node<E> buf = top;
            Node<E> bufObject = ((MyLinkedList) o).top;

            while (buf != null) {
                if ( !buf.value.equals(bufObject.value) ) {
                    eq = false;
                    break;
                }
                buf = buf.next;
                bufObject = bufObject.next;
            }
        }
        return eq;
    }

    public E get(int index) {
        if (index > size - 1 || top == null)
            return null;

        Node<E> buf = top;
        int ind = -1;

        while (++ind != index)
            buf = buf.next;

        return buf.value;
    }

    public E set(int index, E elem) {
        if (index > size - 1 || top == null)
            return null;

        Node<E> buf = top;
        int ind = -1;

        while (++ind != index)
            buf = buf.next;

        buf.value = elem;
        return buf.value;
    }

    public boolean add (int index, E elem) {
        if (index > size - 1) {
            return add(elem); //добавить в конец
        }

        Node<E> buf = top;
        int ind = -1;

        while (++ind != index)
            buf = buf.next;

        Node<E> addNode = new Node<E>(elem);

        addNode.prev = buf.prev;
        if (buf.prev != null) {
            buf.prev.next = addNode;
        } else {
            top = addNode;
        }
        buf.prev = addNode;
        addNode.next = buf;

        size++;
        return true;
    }

    public boolean remove (int index) {
        if (index > size - 1 || top == null)
            return false;
        int ind = -1;
        Node<E> buf = top;

        while (++ind != index) {
            buf = buf.next;
        }

        if (buf.prev != null) {
            buf.prev.next = buf.next;
        } else {
            top = top.next;
        }
        if (buf.next != null) {
            buf.next.prev = buf.prev;
        }

        size--;
        return true;
    }

    public int indexOf(Object elem) {
        if (top == null)
            return -1;
        int ind = -1;
        Node<E> buf = top;

        while (++ind < size && !elem.equals( buf.value ))
            buf = buf.next;

        if ( ind < size && elem.equals( buf.value ) )
            return ind;
        return -1;
    }

    public boolean contains (Object o) {
        return indexOf(o) != -1;
    }



    private class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        private Node(E value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public String toString () {
        Node<E> buf = top;
        String res = "Size " + size + ": ";
        while (buf != null) {
            res += buf.value + "   ";
            buf = buf.next;
        }
        return res;
    }

}
