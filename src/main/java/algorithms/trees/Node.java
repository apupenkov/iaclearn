package algorithms.trees;

public class Node {
    int key;
    int value;
    Node left = null;
    Node right = null;
    int heigth = 0;
    Node(int key, int value) {this.key = key; this.value = value;}

    void updateHeight(Node node) {
        node.heigth = Math.max(getHeigth(node.left), getHeigth(node.right)) + 1;
    }

    int getHeigth(Node node) {
        return (node == null) ? -1 : node.heigth;
    }

    int getBalance(Node node) {
        return (node == null) ? 0 : getHeigth(node.right) - getHeigth(node.left);
    }

    void swap(Node a, Node b) {
        int a_key = a.key;
        a.key = b.key;
        b.key = a_key;
        int a_value = a.value;
        a.value = b.value;
        b.value = a_value;
    }

    void rightRotate(Node node) {
        swap(node, node.left);
        Node buffer = node.right;
        node.right = node.left;
        node.left = node.right.left;
        node.right.left = node.right.right;
        node.right.right = buffer;
        updateHeight(node.right);
        updateHeight(node);
    }

    void leftRotate(Node node) {
        swap(node, node.right);
        Node buffer = node.left;
        node.left = node.right;
        node.right = node.left.right;
        node.right.left = node.right.right;
        node.left.right = node.left.left;
        node.left.left = buffer;
        updateHeight(node.left);
        updateHeight(node);
    }

    void balance(Node node) {
        int balance = getBalance(node);
        if (balance == -2) {
            if (getBalance(node.left) == 1) leftRotate(node.left);
            rightRotate(node);
        } else if (balance == 2) {
            if (getBalance(node.right) == -1) rightRotate(node.right);
            leftRotate(node.left);
        }
    }

    void insert(Node node, int key, int value) {
        if (key < node.key) {
            if (node.left == null) node.left = new Node(key, value);
            else insert(node.left, key, value);
        } else if (key >= node.key) {
            if (node.right == null) node.right = new Node(key, value);
            else insert(node.right, key, value);
        }

        updateHeight(node);
        balance(node);
    }

    Node search(Node node, int key) {
        if (node == null) return null;
        if (node.key == key) return node;
        return (key < node.key) ? search(node.left, key) : search(node.right, key);
    }

    Node getMin(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return getMin(node.left);
    }

    Node getMax(Node node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return getMax(node.right);
    }

    Node delete(Node node, int key) {
        if (node == null) return null;
        else if (key < node.key) node.left = delete(node.left, key);
        else if (key > node.key) node.right = delete(node.right, key);
        else {
            if (node.left == null || node.right == null)
                node = (node.left == null) ? node.right : node.left;
            else {
                Node maxInLeft = getMax(node.left);
                node.key = maxInLeft.key;
                node.value = maxInLeft.value;
                node.right = delete(node.right, maxInLeft.key);
            }
        }
        if (node != null) {
            updateHeight(node);
            balance(node);
        }
        return node;
    }

    void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println(node.value);
        printTree(node.right);
    }

    void deleteTree(Node node) {
        if (node == null) return;
        deleteTree(node.left);
        deleteTree(node.right);
        System.out.println(node.value);
    }

    void copyTree(Node node) {
        if (node == null) return;
        copyTree(node.left);
        copyTree(node.right);
        System.out.println(node.value);
    }
}
