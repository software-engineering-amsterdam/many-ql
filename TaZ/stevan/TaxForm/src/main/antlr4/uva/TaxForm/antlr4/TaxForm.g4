grammar TaxForm;

DIGIT			: '0'..'9';
CHAR			: 'a'..'z' | 'A'..'Z';
ESC_SEQ 		: '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';

LOWER                : '<';
LOWER_EQUAL          : '<=';
UPPER                : '>';
UPPER_EQUAL          : '>=';
ASSIGN               : '=';
EQUAL                : '==';
NOT                  : '!';
NOT_EQUAL            : '!=';
ADD                  : '+';
ADD_TO_PREVIOUS      : '+=';
INCREMENT            : '++';
MINUS                : '-';
MINUS_FROM_PREVIOUS  : '-=';
DECREMENT            : '--';
MULTIPLY             : '*';
MULTIPLY_TO_PREVIOUS : '*=';
DIVIDE               : '/';
DIVIDE_FROM_PREVIOUS : '/=';
MODE                 : '%';
COLON                : ':';
SEMICOLON            : ';';
COMMA                : ',';

//The language supports booleans, integers and string values.
Boolean	: 'True'|'False';
Int		: DIGIT+ '.' DIGIT+;
String	: '"' ( ESC_SEQ | ~('\\'|'"') )* '"'; 

text		: CHAR+;
question	: '"' String '?'? '"';
formName	: String;

form: 'form' formName '{' '}' EOF;

WS: [ \t\r\n]+ -> skip;
NL:  '\r'? '\n';
