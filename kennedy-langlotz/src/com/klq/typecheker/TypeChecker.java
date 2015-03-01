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

    private void firstPass(){
        QuestionTable table = new QuestionTable(errors);
        QuestionMapper mapper = new QuestionMapper(table);
        ast.accept(mapper);
    }

    private void secondPass(){
        TypeCheckerVisitor visitor = new TypeCheckerVisitor(errors);
        ast.accept(visitor);
    }

    public void run(){
        firstPass();
        secondPass();
    }
    //Just a temporary method, this logic should not be in here.
    public void reportErrors(){
        run();
        if(errors.size() > 0){
            for(AError error : errors){
                System.out.println(error.toString());
            }
            System.exit(0);
        }
    }

    public ArrayList<AError> getErrors() {
        return errors;
    }
}
