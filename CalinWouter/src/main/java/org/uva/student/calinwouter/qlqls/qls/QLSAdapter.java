package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractModel;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * This adapter parses the syntax reverse depth-first and creates a corresponding model from the results.
 */
public class QLSAdapter extends ReversedDepthFirstAdapter {

    /* This string is used for fetching the IModel objects. */
    private final static String COMPONENTS_PACKAGE_PREFIX =
            QLSAdapter.class.getPackage().getName() + ".model.components.";
    private final Stack<Object> argumentStack = new Stack<Object>();

    /**
     * This method creates an instance of the class to be found by the specified name, with
     * this QLSAdapter as constructor parameter.
     */
    private AbstractModel newInstanceForClassPathWithQlsInterpreterAsArgument(String classPath, List<Object> args)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException,
            InvocationTargetException, ClassNotFoundException {
        List<Class<?>> classList = new LinkedList<Class<?>>();
        for (Object o : args) {
            classList.add(o.getClass());
        }
        return (AbstractModel) Class.forName(classPath).getConstructor(classList.toArray(new Class<?>[classList.size()]))
                .newInstance(args.toArray());
    }

    /**
     * This method creates applies the parameters to the component, returning the model.
     */
    private AbstractModel interopComponent(String componentName, List<Object> args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        String classPath = createClassPath(firstCharacterToUpper(componentName));
        return newInstanceForClassPathWithQlsInterpreterAsArgument(classPath, args);
    }

    public Object getValue() {
        assert (argumentStack.size() == 1);
        return argumentStack.get(0);
    }

    private static String createClassPath(String name) {
        return COMPONENTS_PACKAGE_PREFIX + name;
    }

    private static String firstCharacterToUpper(String str) {
        return str.substring(0, 1).toUpperCase()
                + str.substring(1);
    }

    @Override
    public void outAEmptyIdentList(AEmptyIdentList node) {
        ArrayList<Object> values = new ArrayList<Object>();
        try {
            final AbstractModel iModel = interopComponent(node.getIdent().getText(), values);
            argumentStack.push(iModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outAFilledIdentList(AFilledIdentList node) {
        ArrayList<Object> values = new ArrayList<Object>();
        for (int i = 0; i < node.getElement().size(); i++) {
            values.add(argumentStack.pop());
        }
        try {
            final AbstractModel iModel = interopComponent(node.getIdent().getText(), values);
            argumentStack.push(iModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outAIdentElement(AIdentElement node) {
        argumentStack.push(node.getIdent().getText());
    }

    @Override
    public void outAHexElement(AHexElement node) {
        argumentStack.push(Integer.parseInt(node.getHex().getText().substring(1), 16));
    }

    @Override
    public void outAStringElement(AStringElement node) {
        argumentStack.push(node.getString().getText());
    }

    @Override
    public void outATypeElement(ATypeElement node) {
        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        argumentStack.push(typeInterpreter.getValue());
    }

    @Override
    public void outANumberElement(ANumberElement node) {
        argumentStack.push(Integer.parseInt(node.getNumber().getText()));
    }

    @Override
    public void outAObjectElement(AObjectElement node) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (int i = 0; i < node.getObjectEl().size(); i++) {
            AbstractMap.SimpleEntry<Object, Object> entry = (AbstractMap.SimpleEntry<Object, Object>) argumentStack.pop();
            hashMap.put(entry.getKey().toString(), entry.getValue());
        }
        argumentStack. push(hashMap);
    }

    @Override
    public void outAObjectEl(AObjectEl node) {
        argumentStack.push(new HashMap.SimpleEntry<Object, Object>(argumentStack.pop(), argumentStack.pop()));
    }
}
