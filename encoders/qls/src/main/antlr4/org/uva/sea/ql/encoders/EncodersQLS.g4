grammar EncodersQLS;
import EncodersQLSLexerRules;

stylesheet:
    'stylesheet' name=NAME '{'  
    page+
    '}'
    EOF;
    
page: 'page''{'  
      section+
      '}';
    
section: 'section' name=NAME
         question;

question:  'question' name=NAME
            widget?;
            
widget: 'widget' spinbox | radio;

spinbox: 'spinbox';

radio: 'radio' '(' STRINGLITERAL (',' STRINGLITERAL)* ')';



    
