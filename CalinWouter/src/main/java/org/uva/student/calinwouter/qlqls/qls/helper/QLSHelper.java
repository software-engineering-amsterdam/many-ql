package org.uva.student.calinwouter.qlqls.qls.helper;

import org.uva.student.calinwouter.qlqls.generated.lexer.Lexer;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.AStylesheetBegin;
import org.uva.student.calinwouter.qlqls.generated.node.Start;
import org.uva.student.calinwouter.qlqls.generated.parser.Parser;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractStaticFormField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.QLSTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.exceptions.CouldNotFindMatchingQLSComponentException;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSTypeCheckResults;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class QLSHelper {

    public static StyleSheet interpretStylesheetString(String input) throws ParserException, IOException, LexerException, CouldNotFindMatchingQLSComponentException {
        final Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        final Parser parser = new Parser(lexer);
        final Start ast = parser.parse();
        final QLSInterpreter qlsInterpreter = new QLSInterpreter();
        return qlsInterpreter.interpret((AStylesheetBegin) ast.getPBegin());
    }

    /**
     * FieldTypes contain the same collection as StaticFields but with less overhead.
     */
    private static List<FieldType> toFieldTypes(StaticFields staticFields) {
        final List<FieldType> fieldTypes = new LinkedList<FieldType>();
        for (AbstractStaticFormField staticFormField : staticFields) {
            final String variable = staticFormField.getVariable();
            final ITypeDescriptor typeDescriptor = staticFormField.getTypeDescriptor();
            final FieldType fieldType = new FieldType(variable, typeDescriptor);
            fieldTypes.add(fieldType);
        }
        return fieldTypes;
    }

    public static QLSTypeCheckResults typeCheckStyleSheet(StyleSheet styleSheet, StaticFields staticFields) {
        return typeCheckStyleSheet(styleSheet, toFieldTypes(staticFields));
    }

    public static QLSTypeCheckResults typeCheckStyleSheet(StyleSheet styleSheet, List<FieldType> fieldTypes) {
        final QLSTypeChecker qlsTypeChecker = new QLSTypeChecker(styleSheet, fieldTypes);
        return qlsTypeChecker.typeCheck();
    }

}
