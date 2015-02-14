//line parser.y:2
package parser

import __yyfmt__ "fmt"

//line parser.y:3
import (
	"fmt"
	"log"
	"strconv"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

var finalQuestionaire *ast.QuestionaireNode

//Top Ends Here

//line parser.y:21
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
const LessThanToken = 57357
const LessOrEqualsThanToken = 57358
const MoreThanToken = 57359
const MoreOrEqualsThanToken = 57360
const EqualsToToken = 57361
const NumericToken = 57362

var qlToknames = []string{
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
	"'+'",
	"'-'",
	"'*'",
	"'/'",
	"'('",
	"')'",
	"LessThanToken",
	"LessOrEqualsThanToken",
	"MoreThanToken",
	"MoreOrEqualsThanToken",
	"EqualsToToken",
	"NumericToken",
}
var qlStatenames = []string{}

const qlEofCode = 1
const qlErrCode = 2
const qlMaxDepth = 200

//line parser.y:239

//line yacctab:1
var qlExca = []int{
	-1, 1,
	1, -1,
	-2, 0,
}

const qlNprod = 23
const qlPrivate = 57344

var qlTokenNames []string
var qlStates []string

const qlLast = 43

var qlAct = []int{

	22, 11, 11, 24, 10, 10, 29, 31, 28, 30,
	27, 24, 20, 26, 5, 6, 13, 12, 25, 4,
	3, 23, 38, 7, 21, 19, 25, 14, 33, 34,
	35, 36, 37, 18, 15, 16, 17, 9, 8, 2,
	1, 0, 32,
}
var qlPact = []int{

	14, -1000, -1000, 8, -13, -1000, -5, -1000, -1000, -1000,
	6, -3, 22, -1000, -1000, -1000, -1000, -1000, -1000, -8,
	-14, -1000, -15, -1000, -1000, -1000, -1000, 0, 0, 0,
	0, 0, -6, -1000, -1000, -1000, -1000, -1000, -1000,
}
var qlPgo = []int{

	0, 40, 39, 15, 38, 37, 27, 25, 24, 0,
	21,
}
var qlR1 = []int{

	0, 1, 2, 3, 3, 3, 4, 6, 6, 6,
	6, 5, 7, 7, 8, 8, 8, 8, 8, 8,
	9, 9, 10,
}
var qlR2 = []int{

	0, 1, 5, 0, 2, 2, 3, 1, 1, 1,
	1, 7, 0, 2, 3, 3, 3, 3, 3, 1,
	1, 1, 1,
}
var qlChk = []int{

	-1000, -1, -2, 6, 11, 27, -3, 28, -4, -5,
	10, 7, 11, 19, -6, 12, 13, 14, 11, -7,
	20, -8, -9, -10, 11, 26, 27, 25, 23, 21,
	24, 22, -3, -9, -9, -9, -9, -9, 28,
}
var qlDef = []int{

	0, -2, 1, 0, 0, 3, 0, 2, 4, 5,
	0, 0, 0, 12, 6, 7, 8, 9, 10, 0,
	0, 13, 19, 20, 21, 22, 3, 0, 0, 0,
	0, 0, 0, 14, 15, 16, 17, 18, 11,
}
var qlTok1 = []int{

	1, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	19, 20, 17, 15, 3, 16, 3, 18, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 27, 3, 28,
}
var qlTok2 = []int{

	2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
	12, 13, 14, 21, 22, 23, 24, 25, 26,
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
		//line parser.y:60
		{
			finalQuestionaire = qlS[qlpt-0].questionaire
		}
	case 2:
		//line parser.y:67
		{
			qlVAL.questionaire = &ast.QuestionaireNode{
				Label: qlS[qlpt-3].content,
				Stack: qlS[qlpt-1].stack,
			}
		}
	case 4:
		//line parser.y:77
		{
			if qlDebug > 0 {
				log.Printf("Question Stack: 1:%#v 2:%#v $:%#v", qlS[qlpt-1].stack,
					qlS[qlpt-0].question, qlVAL.stack)
			}
			q := qlS[qlpt-0].question
			qs := qlVAL.stack
			action := &ast.ActionNode{
				Action: q,
			}
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 5:
		//line parser.y:91
		{
			ifNode := qlS[qlpt-0].ifNode
			qs := qlVAL.stack
			action := &ast.ActionNode{
				Action: ifNode,
			}
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 6:
		//line parser.y:104
		{
			qlVAL.question = &ast.QuestionNode{
				Label:      qlS[qlpt-2].content,
				Identifier: qlS[qlpt-1].content,
				Content:    qlS[qlpt-0].questionType,
			}
		}
	case 7:
		//line parser.y:116
		{
			qlVAL.questionType = new(ast.StringQuestion)
		}
	case 8:
		//line parser.y:120
		{
			qlVAL.questionType = new(ast.IntQuestion)
		}
	case 9:
		//line parser.y:124
		{
			qlVAL.questionType = new(ast.BoolQuestion)
		}
	case 10:
		//line parser.y:129
		{
			qllex.Error(fmt.Sprintf("Question type must be 'string', 'integer', 'bool'. Found: %s", qlS[qlpt-0].content))
		}
	case 11:
		//line parser.y:135
		{
			ifNode := new(ast.IfNode)
			ifNode.Conditions = qlS[qlpt-4].evaluatables
			ifNode.Stack = qlS[qlpt-1].stack
			qlVAL.ifNode = ifNode

			qlS[qlpt-4].evaluatables = []ast.Evaluatable{}
		}
	case 13:
		//line parser.y:147
		{
			evaluatables := qlVAL.evaluatables
			evaluatables = append(evaluatables, qlS[qlpt-0].evaluatable)
			qlVAL.evaluatables = evaluatables
		}
	case 14:
		//line parser.y:156
		{
			condition := new(ast.EqualsNode)
			condition.LeftTerm = qlS[qlpt-2].termNode
			condition.RightTerm = qlS[qlpt-0].termNode
			qlVAL.evaluatable = condition
		}
	case 15:
		//line parser.y:163
		{
			condition := new(ast.MoreThanNode)
			condition.LeftTerm = qlS[qlpt-2].termNode
			condition.RightTerm = qlS[qlpt-0].termNode
			qlVAL.evaluatable = condition
		}
	case 16:
		//line parser.y:170
		{
			condition := new(ast.LessThanNode)
			condition.LeftTerm = qlS[qlpt-2].termNode
			condition.RightTerm = qlS[qlpt-0].termNode
			qlVAL.evaluatable = condition
		}
	case 17:
		//line parser.y:177
		{
			condition := new(ast.MoreOrEqualsThanNode)
			condition.LeftTerm = qlS[qlpt-2].termNode
			condition.RightTerm = qlS[qlpt-0].termNode
			qlVAL.evaluatable = condition
		}
	case 18:
		//line parser.y:184
		{
			condition := new(ast.LessOrEqualsThanNode)
			condition.LeftTerm = qlS[qlpt-2].termNode
			condition.RightTerm = qlS[qlpt-0].termNode
			qlVAL.evaluatable = condition
		}
	case 19:
		//line parser.y:191
		{
			condition := new(ast.SingleTermNode)
			condition.LeftTerm = qlS[qlpt-0].termNode
			qlVAL.evaluatable = condition
		}
	case 20:
		//line parser.y:199
		{
			termNode := new(ast.TermNode)
			termNode.NumericConstant = qlS[qlpt-0].num
			qlVAL.termNode = termNode
		}
	case 21:
		//line parser.y:205
		{
			termNode := new(ast.TermNode)
			termNode.IdentifierReference = qlS[qlpt-0].content
			qlVAL.termNode = termNode
		}
	case 22:
		//line parser.y:214
		{
			num, _ := strconv.ParseFloat(qlS[qlpt-0].content, 32)
			qlVAL.num = float32(num)
		}
	}
	goto qlstack /* stack new state and value */
}
