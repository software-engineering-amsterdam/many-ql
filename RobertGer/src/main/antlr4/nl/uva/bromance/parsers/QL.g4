grammar QL;
questionnaire: 'Name:' name=STRING '{' (form)* '}';
form: 'Form:' name=STRING '{' (statement|question)* '}';
question: 'Question:' name=STRING  '{' (questionContent)* '}';
questionContent: questionText
               | questionAnswer
               | questionRange
               | questionCalcuation;

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
questionCalcuation:
    'Caculation:' name=STRING block;

block:
    '{'blockStatement'}';

blockStatement:
    statement;

statement:
    block
    |ifStatement
    |ifStatement (elseStatement)?
    |ifStatement (elseIfStatement)* (elseStatement)*
    |expression;

ifStatement:
    'If:' expression statement;

elseStatement:
    'Else:' statement (elseIfStatement)?;

elseIfStatement:
    'Else If:' expression statement;

expression
    : primary
    | expression op=RELATIONAL_OPERATOR expression
    | expression op=('==' | '!=') expression
    | expression op=OR_OP expression
    | expression op=AND_OP expression;

primary:
    parExpression
    | id;

parExpression:
    '(' expression ')';

id
    : STRING
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
RELATIONAL_OPERATOR : '>'
                 | '<'
                 | '>='
                 | '<=';

AND_OP: '&&';
OR_OP: '||';

TEXT : [0-9a-zA-Z\.]+;
