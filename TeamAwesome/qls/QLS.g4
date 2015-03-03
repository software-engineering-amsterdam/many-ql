grammar QLS;

qls
    :   nested_statement*
    ;

nested_statement
    :   stylesheet_statement
    |   default_statement
    |   page_statement
    |   section_statement
    |   question_statement
    ;

stylesheet_statement
    :   'stylesheet' name=identifier '{' statements+=nested_statement* '}'
    ;

default_statement
    :   'default' qtype=question_type '{' attributes+=style_attribute* '}'
    ;

style_attribute
    :   name=attribute_name ':' value=attribute_value
    ;

page_statement
    :   'page' name=string '{' statements+=nested_statement* '}'
    ;

section_statement
    :   'section' name=string '{' statements+=nested_statement* '}'
    ;

question_statement
    :   'question' name=identifier ('{' attributes+=style_attribute* '}')?
    ;

attribute_name  : IDENTIFIER ;
attribute_value
    :   integer
    |   string
    |   widget
    ;

question_type
    :   'boolean' 
    |   'integer' 
    |   'string'
    |   'money'
    ;

widget
    :   wtype=widget_type ( '(' options=widget_options ')' )?
    ;

widget_type
    :   'spinbox'
    |   'yesno-radio'
    |   'yesno-dropdown'
    |   'checkbox'
    |   'text'
    |   'slider'
    ;


widget_options
    :   widget_option (',' widget_option)*
    ;

widget_option
    :   integer
    |   string
    ;

identifier      : IDENTIFIER ;
string          : STRING ;
integer         : INTEGER ;

STRING       : '"' (ESC | ~["\\])* '"' ;
fragment ESC : '\\' (["\\/bfnrt]) ;

INTEGER    : '-'? '0' | [1-9] [0-9]*  ;
IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

WS      : [ \n\r\t]+    -> skip ;
COMMENT : '//' ~[\r\n]* -> skip ;
