package parser.ast.nodes.question;

import exceptions.NoSuchType;
import parser.ast.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public enum QuestionType implements AbstractNode {
    STRING(), INTEGER(), BOOLEAN(), DATE(), MONEY(), DECIMAL();



}
