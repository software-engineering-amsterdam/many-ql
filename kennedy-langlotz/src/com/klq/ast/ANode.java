package com.klq.ast;

import java.util.ArrayList;

/**
 * Created by juriaan on 9-2-15.
 */
public abstract class ANode {
    private String loc;
    private ANode parent;
    private ArrayList<ANode> children;

    public ANode(){
        children = new ArrayList<ANode>();
    }

    public ANode(String loc){
        this.loc = loc;
        parent = null;
        children = new ArrayList<ANode>();
    }

    public ANode getParent() {
        return parent;
    }

    //Set the parent node and change the children property of the parent.
    public void setParent(ANode parent) {
        removeParent();
        if(parent != null) {
            this.parent = parent;
            parent.getChildren().add(this);
        }
    }

    public void removeParent(){
        if(parent != null) {
            parent.getChildren().remove(this);
            parent = null;
        }
    }

    public ArrayList<ANode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ANode> children) {
        this.children = children;
    }

    public abstract void accept(IVisitor visitor);

    public void printSelf() {
    }
}
