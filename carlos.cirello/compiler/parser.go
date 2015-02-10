//line parser.y:2
package compiler

import __yyfmt__ "fmt"

//line parser.y:3
import (
	"log"
	"strings"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

var finalQuestionaire *ast.QuestionaireNode

//Top Ends Here

//line parser.y:20
type qlSymType struct {
	yys          int
	content      string
	questionaire *ast.QuestionaireNode
	stack        []*ast.ActionNode
	question     *ast.QuestionNode
	questionType ast.Parser
	ifNode       *ast.IfNode
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
}
var qlStatenames = []string{}

const qlEofCode = 1
const qlErrCode = 2
const qlMaxDepth = 200

//line parser.y:128

// Bottom starts here
// The parser expects the lexer to return 0 on EOF.
const eof = 0

const (
	// FormTokenText - Reserved Word
	FormTokenText = "form"
	// IfTokenText - Reserved Word
	IfTokenText = "if"
	// StringQuestionTokenText - Reserved Word
	StringQuestionTokenText = "string"
	// IntQuestionTokenText - Reserved Word
	IntQuestionTokenText = "integer"
	// BoolQuestionTokenText - Reserved Word
	BoolQuestionTokenText = "bool"

	singleQuotedChar  = `'`
	doubleQuotedChar  = `"`
	literalQuotedChar = "`"
)

type lexer struct {
	scanner scanner.Scanner
}

func newLexer(code string) *lexer {
	var s scanner.Scanner
	s.Init(strings.NewReader(code))
	s.Whitespace = 1<<'\t' | 1<<'\n' | 1<<'\r' | 1<<' '

	return &lexer{
		scanner: s,
	}
}

// The parser calls this method to get each new token.
func (x *lexer) Lex(yylval *qlSymType) int {
	tok := x.scanner.Scan()

	if tok == scanner.EOF {
		return eof
	}

	txt := x.scanner.TokenText()
	typ := TextToken

	if txt == FormTokenText {
		typ = FormToken
	} else if txt == StringQuestionTokenText {
		typ = StringQuestionToken
	} else if txt == IntQuestionTokenText {
		typ = IntQuestionToken
	} else if txt == BoolQuestionTokenText {
		typ = BoolQuestionToken
	} else if txt == IfTokenText {
		typ = IfToken
	} else if txt == "{" || txt == "}" || txt == "(" || txt == ")" {
		typ = int(txt[0])
	} else if strings.HasPrefix(txt, singleQuotedChar) ||
		strings.HasPrefix(txt, doubleQuotedChar) ||
		strings.HasPrefix(txt, literalQuotedChar) {
		typ = QuotedStringToken
		txt = stripSurroundingQuotes(txt)
	}

	yylval.content = txt

	return typ
}

// The parser calls this method on a parse error.
func (x *lexer) Error(s string) {
	log.Printf("parse error: %s", s)
}

// CompileQL generates a AST (*ast.Questionaire and children) out of source code.
func CompileQL(code string) *ast.QuestionaireNode {
	finalQuestionaire = nil
	qlParse(newLexer(code))
	return finalQuestionaire
}

func stripSurroundingQuotes(str string) string {
	return str[1 : len(str)-1]
}

//line yacctab:1
var qlExca = []int{
	-1, 1,
	1, -1,
	-2, 0,
}

const qlNprod = 11
const qlPrivate = 57344

var qlTokenNames []string
var qlStates []string

const qlLast = 24

var qlAct = []int{

	6, 11, 19, 11, 10, 13, 10, 15, 16, 17,
	22, 18, 7, 20, 5, 12, 4, 3, 14, 9,
	8, 21, 2, 1,
}
var qlPact = []int{

	11, -1000, -1000, 5, -1, -1000, -4, -1000, -1000, -1000,
	4, -12, -5, 0, -1000, -1000, -1000, -1000, -16, -2,
	-1000, -6, -1000,
}
var qlPgo = []int{

	0, 23, 22, 0, 20, 19, 18,
}
var qlR1 = []int{

	0, 1, 2, 3, 3, 3, 4, 6, 6, 6,
	5,
}
var qlR2 = []int{

	0, 1, 5, 0, 2, 2, 3, 1, 1, 1,
	7,
}
var qlChk = []int{

	-1000, -1, -2, 6, 11, 15, -3, 16, -4, -5,
	10, 7, 11, 17, -6, 12, 13, 14, 11, 18,
	15, -3, 16,
}
var qlDef = []int{

	0, -2, 1, 0, 0, 3, 0, 2, 4, 5,
	0, 0, 0, 0, 6, 7, 8, 9, 0, 0,
	3, 0, 10,
}
var qlTok1 = []int{

	1, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	17, 18, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 15, 3, 16,
}
var qlTok2 = []int{

	2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
	12, 13, 14,
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
		//line parser.y:46
		{
			if qlDebug > 0 {
				log.Printf("Top: %+v", qlS[qlpt-0].questionaire)
			}
			finalQuestionaire = qlS[qlpt-0].questionaire
		}
	case 2:
		//line parser.y:56
		{
			if qlDebug > 0 {
				log.Println("Form: 1:", qlS[qlpt-4], "2:", qlS[qlpt-3], " 2c:", qlS[qlpt-3].content,
					" $$:", qlVAL)
			}
			qlVAL.questionaire = &ast.QuestionaireNode{
				Label: qlS[qlpt-3].content,
				Stack: qlS[qlpt-1].stack,
			}
		}
	case 4:
		//line parser.y:70
		{
			if qlDebug > 0 {
				log.Printf("Question Stack: 1:%#v 2:%#v $:%#v", qlS[qlpt-1].stack,
					qlS[qlpt-0].question, qlVAL.stack)
			}
			q := qlS[qlpt-0].question
			qs := qlVAL.stack
			action := &ast.ActionNode{
				QuestionNode: q,
			}
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 5:
		//line parser.y:84
		{
			ifNode := qlS[qlpt-0].ifNode
			qs := qlVAL.stack
			action := &ast.ActionNode{
				IfNode: ifNode,
			}
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 6:
		//line parser.y:97
		{
			qlVAL.question = &ast.QuestionNode{
				Label:      qlS[qlpt-2].content,
				Identifier: qlS[qlpt-1].content,
				Content:    qlS[qlpt-0].questionType,
			}
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
		//line parser.y:120
		{
			ifNode := new(ast.IfNode)
			ifNode.Condition = qlS[qlpt-4].content
			ifNode.Stack = qlS[qlpt-1].stack
			qlVAL.ifNode = ifNode
		}
	}
	goto qlstack /* stack new state and value */
}
