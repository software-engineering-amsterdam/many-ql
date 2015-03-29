grammar QLS;

stylesheet :  'stylesheet' Identifier '{' (page)+ '}';

page : 'page' String '{' (statement)+ '}';

statement : section | question | defaultStmt;

section : 'section' String '{' (statement)+ '}';

question : 'question' Identifier ('{' (stylesheetRule)+ '}')?;

defaultStmt : 'default' QuestionType '{' (stylesheetRule)+ '}';

stylesheetRule
    : label='width' ':' Integer
    | label='fontsize' ':' Integer
    | label='font' ':' String
    | label='forecolor' ':' Color
    | label='backcolor' ':' Color
    | label='widget' widgetValue
    ;

widgetValue
    : wlabel='slider' '(' decMin=Decimal ',' decMax=Decimal ',' decStep=Decimal ')'
    | wlabel='slider' '(' intMin=Integer ',' intMax=Integer ',' intStep=Integer ')'
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
    : 'checkbox'
    | 'radio';

Color : '#' Hex Hex Hex Hex Hex Hex;

Integer : (ZeroDigit | NonZeroDigit Digit*);

Decimal : (NonZeroDigit Digit* | ZeroDigit?) '.' Digit+ ;

String : Quote StringCharacter*? Quote;

Identifier : (Letter)(Letter|Digit|'_')*;

Comment : '/*' .*? '*/' -> skip;

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip;
