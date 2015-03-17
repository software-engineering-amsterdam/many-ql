package com.klq.typechecker;

import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.typechecker.error.AError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class TypeChecker {
    private List<AError> errors;
    private QuestionnaireNode ast;

    public TypeChecker(QuestionnaireNode ast){
        errors = new ArrayList<>();
        this.ast = ast;
        run();
    }

    private QuestionTable firstPass(){
        QuestionMapper mapper = new QuestionMapper(errors);
        ast.accept(mapper);
        return mapper.getTable();
    }

    private void secondPass(QuestionTable table){
        TypeCheckerVisitor visitor = new TypeCheckerVisitor(errors, table);
        ast.accept(visitor);
    }

    public void run(){
        secondPass(firstPass());
    }

    public boolean stopApplication(){
        boolean answer = false;
        for(AError error : errors){
            answer = error.getStopRunning();
        }
        return answer;
    }

    public void printErrors(){
        for(AError error : errors){
            System.out.println(error.toString());
        }
    }

    public List<AError> getErrors() {
        return errors;
    }
}
