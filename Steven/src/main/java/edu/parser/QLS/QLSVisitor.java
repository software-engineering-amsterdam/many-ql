package edu.parser.QLS;

import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.nodes.Identifier;
import edu.parser.QLS.nodes.Section;
import edu.parser.QLS.nodes.Stylesheet;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;
import edu.parser.QLS.nodes.statement.QLSQuestion;
import edu.parser.nodes.styles.Style;
import edu.parser.nodes.QuestionType;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public interface QLSVisitor {
    AbstractNode visit(Stylesheet stylesheet);

    AbstractNode visit(Page page);

    AbstractNode visit(QLSQuestion question);

    AbstractNode visit(Identifier identifier);

    AbstractNode visit(Section section);

    AbstractNode visit(Default aDefault);

    AbstractNode visit(QuestionType questionType);

    AbstractNode visit(Style style);
}
