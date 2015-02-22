grammar Ql;

form : 'form' id '{' (question)* (ifblock)* '}' ;
ifblock: IF '(' expression ')' '{' (question)* '}';

question : id ':' label type (expression?);

label : STRINGLITERAL;

IF : 'if';

type : 'boolean'
	 | 'string'
	 | 'integer'
	 | 'date'
	 | 'decimal'
	 | 'money'
	 ;
	 
id : STRINGLITERAL
   | CHARACTERLITERAL
   | INTEGERLITERAL
   | DECIMALLITERAL
   | DATELITERAL
   | BOOLEANLITERAL
   | MONEYLITERAL
   ;
   
CHARACTERLITERAL : [a-zA-Z_] [a-zA-Z_0-9]*;

expression : id													#ExpreId
	 | '(' expression ')' 										#PriorExpr
	 | expression op=('*'|'/') expression     			   		#MulDiv
	 | expression op=('+'|'-') expression      			    	#AddSub
	 | expression op=('<=' | '>=' | '>' | '<') expression   	#Comp
	 | expression op=('==' | '!=') expression               	#EqNotEq
	 | expression op='&&' expression							#And
	 | expression op='||' expression							#Or
	 | '!' expression											#Negate
	 ;
	 
BOOLEANLITERAL : TRUE | FALSE;
TRUE : 'true' | 'TRUE';
FALSE : 'false' | 'FALSE';

INTEGERLITERAL : '-'?POSITIVENUM ;		
DECIMALLITERAL : INTEGERLITERAL'.'POSITIVENUM ;

DATELITERAL : POSITIVENUM'/'POSITIVENUM'/'POSITIVENUM ;
MONEYLITERAL : INTEGERLITERAL
			 | DECIMALLITERAL
			 ;
 						
STRINGLITERAL
    :   '"' StringCharacters? '"'
    ;
	
fragment
StringCharacters
    :   StringCharacter+
    ;
	
fragment
StringCharacter
    :   ~["\\]
	|   EscapeSequence
	;	
	
fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape
    ;
	
fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;	
	
fragment
OctalDigit
    :   [0-7]
    ;
	
fragment
HexDigit
    :   [0-9a-fA-F]
    ;	
	
fragment
ZeroToThree
    :   [0-3]
    ;	

POSITIVENUM : ['0-9']+;	

MUL  : '*' ;
DIV  : '/' ;
SUB  : '-' ;
ADD  : '+' ;
GT   : '>' ;
LT   : '<' ;
EQ   : '==' ;
NEQ  : '!=' ;
GRT  : '>=' ;
LOT  : '<=' ;
AND  : '&&' ;
OR   : '||' ;
NOT  : '!' ;
			
COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
	
WS : [ \t\r\n]+ -> skip ; 