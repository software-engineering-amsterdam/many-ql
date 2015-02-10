grammar QL;
start
    : FORM_TAG UPPERCASE CURL_OPEN question+ CURL_CLOSE;
question
    : question_name question_type question_label
    ;
question_name
    : UPPERCASE
    ;
question_type
    : UPPERCASE
    ;
question_label
    : STRING
    ;

STRING
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