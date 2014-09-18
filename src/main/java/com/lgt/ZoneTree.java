package com.lgt;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lgt on 9/17/14.
 */
public class ZoneTree {
    private Node root = new Node("中国", "");

    public void addNode(Node n) {
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
    public String toString(){
        return "digraph test{"+getStrPath(root)+"}";
    }
    public String getStrPath(Node n) {
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

    public void printDot(){
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

    private boolean isSibling(Node curtNode, Node n) {

        return n.getData().length() == curtNode.getData().length();
    }

    private boolean isSuccessor(Node curtNode, Node n) {

        return n.getData().indexOf(curtNode.getData()) != -1;
    }

   
}
