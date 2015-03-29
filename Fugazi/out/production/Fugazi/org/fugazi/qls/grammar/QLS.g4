grammar QLS;

// stylesheet name, ROOT NODE
stylesheet : 'stylesheet' ID page*;

// Page, includes default declarations, and/or sections.
page    : 'page' ID '{' (defaultStyleDeclr | section)* '}';

// Section, includes questions and/or other sections, and/or default style.
section : 'section' STRING (question | section | defaultStyleDeclr)
        | 'section' STRING '{' (question | section | defaultStyleDeclr)* '}'
        ;

// question id (zero or one widget)
question : 'question' ID widget                 # questionWithWidget
         | 'question' ID                        # questionWithoutWidget
         ;

// widget
widget : 'widget' supportedWidget;

// defaultStyle, can be: default boolean widget radio("Yes", "No"), and/or default int { style widget }
defaultStyleDeclr : 'default' type widget                           # noStylesDefaultDeclr
                  | 'default' type '{' styleProperty+ widget '}'    # stylesDefaultDeclr
                  ;

/**
 * Definitions.
 */

// The supported widgets
supportedWidget : 'checkbox'                                    # checkboxWidget
                | 'radio' '(' yes=STRING ',' no=STRING ')'      # radioWidget
                | 'dropdown' '(' yes=STRING ',' no=STRING ')'   # dropdownWidget
                | 'spinbox'                                     # spinboxWidget
                | 'slider'                                      # sliderWidget
                | 'textbox'                                     # textWidget
                ;

// Properties for styling
styleProperty : 'width:' NUMBER         # widthStyleProperty
              | 'font:' STRING          # fontStyleProperty
              | 'fontsize:' NUMBER      # fontsizeStyleProperty
              | 'color:' HEX            # colorStyleProperty
              ;

// all alowed variable types.
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
HEX : '#' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT ;

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
fragment HEXDIGIT: [0-9a-fA-F] ;
fragment UNICODE : 'u' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT ;
fragment DIGIT   : [0-9] ;