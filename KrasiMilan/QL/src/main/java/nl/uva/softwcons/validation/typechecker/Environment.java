package nl.uva.softwcons.validation.typechecker;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ast.type.Type;

public class Environment {

    private final Map<String, Type> identifiers;

    public Environment() {
        this.identifiers = new HashMap<>();
    }

    /**
     * Returns the type of the given variable or UNDEFINED if the variable is
     * not present in the environment.
     * 
     * @param variableName
     * @return the type of the given variable
     */
    public Type resolveVariable(final String variableName) {
        return this.identifiers.getOrDefault(variableName, Type.UNDEFINED);
    }

    public void defineVariable(final String variableName, final Type variableType) {
        this.identifiers.put(variableName, variableType);
    }
}
