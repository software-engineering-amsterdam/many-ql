package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.SymbolTable;
import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.Form;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;

import java.util.LinkedList;

public class StmtInterpreter extends AnalysisAdapter{
    private SymbolTable symbolTable;
    private Form form;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        if (symbolTable.getVariable(node.getIdent().getText()) == null) {
            symbolTable.setVariable(node.getIdent().getText(), typeInterpreter.getValue().getDefaultValue());
        }
        form.addFormField(new QuestionField(node.getStr().getText(), node.getIdent().getText(), typeInterpreter.getValue()));
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(symbolTable);
        // TODO it may crash here if not all fields are correctly set.
        try {
            node.getExp().apply(expInterpreter);
        } catch (Exception e) {
            symbolTable.setVariable(node.getIdent().getText(), null);
            return;
        }
        symbolTable.setVariable(node.getIdent().getText(),
                expInterpreter.getValue());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);

        form.addFormField(new ComputedValueField(node.getStr().getText(), node.getIdent().getText(), typeInterpreter.getValue()));
    }

    protected StmtInterpreter createStmtInterpreter() {
        return new StmtInterpreter(symbolTable, form);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(symbolTable);
        node.getExp().apply(expInterpreter);
        if (expInterpreter.getValue().getValue() == Boolean.TRUE) {
            executeStmtList(node.getThenStmtList());
        } else {
            executeStmtList(node.getElseStmtList());
        }
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(symbolTable);
        node.getExp().apply(expInterpreter);
        if (expInterpreter.getValue().getValue() == Boolean.TRUE) {
            executeStmtList(node.getThenStmtList());
        }
    }

    protected void executeStmtList(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(createStmtInterpreter());
        }
    }

    public StmtInterpreter(SymbolTable symbolTable, Form form) {
        this.symbolTable = symbolTable;
        this.form = form;
    }

}