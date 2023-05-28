package cake;

import java.util.Objects;

class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public int height() {
        int leftCount = Objects.nonNull(leftChild) ? getHeightCount(leftChild) : 0;
        int rightCount = Objects.nonNull(rightChild) ? getHeightCount(rightChild) : 0;
        int initialHeight = 1;

        return Math.max(leftCount, rightCount) + initialHeight;
    }

    public int getHeightCount(Node node) {
        int count = 1;
        int leftCount = 0;
        int rightCount = 0;

        if(Objects.nonNull(node.getLeftChild())) {
            leftCount = getHeightCount(node.getLeftChild());
        }
        if (Objects.nonNull(node.getRightChild())){
            rightCount = getHeightCount(node.getRightChild());
        }
        return Math.max(leftCount, rightCount) + count;
    }
}