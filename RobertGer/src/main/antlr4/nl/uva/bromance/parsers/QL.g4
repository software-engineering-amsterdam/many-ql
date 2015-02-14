grammar QL;
questionnaire: 'Name:' name=STRING questionnaireBody;

questionnaireBody:
    '{'(form)+'}';

form: 'Form:' name=STRING formBody;

formBody:
    '{'(question|calculation|(ifStatement (elseIfStatement)* (elseStatement)?)|label)*'}';

question: 'Question:' name=STRING questionBody;

questionBody: '{'(questionText
               | questionAnswer
               | questionRange)*'}';

questionText: 'Text:' text=STRING;
//QuestionAnser abstractions
questionAnswer: 'Answer:' (questionAnswerSimple|questionAnswerCustom);
questionAnswerSimple: type=('integer' | 'Integer' | 'double' | 'Double' | 'string' | 'String');
questionAnswerCustom: '['STRING ('||' STRING)+']';

//QuestionRange abstractions
questionRange: 'Range:' (questionRangeFromTo | questionRangeBiggerThan | questionRangeSmallerThan);
questionRangeFromTo: lower=NUMBER '-' higher=NUMBER;
questionRangeBiggerThan: '>' num=NUMBER;
questionRangeSmallerThan: '<' num=NUMBER;

//QuestionCalculation
calculation:
    'Calculation:' name=STRING calculationBody;

calculationBody:
   '{' ((ifStatement (elseIfStatement)* (elseStatement)?)|input)+'}';

ifStatement:
    'If:' expression statementBody;

elseStatement:
    'Else:' statementBody;

elseIfStatement:
    'Else If:' expression statementBody;

statementBody:
    '{'(question|calculation|input|labelText)*'}';

label:
'Label:'name=STRING labelBody;
labelBody:
'{'((ifStatement (elseIfStatement)* (elseStatement)?)| labelText)'}';

labelText:
    'Text:' id STRING
    |'Text:' STRING;

input:
    'Input:' expression;


expression
    : primary
    | expression ('*'|'/') expression
    | expression ('+'|'-') expression
    | expression ('<=' | '>=' | '>' | '<') expression
    | expression ('==' | '!=') expression
    | expression OR_OP expression
    | expression AND_OP expression;

primary:
    parExpression
    | id;

parExpression:
    '(' expression ')';

id
    : '['id']'
    | STRING
    | NUMBER
    | TEXT;

/*
logicalExpression: logic (LOGICAL_SEPARATOR logic)*;
logic: ref=(TEXT)+ operator=LOGICAL_OPERATOR target=(TEXT)+
ifStatement: 'If:' ref=(TEXT+) operator=OPERATOR '{' '}'  ;
elseStatement: 'Else:' '{' '}';
*/
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

AND_OP: '&&';
OR_OP: '||';

TEXT : [0-9a-zA-Z\._]+;

//Skip single line comments and whitespace.
COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
WS  :   [ \t\n\r]+ -> skip ;
