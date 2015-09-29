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

textLabel:
    'Text:' identifier=STRING;

//Conditionals
ifSequence:
    ifStatement (elseIfStatement)* (elseStatement)?;

ifStatement:
    'If:' ifCondition statementContent;

ifCondition:
    expression;

elseStatement:
    'Else:' statementContent;

elseIfStatement:
    'Else If:' elseIfCondition statementContent;

elseIfCondition:
    expression;


//Bodies
questionnaireContent:
    '{'(form)+'}';

formContent:
    '{'(question|calculation|ifSequence)+'}';

questionContent:
   '{' (textLabel questionAnswer)'}';

calculationContent:
    '{'(input|ifSequence)'}';

statementContent:
    '{'(question|calculation|input|textLabel)+'}';


labelContent:
    '{'(ifSequence|textLabel)'}';

//Question
//QuestionAnswer abstractions
questionAnswer:
    'Answer:' type=questionAllowedTypes;

questionAllowedTypes:
    ('integer' | 'boolean' | 'string' );

//Values
variable:
    identifier=TEXT;

primitive:
    value= (STRING | NUMBER | BOOLEAN);

integer:
    value=NUMBER;

//Expressions

expression:
    unaryExpression
    | binaryExpression;

unaryExpression
    : primitive
    | variable;

binaryExpression:
     arithmeticExpression
    | logicalExpression;

arithmeticExpression:
      integer
    | variable
    | '(' arithmeticExpression ')'
    | lhs=arithmeticExpression operator=(MULTIPLICATION|DIVISION) rhs=arithmeticExpression
    | lhs=arithmeticExpression operator=(ADDITION|SUBTRACTION) rhs=arithmeticExpression
    | lhs=arithmeticExpression operator=( EQUALTO | NOTEQUALTO) rhs=arithmeticExpression

logicalExpression:
      primitive
    | variable
    | '(' logicalExpression ')'
    | lhs=logicalExpression operator=(SMALLERTHANOREQUAL | BIGGERTHANOREQUAL | BIGGERTHAN | SMALLERTHAN| EQUALTO | NOTEQUALTO) rhs=logicalExpression
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

BOOLEAN : 'true' | 'false';
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