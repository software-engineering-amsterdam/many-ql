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
 | 'integer'
 | 'string'
 | 'money'
 ;

if_stat
 : IF '(' expr ')' '{' qs+=question* '}'
 ;

/*stat
 : assignment
 | if_stat
 | while_stat
 | log
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

assignment
 : ID '=' expr ';'
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : '{' block '}'
 | stat
 ;

while_stat
 : WHILE expr stat_block
 ;*/
 
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
 | (INT | DOUBLE)  #number
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

INT
 : [0-9]+
 ;

DOUBLE
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : '//' .*? '\n' -> skip
 ;

WS : [ \t\r\n]+ -> skip ;

OTHER
 : . 
 ;
