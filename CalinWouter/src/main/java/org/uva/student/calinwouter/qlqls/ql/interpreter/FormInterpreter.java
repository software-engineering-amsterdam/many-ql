package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.SymbolTable;
import org.uva.student.calinwouter.qlqls.ql.model.Form;

import java.util.LinkedList;


public class FormInterpreter extends AnalysisAdapter {
    private Form form;
    private SymbolTable symbolTable;

    protected StmtInterpreter createStmtInterpreter() {
        return new StmtInterpreter(symbolTable, form);
    }

    @Override
    public void caseAForm(AForm aForm) {
        LinkedList<PStmt> stmts = aForm.getStmt();
        for (PStmt stmt : stmts) {
            stmt.apply(createStmtInterpreter());
        }
    }

    public FormInterpreter(SymbolTable symbolTable, Form form) {
        this.form = form;
        this.symbolTable = symbolTable;
    }
}