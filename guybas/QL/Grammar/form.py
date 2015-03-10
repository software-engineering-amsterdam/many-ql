# Grammar of forms

import pyparsing as pp
import QL.Grammar.expression as expressions
import QL.Factory.forms as forms
import QL.Grammar.basic_types as basic_types
import QL.Grammar.constants as constants


class Form:

    # _id :: characters
    id = basic_types.BasicTypes.characters

    # _label :: sentence
    label = basic_types.BasicTypes.sentence

    # answerR :: "bool" | "number" | "text"
    answerR = (pp.Literal(constants.GrammarConstants.BOOL).setParseAction(forms.FormFactory.make_bool_type) |
               pp.Literal(constants.GrammarConstants.NUMBER).setParseAction(forms.FormFactory.make_number_type) |
               pp.Literal(constants.GrammarConstants.TEXT).setParseAction(forms.FormFactory.make_text_type))

    # q :: Question _id ( answerR ) : _label
    question = (pp.Suppress("Question") + id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + label
                ).setParseAction(forms.FormFactory.make_question)

    # _statements :: question+
    questions = pp.OneOrMore(question)
    
    statement = pp.Forward()

    # _condition :: expr
    condition = expressions.Expressions.expr

    # pIf :: if ( _condition ) { statement+ }
    pIf = (pp.Suppress("if" + pp.Literal("(")) + condition + pp.Suppress(")") + pp.Suppress("{") +
           pp.OneOrMore(statement) + pp.Suppress("}")
           ).setParseAction(forms.FormFactory.make_if)

    # pIfElse :: if ( _condition ) { statement+ } else { statement+ }
    pIfElse = ((pp.Suppress("if" + pp.Literal("(")) + condition + pp.Suppress(")") + pp.Suppress("{") +
                pp.OneOrMore(statement) + pp.Suppress("}")) + pp.Literal("else") + pp.Suppress("{") +
                statement + pp.Suppress("}")
               ).setParseAction(forms.FormFactory.make_else)

    # assignment :: Assignment _id ( answerR ) : expr
    assignment = (pp.Suppress("Assignment") + id + pp.Suppress("(") + answerR + pp.Suppress(")") +
                  pp.Suppress(":") + expressions.Expressions.expr
                  ).setParseAction(forms.FormFactory.make_assignment)

    # statement :: pIfElse | pIf | questions | assignment
    statement <<= (pIfElse |
                   pIf |
                   questions |
                   assignment)

    # introduction :: Introduction : sentences
    introduction = (pp.Group(pp.Suppress("Introduction" + pp.Literal(":")) + basic_types.BasicTypes.sentences))

    # form :: id introduction? statement+
    form = (id + pp.Optional(introduction) + pp.Group(pp.OneOrMore(statement))) + pp.StringEnd()
