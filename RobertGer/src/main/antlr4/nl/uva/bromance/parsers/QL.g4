grammar QL;
questionnaire: 'Name:' name=STRING questionnaireBody;

questionnaireBody:
    '{'(form)+'}';

form: 'Form:' name=STRING formBody;

formBody:
    '{'(question|calculation|ifSequence|label)+'}';

question: 'Question:' name=STRING questionBody;

questionBody: '{'questionText       //Question text is not optional
                 questionAnswer     // Question should always have an answer type defined
                 questionRange?'}'; // Typechecker will point out when a range is necessary so it is optional

questionText: 'Text:' text=STRING;
//QuestionAnser abstractions
questionAnswer: 'Answer:' (questionAnswerSimple|questionAnswerCustom);
questionAnswerSimple: type=('integer' | 'Integer'| 'boolean' | 'Boolean' | 'double' | 'Double' | 'string' | 'String');
questionAnswerCustom: '['STRING (OR STRING)+']';

//QuestionRange abstractions
questionRange: 'Range:' (questionRangeFromTo | questionRangeBiggerThan | questionRangeSmallerThan);
questionRangeFromTo: lower=NUMBER '-' higher=NUMBER;
questionRangeBiggerThan: BIGGERTHAN num=NUMBER;
questionRangeSmallerThan: SMALLERTHAN num=NUMBER;

//QuestionCalculation
calculation:
    'Calculation:' name=STRING calculationBody;

//TODO: Can a calculation have multiple inputs?
calculationBody:
   '{' input '}';

ifSequence: ifStatement (elseIfStatement)* (elseStatement)?;

ifStatement:
    'If:' expression statementBody;

elseStatement:
    'Else:' statementBody;

elseIfStatement:
    'Else If:' expression statementBody;

statementBody:
    '{'(question|calculation|input|labelText)+'}';

label:
'Label:'name=STRING labelBody;
labelBody:
'{'(ifSequence | labelText)'}';

labelText: 'Text:' text=STRING;

input:
    'Input:' expression;


expression
    : id
    | '(' expression ')'
    | expression operator=(TIMES|DIVISION) expression
    | expression operator=(ADDITION|SUBTRACTION) expression
    | expression operator=(SMALLETHANOREQUAL | BIGGERTHANOREQUAL | BIGGERTHAN | SMALLERTHAN | EQUALTO | NOTEQUALTO) expression
    | expression operator=AND expression
    | expression operator=OR expression;

//TODO: Consider doing something about this. id suggests identifier but this is not really an identifier. Would help with the ast as well.
id
    : '['id']'
    | STRING
    | NUMBER
    | TEXT;


//Operators
TIMES: '*';
DIVISION: '/';
ADDITION: '+';
SUBTRACTION: '-';
SMALLETHANOREQUAL: '<=';
BIGGERTHANOREQUAL: '>=';
BIGGERTHAN: '>';
SMALLERTHAN: '<';
EQUALTO: '==';
NOTEQUALTO: '!=';
AND: '&&';
OR: '||';

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
