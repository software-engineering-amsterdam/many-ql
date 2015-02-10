import AST.Node;

import java.util.ArrayList;

/**
 * Created by Timon on 09.02.2015.
 */
public class Main {
    public static void main(String[] args){
        Node parentNode = new Node("bla");
        Node firstChildNode = new Node("bla");
        Node secondChildNode = new Node("bla");
        Node thirdChildNode = new Node("bla");

        ArrayList<Node> list = parentNode.getChildren();
        list.add(firstChildNode);

        System.out.println("yo");
    }
}
