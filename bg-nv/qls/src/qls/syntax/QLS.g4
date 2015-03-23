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
    : wlabel='slider' '(' min=(Decimal|Integer) ',' max=(Decimal|Integer) ',' step=(Decimal|Integer) ')'
    | wlabel='spinbox' '(' min=(Decimal|Integer) ',' max=(Decimal|Integer) ',' step=(Decimal|Integer) ')'
    | wlabel='radio' '(' yesText=String ',' noText=String ')'
    | wlabel='dropdown' '(' yesText=String ',' noText=String ')'
    | wlabel='checkbox'
    | wlabel='textbox'
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

String : Quote StringCharacter*? Quote;

Identifier : (Letter)(Letter|Digit|'_')*;

Comment : '/*' .*? '*/' -> skip;

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip;
