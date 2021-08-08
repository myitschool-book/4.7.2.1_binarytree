package ru.samsung.itschool.mdev;


public class BinaryTree {

    private int value;
    private BinaryTree lchild; // левый потомок
    private BinaryTree rchild; // правый потомок

    public BinaryTree(int value){
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public BinaryTree(){
        this.value = -1; // значение для пустого узла
        this.lchild = null;
        this.rchild = null;
    }

    //      Метод вставки элементов в дерево
    //      node - ссылка на текущий узел дерева
    //      для создания дерева будем передавать null в качестве node
    //      valueNode - значение, которое добавляем в дерево

    public void insertNode(BinaryTree root, int valueNode) {
        // если дерево пустое
        if (root.value == -1) {
            root.value = valueNode; // записываем значение в узел
            return;
        }
        // если значение в текущем узле больше valueNode, то переходим в левое поддерево
        if (root.value > valueNode) {
            // если левого потомка нет, то создаем его с значением valueNode
            if (root.lchild == null) root.lchild = new BinaryTree(valueNode);
                // если левый потомок есть, то переходим ниже в левое поддерево
            else insertNode(root.lchild, valueNode);
        }
        // если значение в текущем узле меньше вставляемого, то переходим в правое поддерево
        else if (root.value < valueNode) {
            // если правого потомка нет, то создаем его с значением valueNode
            if (root.rchild == null) root.rchild = new BinaryTree(valueNode);
                // если правый потомок есть, то переходим ниже в правое поддерево
            else insertNode(root.rchild, valueNode);
        }
    }

    // метод вывода дерева на экран
    public void printBinaryTree(BinaryTree root, int level) {
        if (root != null) {
            printBinaryTree(root.lchild, level + 1);
           for (int i = 0; i < level; i++)
                System.out.print("\t");
            // чем ниже уровень, тем отступ больше
            System.out.println(root.value);
            printBinaryTree(root.rchild, level + 1);
        }
    }

    public static void main(String[] args) {
        // массив значений для добавления в дерево
        int b[] = { 10, 25, 20, 6, 4, 8, 50, 30, 6 };
        BinaryTree tree = new BinaryTree();
        // добавление элементов массива в дерево
        for (int i = 0; i < b.length; i++)
            tree.insertNode(tree, b[i]);
        // вывод содержимого дерева
        tree.printBinaryTree(tree, 0);
    }
}



