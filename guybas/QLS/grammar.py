# Grammar
from pyparsing import Word, oneOf, OneOrMore, ZeroOrMore, Forward, Group, Literal, nums, restOfLine, Optional, delimitedList

# Normal sentence grammar
endSignEsc      = Word('?', exact = 3) | Word ('.', exact = 3) | Word('!', exact = 3)
word            = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_") | endSignEsc
integer         = Word(nums).setName("integer")
hexaColor       = Suppress("#") + Word(hexnums, exact=6)
endSign         = oneOf(". ? !")
sentence        = (OneOrMore(word) + endSign).setParseAction(makeSentence)
sentences       = OneOrMore(sentence).setParseAction(makeSentence)
comment         = Literal("//") + restOfLine | cStyleComment

# Brackets
obrac           = Literal("{")
cbrac           = Literal("}")
opar            = Literal("(")
cpar            = Literal(")")
col             = Literal(":")

# Answer types
bool            = Word("True") | Word("False") | Word("bool")           
option          = Group(Suppress("Option:") + Optional(Word("Default:") + bool) + sentence)
multiOption     = Forward()
multiOption     <<= option + Optional(delimitedList(multiOption))
checkbox        = (Suppress("Checkbox") + Suppress(obrac) + multiOption + Suppress(cbrac)).setParseAction(Checkbox)
radiobutton     = (Suppress("Radiobox") + Suppress(obrac) + multiOption + Suppress(cbrac)).setParseAction(Radiobox)
scale           = (Suppress("Scale") + integer + integer).setParseAction(Scale) 

# Constraints
exp             = bool | Word("between") + integer + Word("and") + integer | integer | integer + Word(">=<") + integer
compare         = oneOf("> >= < <= ==")
condition       = Group(Suppress("Question") + integer + compare + exp)
pIf             = Suppress("if" + opar) + condition + Suppress(cpar)
pElse           = Word("else")

# Form
fontProp        = ((Word("font-family:") + word)
                   | (Word("font-size:") + integer)
                   | (Word("color:") + hexaColor))
font            = (Word("Font") + obrac +
                   ZeroOrMore(fontProp) +
                   cbrac)
formProp        = Word("Introduction:") + sentences | font  
category        = Group(Word("Category:") + word)
hint            = Group(Word("Hint:") + sentence)
questionProp    = font | category | hint               
answerType      = checkbox | radiobutton | scale | Word ("text") | bool
answer          = Suppress("Answer-type:") + answerType.setName("answer")
question        = ((Suppress("Question") + integer + Suppress(col) + sentence +
                   Suppress(obrac) + answer + ZeroOrMore(questionProp) + Suppress(cbrac)).setParseAction(Question))
questions       = OneOrMore(question)
questions2       = (pIf + Suppress(obrac) + questions + Suppress(cbrac) + \
                  Optional(pElse + Suppress(obrac) + questions + Suppress(cbrac))).setParseAction(Conditional_Questions) | \
                  questions
form            = (word + Group(ZeroOrMore(formProp)) + OneOrMore(questions2)).setParseAction(Form)         

# Test
try:
    myfile = open('example.txt', 'r').read()
    l = form.ignore(comment).parseString(myfile)
    for i in l:
        print(i)
except Exception as e:
    exceptionsHandling(e)
