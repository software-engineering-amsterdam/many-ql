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
    AbstractNode accept(Stylesheet stylesheet);

    AbstractNode accept(Page page);

    AbstractNode accept(Style style);

    AbstractNode accept(Question question);

    AbstractNode accept(Identifier identifier);

    AbstractNode accept(Section section);

    AbstractNode accept(Default aDefault);

    AbstractNode accept(QuestionType questionType);
}
