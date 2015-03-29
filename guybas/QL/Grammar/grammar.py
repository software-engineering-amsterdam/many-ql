# Grammar of forms

import pyparsing
import QL.Grammar.Factory.form as form_factory
import QL.Grammar.Factory.expression as expression_factory

#
# basic types
#

# end terminal of a sentence
end_sign = pyparsing.oneOf(". ? !")

# escape end-terminals to make them able in texts
end_sign_esc = pyparsing.Suppress("\\") + end_sign

# characters allowed in sentences
characters = pyparsing.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*-+=/\'\"`~_") | pyparsing.Word(",")
word = end_sign_esc | characters
sentence = (pyparsing.OneOrMore(word) + end_sign).setParseAction(form_factory.make_sentence)
sentences = pyparsing.OneOrMore(sentence)

# comment :: // ....\n  | /* .... */
comment = pyparsing.Literal("//") + pyparsing.restOfLine | pyparsing.cStyleComment

# values allowed in expressions: bool, number, id or text
# this is different from the statement_id later on as this is parsed as a real object and not just as a reference
statement_id_object = pyparsing.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")
boolean = pyparsing.Literal("True") | pyparsing.Literal("False")
text = pyparsing.Suppress("\"") + pyparsing.OneOrMore(pyparsing.Word(pyparsing.alphanums)) + pyparsing.Suppress("\"")
number = pyparsing.Word(pyparsing.nums)
value = (boolean.setParseAction(expression_factory.make_bool) |
         number.setParseAction(expression_factory.make_number) |
         statement_id_object.setParseAction(expression_factory.make_variable) |
         text.setParseAction(expression_factory.make_text))


#
# expressions
#

# operators
not_op = pyparsing.Literal("not")
mul_op = pyparsing.oneOf('* /')
plus_op = pyparsing.oneOf('+ -')
comp_op = pyparsing.oneOf('> >= == < <=')
extra_op = pyparsing.oneOf('and or')

# expr uses the above operators in the following order and associations
# 1 means it binds to one operand, 2 means it binds to two operands
# pyparsing doesn't support non-associative so left is chosen
expr = pyparsing.infixNotation(value,
         [(not_op, 1, pyparsing.opAssoc.RIGHT, expression_factory.make_not_expression),
          (mul_op, 2, pyparsing.opAssoc.LEFT, expression_factory.make_mul_expression),
          (plus_op, 2, pyparsing.opAssoc.LEFT, expression_factory.make_add_min_expression),
          (comp_op, 2, pyparsing.opAssoc.LEFT, expression_factory.make_compare_expression),
          (extra_op, 2, pyparsing.opAssoc.LEFT, expression_factory.make_logic_expression)]
    )


#
# forms
#

# statement_id is the same as id_characters but not parsed as the same object
statement_id = pyparsing.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")

# answer type is one of the texts: "bool", "number" or "text"
answer_type = (pyparsing.Literal("bool").setParseAction(expression_factory.make_bool_type) |
           pyparsing.Literal("number").setParseAction(expression_factory.make_number_type) |
           pyparsing.Literal("text").setParseAction(expression_factory.make_text_type))

# question :: Question id ( answer_type ) : label
question = (pyparsing.Suppress("Question") + statement_id + pyparsing.Suppress("(") + answer_type +
            pyparsing.Suppress(")") + pyparsing.Suppress(":") + sentence
            ).setParseAction(form_factory.make_question)
questions = pyparsing.OneOrMore(question)

statement = pyparsing.Forward()

# pIf :: if ( expr ) { statement+ }
pIf = (pyparsing.Suppress("if" + pyparsing.Literal("(")) + expr + pyparsing.Suppress(")") + pyparsing.Suppress("{") +
       pyparsing.OneOrMore(statement) + pyparsing.Suppress("}")
       ).setParseAction(form_factory.make_if)

# pIfElse :: if ( expr ) { statement+ } else { statement+ }
pIfElse = ((pyparsing.Suppress("if" + pyparsing.Literal("(")) + expr + pyparsing.Suppress(")") +
            pyparsing.Suppress("{") + pyparsing.OneOrMore(statement) + pyparsing.Suppress("}")) +
           pyparsing.Literal("else") + pyparsing.Suppress("{") + statement + pyparsing.Suppress("}")
           ).setParseAction(form_factory.make_else)

# assignment :: Assignment id (answer_type) : expr
assignment = (pyparsing.Suppress("Assignment") + statement_id + pyparsing.Suppress("(") + answer_type +
              pyparsing.Suppress(")") + pyparsing.Suppress(":") + expr
              ).setParseAction(form_factory.make_assignment)

statement <<= (pIfElse |
               pIf |
               questions |
               assignment)

introduction = (pyparsing.Group(pyparsing.Suppress("Introduction" + pyparsing.Literal(":")) + sentences))

# form :: statement_id introduction? statement+
form = (statement_id + pyparsing.Optional(introduction) + pyparsing.Group(pyparsing.OneOrMore(statement))) + pyparsing.StringEnd()
