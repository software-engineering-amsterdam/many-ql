grammar QLS;

stylesheet :  'stylesheet' Identifier '{' (page)+ '}';

page : 'page' Identifier '{' (statement)+ '}';

statement : section | question | defaultStmt;

section : 'section' String '{' (statement)+ '}';

question : 'question' Identifier ('{' (stylesheetRule)+ '}')?;

defaultStmt : 'default' QuestionType '{' (stylesheetRule)+ '}';

stylesheetRule
    : label='width' ':' Integer
    | label='fontsize' ':' Integer
    | label='font' ':' String
    | label='color' ':' Color
    | label='widget' widgetValue
    ;

widgetValue
    : label='slider'
    | label='slider' '(' min=IntOrDec ',' max=IntOrDec ')'
    | label='spinbox'
    | label='spinbox' '(' min=IntOrDec ',' max=IntOrDec ')'
    | label='textbox'
    | label='radio' '(' yesText=String ',' noText=String ')'
    | label='checkbox'
    | label='dropdown' '(' yesText=String ',' noText=String ')'
    ;

fragment Hex : [0-9A-F];

fragment Letter : [a-zA-Z];

fragment Digit : ZeroDigit|NonZeroDigit;

fragment NonZeroDigit : [1-9];

fragment ZeroDigit : [0];

fragment StringCharacter : EscapeSequence | ~[\\];

fragment Quote : ["];

fragment EscapeSequence : '\\' Quote;

QuestionType
   : 'boolean'
   | 'decimal'
   | 'integer'
   | 'string'
   ;

Boolean
   : 'true'
   | 'false'
   ;

WidgetType
    : 'spinbox'
    | 'checkbox'
    | 'radio';

Color : '#' Hex Hex Hex Hex Hex Hex;

Integer : (ZeroDigit | NonZeroDigit Digit*);

Decimal : (NonZeroDigit Digit* | ZeroDigit?) '.' Digit+ ;

IntOrDec : Integer | Decimal;

String : Quote StringCharacter*? Quote;

Identifier : (Letter)(Letter|Digit|'_')*;

Comment : '/*' .*? '*/' -> skip;

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip;
