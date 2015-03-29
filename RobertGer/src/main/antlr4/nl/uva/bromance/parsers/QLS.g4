grammar QLS;
stylesheet: (page)*|(question|label)*;
page: 'Page:' name=STRING pageBody;
pageBody: '{'(section|question|label)*'}';
section: 'Section:' name=STRING sectionBody;
sectionBody: '{'(question|label)*'}';
question: 'Question:' name=STRING questionBody;
label: 'Label:' name=STRING labelBody;
questionBody: '{' '}';
labelBody: '{' '}';

// String and number definitions taken from : https://github.com/antlr/grammars-v4/blob/master/json/JSON.g4
STRING :  '"' (ESC | ~["\\])* '"' ;
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
NUMBER
    :   '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :   '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]
fragment NL   : '\r' '\n' | '\n' | '\r';

TEXT : [0-9a-zA-Z\._]+;

//Skip single line comments and whitespace.
COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
WS  :   [ \t\n\r]+ -> skip ;
