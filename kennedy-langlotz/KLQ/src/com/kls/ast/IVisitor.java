package com.kls.ast;

import com.kls.ast.node.*;

/**
 * Created by Timon on 03.03.2015.
 */
public interface IVisitor<T> {

    T visit(StylesheetNode stylesheetNode);

    T visit(PageNode pageNode);

    T visit(SectionNode sectionNode);

    T visit(QuestionNode questionNode);

    T visit(DefaultNode defaultNode);

    T visit(DeclarationNode declarationNode);

    T visit(PropertyNode propertyNode);

    T visit(ValueNode valueNode);

}
