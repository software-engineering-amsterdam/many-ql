package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.generated.analysis.ReversedDepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.ql.interpreter.types.TypeModel;
import org.uva.student.calinwouter.qlqls.qls.components.IComponent;
import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;
import org.uva.student.calinwouter.qlqls.qls.types.PopAction;

import java.io.IOException;
import java.util.*;

/*
ident_list
    = {empty}       ident
    | {filled}      ident element*
    ;
element
    = {type}        type
    | {ident}       ident
    | {hex}         hex
    | {string}      string
    | {number}      number
    | {object}      object_el*
    | {list}        ident_list
    ;
object_el
    = [key]:element [value]:element
    ;
 */
public class QLSInterpreter extends ReversedDepthFirstAdapter {
    private final static String COMPONENTS_PACKAGE_PREFIX =
            QLSInterpreter.class.getPackage().getName().toString() + ".components.";

    private Stack<AbstractPushable<?>> argumentStack = new Stack<AbstractPushable<?>>();

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
    public AbstractPushable<?> interopComponent(String componentName, Object... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = COMPONENTS_PACKAGE_PREFIX + componentName.substring(0, 1).toUpperCase()
                + componentName.substring(1);
//        System.out.println(className);
        Class<IComponent> cls = (Class<IComponent>) Class.forName(className);
        IComponent component = cls.newInstance();
        return component.interop(args);
    }

    @Override
    public void outAEmptyIdentList(AEmptyIdentList node) {
        push(new AbstractPushable<Object[]>(new Object[0]) {
            @Override
            public Object[] getObjectArray() {
                return getValue();
            }
        });
    }

    @Override
    public void outAFilledIdentList(AFilledIdentList node) {
            ArrayList<Object> values = new ArrayList<Object>();
            System.out.println("size: " + node.getElement().size());
            for (int i = 0; i < node.getElement().size(); i++)
                values.add(pop().getValue());
        try {
            push(interopComponent(node.getIdent().getText(), values.toArray()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outATypeElement(ATypeElement node) {
        TypeInterpreter t = new TypeInterpreter();
        node.getType().apply(t);
        push(new AbstractPushable<TypeDescriptor<?>>(t.getValue()) {
            @Override
            public TypeDescriptor<?> getTypeDescriptor() {
                return getValue();
            }
        });
    }

    @Override
    public void outAIdentElement(AIdentElement node) {
        System.out.println("ident");
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
        });
    }

    @Override
    public void outAStringElement(AStringElement node) {
        push(new AbstractPushable<String>(node.getString().getText()) {
            @Override
            public String getString() {
                return getValue();
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
        });
    }

    @Override
    public void outAObjectElement(AObjectElement node) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        ArrayList<HashMap.SimpleEntry<Object, Object>> values =
                new ArrayList<HashMap.SimpleEntry<Object, Object>>();
        for (int i = 0; i < node.getObjectEl().size(); i++)
            hashMap.put(pop().getValue(), pop().getValue());
    }

    @Override
    public void outAListElement(AListElement node) {
//        node.get
//        push(null); // TODO
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

    public static void main(String[] args) throws ParserException, IOException, LexerException {
        String input = "styleSheet(taxOfficeExample," +
                "" +
                "\tpage(Housing,\n" +
                        "\t\tsection(Buying,\n" +
                        "\t\t\tquestion(hasBoughtHouse, {widget: checkbox})),\n" +
                        "\t\tsection(Loaning,\n" +
                        "\t\t\tquestion(hasMaintLoan))\n" +
                        "\t), page(Selling,\n" +
                        "\t\tsection(Selling,\n" +
                        "\t\t\tquestion(hasSoldHouse, {widget: radio(\"Yes\", \"No\")})), \n" +
                        "\t\tsection(\"You sold a house\",\n" +
                        "\t\t\tquestion(sellingPrice, {widget: spinbox}),\n" +
                        "\t\t\tquestion(privateDebt, {widget: spinbox}),\n" +
                        "\t\t\tquestion(valueResidue)),\n" +
                        "\t\tdefault(integer, {\n" +
                        "\t\t\twidth: 400,\n" +
                        "\t\t\tfont: \"Arial\",\n" +
                        "\t\t\tfontsize: 14,\n" +
                        "\t\t\tcolor: #999999,\n" +
                        "\t\t\twidget: spinbox\n" +
                        "\t\t})\n" +
                        "\t), default(boolean, {widget: radio(\"Yes\", \"No\")})\n" +
                        ")";

        InterpreterHelper.interpetStylesheetString(input);
    }
}
