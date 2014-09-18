package com.lgt;

/**
 * 这里Node表示一个区域节点。
 * 每个节点有name, data,parent,leftChild,rightsibling 组成。
 * 其中name 表示当前节点的名称，
 * data 表示当前节点的值。
 * parent、leftChild、rightsibling分别表示对父节点，左子节点，兄弟节点链的引用。
 * Created by lgt on 9/17/14.
 */

public class Node {

    private String name;
    private String data;
    private Node parent;
    private Node leftChild;
    private Node rightsibling;  //和当前节点同级的节点的引用

    public Node(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightsibling() {
        return rightsibling;
    }

    public void setRightsibling(Node rightsibling) {
        this.rightsibling = rightsibling;
    }
}
