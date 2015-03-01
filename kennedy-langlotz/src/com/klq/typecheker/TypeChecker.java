package com.klq.typecheker;

import com.klq.ast.ANode;
import com.klq.typecheker.error.AError;

import java.util.ArrayList;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class TypeChecker {
    private ArrayList<AError> errors;
    private ANode ast;

    public TypeChecker(ANode ast){
        errors = new ArrayList<AError>();
        this.ast = ast;
    }

    public void firstPass(){
        QuestionTable table = new QuestionTable(errors);
        QuestionMapper mapper = new QuestionMapper(table);
        ast.accept(mapper);
    }

    public ArrayList<AError> getErrors() {
        return errors;
    }
}
