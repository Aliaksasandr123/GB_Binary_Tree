import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    /**
     * Метод для проверки наличия в дереве определенного значения
     *
     * @param value значение, которое ищем в дереве
     * @return если значение найдено, возвращаем true, иначе false
     */
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    /**
     * Рекурсивный метод, проходит по дереву и ищет значение
     *
     * @param current Текущий узел
     * @param value   значение, которое ищем в дереве
     * @return если значение найдено, возвращаем true, иначе false
     */
    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.getValue() == value) {
            return true;
        }
        return value < current.getValue() ?
                containsNodeRecursive(current.getLeftChild(), value) :
                containsNodeRecursive(current.getRightChild(), value);
    }

    /**
     * Метод добавления значения в дерево
     *
     * @param value значение, которое добавляем в дерево
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * Рекурсивный метод, для вставки значения
     *
     * @param current Текущий узел
     * @param value   значение, для вставки в дерево
     * @return возвращает узел вставки
     */
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeftChild(addRecursive(current.getLeftChild(), value));
        } else if (value > current.getValue()) {
            current.setRightChild(addRecursive(current.getRightChild(), value));
        } else {
            return current;
        }
        return current;
    }

    /**
     * Метод удаления значения из дерева
     *
     * @param value значение, которое удаляем из дерева
     */
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    /**
     * Рекурсивный метод, для удаления значения
     *
     * @param current Текущий узел
     * @param value   значение, для удаления из дерева
     * @return возвращает узел удаления
     */
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.getValue()) {
            if (current.getLeftChild() == null && current.getRightChild() == null) {
                return null;
            }
            if (current.getRightChild() == null) {
                return current.getLeftChild();
            }
            if (current.getLeftChild() == null) {
                return current.getRightChild();
            }
            int smallestValue = findSmallestValue(current.getRightChild());
            current.setValue(smallestValue);
            current.setRightChild(deleteRecursive(current.getRightChild(), smallestValue));
            return current;
        }
        if (value < current.getValue()) {
            current.setLeftChild(deleteRecursive(current.getLeftChild(), value));
            return current;
        }
        current.setRightChild(deleteRecursive(current.getRightChild(), value));
        return current;
    }

    /**
     * Метод нахождения наименьшего элемента для узла
     *
     * @param root Текущий узел
     * @return возвращает значение наименьшего элемента
     */
    private int findSmallestValue(Node root) {
        return root.getLeftChild() == null ? root.getValue() : findSmallestValue(root.getLeftChild());
    }

    /**
     * Метод подсчёта количества элементов в дереве
     *
     * @return возвращает количиство элементов
     */
    public int getSize() {
        return getSizeRecursive(root);
    }

    /**
     * Рекурсивный метод, для подсчёта количества элементов в дереве
     *
     * @param current Текущий узел
     * @return возвращает количиство элементов
     */
    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.getLeftChild()) + 1 + getSizeRecursive(current.getRightChild());
    }

    /**
     * Метод обхода дерева в ширину
     */
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println("Node: " + node.getValue());
            if (node.getLeftChild() != null) {
                System.out.print(" Left child: " + node.getLeftChild().getValue());
                nodes.add(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                System.out.print(" Right child: " + node.getRightChild().getValue());
                nodes.add(node.getRightChild());
            }
            System.out.println();
        }
    }
}