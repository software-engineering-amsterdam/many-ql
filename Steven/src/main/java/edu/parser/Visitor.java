package edu.parser;

import edu.parser.nodes.QuestionType;

/**
 * Created by Steven Kok on 3/2/2015.
 */
public interface Visitor {
    AbstractNode visit(QuestionType questionType);
}
