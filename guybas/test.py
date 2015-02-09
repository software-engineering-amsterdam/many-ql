__author__ = 'guyromb'
from pyparsing import Word, alphas
greet = Word( alphas ) + "," + Word( alphas ) + "!" # <-- grammar defined here
hello = "Hello, World!"
print (hello, "->", greet.parseString( hello ))