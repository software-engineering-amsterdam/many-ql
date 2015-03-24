%{

package parser

import (
	"strconv"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
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

%left  '+'  '-'
%left  '*'  '/'
%left  '.'  '%'

// Add tokens here must also lead to a lexer update at lexer.go
%token BlockBeginToken
%token BlockEndToken
%token FormToken
%token IfToken
%token ParenBeginToken
%token ParenEndToken
%token QuotedStringToken
%token TextToken
%token StringQuestionToken
%token NumericQuestionToken
%token BoolQuestionToken
%token ComputedQuestionToken
%token '+' '-' '*' '/' '(' ')' '!' '.' '%'
%token LessThanToken
%token LessOrEqualsThanToken
%token MoreThanToken
%token MoreOrEqualsThanToken
%token EqualsToToken
%token NotEqualsToToken
%token NumericToken
%token ElseToken
%token BoolAndToken
%token BoolOrToken
%token BoolTrueToken
%token BoolFalseToken
%token LikeToken

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
		$$.questionaire = ast.NewQuestionaireNode($2.content, $4.stack, $2.position)
	}
	;

stack:
	| stack question
	{
		q := $2.question
		qs := $$.stack
		action := ast.NewActionNode(q, $2.position)
		qs = append(qs, action)
		$$.stack = qs
	}
	| stack ifBlock
	{
		ifNode := $2.ifNode
		qs := $$.stack
		action := ast.NewActionNode(ifNode, $2.position)
		qs = append(qs, action)
		$$.stack = qs
	}
	;

question:
	QuotedStringToken TextToken questionType
	{
		$$.question = ast.NewQuestionNode($1.content, $2.content, $3.questionType, $1.position)
	}
	;


questionType:
	TextToken
	{
		$$.questionType = ast.NewScalarQuestion($1.content, $1.position)
	}
	| ComputedQuestionToken '=' andOrBlock
	{
		$$.questionType = ast.NewComputedQuestion($3.evaluatable, $3.position)
	}
	;

ifBlock:
	IfToken '(' andOrBlock ')' '{' stack '}'
	{
		$$.ifNode = ast.NewIfNode($3.evaluatable, $6.stack, nil, $1.position)

		$$.evaluatable = new(ast.Evaluatable)
		$$.stack = []*ast.ActionNode{}
		$3.evaluatable = new(ast.Evaluatable)
		$6.stack = []*ast.ActionNode{}
	}
	| IfToken '(' andOrBlock ')' '{' stack '}' ElseToken ifBlock
	{
		$$.ifNode = ast.NewIfNode($3.evaluatable, $6.stack, $9.ifNode, $1.position)

		$$.evaluatable = new(ast.Evaluatable)
		$$.stack = []*ast.ActionNode{}
		$3.evaluatable = new(ast.Evaluatable)
		$6.stack = []*ast.ActionNode{}
		$9.ifNode = nil
	}
	| IfToken '(' andOrBlock ')' '{' stack '}' ElseToken '{' stack '}'
	{
		elseNode := ast.NewIfNode(
			ast.NewTermNode(ast.NumericLiteralNodeType, true, 1, "", "", $8.position),
			$10.stack,
			nil,
			$8.position,
		)
		$$.ifNode = ast.NewIfNode($3.evaluatable, $6.stack, elseNode, $1.position)

		$$.evaluatable = new(ast.Evaluatable)
		$$.stack = []*ast.ActionNode{}
		$3.evaluatable = new(ast.Evaluatable)
		$6.stack = []*ast.ActionNode{}
		$10.stack = []*ast.ActionNode{}
	}
	;

andOrBlock:
	evaluatable BoolAndToken evaluatable
	{
		$$.evaluatable = ast.NewBoolAndNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| evaluatable BoolOrToken evaluatable
	{
		$$.evaluatable = ast.NewBoolOrNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| evaluatable
	;

evaluatable:
	term EqualsToToken term
	{
		$$.evaluatable = ast.NewEqualsNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term NotEqualsToToken term
	{
		$$.evaluatable = ast.NewNotEqualsNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term MoreThanToken term
	{
		$$.evaluatable = ast.NewMoreThanNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term LessThanToken term
	{
		$$.evaluatable = ast.NewLessThanNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term MoreOrEqualsThanToken term
	{
		$$.evaluatable = ast.NewMoreOrEqualsThanNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term LessOrEqualsThanToken term
	{
		$$.evaluatable = ast.NewLessOrEqualsThanNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term LikeToken term
	{
		$$.evaluatable = ast.NewLikeNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| '!' evaluatable
	{
		$$.evaluatable = ast.NewBoolNegNode($2.evaluatable, $1.position)
	}
	| term
	;

term:
	term '+' term
	{
		$$.evaluatable = ast.NewMathAddNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term '-' term
	{
		$$.evaluatable = ast.NewMathSubNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term '*' term
	{
		$$.evaluatable = ast.NewMathMulNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term '/' term
	{
		$$.evaluatable = ast.NewMathDivNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term '%' term
	{
		$$.evaluatable = ast.NewMathModNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| term '.' term
	{
		$$.evaluatable = ast.NewConcatNode($1.evaluatable, $3.evaluatable, $2.position)
	}
	| '(' andOrBlock ')'
	{
		$$ = $2
	}
	| value
	{
		$$.evaluatable = $1.termNode
		$$.position = $1.position
	}
	;

value:
	NumericToken
	{
		num, _ := strconv.ParseFloat($1.content, 32)
		$$.num = float32(num)
		termNode := ast.NewTermNode(
			ast.NumericLiteralNodeType,
			false,
			$$.num,
			"",
			"",
			$1.position,
		)
		$$.termNode = termNode
	}
	| TextToken
	{
		termNode := ast.NewTermNode(
			ast.IdentifierReferenceNodeType,
			false,
			$$.num,
			"",
			$1.content,
			$1.position,
		)
		$$.termNode = termNode
	}
	| QuotedStringToken
	{
		termNode := ast.NewTermNode(
			ast.StringLiteralNodeType,
			false,
			$$.num,
			$1.content,
			"",
			$1.position,
		)
		$$.termNode = termNode
	}
	| BoolTrueToken
	{
		termNode := ast.NewTermNode(
			ast.BooleanLiteralNodeType,
			true,
			1,
			"",
			"",
			$1.position,
		)
		$$.termNode = termNode
	}
	| BoolFalseToken
	{
		termNode := ast.NewTermNode(
			ast.BooleanLiteralNodeType,
			false,
			0,
			"",
			"",
			$1.position,
		)
		$$.termNode = termNode
	}
	;
%%
