grammar EncodersQLS;
import EncodersQLSLexerRules;

stylesheet: 'stylesheet' name=NAME page+ EOF;
    
page: 'page' name=NAME '{' section+ defaultStyle* '}';
    
section: 
         'section' name=STRINGLITERAL      (question | section | defaultStyle)
       | 'section' name=STRINGLITERAL ('{' (question | section | defaultStyle)+ '}') 
       ;

question:  'question' name=NAME widget?;

defaultStyle:
          'default' DATATYPE     (styleProperty | widget)
        | 'default' DATATYPE  '{' styleProperty* widget? '}'
        ;

styleProperty:  
            ('width:' value=INTEGERLITERAL)     #Width
          | ('font:' value=STRINGLITERAL)       #Font
          | ('fontsize:' value=INTEGERLITERAL)  #FontSize
          | ('color:' '#'value=STRINGLITERAL)  #Color
          ;
          
widget:   'widget' 'textfield'                                          #TextField
        | 'widget' 'numberfield'                                        #NumberField
        | 'widget' 'checkbox'                                           #CheckBox
        | 'widget' 'radio' '(' STRINGLITERAL (',' STRINGLITERAL)* ')'   #Radio
        ;
        