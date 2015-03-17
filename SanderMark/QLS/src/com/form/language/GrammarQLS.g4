grammar GrammarQLS;

stylesheet returns[StyleSheet result]
	: 'stylesheet' ID '{' pages=pageList {$result = new StyleSheet($ID.text,$pages.result);}'}' 
;

pageList returns [List<Page> result]
	@init {List<Page> pages = new ArrayList<Page>();}
	: (stmt=page {stmts.add($stmt.result);})+ 
	{$result = stmts;}
	;
	
page returns [Page result]
	: 'page' ID '{' stmts=statementList {$result = new Page($ID.text,$stmts.result);}'}' 
;

statementList returns [List<Statement> result]
	@init {List<Statement> sections = new ArrayList<Statement>();}
	: (stmt=statement {stmts.add($stmt.result);})+ 
	{$result = stmts;}
	;
	
statement returns [Statement result]
: Sectionstmt=sectionStatement 	 {$result = $Sectionstmt.result;}
| Questionstmt=questionStatement {$result = $Questionstmt.result;}
| Defaultstmt=defaultStatement 	 {$result = $Defaultstmt.result;}
;

sectionStatement returns [Section result]
	: 'section' STRING '{' stmts=statementList {$result = new Section($STRING.text,$stmts.result);}'}' 
;

questionStatement returns [Question result]
	: 'question' ID widget {$result = new Question($ID.text, $widget.result);}
	| 'question' ID 	   {$result = new Question($ID.text);}
;

defaultStatement returns[Default result]
	: 'default' type widget { $result = new Default($type.result,$widget.result);}
	| 'default' type '{' styles=styleList widget { $result = new Default($type.result,$widget.result,$styles.result);} '}'
;

styleList returns [List<Style> result]
	@init {List<Style> sections = new ArrayList<Style>();}
	: (stmt=style {stmts.add($stmt.result);})+ 
	{$result = stmts;}
	;

widget returns [Widget result]
	: 'widget' specificWidget {$result = new Widget($specificWidget.result)};

specificWidget returns [Widget result]
	: 'textbox' 						  	{$result = new TextBox();}
	| 'checkbox' 						  	{$result = new CheckBox();}
	| 'spinbox'						  	  	{$result = new SpinBox();}	
	| 'slider' 						  	  	{$result = new Slider();}	
	| 'dropdown''(' STRING ',' STRING ')' 	{$result = new DropDown();} 
	| 'radiobutton' 	'(' STRING ','  STRING ')'	{$result = new RadioButton();} 
	;
	
style returns [Style result]:
	 'width' ':' INTEGER 	  {$result = new Width($INTEGER.text);}
	| 'font' ':' STRING  	  {$result = new Width($STRING.text);}
	| 'fontsize' ':' INTEGER  {$result = new FontSize($INTEGER.text)}
	| 'color' ':' COLOR 	  {$result = new Color($COLOR.text)}
	;	
	
type returns [Type result]
	: 'Boolean' {$result = new BoolType();}
	| 'String'  {$result = new StringType();}
	| 'Number'  {$result = new IntType();};


BOOLEAN : 'true' | 'false';
STRING: '"'.*?'"';
INTEGER : [0-9]+;
COLOR : '#' DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT;

ID : ([a-z][A-Za-z0-9]+);
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
COMMENT : '//' .*? ('\n'|'\r') -> skip;
DIGIT : [0-9];