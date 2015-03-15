# Grammar of forms

import pyparsing as pp
import QL.Factory.forms as forms
import QL.Grammar.constants as constants
import QL.Factory.expressions as e

    
# end_sign :: . | ? | !
end_sign = pp.oneOf(". ? !")

# end_sign_esc :: \ end_sign
end_sign_esc = pp.Suppress("\\") + end_sign

# characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_]
characters = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*-+=/\'\"`~_") | pp.Word(",")

# word :: end_sign_esc | characters
word = end_sign_esc | characters

# sentence :: word+ end_sign
sentence = (pp.OneOrMore(word) + end_sign).setParseAction(forms.FormFactory.make_sentence)

# sentences :: sentence+
sentences = pp.OneOrMore(sentence)

# comment :: // ....\n  | /* .... */
comment = pp.Literal("//") + pp.restOfLine | pp.cStyleComment

# id :: [1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_]
id = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_")

# bool :: True | False
bool = pp.Literal("True") | pp.Literal("False")

# text
text = pp.Suppress("\"") + pp.OneOrMore(pp.Word(pp.alphanums)) + pp.Suppress("\"")

# number :: [0-9]
number = pp.Word(pp.nums)

# value :: bool | number | id
value = (bool.setParseAction(e.ExpressionFactory.make_bool) |
         number.setParseAction(e.ExpressionFactory.make_number) |
         id.setParseAction(e.ExpressionFactory.make_variable) |
         text.setParseAction(e.ExpressionFactory.make_text))

# operator :: + | - | / | * | and | or | not | > | >= | < | <= | ==
operator = pp.oneOf('+ - / * and or not > >= < <= ==').setParseAction(e.ExpressionFactory.make_operator)

expr = pp.Forward()

# atom :: ( expr ) | value
atom = (pp.Suppress("(") + expr + pp.Suppress(")")).setParseAction(e.ExpressionFactory.make_expression) | value

# expr :: atom | (operator expr)*
expr << (atom + pp.ZeroOrMore(operator + expr)).setParseAction(e.ExpressionFactory.make_sub_expression)

# _id :: characters
id = characters

# answerR :: "bool" | "number" | "text"
answerR = (pp.Literal(constants.GrammarConstants.BOOL).setParseAction(forms.FormFactory.make_bool_type) |
           pp.Literal(constants.GrammarConstants.NUMBER).setParseAction(forms.FormFactory.make_number_type) |
           pp.Literal(constants.GrammarConstants.TEXT).setParseAction(forms.FormFactory.make_text_type))

# q :: Question _id ( answerR ) : _label
question = (pp.Suppress("Question") + id + pp.Suppress("(") + answerR + pp.Suppress(")") + pp.Suppress(":") + sentence
            ).setParseAction(forms.FormFactory.make_question)

# _statements :: question+
questions = pp.OneOrMore(question)

statement = pp.Forward()

# pIf :: if ( _condition ) { statement+ }
pIf = (pp.Suppress("if" + pp.Literal("(")) + expr + pp.Suppress(")") + pp.Suppress("{") +
       pp.OneOrMore(statement) + pp.Suppress("}")
       ).setParseAction(forms.FormFactory.make_if)

# pIfElse :: if ( _condition ) { statement+ } else { statement+ }
pIfElse = ((pp.Suppress("if" + pp.Literal("(")) + expr + pp.Suppress(")") + pp.Suppress("{") +
            pp.OneOrMore(statement) + pp.Suppress("}")) + pp.Literal("else") + pp.Suppress("{") +
            statement + pp.Suppress("}")
           ).setParseAction(forms.FormFactory.make_else)

# assignment :: Assignment _id ( answerR ) : expr
assignment = (pp.Suppress("Assignment") + id + pp.Suppress("(") + answerR + pp.Suppress(")") +
              pp.Suppress(":") + expr
              ).setParseAction(forms.FormFactory.make_assignment)

# statement :: pIfElse | pIf | questions | assignment
statement <<= (pIfElse |
               pIf |
               questions |
               assignment)

# introduction :: Introduction : sentences
introduction = (pp.Group(pp.Suppress("Introduction" + pp.Literal(":")) + sentences))

# form :: id introduction? statement+
form = (id + pp.Optional(introduction) + pp.Group(pp.OneOrMore(statement))) + pp.StringEnd()
