# Grammar of forms

import pyparsing as pp
import QL.Factory.forms as form_factory
import QL.Grammar.constants as constants
import QL.Factory.expressions as expression_factory

    
# end_sign :: . | ? | !
end_sign = pp.oneOf(". ? !")

# end_sign_esc :: \ end_sign
end_sign_esc = pp.Suppress("\\") + end_sign

# characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_]
characters = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*-+=/\'\"`~_") | pp.Word(",")

# word :: end_sign_esc | characters
word = end_sign_esc | characters

# sentence :: word+ end_sign
sentence = (pp.OneOrMore(word) + end_sign).setParseAction(form_factory.make_sentence)

# sentences :: sentence+
sentences = pp.OneOrMore(sentence)

# comment :: // ....\n  | /* .... */
comment = pp.Literal("//") + pp.restOfLine | pp.cStyleComment

# statement_id :: [1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_]
statement_id_var = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")

# bool :: True | False
bool = pp.Literal("True") | pp.Literal("False")

# text
text = pp.Suppress("\"") + pp.OneOrMore(pp.Word(pp.alphanums)) + pp.Suppress("\"")

# number :: [0-9]
number = pp.Word(pp.nums)

# value :: bool | number | statement_id | text
value = (bool.setParseAction(expression_factory.make_bool) |
         number.setParseAction(expression_factory.make_number) |
         statement_id_var.setParseAction(expression_factory.make_variable) |
         text.setParseAction(expression_factory.make_text))


############
not_op = pp.Literal("!").setParseAction(expression_factory.make_operator)
mul_op = pp.oneOf('* /').setParseAction(expression_factory.make_operator)
plus_op = pp.oneOf('+ -').setParseAction(expression_factory.make_operator)
comp_op = pp.oneOf('> >= == < <=').setParseAction(expression_factory.make_operator)
extra_op = pp.oneOf('&& ||').setParseAction(expression_factory.make_operator)

expr = pp.infixNotation\
        (value,
         [(not_op, 1, pp.opAssoc.RIGHT),
             (mul_op, 2, pp.opAssoc.LEFT),
             (plus_op, 2, pp.opAssoc.LEFT),
             (comp_op, 2, pp.opAssoc.RIGHT),
             (extra_op, 2, pp.opAssoc.LEFT)
         ]
    ).setParseAction(expression_factory.make_expression)
############

# _id :: characters
statement_id = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")

# answerR :: "bool" | "number" | "text"
answerR = (pp.Literal(constants.GrammarConstants.BOOL).setParseAction(form_factory.make_bool_type) |
           pp.Literal(constants.GrammarConstants.NUMBER).setParseAction(form_factory.make_number_type) |
           pp.Literal(constants.GrammarConstants.TEXT).setParseAction(form_factory.make_text_type))

# q :: Question _id ( answerR ) : _label
question = (pp.Suppress("Question") + statement_id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + sentence
            ).setParseAction(form_factory.make_question)

# _statements :: question+
questions = pp.OneOrMore(question)

statement = pp.Forward()

# pIf :: if ( _condition ) { statement+ }
pIf = (pp.Suppress("if" + pp.Literal("(")) + expr + pp.Suppress(")") + pp.Suppress("{") +
       pp.OneOrMore(statement) + pp.Suppress("}")
       ).setParseAction(form_factory.make_if)

# pIfElse :: if ( _condition ) { statement+ } else { statement+ }
pIfElse = ((pp.Suppress("if" + pp.Literal("(")) + expr + pp.Suppress(")") + pp.Suppress("{") +
            pp.OneOrMore(statement) + pp.Suppress("}")) + pp.Literal("else") + pp.Suppress("{") +
            statement + pp.Suppress("}")
           ).setParseAction(form_factory.make_else)

# assignment :: Assignment _id ( answerR ) : expr
assignment = (pp.Suppress("Assignment") + statement_id + pp.Suppress("(") + answerR + pp.Suppress(")") +
              pp.Suppress(":") + expr
              ).setParseAction(form_factory.make_assignment)

# statement :: pIfElse | pIf | questions | assignment
statement <<= (pIfElse |
               pIf |
               questions |
               assignment)

# introduction :: Introduction : sentences
introduction = (pp.Group(pp.Suppress("Introduction" + pp.Literal(":")) + sentences))

# grammar :: statement_id introduction? statement+
form = (statement_id + pp.Optional(introduction) + pp.Group(pp.OneOrMore(statement)))
