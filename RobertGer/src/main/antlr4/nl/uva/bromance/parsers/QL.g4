grammar QL;
questionnaire: 'Name:' name=STRING '{' (form)* '}';
form: 'Form:' name=STRING '{' (logicalStatement|question)* '}';
question: 'Question:' name=STRING  '{' (questionContent)* '}';
questionContent: questionText
               | questionAnswer
               | questionRange;

questionText: 'Text:' text=STRING;
questionAnswer: 'Answer:' (questionAnswerSimple|questionAnswerCustom);
questionAnswerSimple: type=('integer' | 'Integer' | 'double' | 'Double' | 'string' | 'String');
questionAnswerCustom: '['STRING ('||' STRING)+']';
questionRange: 'Range:' (questionRangeFromTo | questionRangeBiggerThan | questionRangeSmallerThan);
questionRangeFromTo: lower=NUMBER '-' higher=NUMBER;
questionRangeBiggerThan: '>' num=NUMBER;
questionRangeSmallerThan: '<' num=NUMBER;

logicalStatement: 'If:' lexpression '{' (logicalStatement|question)* '}';

lexpression
    : '(' lexpression ')'
    | LOGICAL_SEPARATOR lexpression
    | TEXT LOGICAL_OPERATOR lexpression
    | TEXT lexpression
    | STRING lexpression
    ;

// String and number definitions taken from : https://github.com/antlr/grammars-v4/blob/master/json/JSON.g4
STRING :  '"' (ESC | ~["\\])* '"' ;
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
NUMBER
    :   '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :   '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]
WS  :   [ \t\n\r]+ -> skip ;
fragment NL   : '\r' '\n' | '\n' | '\r';
LOGICAL_OPERATOR : '=='
                 | '>'
                 | '<'
                 | '!=;';
LOGICAL_SEPARATOR : '||'
                  |'&&';
TEXT : [0-9a-zA-Z\.]+;
