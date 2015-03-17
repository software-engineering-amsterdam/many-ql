package com.klq.controller;

import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.value.UndefinedValue;
import com.klq.ast.impl.value.Value;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timon on 17.03.2015.
 */
public class VariableTable {
    private final Map<IdentifierNode, Value> variables;

    public VariableTable() {
        this.variables = new HashMap<>();
    }

    public void add(IdentifierNode id) {
        assert (!variables.containsKey(id)): "Identifier already exists in Store.";
        variables.put(id, new UndefinedValue());
    }

    public void update(IdentifierNode id, @NotNull Value value){
        assert (variables.containsKey(id)): "Identifierts need to be added before updating them.";
        variables.put(id, value);
    }

    public boolean contains(IdentifierNode id) {
        return variables.containsKey(id);
    }

    public Value get(IdentifierNode id) {
        return variables.get(id);
    }
}
