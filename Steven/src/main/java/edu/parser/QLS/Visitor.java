package edu.parser.QLS;

import edu.parser.AbstractNode;
import edu.parser.QLS.nodes.*;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Question;
import edu.parser.QLS.nodes.styles.Style;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public interface Visitor {
    AbstractNode visit(Stylesheet stylesheet);

    AbstractNode visit(Page page);

    AbstractNode visit(Style style);

    AbstractNode visit(Question question);

    AbstractNode visit(Identifier identifier);

    AbstractNode visit(Section section);

    AbstractNode visit(Default aDefault);

    AbstractNode visit(QuestionType questionType);
}
