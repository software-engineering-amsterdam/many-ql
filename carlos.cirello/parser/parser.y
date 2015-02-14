%{

package parser

import (
	"fmt"
	"log"
	"strconv"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

var finalQuestionaire *ast.QuestionaireNode

//Top Ends Here
%}

%start top

%union {
	content string
	num float32

	evaluatables []ast.Evaluatable
	evaluatable ast.Evaluatable
	ifNode *ast.IfNode
	question *ast.QuestionNode
	questionaire *ast.QuestionaireNode
	questionType ast.Parser
	stack []*ast.ActionNode
	termNode *ast.TermNode

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
%token '+' '-' '*' '/' '(' ')'
%token LessThanToken
%token LessOrEqualsThanToken
%token MoreThanToken
%token MoreOrEqualsThanToken
%token EqualsToToken
%token NumericToken

%%

top:
	questionaire
	{
		finalQuestionaire = $1.questionaire
	}
	;

questionaire:
	FormToken TextToken '{' stack '}'
	{
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


ifBlock: IfToken '(' evaluatables ')' '{' stack '}'
	{
		ifNode := new(ast.IfNode)
		ifNode.Conditions = $3.evaluatables
		ifNode.Stack = $6.stack
		$$.ifNode = ifNode

		$3.evaluatables = []ast.Evaluatable{}
	}
	;

evaluatables:
	| evaluatables evaluatable
	{
		evaluatables := $$.evaluatables
		evaluatables = append(evaluatables, $2.evaluatable)
		$$.evaluatables = evaluatables
	}
	;

evaluatable:
	term EqualsToToken term
	{
		condition := new (ast.EqualsNode)
		condition.LeftTerm = $1.termNode
		condition.RightTerm = $3.termNode
		$$.evaluatable = condition
	}
	| term MoreThanToken term
	{
		condition := new (ast.MoreThanNode)
		condition.LeftTerm = $1.termNode
		condition.RightTerm = $3.termNode
		$$.evaluatable = condition
	}
	| term LessThanToken term
	{
		condition := new (ast.LessThanNode)
		condition.LeftTerm = $1.termNode
		condition.RightTerm = $3.termNode
		$$.evaluatable = condition
	}
	| term MoreOrEqualsThanToken term
	{
		condition := new (ast.MoreOrEqualsThanNode)
		condition.LeftTerm = $1.termNode
		condition.RightTerm = $3.termNode
		$$.evaluatable = condition
	}
	| term LessOrEqualsThanToken term
	{
		condition := new (ast.LessOrEqualsThanNode)
		condition.LeftTerm = $1.termNode
		condition.RightTerm = $3.termNode
		$$.evaluatable = condition
	}
	| term
	{
		condition := new (ast.SingleTermNode)
		condition.LeftTerm = $1.termNode
		$$.evaluatable = condition
	}
	;

term: number
	{
		termNode := new(ast.TermNode)
		termNode.NumericConstant = $1.num
		$$.termNode = termNode
	}
	| TextToken
	{
		termNode := new(ast.TermNode)
		termNode.IdentifierReference = $1.content
		$$.termNode = termNode
	}
	;

number:
	NumericToken
	{
		num, _ := strconv.ParseFloat($1.content, 32)
		$$.num = float32(num)
	}
	;

// expr:
// 	expr1
// 	| '+' expr { $$.num = $2.num }
// 	| '-' expr { $$.num.Neg($2.num) }
//
// expr1:
// 	expr2
// 	| NumericToken { $$.num = $1.num }
// 	| TextToken
// 	| expr1 '+' expr2 { $$.num.Add($1.num, $3.num) }
// 	| expr1 '-' expr2 { $$.num.Sub($1.num, $3.num) }
//
// expr2:
// 	expr3
// 	| expr2 '*' expr3 { $$.num.Mul($1.num, $3.num) }
// 	| expr2 '/' expr3 { $$.num.Quo($1.num, $3.num) }
//
// expr3:
// 	| '(' expr ')' { $$.num = $2.num }
%%
