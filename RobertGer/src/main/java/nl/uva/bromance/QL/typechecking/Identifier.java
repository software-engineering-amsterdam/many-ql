package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.exceptions.DuplicateIdentifierException;
import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.unary.Primitive;

import java.util.List;

public class Identifier {
    private final String identifier;
    private final Primitive type;
    private int line;

    public Identifier(String identifier, Primitive type, int line) {

        this.identifier = identifier;
        this.type = type;
        this.line = line;
    }

    public void addDuplicateExceptionToExceptionList(List<QLError> exceptions) {
        exceptions.add(new DuplicateIdentifierException("Apparently you have defined identical identifiers named: " + identifier + ". Please look at line: " + line));
    }

    public boolean compareIdentifier(String identifier){
        return identifier == this.identifier;
    }

    //I realize that comparing classes is not desirable however I couldn't think of another way to compare types.
    public boolean compareType(Primitive type)
    {
        return type.getClass() == this.type.getClass();
    }
}
