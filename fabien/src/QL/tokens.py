
import ply.lex

literals = ["!", "(", ")", '{', '}', '<', '>', ':', '+', '-', '*', '/', '=']

reserved = {
  "form"    : "FORM",
  "if"      : "IF",
  "else"    : "ELSE",

  "or"      : "OR",
  "and"     : "AND",

  "integer" : "TYPE",
  "boolean" : "TYPE",
  "string"  : "TYPE",
  "money"   : "TYPE"
}

tokens = [
    'ID',
    'NUMBER',
    'STRING',

    'EQ',
    'NEQ',
    'LT_EQ',
    'GT_EQ'
] + list(set(reserved.values()))

t_EQ     = r'=='
t_NEQ    = r'!='
t_LT_EQ  = r'<='
t_GT_EQ  = r'>='

t_OR     = r'\|\||or'
t_AND    = r'&&|and'

t_STRING = r'("[^"]*")|(\'[^\']*\')'
t_NUMBER = r'[0-9]*\.?[0-9]+'
t_TYPE   = r'integer|boolean|string|money'


def t_ID(t):
    r'[a-zA-Z_][a-zA-Z0-9_]*'
    t.type = reserved.get(t.value, "ID")
    return t

# Track line numbers to use in error messages
def t_NEWLINE(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

def t_COMMENT(t):
    r'(/\*(.|\n)*?\*/)|(//.*)|(\#.*)'
    pass

def t_error(t):
    print "Illegal character '%s'" % t.value[0]
    t.lexer.skip(1)

t_ignore = " \t"

# Build the lexer
def Lexer():
    return ply.lex.lex()
