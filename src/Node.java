public class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    /**
     * Конструктор класса Узел бинарного дерева
     *
     * @param value значение Узла
     *              leftChild левый дочерний элемент
     *              rightChild правый дочерний элемент
     */
    public Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}