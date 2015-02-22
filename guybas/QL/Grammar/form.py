# Grammar of form

from Grammar.expressions import *


class FormFormat:

    # id :: characters
    id = BasicTypes.characters

    # label :: sentence
    label = BasicTypes.sentence

    # answerR :: "bool" | "number" | "text"
    answerR = Literal(BasicTypes.bool_name) | Literal(BasicTypes.number_name) | Literal(BasicTypes.text_name)

    # question :: Question id ( answerR ) : label
    question = \
        (Suppress("Question") + id + Suppress("(") + answerR + Suppress(")") + Suppress(":") + label
         ).setParseAction(FormFactory.make_question)

    # statements   :: question+
    questions = OneOrMore(question)
    
    statement = Forward()

    # condition :: condition
    condition = Expressions.condition

    # pIf :: if ( condition ) { statement+ }
    pIf = \
        (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
         OneOrMore(statement) + Suppress("}")).setParseAction(FormFactory.make_if)

    # pIfElse :: if ( condition ) { statement+ } else { statement+ }
    pIfElse = \
        ((Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
          OneOrMore(statement) + Suppress("}")) + Literal("else") + Suppress("{") + statement + Suppress("}")
         ).setParseAction(FormFactory.make_else)

    # statement :: pIfElse | pIf | statements
    statement <<= \
        pIfElse | \
        pIf | \
        questions

    # introduction :: Introduction : sentences
    introduction = (Group(Suppress("Introduction" + Literal(":")) + BasicTypes.sentences))

    # form :: id introduction? statement+
    form = (id + Optional(introduction) + OneOrMore(statement))
