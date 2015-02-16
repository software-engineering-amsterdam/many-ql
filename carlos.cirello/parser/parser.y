%{

package parser

import (
	"fmt"
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

%left  '+'  '-'
%left  '*'  '/'

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
%token IntQuestionToken
%token BoolQuestionToken
%token ComputedQuestionToken
%token '+' '-' '*' '/' '(' ')'
%token LessThanToken
%token LessOrEqualsThanToken
%token MoreThanToken
%token MoreOrEqualsThanToken
%token EqualsToToken
%token NumericToken
%token ElseToken

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
		$$.questionaire = ast.NewQuestionaireNode($2.content, $4.stack)
	}
	;

stack:
	| stack question
	{
		q := $2.question
		qs := $$.stack
		action := ast.NewActionNode(q)
		qs = append(qs, action)
		$$.stack = qs
	}
	| stack ifBlock
	{
		ifNode := $2.ifNode
		qs := $$.stack
		action := ast.NewActionNode(ifNode)
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
questionType:
	StringQuestionToken
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
	| ComputedQuestionToken '=' term
	{
		computedQuestion := new(ast.ComputedQuestion)
		computedQuestion.Expression = $3.evaluatable
		$$.questionType = computedQuestion
	}
	| term
	{
		qllex.Error(fmt.Sprintf("Question type must be 'string', 'integer', 'bool' or 'computed'. Found: %s", $1.content))
	}
	;

ifBlock:
	IfToken '(' evaluatable ')' '{' stack '}'
	{
		ifNode := new(ast.IfNode)
		ifNode.Conditions = $3.evaluatable
		ifNode.Stack = $6.stack
		$$.ifNode = ifNode

		$$.evaluatable = new(ast.Evaluatable)
		$$.stack = []*ast.ActionNode{}
		$3.evaluatable = new(ast.Evaluatable)
		$6.stack = []*ast.ActionNode{}
	}
	| IfToken '(' evaluatable ')' '{' stack '}' ElseToken ifBlock
	{
		ifNode := new(ast.IfNode)
		ifNode.Conditions = $3.evaluatable
		ifNode.Stack = $6.stack
		ifNode.ElseNode = $9.ifNode
		$$.ifNode = ifNode

		$$.evaluatable = new(ast.Evaluatable)
		$$.stack = []*ast.ActionNode{}
		$3.evaluatable = new(ast.Evaluatable)
		$6.stack = []*ast.ActionNode{}
		$9.ifNode = nil
	}
	| IfToken '(' evaluatable ')' '{' stack '}' ElseToken '{' stack '}'
	{
		ifNode := new(ast.IfNode)
		ifNode.Conditions = $3.evaluatable
		ifNode.Stack = $6.stack

		elseNode := new(ast.IfNode)
		elseCondition := &ast.TermNode{
			Type: ast.NumericConstantNodeType,
			NumericConstant: 1,
		}
		elseNode.Conditions = elseCondition
		elseNode.Stack = $10.stack
		ifNode.ElseNode = elseNode

		$$.ifNode = ifNode

		$$.evaluatable = new(ast.Evaluatable)
		$$.stack = []*ast.ActionNode{}
		$3.evaluatable = new(ast.Evaluatable)
		$6.stack = []*ast.ActionNode{}
		$10.stack = []*ast.ActionNode{}
	}
	;

evaluatable:
	term EqualsToToken term
	{
		condition := new (ast.EqualsNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term MoreThanToken term
	{
		condition := new (ast.MoreThanNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term LessThanToken term
	{
		condition := new (ast.LessThanNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term MoreOrEqualsThanToken term
	{
		condition := new (ast.MoreOrEqualsThanNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term LessOrEqualsThanToken term
	{
		condition := new (ast.LessOrEqualsThanNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term
	;

term:
	term '+' term
	{
		condition := new (ast.MathAddNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term '-' term
	{
		condition := new (ast.MathSubNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term '*' term
	{
		condition := new (ast.MathMulNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| term '/' term
	{
		condition := new (ast.MathDivNode)
		condition.LeftTerm = $1.evaluatable
		condition.RightTerm = $3.evaluatable
		$$.evaluatable = condition
	}
	| value
	{
		$$.evaluatable = $1.termNode
	}
	;

value:
	NumericToken
	{
		num, _ := strconv.ParseFloat($1.content, 32)
		$$.num = float32(num)
		termNode := new(ast.TermNode)
		termNode.NumericConstant = $$.num
		termNode.Type = ast.NumericConstantNodeType
		$$.termNode = termNode
	}
	| TextToken
	{
		termNode := new(ast.TermNode)
		termNode.IdentifierReference = $1.content
		termNode.Type = ast.IdentifierReferenceNodeType
		$$.termNode = termNode
	}
	| QuotedStringToken
	{
		termNode := new(ast.TermNode)
		termNode.StringConstant = $1.content
		termNode.Type = ast.StringConstantNodeType
		$$.termNode = termNode
	}
	;
%%
