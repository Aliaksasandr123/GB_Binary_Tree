public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Adding values to binary tree");
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);
        System.out.println("Binary tree size: " + binaryTree.getSize());
        System.out.println("Binary tree contains value 6: " + binaryTree.containsNode(6));
        System.out.println("Binary tree contains value 4: " + binaryTree.containsNode(4));
        System.out.println("Binary tree contains value 200: " + binaryTree.containsNode(200));
        System.out.println("Deleting value 3 from binary tree");
        binaryTree.delete(3);
        System.out.println("Binary tree size: " + binaryTree.getSize());
        System.out.println("\n\tBinary Tree :");
        binaryTree.traverseLevelOrder();
    }
}