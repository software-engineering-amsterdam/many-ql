grammar QL;
//Objects
questionnaire:
    'Name:' identifier=STRING questionnaireContent;

form:
    'Form:' identifier=STRING formContent;

question:
    'Question:' identifier=STRING questionContent;

calculation:
    'Calculation:' identifier=STRING calculationContent;

label:
    'Label:' identifier=STRING labelContent;

textLabel:
    'Text:' identifier=STRING;

input:
    'Input:' expression;

//Conditionals
ifSequence:
    ifStatement (elseIfStatement)* (elseStatement)?;

ifStatement:
    'If:' expression statementContent;

elseStatement:
    'Else:' statementContent;

elseIfStatement:
    'Else If:' expression statementContent;

//Bodies
questionnaireContent:
    '{'(form)+'}';

formContent:
    '{'(question|calculation|ifSequence|label)+'}';

questionContent:
   '{' (textLabel questionAnswer questionRange?)'}';

calculationContent:
    '{'(input|ifSequence)'}';

statementContent:
    '{'(question|calculation|input|textLabel)+'}';


labelContent:
    '{'(ifSequence|textLabel)'}';

//Question
//QuestionAnser abstractions
questionAnswer:
    'Answer:' (questionAnswerSimple|questionAnswerCustom);

questionAnswerSimple:
    type=questionAllowedTypes;

questionAnswerCustom:
    '['STRING (OR STRING)+']';

//QuestionRange abstractions
questionRange:
    'Range:' (questionRangeFromTo | questionRangeBiggerThan | questionRangeSmallerThan);

questionRangeFromTo:
    lower=NUMBER '-' higher=NUMBER;

questionRangeBiggerThan:
    BIGGERTHAN num=NUMBER;

questionRangeSmallerThan:
    SMALLERTHAN num=NUMBER;

questionAllowedTypes:
    ('integer' | 'boolean' | 'string' );

//Values
variable:
    identifier=TEXT;

primitive:
    value= (STRING | NUMBER);


//Expressions
expression
    : primitive
    | variable
    | lhs=expression operator=( EQUALTO | NOTEQUALTO) rhs=expression
    | arithmeticExpression
    | logicalExpression;


arithmeticExpression:
      NUMBER
    | variable
    | '(' arithmeticExpression ')'
    | lhs=arithmeticExpression operator=(MULTIPLICATION|DIVISION) rhs=arithmeticExpression
    | lhs=arithmeticExpression operator=(ADDITION|SUBTRACTION) rhs=arithmeticExpression;

logicalExpression:
      primitive
    | variable
    | '(' logicalExpression ')'
    | lhs=logicalExpression operator=(SMALLETHANOREQUAL | BIGGERTHANOREQUAL | BIGGERTHAN | SMALLERTHAN | EQUALTO | NOTEQUALTO) rhs=logicalExpression
    | lhs=logicalExpression operator=AND rhs=logicalExpression
    | lhs=logicalExpression operator=OR rhs=logicalExpression;

//Operators
MULTIPLICATION: '*';
DIVISION: '/';
ADDITION: '+';
SUBTRACTION: '-';
SMALLERTHANOREQUAL: '<=';
BIGGERTHANOREQUAL: '>=';
BIGGERTHAN: '>';
SMALLERTHAN: '<';
EQUALTO: '==';
NOTEQUALTO: '!=';
AND: '&&';
OR: '||';

//Primitives
STRING :
'"' (ESC | ~["\\])* '"' ;
fragment ESC :
   '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE :
 'u' HEX HEX HEX HEX ;
fragment HEX :
 [0-9a-fA-F] ;

NUMBER :
    '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :
    '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP :
    [Ee] [+\-]? INT ; // \- since - means "range" inside [...]
fragment NL   :
    '\r' '\n' | '\n' | '\r';

TEXT :
    [0-9a-zA-Z\._]+;

COMMENT:
    '//' ~[\r\n]* -> skip;

WHITESPACE  :
    [ \t\n\r]+ -> skip;