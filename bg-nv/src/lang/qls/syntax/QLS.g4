grammar QLS;

import Types, Ident, Comments;

stylesheet :  'stylesheet' Identifier '{'  '}';

page : 'page' Identifier '{' '}';

section : 'section' String '{' '}';

question : ('question' Identifier) | ('question' Identifier 'widget' WidgetType);

default : 'default' Type '{' (style)* '}';

style
    : 'width' ':' Number
    | 'fontsize' ':' Number
    | 'font' ':' String
    | 'color' ':' Color;

WidgetType
    : 'spinbox'
    | 'checkbox'
    | 'radio' ;

fragment Hex : [0-9A-F];

Color : [#] Hex Hex Hex Hex Hex Hex;
