# Grammar of forms

import pyparsing as pp
import QL.Grammar.Factory.forms as form_factory
import QL.Grammar.Factory.expressions as expression_factory

#
# basic types
#

# end terminal of a sentence
end_sign = pp.oneOf(". ? !")

# escape end-terminals to make them able in texts
end_sign_esc = pp.Suppress("\\") + end_sign

# characters allowed in sentences
characters = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*-+=/\'\"`~_") | pp.Word(",")
word = end_sign_esc | characters
sentence = (pp.OneOrMore(word) + end_sign).setParseAction(form_factory.make_sentence)
sentences = pp.OneOrMore(sentence)

# comment :: // ....\n  | /* .... */
comment = pp.Literal("//") + pp.restOfLine | pp.cStyleComment

# values allowed in expressions: bool, number, id or text
id_characters = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")
boolean = pp.Literal("True") | pp.Literal("False")
text = pp.Suppress("\"") + pp.OneOrMore(pp.Word(pp.alphanums)) + pp.Suppress("\"")
number = pp.Word(pp.nums)
value = (boolean.setParseAction(expression_factory.make_bool) |
         number.setParseAction(expression_factory.make_number) |
         id_characters.setParseAction(expression_factory.make_variable) |
         text.setParseAction(expression_factory.make_text))


#
# expressions
#

not_op = pp.Literal("not")
mul_op = pp.oneOf('* /')
plus_op = pp.oneOf('+ -')
comp_op = pp.oneOf('> >= == < <=')
extra_op = pp.oneOf('and or')

# expr uses the above operators in the following order and associations
# 1 means it binds to one operand, 2 means it binds to two operands
# pyparsing doesn't support non-associative so left is chosen
expr = pp.infixNotation(value,
         [(not_op, 1, pp.opAssoc.RIGHT, expression_factory.make_not),
          (mul_op, 2, pp.opAssoc.LEFT, expression_factory.make_mul_expression),
          (plus_op, 2, pp.opAssoc.LEFT, expression_factory.make_add_min_expression),
          (comp_op, 2, pp.opAssoc.LEFT, expression_factory.make_compare2),
          (extra_op, 2, pp.opAssoc.LEFT, expression_factory.make_extra)]
    )


#
# forms
#

# statement_id is the same as id_characters but not parsed as the same object
statement_id = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")

# answer type is one of the texts: "bool", "number" or "text"
answer_type = (pp.Literal("bool").setParseAction(expression_factory.make_bool_type) |
           pp.Literal("number").setParseAction(expression_factory.make_number_type) |
           pp.Literal("text").setParseAction(expression_factory.make_text_type))

# question :: Question id ( answer_type ) : label
question = (pp.Suppress("Question") + statement_id + pp.Suppress("(") + answer_type + pp.Suppress(")") + pp.Suppress(":") + sentence
            ).setParseAction(form_factory.make_question)
questions = pp.OneOrMore(question)

statement = pp.Forward()

# pIf :: if ( expr ) { statement+ }
pIf = (pp.Suppress("if" + pp.Literal("(")) + expr + pp.Suppress(")") + pp.Suppress("{") +
       pp.OneOrMore(statement) + pp.Suppress("}")
       ).setParseAction(form_factory.make_if)

# pIfElse :: if ( expr ) { statement+ } else { statement+ }
pIfElse = ((pp.Suppress("if" + pp.Literal("(")) + expr + pp.Suppress(")") + pp.Suppress("{") +
            pp.OneOrMore(statement) + pp.Suppress("}")) + pp.Literal("else") + pp.Suppress("{") +
            statement + pp.Suppress("}")
           ).setParseAction(form_factory.make_else)

# assignment :: Assignment id (answer_type) : expr
assignment = (pp.Suppress("Assignment") + statement_id + pp.Suppress("(") + answer_type + pp.Suppress(")") +
              pp.Suppress(":") + expr
              ).setParseAction(form_factory.make_assignment)

statement <<= (pIfElse |
               pIf |
               questions |
               assignment)

introduction = (pp.Group(pp.Suppress("Introduction" + pp.Literal(":")) + sentences))

# form :: statement_id introduction? statement+
form = (statement_id + pp.Optional(introduction) + pp.Group(pp.OneOrMore(statement))) + pp.StringEnd()
