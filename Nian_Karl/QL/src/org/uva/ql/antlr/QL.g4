grammar QL;

/*  PARSER RULES  */

questionnaire: form*;

form: FORM Identifier block;

block: LEFT_BRACE statement* RIGHT_BRACE;

statement
  : ifStatement
  | question
  ;

ifStatement
  : IF LEFT_PAREN expression RIGHT_PAREN ifBody = block ELSE elseBody = block   #IfElse
  | IF LEFT_PAREN expression RIGHT_PAREN ifBody = block #If
  ;

question
  : identifier = questionIdentifier COLON label = questionLabel type = questionType LEFT_PAREN expr = expression RIGHT_PAREN #QuestionCompute
  | identifier = questionIdentifier COLON label = questionLabel type = questionType                                          #QuestionNormal
  ;

questionIdentifier: Identifier;
questionLabel: StringLiteral;

questionType
  : INT       #TypeInt 
  | STR       #TypeStr 
  | BOOL      #TypeBool
  ;

expression
  : NOT        expression                #ExprNot
  | PLUS       expression                #ExprPositive
  | MINUS      expression                #ExprNegative
  | left = expression PLUS          right = expression  #ExprPlus
  | left = expression MINUS         right = expression  #ExprMinus
  | left = expression MULTIPLY      right = expression  #ExprMultiply
  | left = expression DIVIDE        right = expression  #ExprDivide
  | left = expression AND           right = expression  #ExprAnd
  | left = expression OR            right = expression  #ExprOr
  | left = expression EQUAL         right = expression  #ExprEqual
  | left = expression NOTEQUAL      right = expression  #ExprNotEqual
  | left = expression GREATER       right = expression  #ExprGreater
  | left = expression GREATER_EQUAL right = expression  #ExprGreaterEqual
  | left = expression LESS          right = expression  #ExprLess
  | left = expression LESS_EQUAL    right = expression  #ExprLessEqual
  | LEFT_PAREN expression    RIGHT_PAREN #ExprParentheses
  | literal                              #ExprLiteral
  ;

literal
  : Identifier       #LiteralId
  | IntegerLiteral   #LiteralInt
  | BooleanLiteral   #LiteralBool
  | StringLiteral    #LiteralStr
  ;


/* LEXER RULES */
// Keywords	
FORM:          'form';
IF:            'if';
ELSE:          'else';

// DataTypes
INT:           'Int';
STR:           'Str';
BOOL:          'Bool';

// Operators
NOT:           '!';
PLUS:          '+';
MINUS:         '-';
MULTIPLY:      '*';
DIVIDE:        '/';
AND:           '&&';
OR:            '||';
EQUAL:         '==';
NOTEQUAL:      '!=';
GREATER:       '>';
GREATER_EQUAL: '>='; 
LESS:          '<';
LESS_EQUAL:    '<=';

// Symbols
LEFT_BRACE:    '{';
RIGHT_BRACE:   '}';
LEFT_PAREN:    '(';
RIGHT_PAREN:   ')';
COLON:         ':';

IntegerLiteral: [1-9][0-9]*;

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' (~[\r\n"] | '""')* '"';

WhiteSpace: (' ' | '\t' | '\n' | '\r') -> skip;

MultiComment: '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
