%{

package parser

import (
	"fmt"
	"log"
	"math/big"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

var finalQuestionaire *ast.QuestionaireNode

//Top Ends Here
%}

%start top

%union {
	content string

	questionaire *ast.QuestionaireNode
	stack []*ast.ActionNode
	question *ast.QuestionNode
	questionType ast.Parser
	ifNode *ast.IfNode
	num *big.Rat

	position scanner.Position
}

%token BlockBeginToken
%token BlockEndToken
%token FormToken
%token IfToken
%token ParenBeginToken
%token ParenEndToken
%token QuotedStringToken
%token TextToken
%token StringQuestionToken
%token IntQuestionToken
%token BoolQuestionToken
%token NumericToken
%token '+' '-' '*' '/' '(' ')'


%%

top:
	questionaire
	{
		if qlDebug > 0 {
			log.Printf("Top: %+v", $1.questionaire)
		}
		finalQuestionaire = $1.questionaire
	}
	;

questionaire:
	FormToken TextToken '{' stack '}'
	{
		if qlDebug > 0 {
			log.Println("Form: 1:", $1, "2:", $2, " 2c:", $2.content,
				" $$:", $$)
		}
		$$.questionaire = &ast.QuestionaireNode{
			Label: $2.content,
			Stack: $4.stack,
		}
	}
	;

stack:
	| stack question
	{
		if qlDebug > 0 {
			log.Printf("Question Stack: 1:%#v 2:%#v $:%#v", $1.stack,
				$2.question, $$.stack)
		}
		q := $2.question
		qs := $$.stack
		action := &ast.ActionNode {
			Action: q,
		}
		qs = append(qs, action)
		$$.stack = qs
	}
	| stack ifBlock
	{
		ifNode := $2.ifNode
		qs := $$.stack
		action := &ast.ActionNode {
			Action: ifNode,
		}
		qs = append(qs, action)
		$$.stack = qs
	}
	;

question:
	QuotedStringToken TextToken questionType
	{
		$$.question = &ast.QuestionNode{
			Label: $1.content,
			Identifier: $2.content,
			Content: $3.questionType,
		}
	}
	;


// Extract question types out of grammar???
questionType: StringQuestionToken
		{
			$$.questionType = new(ast.StringQuestion)
		}
	    | IntQuestionToken
		{
			$$.questionType = new(ast.IntQuestion)
		}
	    | BoolQuestionToken
		{
			$$.questionType = new(ast.BoolQuestion)
		}

	    | TextToken
		{
			qllex.Error(fmt.Sprintf("Question type must be 'string', 'integer', 'bool'. Found: %s", $1.content))
		}


ifBlock: IfToken '(' expr ')' '{' stack '}'
		{
			ifNode := new(ast.IfNode)
			ifNode.Condition = $3.content
			ifNode.Stack = $6.stack
			$$.ifNode = ifNode
		}
	;


expr:
	TextToken
	|expr1
	| '+' expr
	{
		$$.num = $2.num
	}
	| '-' expr
	{
		$$.num.Neg($2.num)
	}

expr1:
	expr2
	| expr1 '+' expr2
	{
		$$.num.Add($1.num, $3.num)
	}
	| expr1 '-' expr2
	{
		$$.num.Sub($1.num, $3.num)
	}

expr2:
	expr3
	| expr2 '*' expr3
	{
		$$.num.Mul($1.num, $3.num)
	}
	| expr2 '/' expr3
	{
		$$.num.Quo($1.num, $3.num)
	}

expr3:
	NumericToken
	| '(' expr ')'
	{
		$$.num = $2.num
	}

%%
