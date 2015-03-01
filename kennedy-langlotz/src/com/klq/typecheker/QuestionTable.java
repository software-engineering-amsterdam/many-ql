package com.klq.typecheker;

import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;
import com.klq.typecheker.error.AError;
import com.klq.typecheker.error.NotUniqueID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class QuestionTable {
    private Map<String, QuestionNode> table;
    private ArrayList<AError> errors;

    public QuestionTable(ArrayList<AError> errors) {
        this.errors = errors;
        table = new HashMap<String, QuestionNode>();
    }

    public void add(String questionId, QuestionNode node){
        if(table.containsKey(questionId)){
            errors.add(new NotUniqueID(node));
        }
        else{
            table.put(questionId, node);
        }
    }
}
