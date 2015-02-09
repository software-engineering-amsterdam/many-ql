__author__ = 'guyromb'

from string import ascii_lowercase
from pyparsing import *

question = Word('Question')
form = Word('Form')
braceStart = Word('{')


def allUnique(x):
    seen = set()
    return not any(i in seen or seen.add(i) for i in x)

properti = Or(Word('Size') | Word('Color') | Word('Text') | Word('')) + ":" + Word(alphanums)
properties = OneOrMore(properti)

braceEnd = Word('}')


grammar = Or(question | form) + braceStart + properties + braceEnd

# Question {
#     size : 20;
#
# }


print(grammar.parseString('Question { Size : 20 Color : 123456 Color : 123456 }'))
