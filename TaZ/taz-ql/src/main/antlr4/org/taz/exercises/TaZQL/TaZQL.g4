/**
 * Define a grammar called Hello
 */
grammar TaZQL;

/** A rule called init that matches comma-separated values between {...}. */
init  : page ;  // must match at least one value

page  : title content ;
title : 'title:' STRING ;
content :'{' question answer ' }' | '{' question answer ' },' content ;
question : Q STRING ;
answer : A STRING ;

Q : 'q:' ;
A : 'a:' ;
STRING : [a-zA-Z]+ ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

