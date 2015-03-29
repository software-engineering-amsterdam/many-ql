package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.staticfieldscollector.PTypeCollector;
import org.uva.student.calinwouter.qlqls.qls.exceptions.CouldNotFindMatchingQLSComponentException;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.uva.student.calinwouter.qlqls.ql.helper.ASTHelper.*;

/**
 * This adapter parses the syntax reverse depth-first and creates a corresponding internal model of the results,
 * using the functions defined in the COMPONENTS_PACKAGE_PREFIX location. This way, QLS is extremely flexible,
 * as the user can simply add new functions whenever required, without touching the syntax.
 *
 * Note that the GUI and QLS are completely separated, and that QLS is also completely separated
 * from the QL Interpreter.
 */
public class QLSAdapter extends ReversedDepthFirstAdapter {

    private final PTypeCollector pTypeCollector = new PTypeCollector();

    private final static List<String> allowablePaths = new LinkedList<String>();

    /* This is the relative package where the functions reside. */
    private final static String COMPONENTS_PACKAGE_PREFIX =
            QLSAdapter.class.getPackage().getName() + ".model.functions.";

    /* This is the relative package where the functions reside. */
    private final static String WIDGETS_PACKAGE_PREFIX =
            QLSAdapter.class.getPackage().getName() + ".model.functions.widgets.";

    /* The stack is used for pushing parameters of functions and the hashmaps to the stack, and forming a model
     * by popping the elements of the stack and putting them into the constructor of the corresponding class. */
    private final Stack<Object> argumentStack = new Stack<Object>();

    /**
     * This method creates a new component or widget dynamically using QLSReflection.
     */
    private Object interopComponent(String componentName, List<Object> args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, CouldNotFindMatchingQLSComponentException {
        final String classPath = firstCharacterToUpper(componentName);
        QLSReflection qlsReflection = new QLSReflection(allowablePaths);
        return qlsReflection.newComponentInstance(classPath, args);
    }

    /**
     * Get the value of the first object on the stack.
     *
     * Example of correct usage:
     * - Parse a AStylesheet-object using the apply-method on the abstract syntax tree's method.
     * - This method returns the transformed stylesheet (StyleSheet)-object.
     * @return the value of the first object on the stack.
     */
    public Object popValue() {
        assert (argumentStack.size() == 1);
        return pop();
    }


    /**
     * ANonParameterizedFunction-s are functions in the form of:
     *
     * fn ()
     */
    @Override
    public void outANonParameterizedFunction(ANonParameterizedFunction node) {
        ArrayList<Object> values = new ArrayList<Object>();
        final Object model;
        try {
            final String identifier = getIdentifier(node);
            model = interopComponent(identifier, values);
            push(model);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (CouldNotFindMatchingQLSComponentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AParameterizedFunction-s are functions of the form of:
     *
     * ident (expr_1, ... expr_n), with n > 0.
     */
    @Override
    public void outAParameterizedFunction(AParameterizedFunction node) {
        ArrayList<Object> values = new ArrayList<Object>();
        for (int i = 0; i < node.getElement().size(); i++) {
            values.add(pop());
        }
        try {
            final String identifier = getIdentifier(node);
            final Object model = interopComponent(identifier, values);
            push(model);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (CouldNotFindMatchingQLSComponentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AIdentifierElement-s are identifier representations (e.g. variables or references).
     */
    @Override
    public void outAIdentifierElement(AIdentifierElement node) {
        final String identifier = getIdentifier(node);
        push(identifier);
    }

    /**
     * AHexElement-s are number representations in hexadecimal format.
     */
    @Override
    public void outAHexElement(AHexElement node) {
        final Integer hexValue = getHex(node);
        push(hexValue);
    }

    /**
     * AStringElement-s are string representations.
     */
    @Override
    public void outAStringElement(AStringElement node) {
        final String string = getString(node);
        push(string);
    }

    private ITypeDescriptor convertAstTypeToTypeDescriptor(PType nodeAstType) {
        nodeAstType.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    /**
     * ATypeElement-s are type representations (i.e. int, boolean, string).
     */
    @Override
    public void outATypeElement(ATypeElement node) {
        final PType nodeAstType = node.getType();
        final ITypeDescriptor nodeTypeDescriptor = convertAstTypeToTypeDescriptor(nodeAstType);
        push(nodeTypeDescriptor);
    }

    /**
     * ANumberElement-s are number representations.
     */
    @Override
    public void outANumberElement(ANumberElement node) {
        final Integer elementAsNumber = getNumber(node);
        push(elementAsNumber);
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
    @SuppressWarnings("unchecked") // Required for reflection.
    public void outAObjectElement(AObjectElement node) {
        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        for (int i = 0; i < node.getKeyValue().size(); i++) {
            final AbstractMap.SimpleEntry<Object, Object> entry =
                    (AbstractMap.SimpleEntry<Object, Object>) pop();
            final Object keyObject = entry.getKey();
            final String key = keyObject.toString();
            final Object value = entry.getValue();
            hashMap.put(key, value);
        }
        push(hashMap);
    }

    /**
     * AKeyValue-s are the entries in the AObjectElement's key-value map.
     *
     * Syntax:
     *
     * (Any)Element ':' (Any)Element
     *
     * =>
     *
     * SimpleEntry<Object, Object>
     */
    @Override
    public void outAKeyValue(AKeyValue node) {
        AbstractMap.SimpleEntry<Object, Object> mapEntry = new AbstractMap.SimpleEntry<Object, Object>(pop(), pop());
        push(mapEntry);
    }

    private Object pop() {
        return argumentStack.pop();
    }

    private void push(Object toPush) {
        argumentStack.push(toPush);
    }

    private static String firstCharacterToUpper(String str) {
        assert(str.length() > 0);
        final String firstCharacter = str.substring(0, 1);
        final String rest = str.substring(1);
        return firstCharacter.toUpperCase() + rest;
    }

    /** QLSAdapter can only be used through the QLSInterpreter and the QLSTypeChecker. */
    protected QLSAdapter() {}

    static {
        allowablePaths.add(COMPONENTS_PACKAGE_PREFIX);
        allowablePaths.add(WIDGETS_PACKAGE_PREFIX);
    }
}
