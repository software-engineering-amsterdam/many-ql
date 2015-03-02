grammar QLS;

// stylesheet name, ROOT NODE
stylesheet : 'stylesheet' ID page*;

// Page, includes default declarations, and/or sections.
page    : 'page' ID '{' (defaultStyleDeclr | section)* '}';

// Section, includes questions and/or other sections, and/or default declarations.
section : 'section' STRING question
        | 'section' STRING '{' (question | section)* '}';

// question id (zero or one widget)
question : 'question' ID widget??;

// widget
widget : 'widget' supportedWidget   # simpleWidget
       | defaultStyleDeclr          # defaultStyleWidget
       ;

// defaultStyle, can be: default boolean widget radio("Yes", "No"), and/or default int { style widget }
defaultStyleDeclr : 'default' type widget                           # noStylesDefault
                  | 'default' type '{' styleProperty* widget '}'    # stylesDefault
                  ;

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
HEX : [0-9a-fA-F] ; // todo: does not work

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