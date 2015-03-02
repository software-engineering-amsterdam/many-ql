grammar QLS;

// stylesheet name
stylesheet : 'stylesheet' ID;

// Page, includes default declarations, and/or sections
page    : 'page' ID '{' (defaultStyleDeclr | section)* '}';

// Section, includes questions
section : 'section' STRING '{' question* '}'; //todo: make curlies optional for single statements

// question
question : 'question' ID widget;

// widget
widget : 'widget' supportedWidget;

// defaultStyle
defaultStyleDeclr : 'default' type widget; // todo: create this.

/**
 * Definitions.
 */

// The supported widgets
supportedWidget : 'checkbox'    # checkboxWidget
                | 'radio'       # radioWidget
                | 'dropdown'    # dropdownWidget
                | 'spinbox'     # spinboxWidget
                | 'slider'      # sliderWidget
                | 'text'        # textWidget
                ;

// Properties for styling
styleProperty : 'width' NUMBER
              | 'font' STRING
              | 'fontsize' NUMBER
              | 'color' '#'HEX
              | widget
              ;


// all alowed variable types. //todo: share grammar part with QL?
type    : 'bool'        # boolType
        | 'int'         # intType
        | 'string'      # stringType
        ;

/**
 * LITERALS
 */

// String
STRING :  '"' (ESC | ~["\\])* '"' ;

// Identidier
ID  :   [a-zA-Z]+;

// Number
NUMBER : DIGIT+ ;

// HEX
HEX : [0-9a-fA-F] ;

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
fragment DIGIT   : [0-9] ; // match single digit