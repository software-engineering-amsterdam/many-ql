from string import ascii_lowercase
from pyparsing import Word
from pyparsing import OneOrMore

word = Word(ascii_lowercase) # word only
sentence = OneOrMore(word) # words seperated by space
uppercase = ascii_lowercase.upper() # identify uppercase
startChar = Word(uppercase, exact=1) # only H
endOfSentence = Word("?!:.", exact=1)

grammar = startChar + sentence + endOfSentence

# print(word.parseString('hello'))
# print(startChar.parseString('Hello'))
print(grammar.parseString('Shalom olam!'))

