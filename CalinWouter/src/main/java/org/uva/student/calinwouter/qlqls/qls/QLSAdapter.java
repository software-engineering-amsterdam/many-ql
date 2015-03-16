package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.staticfieldscollector.PTypeCollector;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * This adapter parses the syntax reverse depth-first and creates a corresponding internal model of the results,
 * using the components defined in the COMPONENTS_PACKAGE_PREFIX location. This way, QLS is extremely flexible,
 * as the user can simply add new components whenever required, without touching the syntax.
 *
 * Note that the GUI and QLS are completely separated, and that QLS is also completely separated
 * from the QL Interpreter.
 */
public class QLSAdapter extends ReversedDepthFirstAdapter {

    private final PTypeCollector pTypeCollector = new PTypeCollector();

    /* This is the relative package where the components reside. */
    private final static String COMPONENTS_PACKAGE_PREFIX =
            QLSAdapter.class.getPackage().getName() + ".model.components.";

    /* This is the relative package where the components reside. */
    private final static String WIDGETS_PACKAGE_PREFIX =
            QLSAdapter.class.getPackage().getName() + ".model.components.widgets.";

    /* The stack is used for pushing parameters of functions and the hashmaps to the stack, and forming a model
     * by popping the elements of the stack and putting them into the constructor of the corresponding class. */
    private final Stack<Object> argumentStack = new Stack<Object>();

    /**
     * This method creates a new component or widget dynamically using QLSReflection.
     */
    private Object interopComponent(String componentName, List<Object> args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        String classPath = firstCharacterToUpper(componentName);
        QLSReflection qlsReflection = new QLSReflection(COMPONENTS_PACKAGE_PREFIX, WIDGETS_PACKAGE_PREFIX);
        return qlsReflection.newInstanceForClassPath(classPath, args);
    }

    /**
     * Get the value of the first object on the stack.
     *
     * Example of correct usage:
     * - Parse a AStylesheet-object using the apply-method on the abstract syntax tree's method.
     * - This method returns the transformed stylesheet (StyleSheet)-object.
     * @return the value of the first object on the stack.
     */
    public Object getValue() {
        assert (argumentStack.size() == 1);
        return argumentStack.get(0);
    }

    /**
     * AEmptyIdentList-s (Empty Identified List) are functions in the form of:
     *
     * fn ()
     */
    @Override
    public void outAEmptyIdentList(AEmptyIdentList node) {
        ArrayList<Object> values = new ArrayList<Object>();
        try {
            final Object model = interopComponent(node.getIdent().getText(), values);
            argumentStack.push(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AFilledIdentList-s (Filled Identified List) are functions in the form of:
     *
     * ident (expr_1, ... expr_n), with n > 0.
     */
    @Override
    public void outAFilledIdentList(AFilledIdentList node) {
        ArrayList<Object> values = new ArrayList<Object>();
        for (int i = 0; i < node.getElement().size(); i++) {
            values.add(argumentStack.pop());
        }
        try {
            final Object model = interopComponent(node.getIdent().getText(), values);
            argumentStack.push(model);
        } catch (Exception e) {
            // TODO This catches ALL the exceptions!
            throw new RuntimeException(e);
        }
    }

    /**
     * AIdentElemnt-s are identifier representations (e.g. variables or references).
     */
    @Override
    public void outAIdentElement(AIdentElement node) {
        argumentStack.push(node.getIdent().getText());
    }

    /**
     * AHexElement-s are number representations in hexadecimal format.
     */
    @Override
    public void outAHexElement(AHexElement node) {
        argumentStack.push(Integer.parseInt(node.getHex().getText().substring(1), 16));
    }

    /**
     * AStringElement-s are string representations.
     */
    @Override
    public void outAStringElement(AStringElement node) {
        argumentStack.push(node.getString().getText());
    }

    /**
     * ATypeElement-s are type representations (i.e. int, boolean, string).
     */
    @Override
    public void outATypeElement(ATypeElement node) {
        node.getType().apply(pTypeCollector);
        argumentStack.push(pTypeCollector.popType());
    }

    /**
     * ANumberElement-s are number representations.
     */
    @Override
    public void outANumberElement(ANumberElement node) {
        argumentStack.push(Integer.parseInt(node.getNumber().getText()));
    }

    /**
     * AObjectElement-s are key-value maps
     *
     * Syntax:
     *
     * '{' AObjectEl* '}'
     *
     * =>
     *
     * HashMap<Object, Object>
     *
     * In case the elements on the stack deviate from the SimpleEntry-type, this method raises a ClassCastException.
     */
    @Override
    public void outAObjectElement(AObjectElement node) {
        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        for (int i = 0; i < node.getObjectEl().size(); i++) {
            AbstractMap.SimpleEntry<Object, Object> entry = (AbstractMap.SimpleEntry<Object, Object>) argumentStack.pop();
            hashMap.put(entry.getKey().toString(), entry.getValue());
        }
        argumentStack.push(hashMap);
    }

    /**
     * AObjectEl-s are the entries in the AObjectElement's key-value map.
     *
     * Syntax:
     *
     * AStringElement ':' (Any)Element
     *
     * =>
     *
     * SimpleEntry<Object, Object>
     *
     * In case the first element on the stack deviates from the String-type (key), this method raises a ClassCastException.
     */
    @Override
    public void outAObjectEl(AObjectEl node) {
        argumentStack.push(new AbstractMap.SimpleEntry<Object, Object>((Object) argumentStack.pop(), argumentStack.pop()));
    }

    private static String firstCharacterToUpper(String str) {
        return str.substring(0, 1).toUpperCase()
                + str.substring(1);
    }

    /** QLSAdapter can only be used through the QLSInterpreter and the QLSTypeChecker. */
    protected QLSAdapter() {}
}
