# Grammar
from pyparsing import *
from exceptions import *
from abstract import *
from ast import *

# Normal sentence grammar
endSignEsc      = Suppress("\\") + Literal("?") | Literal("/.") | Literal("/!")
characters      = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_")
word            = endSignEsc | characters  
hexaColor       = Suppress("#") + Word(hexnums, exact=6)
endSign         = oneOf(". ? !")
comment         = Literal("//") + restOfLine | cStyleComment
variable        = Word(alphanums)

# Answer types
boolean            = Literal("True") | Literal("False")
sentence        = (OneOrMore(word) + endSign).setParseAction(make_sentence)
sentences       = OneOrMore(sentence)
integer         = Word(nums)

# Constraints
exp             = boolean | integer | sentence
c_operators     = oneOf("> >= < <= ==")
e_operators     = oneOf("+ - * / ")
condition       = (Suppress("Question") + integer + c_operators + exp)

# Form
answerType      = Literal("bool") | Literal("integer") | Literal("text")  
question        = (Suppress("Question") + word + Suppress("(") + answerType + Suppress(")") + Suppress(":") +
                   sentence).setResultsName("QUESTION").setParseAction(ASTReady.make_question)
questions       = OneOrMore(question)
pIf             = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") + questions + Suppress("}"))
pElse           = pIf + Literal("else") + Suppress("{") + questions + Suppress("}")
questions2      = pElse.setParseAction(ASTReady.make_else) | pIf.setParseAction(ASTReady.make_if) | questions
form            = (word + OneOrMore(questions2)).setParseAction(ASTReady.make_form)

# Test
try:
    myfile = open('ql_example.ql', 'r').read()
    l = form.ignore(comment).parseString(myfile)
    for i in l:
        print(i)    
except Exception as e:
    exceptions_handling(e)