package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.Node;

public class TypeCheckingException extends Exception {

    public TypeCheckingException(String message) {
        super(message);
    }

    public static class QuestionRangeTypeCheckingException extends TypeCheckingException {
        public QuestionRangeTypeCheckingException(String message) {
            super(message);
        }
    }

    public static class AlreadyDefinedTypeCheckingException extends TypeCheckingException {
        public AlreadyDefinedTypeCheckingException(Node node, String identifier) {
            super("TypeChecker Error @ line " + node.getLineNumber() + ":" + node.getClass().getSimpleName() + " " + identifier + " was already defined with a different type.");
        }

    }

    public static class NoIdentifierDefinedTypeCheckingException extends TypeCheckingException {
        public NoIdentifierDefinedTypeCheckingException(int lineNumber) {
            super("TypeChecker Error @ line " + lineNumber + "no identifier defined.");
        }
    }

}
