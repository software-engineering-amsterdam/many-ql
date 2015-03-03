grammar QLS;

import Types, Ident, Comments;

stylesheet :  'stylesheet' Identifier '{' (page)+ '}';

page : 'page' Identifier '{' (statement)+ '}';

statement : section | question | defaultStmt;

section : 'section' String '{' (statement)+ '}';

question : 'question' Identifier ('{' (stylesheetRule)+ '}')?;

defaultStmt : 'default' QuestionType '{' (stylesheetRule)+ '}';

stylesheetRule
    : 'width' ':' Integer
    | 'fontsize' ':' Integer
    | 'font' ':' String
    | 'color' ':' Color
    | 'widget' WidgetType;

fragment Hex : [0-9A-F];

WidgetType
    : 'spinbox'
    | 'checkbox'
    | 'radio' ;

Color : [#] Hex Hex Hex Hex Hex Hex;
