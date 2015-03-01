lexer grammar Types;

fragment Digit : ZeroDigit|NonZeroDigit;

fragment NonZeroDigit : [1-9];

fragment ZeroDigit : [0];

fragment StringCharacter : EscapeSequence | ~[\\] ;

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

Integer : (ZeroDigit | NonZeroDigit Digit*);

Decimal : (NonZeroDigit Digit* | ZeroDigit?) '.' Digit+ ;

String : Quote StringCharacter*? Quote;
