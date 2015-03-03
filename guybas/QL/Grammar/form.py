# Grammar of form

from pyparsing import Group, Optional
from QL.Grammar.expressions import *
from QL.Factory.forms import *
from QL.Grammar.basic_types import *


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

    # _statements   :: question+
    questions = OneOrMore(question)
    
    statement = Forward()

    # condition :: expr
    condition = Expressions.expr

    # pIf :: if ( condition ) { statement+ }
    pIf = \
        (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
         OneOrMore(statement) + Suppress("}")).setParseAction(FormFactory.make_if)

    # pIfElse :: if ( condition ) { statement+ } else { statement+ }
    pIfElse = \
        ((Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
          OneOrMore(statement) + Suppress("}")) + Literal("else") + Suppress("{") + statement + Suppress("}")
         ).setParseAction(FormFactory.make_else)

    # assignment ::
    assignment = \
        (Suppress("Assignment") + id + Suppress("(") + answerR + Suppress(")") + Suppress(":") + Expressions.expr
        ).setParseAction(FormFactory.make_assignment)

    # statement :: pIfElse | pIf | statements
    statement <<= \
        pIfElse | \
        pIf | \
        questions | \
        assignment

    # introduction :: Introduction : sentences
    introduction = (Group(Suppress("Introduction" + Literal(":")) + BasicTypes.sentences))

    # form :: id _introduction? statement+
    form = (id + Optional(introduction) + Group(OneOrMore(statement))) + stringEnd()
