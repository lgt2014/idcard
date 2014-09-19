package com.lgt;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lgt on 9/17/14.
 */
public class ZoneTree {
    private Node root = new Node("中国", "");

    public void addNode(Node n) {
        if(findNode(root,n.getName())!=null){
            return;
        }
        Node curtNode = root;
        Node placeNode = null;
        while (curtNode != null) {
            if (isSuccessor(curtNode, n)) {
                placeNode = curtNode;
                curtNode = curtNode.getLeftChild();
            } else if (isSibling(curtNode, n)) {
                placeNode=null;
                n.setRightsibling(curtNode.getRightsibling());
                curtNode.setRightsibling(n);
                n.setParent(curtNode.getParent());
                return;
            } else {
                curtNode = curtNode.getRightsibling();
            }
        }
        if (placeNode != null) {
            n.setParent(placeNode);
            placeNode.setLeftChild(n);
        }
    }

    /**
     * find the node which name equals to the given parameter name
     * @param curtNode
     * @param name
     * @return the node which has the same name with parameter;null if not find.
     */
    public Node findNode(Node curtNode,String name){
        Node n = null;
        if(curtNode==null){
            return n;
        }
        if( name.equalsIgnoreCase(curtNode.getName())){
            return curtNode;
        }else{
            n = findNode(curtNode.getLeftChild(),name);
        }
        if(n==null){
            n=findNode(curtNode.getRightsibling(),name);
        }
        return n;
    }
    public String toString(){
        return "digraph test{"+getStrPath(root)+"}";
    }
    private String getStrPath(Node n) {
        StringBuilder sb = new StringBuilder("");
        if (n != null) {
            Node temp = n.getLeftChild();
            while (temp != null) {
                sb.append(n.getName()).append("->").append(temp.getName()).append(";\n");
                sb.append(getStrPath(temp));
                temp = temp.getRightsibling();
            }
        }
        return sb.toString();
    }

    private void printDot(){
        FileWriter fw = null;
        try {
            fw = new FileWriter("tree.dot");
            fw.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * To judge whether the node n is the sibling of the current node.
     * @param curtNode
     * @param n
     * @return true if n is the sibling of curtNode;false else;
     */
    private boolean isSibling(Node curtNode, Node n) {

        return n.getData().length() == curtNode.getData().length();
    }

    /**
     * To judge the node n whether it's the successor of the current node.
     * @param curtNode
     * @param n
     * @return true if the node n is the successor of curtNode;false else;
     */
    private boolean isSuccessor(Node curtNode, Node n) {

        return n.getData().indexOf(curtNode.getData()) != -1;
    }

    public static void main(String[] args) {
        ZoneTree zt = new ZoneTree();
        Node n = new Node("山东省", "37");
        zt.addNode(n);
        zt.addNode(n);
        zt.addNode(new Node("北京","01"));
        zt.addNode(new Node("河南","38"));
        zt.addNode(new Node("聊城市", "3715"));
        zt.addNode(new Node("济南市", "3716"));
        zt.addNode(new Node("临清市", "371581"));
        zt.addNode(new Node("冠县", "371582"));
        zt.addNode(new Node("临市", "371583"));
        zt.addNode(new Node("商河", "371681"));
        zt.addNode(new Node("齐河", "371683"));
        zt.addNode(new Node("聊城市1", "3815"));
        zt.addNode(new Node("济南市1", "3816"));
        zt.addNode(new Node("临清市1", "381581"));
        zt.addNode(new Node("冠县1", "381582"));
        zt.addNode(new Node("临市1", "381583"));
        zt.addNode(new Node("商河1", "381681"));
        zt.addNode(new Node("齐河1", "381683"));
        zt.printDot();
    }

    public Node getRoot() {
        return root;
    }
}
