grammar QL;
start
    : FORM_TAG UPPERCASE CURL_OPEN question+ CURL_CLOSE;

question
    : UPPERCASE UPPERCASE LABEL
    ;
LABEL
 : '"' (~[\r\n"] | '""')* '"'
 ;
UPPERCASE
    : [A-Z]+
    ;

FORM_TAG
    : 'form'
    ;
CURL_OPEN
    : '{'
    ;
CURL_CLOSE
    : '}'
    ;
WS
    : [ \t\r\n]+ -> skip
    ; // skip spaces, tabs, newlines