//line parser.y:2
package parser

import __yyfmt__ "fmt"

//line parser.y:3
import (
	"fmt"
	"strconv"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

var finalQuestionaire *ast.QuestionaireNode

//Top Ends Here

//line parser.y:20
type qlSymType struct {
	yys     int
	content string
	num     float32

	evaluatables []ast.Evaluatable
	evaluatable  ast.Evaluatable
	ifNode       *ast.IfNode
	question     *ast.QuestionNode
	questionaire *ast.QuestionaireNode
	questionType ast.Parser
	stack        []*ast.ActionNode
	termNode     *ast.TermNode

	position scanner.Position
}

const BlockBeginToken = 57346
const BlockEndToken = 57347
const FormToken = 57348
const IfToken = 57349
const ParenBeginToken = 57350
const ParenEndToken = 57351
const QuotedStringToken = 57352
const TextToken = 57353
const StringQuestionToken = 57354
const IntQuestionToken = 57355
const BoolQuestionToken = 57356
const ComputedQuestionToken = 57357
const LessThanToken = 57358
const LessOrEqualsThanToken = 57359
const MoreThanToken = 57360
const MoreOrEqualsThanToken = 57361
const EqualsToToken = 57362
const NumericToken = 57363
const ElseToken = 57364

var qlToknames = []string{
	"'+'",
	"'-'",
	"'*'",
	"'/'",
	"BlockBeginToken",
	"BlockEndToken",
	"FormToken",
	"IfToken",
	"ParenBeginToken",
	"ParenEndToken",
	"QuotedStringToken",
	"TextToken",
	"StringQuestionToken",
	"IntQuestionToken",
	"BoolQuestionToken",
	"ComputedQuestionToken",
	"'('",
	"')'",
	"LessThanToken",
	"LessOrEqualsThanToken",
	"MoreThanToken",
	"MoreOrEqualsThanToken",
	"EqualsToToken",
	"NumericToken",
	"ElseToken",
}
var qlStatenames = []string{}

const qlEofCode = 1
const qlErrCode = 2
const qlMaxDepth = 200

//line parser.y:265

//line yacctab:1
var qlExca = []int{
	-1, 1,
	1, -1,
	-2, 0,
}

const qlNprod = 29
const qlPrivate = 57344

var qlTokenNames []string
var qlStates []string

const qlLast = 68

var qlAct = []int{

	6, 9, 19, 27, 28, 29, 30, 23, 22, 15,
	16, 17, 18, 26, 42, 11, 25, 5, 10, 50,
	21, 34, 36, 33, 35, 32, 31, 13, 11, 37,
	38, 39, 40, 41, 54, 43, 44, 45, 46, 47,
	12, 11, 11, 48, 10, 10, 52, 4, 3, 23,
	22, 20, 51, 53, 27, 28, 29, 30, 29, 30,
	49, 7, 21, 24, 14, 8, 2, 1,
}
var qlPact = []int{

	38, -1000, -1000, 32, -12, -1000, 31, -1000, -1000, -1000,
	25, 7, -7, 35, -1000, -1000, -1000, -1000, -18, 50,
	-1000, -1000, -1000, -1000, 5, -1, 35, 35, 35, 35,
	35, -15, 35, 35, 35, 35, 35, 50, 52, 52,
	-1000, -1000, -1000, 50, 50, 50, 50, 50, 30, -9,
	17, -1000, -1000, 4, -1000,
}
var qlPgo = []int{

	0, 67, 66, 0, 65, 1, 64, 2, 63, 51,
}
var qlR1 = []int{

	0, 1, 2, 3, 3, 3, 4, 6, 6, 6,
	6, 6, 5, 5, 5, 8, 8, 8, 8, 8,
	8, 7, 7, 7, 7, 7, 9, 9, 9,
}
var qlR2 = []int{

	0, 1, 5, 0, 2, 2, 3, 1, 1, 1,
	3, 1, 7, 9, 11, 3, 3, 3, 3, 3,
	1, 3, 3, 3, 3, 1, 1, 1, 1,
}
var qlChk = []int{

	-1000, -1, -2, 10, 15, 29, -3, 30, -4, -5,
	14, 11, 15, 20, -6, 16, 17, 18, 19, -7,
	-9, 27, 15, 14, -8, -7, 31, 4, 5, 6,
	7, 21, 26, 24, 22, 25, 23, -7, -7, -7,
	-7, -7, 29, -7, -7, -7, -7, -7, -3, 30,
	28, -5, 29, -3, 30,
}
var qlDef = []int{

	0, -2, 1, 0, 0, 3, 0, 2, 4, 5,
	0, 0, 0, 0, 6, 7, 8, 9, 0, 11,
	25, 26, 27, 28, 0, 20, 0, 0, 0, 0,
	0, 0, 0, 0, 0, 0, 0, 10, 21, 22,
	23, 24, 3, 15, 16, 17, 18, 19, 0, 12,
	0, 13, 3, 0, 14,
}
var qlTok1 = []int{

	1, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	20, 21, 6, 4, 3, 5, 3, 7, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 31, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 29, 3, 30,
}
var qlTok2 = []int{

	2, 3, 8, 9, 10, 11, 12, 13, 14, 15,
	16, 17, 18, 19, 22, 23, 24, 25, 26, 27,
	28,
}
var qlTok3 = []int{
	0,
}

//line yaccpar:1

/*	parser for yacc output	*/

var qlDebug = 0

type qlLexer interface {
	Lex(lval *qlSymType) int
	Error(s string)
}

const qlFlag = -1000

func qlTokname(c int) string {
	// 4 is TOKSTART above
	if c >= 4 && c-4 < len(qlToknames) {
		if qlToknames[c-4] != "" {
			return qlToknames[c-4]
		}
	}
	return __yyfmt__.Sprintf("tok-%v", c)
}

func qlStatname(s int) string {
	if s >= 0 && s < len(qlStatenames) {
		if qlStatenames[s] != "" {
			return qlStatenames[s]
		}
	}
	return __yyfmt__.Sprintf("state-%v", s)
}

func qllex1(lex qlLexer, lval *qlSymType) int {
	c := 0
	char := lex.Lex(lval)
	if char <= 0 {
		c = qlTok1[0]
		goto out
	}
	if char < len(qlTok1) {
		c = qlTok1[char]
		goto out
	}
	if char >= qlPrivate {
		if char < qlPrivate+len(qlTok2) {
			c = qlTok2[char-qlPrivate]
			goto out
		}
	}
	for i := 0; i < len(qlTok3); i += 2 {
		c = qlTok3[i+0]
		if c == char {
			c = qlTok3[i+1]
			goto out
		}
	}

out:
	if c == 0 {
		c = qlTok2[1] /* unknown char */
	}
	if qlDebug >= 3 {
		__yyfmt__.Printf("lex %s(%d)\n", qlTokname(c), uint(char))
	}
	return c
}

func qlParse(qllex qlLexer) int {
	var qln int
	var qllval qlSymType
	var qlVAL qlSymType
	qlS := make([]qlSymType, qlMaxDepth)

	Nerrs := 0   /* number of errors */
	Errflag := 0 /* error recovery flag */
	qlstate := 0
	qlchar := -1
	qlp := -1
	goto qlstack

ret0:
	return 0

ret1:
	return 1

qlstack:
	/* put a state and value onto the stack */
	if qlDebug >= 4 {
		__yyfmt__.Printf("char %v in %v\n", qlTokname(qlchar), qlStatname(qlstate))
	}

	qlp++
	if qlp >= len(qlS) {
		nyys := make([]qlSymType, len(qlS)*2)
		copy(nyys, qlS)
		qlS = nyys
	}
	qlS[qlp] = qlVAL
	qlS[qlp].yys = qlstate

qlnewstate:
	qln = qlPact[qlstate]
	if qln <= qlFlag {
		goto qldefault /* simple state */
	}
	if qlchar < 0 {
		qlchar = qllex1(qllex, &qllval)
	}
	qln += qlchar
	if qln < 0 || qln >= qlLast {
		goto qldefault
	}
	qln = qlAct[qln]
	if qlChk[qln] == qlchar { /* valid shift */
		qlchar = -1
		qlVAL = qllval
		qlstate = qln
		if Errflag > 0 {
			Errflag--
		}
		goto qlstack
	}

qldefault:
	/* default state action */
	qln = qlDef[qlstate]
	if qln == -2 {
		if qlchar < 0 {
			qlchar = qllex1(qllex, &qllval)
		}

		/* look through exception table */
		xi := 0
		for {
			if qlExca[xi+0] == -1 && qlExca[xi+1] == qlstate {
				break
			}
			xi += 2
		}
		for xi += 2; ; xi += 2 {
			qln = qlExca[xi+0]
			if qln < 0 || qln == qlchar {
				break
			}
		}
		qln = qlExca[xi+1]
		if qln < 0 {
			goto ret0
		}
	}
	if qln == 0 {
		/* error ... attempt to resume parsing */
		switch Errflag {
		case 0: /* brand new error */
			qllex.Error("syntax error")
			Nerrs++
			if qlDebug >= 1 {
				__yyfmt__.Printf("%s", qlStatname(qlstate))
				__yyfmt__.Printf(" saw %s\n", qlTokname(qlchar))
			}
			fallthrough

		case 1, 2: /* incompletely recovered error ... try again */
			Errflag = 3

			/* find a state where "error" is a legal shift action */
			for qlp >= 0 {
				qln = qlPact[qlS[qlp].yys] + qlErrCode
				if qln >= 0 && qln < qlLast {
					qlstate = qlAct[qln] /* simulate a shift of "error" */
					if qlChk[qlstate] == qlErrCode {
						goto qlstack
					}
				}

				/* the current p has no shift on "error", pop stack */
				if qlDebug >= 2 {
					__yyfmt__.Printf("error recovery pops state %d\n", qlS[qlp].yys)
				}
				qlp--
			}
			/* there is no state on the stack with an error shift ... abort */
			goto ret1

		case 3: /* no shift yet; clobber input char */
			if qlDebug >= 2 {
				__yyfmt__.Printf("error recovery discards %s\n", qlTokname(qlchar))
			}
			if qlchar == qlEofCode {
				goto ret1
			}
			qlchar = -1
			goto qlnewstate /* try again in the same state */
		}
	}

	/* reduction by production qln */
	if qlDebug >= 2 {
		__yyfmt__.Printf("reduce %v in:\n\t%v\n", qln, qlStatname(qlstate))
	}

	qlnt := qln
	qlpt := qlp
	_ = qlpt // guard against "declared and not used"

	qlp -= qlR2[qln]
	qlVAL = qlS[qlp+1]

	/* consult goto table to find next state */
	qln = qlR1[qln]
	qlg := qlPgo[qln]
	qlj := qlg + qlS[qlp].yys + 1

	if qlj >= qlLast {
		qlstate = qlAct[qlg]
	} else {
		qlstate = qlAct[qlj]
		if qlChk[qlstate] != -qln {
			qlstate = qlAct[qlg]
		}
	}
	// dummy call; replaced with literal code
	switch qlnt {

	case 1:
		//line parser.y:65
		{
			finalQuestionaire = qlS[qlpt-0].questionaire
		}
	case 2:
		//line parser.y:72
		{
			qlVAL.questionaire = ast.NewQuestionaireNode(qlS[qlpt-3].content, qlS[qlpt-1].stack)
		}
	case 4:
		//line parser.y:79
		{
			q := qlS[qlpt-0].question
			qs := qlVAL.stack
			action := ast.NewActionNode(q)
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 5:
		//line parser.y:87
		{
			ifNode := qlS[qlpt-0].ifNode
			qs := qlVAL.stack
			action := ast.NewActionNode(ifNode)
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 6:
		//line parser.y:98
		{
			qlVAL.question = ast.NewQuestionNode(qlS[qlpt-2].content, qlS[qlpt-1].content, qlS[qlpt-0].questionType, false)
		}
	case 7:
		//line parser.y:107
		{
			qlVAL.questionType = new(ast.StringQuestion)
		}
	case 8:
		//line parser.y:111
		{
			qlVAL.questionType = new(ast.IntQuestion)
		}
	case 9:
		//line parser.y:115
		{
			qlVAL.questionType = new(ast.BoolQuestion)
		}
	case 10:
		//line parser.y:119
		{
			computedQuestion := new(ast.ComputedQuestion)
			computedQuestion.Expression = qlS[qlpt-0].evaluatable
			qlVAL.questionType = computedQuestion
		}
	case 11:
		//line parser.y:125
		{
			qllex.Error(fmt.Sprintf("Question type must be 'string', 'integer', 'bool' or 'computed'. Found: %s", qlS[qlpt-0].content))
		}
	case 12:
		//line parser.y:132
		{
			qlVAL.ifNode = ast.NewIfNode(qlS[qlpt-4].evaluatable, qlS[qlpt-1].stack, nil)

			qlVAL.evaluatable = new(ast.Evaluatable)
			qlVAL.stack = []*ast.ActionNode{}
			qlS[qlpt-4].evaluatable = new(ast.Evaluatable)
			qlS[qlpt-1].stack = []*ast.ActionNode{}
		}
	case 13:
		//line parser.y:141
		{
			qlVAL.ifNode = ast.NewIfNode(qlS[qlpt-6].evaluatable, qlS[qlpt-3].stack, qlS[qlpt-0].ifNode)

			qlVAL.evaluatable = new(ast.Evaluatable)
			qlVAL.stack = []*ast.ActionNode{}
			qlS[qlpt-6].evaluatable = new(ast.Evaluatable)
			qlS[qlpt-3].stack = []*ast.ActionNode{}
			qlS[qlpt-0].ifNode = nil
		}
	case 14:
		//line parser.y:151
		{
			elseNode := ast.NewIfNode(&ast.TermNode{
				Type:            ast.NumericConstantNodeType,
				NumericConstant: 1,
			}, qlS[qlpt-1].stack, nil)
			qlVAL.ifNode = ast.NewIfNode(qlS[qlpt-8].evaluatable, qlS[qlpt-5].stack, elseNode)

			qlVAL.evaluatable = new(ast.Evaluatable)
			qlVAL.stack = []*ast.ActionNode{}
			qlS[qlpt-8].evaluatable = new(ast.Evaluatable)
			qlS[qlpt-5].stack = []*ast.ActionNode{}
			qlS[qlpt-1].stack = []*ast.ActionNode{}
		}
	case 15:
		//line parser.y:168
		{
			condition := new(ast.EqualsNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 16:
		//line parser.y:175
		{
			condition := new(ast.MoreThanNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 17:
		//line parser.y:182
		{
			condition := new(ast.LessThanNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 18:
		//line parser.y:189
		{
			condition := new(ast.MoreOrEqualsThanNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 19:
		//line parser.y:196
		{
			condition := new(ast.LessOrEqualsThanNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 21:
		//line parser.y:207
		{
			condition := new(ast.MathAddNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 22:
		//line parser.y:214
		{
			condition := new(ast.MathSubNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 23:
		//line parser.y:221
		{
			condition := new(ast.MathMulNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 24:
		//line parser.y:228
		{
			condition := new(ast.MathDivNode)
			condition.LeftTerm = qlS[qlpt-2].evaluatable
			condition.RightTerm = qlS[qlpt-0].evaluatable
			qlVAL.evaluatable = condition
		}
	case 25:
		//line parser.y:235
		{
			qlVAL.evaluatable = qlS[qlpt-0].termNode
		}
	case 26:
		//line parser.y:242
		{
			num, _ := strconv.ParseFloat(qlS[qlpt-0].content, 32)
			qlVAL.num = float32(num)
			termNode := new(ast.TermNode)
			termNode.NumericConstant = qlVAL.num
			termNode.Type = ast.NumericConstantNodeType
			qlVAL.termNode = termNode
		}
	case 27:
		//line parser.y:251
		{
			termNode := new(ast.TermNode)
			termNode.IdentifierReference = qlS[qlpt-0].content
			termNode.Type = ast.IdentifierReferenceNodeType
			qlVAL.termNode = termNode
		}
	case 28:
		//line parser.y:258
		{
			termNode := new(ast.TermNode)
			termNode.StringConstant = qlS[qlpt-0].content
			termNode.Type = ast.StringConstantNodeType
			qlVAL.termNode = termNode
		}
	}
	goto qlstack /* stack new state and value */
}
