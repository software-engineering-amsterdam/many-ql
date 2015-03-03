# Grammar of form

import pyparsing as pp
import QL.Grammar.expressions as expressions
import QL.Factory.forms as forms
import QL.Grammar.basic_types as basic_types


class FormFormat:

    # id :: characters
    id = basic_types.BasicTypes.characters

    # label :: sentence
    label = basic_types.BasicTypes.sentence

    # answerR :: "bool" | "number" | "text"
    answerR = pp.Literal(basic_types.BasicTypes.bool_name) | pp.Literal(basic_types.BasicTypes.number_name) | pp.Literal(basic_types.BasicTypes.text_name)

    # q :: Question id ( answerR ) : label
    question = \
        (pp.Suppress("Question") + id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + label
         ).setParseAction(forms.FormFactory.make_question)

    # _statements   :: q+
    questions = pp.OneOrMore(question)
    
    statement = pp.Forward()

    # condition :: expr
    condition = expressions.Expressions.expr

    # pIf :: if ( condition ) { statement+ }
    pIf = \
        (pp.Suppress("if" + pp.Literal("(")) + condition + pp.Suppress(")") + pp.Suppress("{") +
         pp.OneOrMore(statement) + pp.Suppress("}")).setParseAction(forms.FormFactory.make_if)

    # pIfElse :: if ( condition ) { statement+ } else { statement+ }
    pIfElse = \
        ((pp.Suppress("if" + pp.Literal("(")) + condition + pp.Suppress(")") + pp.Suppress("{") +
          pp.OneOrMore(statement) + pp.Suppress("}")) + pp.Literal("else") + pp.Suppress("{") + statement + pp.Suppress("}")
         ).setParseAction(forms.FormFactory.make_else)

    # assignment ::
    assignment = \
        (pp.Suppress("Assignment") + id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + expressions.Expressions.expr
        ).setParseAction(forms.FormFactory.make_assignment)

    # statement :: pIfElse | pIf | statements
    statement <<= \
        pIfElse | \
        pIf | \
        questions | \
        assignment

    # introduction :: Introduction : sentences
    introduction = (pp.Group(pp.Suppress("Introduction" + pp.Literal(":")) + basic_types.BasicTypes.sentences))

    # form :: id _introduction? statement+
    form = (id + pp.Optional(introduction) + pp.Group(pp.OneOrMore(statement))) + pp.StringEnd()
