package com.kls.typechecker;

import com.klq.typecheker.error.AError;
import com.klq.typecheker.error.NotUniqueID;
import com.kls.ast.IVisitor;
import com.kls.ast.node.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 07.03.2015.
 */
public class Typechecker implements IVisitor<ANodeBase> {
    private final List<AError> errors;

    private final List<String> questionIds;

    public Typechecker() {
        this.errors = new ArrayList<>();
        this.questionIds = new ArrayList<>();
    }

    @Override
    public ANodeBase visit(StylesheetNode stylesheetNode) {
        return null;
    }

    @Override
    public ANodeBase visit(PageNode pageNode) {
        return null;
    }

    @Override
    public ANodeBase visit(SectionNode sectionNode) {
        return null;
    }

    @Override
    public ANodeBase visit(QuestionNode questionNode) {
        String id = questionNode.getIdentifier();
        if (questionIds.contains(id)){
            //NotUniqueID idError = new NotUniqueID(questionNode);
        }
        return null;
    }

    @Override
    public ANodeBase visit(DefaultNode defaultNode) {
        return null;
    }

    @Override
    public ANodeBase visit(DeclarationNode declarationNode) {
        return null;
    }

    @Override
    public ANodeBase visit(PropertyNode propertyNode) {
        return null;
    }

    @Override
    public ANodeBase visit(ValueNode valueNode) {
        return null;
    }
}
