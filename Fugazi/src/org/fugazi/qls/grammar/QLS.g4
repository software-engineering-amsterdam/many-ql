grammar QLS;

// top node
stylesheet : 'stylesheet' ID;

// Page
page    : 'page' ID '{' section* '}';

// Section
section : 'section' STRING;

// question
question : 'question' ID;

// widget
widget : 'widget' widgets;

widgets : 'checkbox'    # checkboxWidget
        | 'radio'       # radioWidget
        | 'dropdown'    # dropdownWidget
        | 'spinbox'     # spinboxWidget
        | 'slider'      # sliderWidget
        | 'text'        # textWidget
        ;

/**
 * LITERALS
 */
STRING :  '"' (ESC | ~["\\])* '"' ;
ID  :   [a-zA-Z]+;

// comment matches anything between /* and */
COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN)
    ;

// ignore whitespaces
WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;

// line comment matches anything after // until newline
LINE_COMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
    ;

// Fragments
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
fragment DIGIT   : [0-9] ; // match single digit