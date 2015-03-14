grammar KLS;

//Keywords
PAGE            : 'page' ;
SECTION         : 'section' ;
QUESTION        : 'question' ;
END             : 'end' ;

WIDGET          : 'widget' ;
SLIDER          : 'slider' ;
SPINBOX         : 'spinbox' ;
TEXT            : 'text' ;
YESNORADIO      : 'yes-no-radio' ;
YESNODROPDOWN   : 'yes-no-dropdown' ;
CHECKBOX        : 'checkbox' ;

FONTFAMILY      : 'font-family' ;
FONTSTYLE       : 'font-style' ;
FONTSIZE        : 'font-size' ;
FONTCOLOR       : 'font-color' ;
BACKGROUNDCOLOR : 'background-color' ;
BOLD            : 'bold' ;
ITALIC          : 'italic' ;
UNDERLINED      : 'underlined' ;

DEFAULT         : 'default' ;

//Types from KLQ
SET         : 'set' ;
BOOLEAN     : 'boolean' ;
DATE        : 'date' ;
KLQSTRING   : 'string' ;
NUMERAL     : 'numeral' ;

stylesheet
    : (page | section | question)+
    ;

page
    : 'page' title=STRING NEWLINE
         (section | question)+
          defaultStyle?
      'end' (NEWLINE+ | EOF)
    ;

section
    : 'section' title=STRING NEWLINE
          question+
          defaultStyle?
      'end' (NEWLINE+ | EOF)
    ;

question
    : full
    | identifier
    ;

full
    : ('question' id=IDENTIFIER NEWLINE
                declaration+
       'end' (NEWLINE+ | EOF))
    ;

identifier
    : (id=IDENTIFIER NEWLINE)
    ;

declaration
    : property ':' value NEWLINE
    ;

property
    : 'font-family'
    | 'font-style'
    | 'font-size'
    | 'font-color'
    | 'background-color'
    | 'widget'
    ;

value
    : STRING
    | INT
    | HEXCOLOR
    | fontStyle
    | widget
    ;

fontStyle
    : 'bold'       #bold
    | 'italic'     #italic
    | 'underlined' #underlined
    ;

widget
    : 'slider'          #slider
    | 'spinbox'         #spinbox
    | 'text'            #text
    | 'yes-no-radio'    #yesnoradio
    | 'yes-no-dropdown' #yesnodropdown
    | 'checkbox'        #checkbox
    ;

defaultStyle
    : 'default' klqType NEWLINE
          declaration+
      'end' NEWLINE+
    ;

klqType
    : 'set'
    | 'boolean'
    | 'date'
    | 'string'
    | 'numeral'
    ;

IDENTIFIER
    : Letter LetterOrDigit*
    ;

STRING
    : '"' StringCharacter* '"'
    ;

INT
    : Digit+
    ;

HEXCOLOR
    : '#' HexChar HexChar HexChar HexChar HexChar HexChar
    ;

fragment StringCharacter
    : ~[\\"]
    ;

fragment Letter
    : [a-zA-Z]
    ;

fragment HexChar
    : [a-fA-F0-9]
    ;

fragment LetterOrDigit
    : [a-zA-Z0-9]
    ;

fragment Digit
    : [0-9]
    ;

//New lines
NEWLINE
    : '\r'? '\n' | '\f'
    ;

// Whitespace and comments
WHITESPACE
    : [ \t]+ -> skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;

LINECOMMENT
    : '//' ~[\r\n]* -> skip
    ;