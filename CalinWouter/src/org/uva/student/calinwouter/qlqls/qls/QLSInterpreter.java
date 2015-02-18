package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.qls.model.IModel;
import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;

import java.io.IOException;
import java.util.*;

/**
 * This interpreter parses the syntax depth-first and creates corresponding models from the results.
 */
public class QLSInterpreter extends ReversedDepthFirstAdapter {

    /* This string is used for fetching the IModel objects. */
    private final static String COMPONENTS_PACKAGE_PREFIX =
            QLSInterpreter.class.getPackage().getName().toString() + ".model.";

    private Stack<AbstractPushable<?>> argumentStack = new Stack<AbstractPushable<?>>();

    public AbstractPushable<?> getValue() {
        assert(argumentStack.size() == 1);
        return argumentStack.get(0);
    }

    private void push(AbstractPushable<?> o) {
        argumentStack.push(o);
        System.out.println(" , " + argumentStack.size());
    }

    private AbstractPushable<?> pop() {
        AbstractPushable<?> a = argumentStack.pop();
        System.out.println(a.getClass() + " , " + argumentStack.size());
        return a;
    }

    /**
     * This method creates a new component based on the component name and it's arguments.
     */
    public IModel interopComponent(String componentName, List<AbstractPushable<?>> args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = COMPONENTS_PACKAGE_PREFIX + componentName.substring(0, 1).toUpperCase()
                + componentName.substring(1);
        Class<IModel> cls = (Class<IModel>) Class.forName(className);
        IModel model = cls.newInstance();
        for (AbstractPushable arg : args)
            arg.apply(model);
        return model;
    }

    @Override
    public void outAEmptyIdentList(AEmptyIdentList node) {
        ArrayList<AbstractPushable<?>> values = new ArrayList<AbstractPushable<?>>();
        try {
            IModel iModel = interopComponent(node.getIdent().getText(), values);
            AbstractPushable<IModel> abstractPushable = new AbstractPushable<IModel>(iModel) {};
            push(abstractPushable);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outAFilledIdentList(AFilledIdentList node) {
        ArrayList<AbstractPushable<?>> values = new ArrayList<AbstractPushable<?>>();
        for (int i = 0; i < node.getElement().size(); i++)
            values.add(pop());
        try {
            IModel iModel = interopComponent(node.getIdent().getText(), values);
            AbstractPushable<IModel> abstractPushable = new AbstractPushable<IModel>(iModel) {};
            push(abstractPushable);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void defaultOut(@SuppressWarnings("unused") Node node) {
        System.out.println("Ignoring: " + node.getClass());
    }

    @Override
    public void outAIdentElement(AIdentElement node) {
        push(new AbstractPushable<String>(node.getIdent().getText()) {
            @Override
            public String getString() {
                return getValue();
            }
        });
    }

    @Override
    public void outAHexElement(AHexElement node) {
        push(new AbstractPushable<Integer>(Integer.parseInt(node.getHex().getText().substring(1), 16)) {
            @Override
            public Integer getInteger() {
                return getValue();
            }

            @Override
            public void apply(IModel model) {
                model.caseInteger(getValue());
            }
        });
    }

    @Override
    public void outAStringElement(AStringElement node) {
        push(new AbstractPushable<String>(node.getString().getText()) {
            @Override
            public String getString() {
                return getValue();
            }

            @Override
            public void apply(IModel model) {
                model.caseString(getValue());
            }
        });
    }

    @Override
    public void outATypeElement(ATypeElement node) {
        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        push(new AbstractPushable<TypeDescriptor<?>>(typeInterpreter.getValue()) {

            @Override
            public TypeDescriptor<?> getTypeDescriptor() {
                return getValue();
            }

            @Override
            public void apply(IModel model) {
                model.caseTypeDescriptor(getValue());
            }
        });

    }

    @Override
    public void outANumberElement(ANumberElement node) {
        push(new AbstractPushable<Integer>(Integer.parseInt(node.getNumber().getText())) {
            @Override
            public Integer getInteger() {
                return getValue();
            }

            @Override
            public void apply(IModel model) {
                model.caseInteger(getValue());
            }
        });
    }

    @Override
    public void outAObjectElement(AObjectElement node) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (int i = 0; i < node.getObjectEl().size(); i++) {
            AbstractMap.SimpleEntry<Object, Object> entry = pop().getSimpleEntry();
            hashMap.put(entry.getKey(), entry.getValue());
        }
        push(new AbstractPushable<HashMap<Object, Object>>(hashMap) {
            @Override
            public HashMap<Object, Object> getHashMap() {
                return getValue();
            }

            @Override
            public void apply(IModel model) {
                model.caseHashMap(getValue());
            }
        });
    }

    @Override
    public void outAObjectEl(AObjectEl node) {
        push(new AbstractPushable<HashMap.SimpleEntry>(new HashMap.SimpleEntry<Object, Object>(
                pop().getValue(),
                pop().getValue())) {
            @Override
            public AbstractMap.SimpleEntry<Object, Object> getSimpleEntry() {
                return getValue();
            }
        });
    }
}