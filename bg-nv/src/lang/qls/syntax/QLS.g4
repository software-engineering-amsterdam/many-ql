grammar QLS;

import Types, Ident, Comments;

stylesheet :  'stylesheet' Identifier '{'  '}';

page : 'page' Identifier '{' '}';

section : 'section' String '{' '}';

question : ('question' Identifier) | ('question' Identifier 'widget' WidgetType);

WidgetType
    : 'spinbox'
    | 'checkbox'
    | 'radio' ;
