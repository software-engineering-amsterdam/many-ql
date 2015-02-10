grammar TaxForm;

fragment DIGIT	: '0'..'9';
fragment ESC_SEQ : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');

//The language supports booleans, integers and string values.
Boolean	: 'True'|'False';
Int		: DIGIT+ '.' DIGIT+;
String	: '"' ( ESC_SEQ | ~('\\'|'"') )* '"'; 

text		: String;

form:
    questions = text+ NL
    EOF;

WS: (' ' | '\t')+;
NL:  '\r'? '\n';
