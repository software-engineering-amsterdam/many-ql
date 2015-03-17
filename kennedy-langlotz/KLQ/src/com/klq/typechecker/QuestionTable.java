package com.klq.typechecker;

import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.Type;
import com.klq.typechecker.error.AError;
import com.klq.typechecker.error.NotUniqueID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class QuestionTable {
    private Map<IdentifierNode, QuestionNode> table;

    public QuestionTable() {
        table = new HashMap<>();
    }

    public void add(IdentifierNode questionId, QuestionNode node){
        table.put(questionId, node);
    }

    public QuestionNode get(IdentifierNode questionId){
        return table.get(questionId);
    }

    public boolean has(IdentifierNode questionId){
        return table.containsKey(questionId);
    }

    public Type getQuestionType(IdentifierNode questionId){
        return table.get(questionId).getType();
    }
}
