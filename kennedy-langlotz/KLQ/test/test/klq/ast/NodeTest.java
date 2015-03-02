//package com.klq.AST;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class NodeTest {
//    Node parentNode;
//
//    @Before
//    public void setUp() throws Exception {
//        parentNode = new Node("bla");
//    }
//
//    @Test
//    public void testSetParent() throws Exception {
//        Node newChild = addChild();
//        assertNotNull(newChild.getParent());
//        assertEquals(parentNode.getChildren().size(), 1);
//        assertTrue(parentNode.getChildren().contains(newChild));
//    }
//
//    @Test
//    public void testRemoveParent() throws Exception {
//        addChild().removeParent();
//        assertTrue(parentNode.getChildren().isEmpty());
//    }
//
//    private Node addChild(){
//        Node newChild = new Node("newChild");
//        newChild.setParent(parentNode);
//        return newChild;
//    }
//}