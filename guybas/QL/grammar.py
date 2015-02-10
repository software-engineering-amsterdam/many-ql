# Grammar 
from pyparsing import *
from exceptions import *
from abstract import *
from ast import *

# Normal sentence grammar
endSignEsc      = Word('?', exact = 3) | Word ('.', exact = 3) | Word('!', exact = 3)
word            = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_") | endSignEsc
hexaColor       = Suppress("#") + Word(hexnums, exact=6)
endSign         = oneOf(". ? !")
comment         = Literal("//") + restOfLine | cStyleComment
variable        = Word(alphanums)

# Brackets / Brackets / Colon
obrac           = Literal("{")
cbrac           = Literal("}")
opar            = Literal("(")
cpar            = Literal(")")
col             = Literal(":")

# Answer types
bool            = Literal("True") | Literal("False") 
sentence        = (OneOrMore(word) + endSign).setParseAction(make_sentence)
sentences       = OneOrMore(sentence)
integer         = Word(nums)

# Constraints
exp             = bool | integer | sentence
compare         = oneOf("> >= < <= ==")
condition       = (Suppress("Question") + integer + compare + exp)

# Form
answerType      = Literal("bool") | Literal("integer") | Literal("text")  
answer          = Suppress("Answer-type:") + answerType
question        = (Suppress("Question") + integer + Suppress(col) + sentence +\
                  answer).setResultsName("QUESTION").setParseAction(ASTReady.make_question)
questions       = OneOrMore(question)
pIf             = (Suppress("if" + opar) + condition + Suppress(cpar) + Suppress(obrac) + questions + Suppress(cbrac))
pElse           = pIf+ Literal("else") + Suppress(obrac) +  questions + Suppress(cbrac)
questions2      = pElse.setParseAction(ASTReady.make_else) | pIf.setParseAction(ASTReady.make_if) | questions
form            = (word + OneOrMore(questions2)).setParseAction(ASTReady.make_form)

# Test
try:
    myfile = open('ql_example.ql', 'r').read()
    l = form.ignore(comment).parseString(myfile)
    for i in l:
        print(i)    
except Exception as e:
    exceptionsHandling(e)