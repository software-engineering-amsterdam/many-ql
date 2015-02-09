grammar QL;
form    :   'form' FORMNAME '{' NUMERIC NUMERIC QLABEL '}';
FORMNAME    :   [A-Z]+;
NUMERIC     :   [a-z]+;
QLABEL      :   '"' [a-z]+ '"';
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines