package com.kls.typechecker;

import com.common.ast.Location;
import com.common.typechecker.error.AError;
import com.common.typechecker.error.NotUniqueID;
import com.common.typechecker.error.UnexpectedValue;
import com.kls.ast.IVisitor;
import com.kls.ast.node.*;
import com.kls.ast.node.property.AProperty;
import com.kls.ast.node.value.AValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 07.03.2015.
 */
public class Typechecker implements IVisitor<Void> {
    private final List<AError> errors;
    private final List<String> questionIds;

    public Typechecker() {
        this.errors = new ArrayList<>();
        this.questionIds = new ArrayList<>();
    }

    @Override
    public Void visit(StylesheetNode stylesheetNode) {
        for (AGroupNodeBase groupNodeBase : stylesheetNode.getGroups()) {

        }
        return null;
    }

    @Override
    public Void visit(PageNode pageNode) {
        return null;
    }

    @Override
    public Void visit(SectionNode sectionNode) {
        return null;
    }

    @Override
    public Void visit(QuestionNode questionNode) {
        String id = questionNode.getIdentifier();
        if (questionIds.contains(id)){
            Location location = questionNode.getLocation();
            NotUniqueID idError = new NotUniqueID(id, location);
            errors.add(idError);
        } else {
            questionIds.add(id);
        }
        for (DeclarationNode declaration : questionNode.getDeclarations()) {
            visit(declaration);
        }
        return null;
    }

    @Override
    public Void visit(DefaultNode defaultNode) {
        return null;
    }

    @Override
    public Void visit(DeclarationNode declarationNode) {
        AProperty property = declarationNode.getProperty().getProperty();
        AValue value = declarationNode.getValue().getValue();

        if (!property.isCompatibleWith(value)){
            AError unexpectedValue = new UnexpectedValue(property, value, declarationNode.getLocation());
            errors.add(unexpectedValue);
        }

        return null;
    }


    @Override
    public Void visit(PropertyNode propertyNode) {
        return null;
    }

    @Override
    public Void visit(ValueNode valueNode) {
        return null;
    }
}
