grammar QLS;

@header {
package nl.uva.softwcons.generated;
}

/* Parser */
stylesheet:   'stylesheet' ID '{' page+ '}';

page: 'page' ID '{' pageSegment+ defaultStatement* '}';

section: 'section' STRING '{' pageSegment+ defaultStatement* '}';

pageSegment: question
           | section
           ;

defaultStatement: 'default' type widget;

question: 'question' ID                              # questionWithoutWidget
        | 'question' ID widget                       # questionWithWidget
        ;

widget: 'widget' widgetType                          # widgetWithoutStyle
      | 'widget' widgetType style                    # widgetWithStyle
      ;

style: '{' styleProperty+ '}';

styleProperty: key=STRING ':' value;

value: ID
     | STRING
     | NUMBER
     ;

type: BOOL_TYPE
    | STRING_TYPE
    | NUM_TYPE
    | DATE_TYPE
    ;

widgetType: RADIO '(' yes=STRING',' no=STRING ')'                     # radio
          | CHECKBOX '(' yes=STRING ')'                               # checkbox
          | DROPDOWN '(' yes=STRING',' no=STRING ')'                  # dropdown
          | SLIDER '(' start=NUMBER',' end=NUMBER',' step=NUMBER ')'  # slider
          | TEXT                                                      # text
          ;


/* Lexer */
// Types
BOOL_TYPE    : 'boolean' ;
STRING_TYPE  : 'string' ;
NUM_TYPE     : 'number' ;
DATE_TYPE    : 'date' ;

RADIO        : 'radio';
CHECKBOX     : 'checkbox';
SPINBOX      : 'spinbox';
DROPDOWN     : 'dropdown';
SLIDER       : 'slider';
TEXT         : 'text';

// Identifiers
ID : [a-zA-Z][a-zA-Z0-9]*;

// Strings
STRING : '"' ~["\r\n]* '"';

// Numbers, inspired by JSON.g4 in antlr/grammars-v4/ repository
NUMBER :  '-'? INT_FRAG
    |     '-'? INT_FRAG '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |     '-'? INT_FRAG EXP // 1e10 -3e4
    ;

fragment EXP : [Ee] [+\-]? INT_FRAG ; // \- since - means "range" inside [...]
fragment INT_FRAG : '0' | [1-9] [0-9]* ; // no leading zeros

// Comments
COMMENT : '//' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;

// Whitespace
WS : [ \n\t\r]+ -> skip;