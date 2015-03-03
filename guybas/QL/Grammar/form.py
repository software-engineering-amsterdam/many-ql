# Grammar of form

import pyparsing as pp
from QL.Grammar.expressions import *
from QL.Factory.forms import *
from QL.Grammar.basic_types import *


class FormFormat:

    # id :: characters
    id = BasicTypes.characters

    # label :: sentence
    label = BasicTypes.sentence

    # answerR :: "bool" | "number" | "text"
    answerR = pp.Literal(BasicTypes.bool_name) | pp.Literal(BasicTypes.number_name) | pp.Literal(BasicTypes.text_name)

    # question :: Question id ( answerR ) : label
    question = \
        (pp.Suppress("Question") + id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + label
         ).setParseAction(FormFactory.make_question)

    # _statements   :: question+
    questions = pp.OneOrMore(question)
    
    statement = pp.Forward()

    # condition :: expr
    condition = Expressions.expr

    # pIf :: if ( condition ) { statement+ }
    pIf = \
        (pp.Suppress("if" + pp.Literal("(")) + condition + pp.Suppress(")") + pp.Suppress("{") +
         pp.OneOrMore(statement) + pp.Suppress("}")).setParseAction(FormFactory.make_if)

    # pIfElse :: if ( condition ) { statement+ } else { statement+ }
    pIfElse = \
        ((pp.Suppress("if" + pp.Literal("(")) + condition + pp.Suppress(")") + pp.Suppress("{") +
          pp.OneOrMore(statement) + pp.Suppress("}")) + pp.Literal("else") + pp.Suppress("{") + statement + pp.Suppress("}")
         ).setParseAction(FormFactory.make_else)

    # assignment ::
    assignment = \
        (pp.Suppress("Assignment") + id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + Expressions.expr
        ).setParseAction(FormFactory.make_assignment)

    # statement :: pIfElse | pIf | statements
    statement <<= \
        pIfElse | \
        pIf | \
        questions | \
        assignment

    # introduction :: Introduction : sentences
    introduction = (pp.Group(pp.Suppress("Introduction" + pp.Literal(":")) + BasicTypes.sentences))

    # form :: id _introduction? statement+
    form = (id + pp.Optional(introduction) + pp.Group(pp.OneOrMore(statement))) + pp.StringEnd()
