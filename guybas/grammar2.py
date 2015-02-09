# Grammar 2.0
from pyparsing import *
from exceptions import *
from ast2 import *

# Normal sentence grammar
endSignEsc      = Word('?', exact = 3) | Word ('.', exact = 3) | Word('!', exact = 3)
word            = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_") | endSignEsc
hexaColor       = Suppress("#") + Word(hexnums, exact=6)
endSign         = oneOf(". ? !")
comment         = Literal("//") + restOfLine | cStyleComment

# Brackets / Brackets / Colon
obrac           = Literal("{")
cbrac           = Literal("}")
opar            = Literal("(")
cpar            = Literal(")")
col             = Literal(":")

# Answer types
bool            = Word("True") | Word("False") 
sentence        = (OneOrMore(word) + endSign).setResultsName("TEXT").setParseAction(makeSentence)
sentences       = OneOrMore(sentence)
integer         = Word(nums).setName("INTEGER")

# Constraints
exp             = bool | integer | sentence
compare         = oneOf("> >= < <= ==")
condition       = Group(Suppress("Question") + integer + compare + exp)
pIf             = Suppress("if" + opar) + condition + Suppress(cpar)
pElse           = Word("else")

# Form
answerType      = Word("bool") | Word("integer") | sentence  
answer          = Group(Suppress("Answer-type:") + answerType)
question        = (Suppress("Question") + integer + Suppress(col) + sentence +\
                  answer).setResultsName("QUESTION").setParseAction(Question)
questions       = OneOrMore(question)
questions2       = Group(pIf + Suppress(obrac) + questions + Suppress(cbrac)).setResultsName("CONDITIONAL").setParseAction(Conditional_Questions) | questions
form            = (word.setResultsName("NAME") + OneOrMore(questions2)).setResultsName("FORM")

# Test
try:
    myfile = open('ql_example.ql', 'r').read()
    l = form.ignore(comment).parseString(myfile)
    print(l)
    
except Exception as e:
    exceptionsHandling(e)