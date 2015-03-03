grammar Grammar;

@lexer::header  { package uva.sc.parser; }
@parser::header { package uva.sc.parser; }

form
 : 'form' ID  '{' sts+=stat* '}' 
 ;
 
stat
 : question 
 | if_stat
 ;
 
 
question
 : STRING ID ':' type ('=' expr)?
 ;

type
 : 'boolean' 
 | 'number'
 | 'string'
 ;

if_stat
 : IF '(' expr ')' '{' qs+=question* '}'
 ;
 
expr										
 : expr '^' expr           					#power
 | '-' expr                           		#unaryMinus
 | '!' expr                             	#not
 | expr op=(MULT | DIV | MOD) expr      	#multiplication
 | expr op=(ADD | SUB) expr					#additive
 | expr op=(LTE | GTE | LT | GT) expr 		#relational
 | expr op=(EQ | NEQ) expr              	#equality
 | expr '&&' expr                       	#and
 | expr '||' expr                         	#or
 | atom                                 	#atomium
 ;
 
atom
 : '(' expr ')'    #parenthesis
 | NUMBER		   #number
 | BOOLEAN 		   #boolean
 | ID              #id
 | STRING          #string
 ;
 
BOOLEAN: TRUE | FALSE;
TRUE : 'true' | 'TRUE' | 'True';
FALSE : 'false' | 'FALSE' | 'False' ;
IF : 'if';
ELSE : 'else';
WHILE : 'while';
LOG : 'log';

MULT: '*';
DIV: '/';
MOD: '%';

ADD: '+';
SUB: '-';

LTE: '<=';
GTE: '>=';
LT: '<';
GT: '>';

EQ: '==';
NEQ: '!=';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

NUMBER
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 | [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : '//' .*? '\n' -> skip
 ;

WS : [ \t\r\n]+ -> skip ;
