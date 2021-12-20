package structure.flyweight;

import java.util.HashMap;

public class FlyweightTest {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,1,TreeFactory.getTree("1"));
        TreeNode treeNode1 = new TreeNode(1,1,TreeFactory.getTree("1"));
        TreeNode treeNode2 = new TreeNode(1,1,TreeFactory.getTree("1"));
        System.out.println(treeNode);
        System.out.println(treeNode1);
        System.out.println(treeNode2);
    }
}

class Tree {
    private final String name;

    public Tree(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                '}';
    }
}

class TreeNode {
    private int x, y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory {
    private static HashMap<String, Tree> treeHashMap = new HashMap<>();

    public static Tree getTree(String name) {
        if (treeHashMap.containsKey(name)) {
            return treeHashMap.get(name);
        }
        Tree tree = new Tree(name);
        treeHashMap.put(name, tree);
        return tree;
    }
}
