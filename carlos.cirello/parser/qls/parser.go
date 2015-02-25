//line parser.y:2
package parser

import __yyfmt__ "fmt"

//line parser.y:3
import (
	"text/scanner"

	"github.com/davecgh/go-spew/spew"
)

var finalStyle interface{}

//line parser.y:16
type qlsSymType struct {
	yys     int
	content string

	position scanner.Position
}

const StylesheetToken = 57346
const TextToken = 57347
const NumericToken = 57348
const QuotedStringToken = 57349
const DefaultToken = 57350

var qlsToknames = []string{
	"StylesheetToken",
	"TextToken",
	"NumericToken",
	"QuotedStringToken",
	"DefaultToken",
}
var qlsStatenames = []string{}

const qlsEofCode = 1
const qlsErrCode = 2
const qlsMaxDepth = 200

//line yacctab:1
var qlsExca = []int{
	-1, 1,
	1, -1,
	-2, 0,
}

const qlsNprod = 5
const qlsPrivate = 57344

var qlsTokenNames []string
var qlsStates []string

const qlsLast = 10

var qlsAct = []int{

	8, 10, 6, 4, 9, 3, 2, 7, 5, 1,
}
var qlsPact = []int{

	2, -1000, 0, -6, -1000, -8, -1000, -1000, -1, -4,
	-1000,
}
var qlsPgo = []int{

	0, 9, 8, 7,
}
var qlsR1 = []int{

	0, 1, 2, 2, 3,
}
var qlsR2 = []int{

	0, 5, 0, 2, 3,
}
var qlsChk = []int{

	-1000, -1, 4, 5, 9, -2, 10, -3, 8, 5,
	5,
}
var qlsDef = []int{

	0, -2, 0, 0, 2, 0, 1, 3, 0, 0,
	4,
}
var qlsTok1 = []int{

	1, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 9, 3, 10,
}
var qlsTok2 = []int{

	2, 3, 4, 5, 6, 7, 8,
}
var qlsTok3 = []int{
	0,
}

//line yaccpar:1

/*	parser for yacc output	*/

var qlsDebug = 0

type qlsLexer interface {
	Lex(lval *qlsSymType) int
	Error(s string)
}

const qlsFlag = -1000

func qlsTokname(c int) string {
	// 4 is TOKSTART above
	if c >= 4 && c-4 < len(qlsToknames) {
		if qlsToknames[c-4] != "" {
			return qlsToknames[c-4]
		}
	}
	return __yyfmt__.Sprintf("tok-%v", c)
}

func qlsStatname(s int) string {
	if s >= 0 && s < len(qlsStatenames) {
		if qlsStatenames[s] != "" {
			return qlsStatenames[s]
		}
	}
	return __yyfmt__.Sprintf("state-%v", s)
}

func qlslex1(lex qlsLexer, lval *qlsSymType) int {
	c := 0
	char := lex.Lex(lval)
	if char <= 0 {
		c = qlsTok1[0]
		goto out
	}
	if char < len(qlsTok1) {
		c = qlsTok1[char]
		goto out
	}
	if char >= qlsPrivate {
		if char < qlsPrivate+len(qlsTok2) {
			c = qlsTok2[char-qlsPrivate]
			goto out
		}
	}
	for i := 0; i < len(qlsTok3); i += 2 {
		c = qlsTok3[i+0]
		if c == char {
			c = qlsTok3[i+1]
			goto out
		}
	}

out:
	if c == 0 {
		c = qlsTok2[1] /* unknown char */
	}
	if qlsDebug >= 3 {
		__yyfmt__.Printf("lex %s(%d)\n", qlsTokname(c), uint(char))
	}
	return c
}

func qlsParse(qlslex qlsLexer) int {
	var qlsn int
	var qlslval qlsSymType
	var qlsVAL qlsSymType
	qlsS := make([]qlsSymType, qlsMaxDepth)

	Nerrs := 0   /* number of errors */
	Errflag := 0 /* error recovery flag */
	qlsstate := 0
	qlschar := -1
	qlsp := -1
	goto qlsstack

ret0:
	return 0

ret1:
	return 1

qlsstack:
	/* put a state and value onto the stack */
	if qlsDebug >= 4 {
		__yyfmt__.Printf("char %v in %v\n", qlsTokname(qlschar), qlsStatname(qlsstate))
	}

	qlsp++
	if qlsp >= len(qlsS) {
		nyys := make([]qlsSymType, len(qlsS)*2)
		copy(nyys, qlsS)
		qlsS = nyys
	}
	qlsS[qlsp] = qlsVAL
	qlsS[qlsp].yys = qlsstate

qlsnewstate:
	qlsn = qlsPact[qlsstate]
	if qlsn <= qlsFlag {
		goto qlsdefault /* simple state */
	}
	if qlschar < 0 {
		qlschar = qlslex1(qlslex, &qlslval)
	}
	qlsn += qlschar
	if qlsn < 0 || qlsn >= qlsLast {
		goto qlsdefault
	}
	qlsn = qlsAct[qlsn]
	if qlsChk[qlsn] == qlschar { /* valid shift */
		qlschar = -1
		qlsVAL = qlslval
		qlsstate = qlsn
		if Errflag > 0 {
			Errflag--
		}
		goto qlsstack
	}

qlsdefault:
	/* default state action */
	qlsn = qlsDef[qlsstate]
	if qlsn == -2 {
		if qlschar < 0 {
			qlschar = qlslex1(qlslex, &qlslval)
		}

		/* look through exception table */
		xi := 0
		for {
			if qlsExca[xi+0] == -1 && qlsExca[xi+1] == qlsstate {
				break
			}
			xi += 2
		}
		for xi += 2; ; xi += 2 {
			qlsn = qlsExca[xi+0]
			if qlsn < 0 || qlsn == qlschar {
				break
			}
		}
		qlsn = qlsExca[xi+1]
		if qlsn < 0 {
			goto ret0
		}
	}
	if qlsn == 0 {
		/* error ... attempt to resume parsing */
		switch Errflag {
		case 0: /* brand new error */
			qlslex.Error("syntax error")
			Nerrs++
			if qlsDebug >= 1 {
				__yyfmt__.Printf("%s", qlsStatname(qlsstate))
				__yyfmt__.Printf(" saw %s\n", qlsTokname(qlschar))
			}
			fallthrough

		case 1, 2: /* incompletely recovered error ... try again */
			Errflag = 3

			/* find a state where "error" is a legal shift action */
			for qlsp >= 0 {
				qlsn = qlsPact[qlsS[qlsp].yys] + qlsErrCode
				if qlsn >= 0 && qlsn < qlsLast {
					qlsstate = qlsAct[qlsn] /* simulate a shift of "error" */
					if qlsChk[qlsstate] == qlsErrCode {
						goto qlsstack
					}
				}

				/* the current p has no shift on "error", pop stack */
				if qlsDebug >= 2 {
					__yyfmt__.Printf("error recovery pops state %d\n", qlsS[qlsp].yys)
				}
				qlsp--
			}
			/* there is no state on the stack with an error shift ... abort */
			goto ret1

		case 3: /* no shift yet; clobber input char */
			if qlsDebug >= 2 {
				__yyfmt__.Printf("error recovery discards %s\n", qlsTokname(qlschar))
			}
			if qlschar == qlsEofCode {
				goto ret1
			}
			qlschar = -1
			goto qlsnewstate /* try again in the same state */
		}
	}

	/* reduction by production qlsn */
	if qlsDebug >= 2 {
		__yyfmt__.Printf("reduce %v in:\n\t%v\n", qlsn, qlsStatname(qlsstate))
	}

	qlsnt := qlsn
	qlspt := qlsp
	_ = qlspt // guard against "declared and not used"

	qlsp -= qlsR2[qlsn]
	qlsVAL = qlsS[qlsp+1]

	/* consult goto table to find next state */
	qlsn = qlsR1[qlsn]
	qlsg := qlsPgo[qlsn]
	qlsj := qlsg + qlsS[qlsp].yys + 1

	if qlsj >= qlsLast {
		qlsstate = qlsAct[qlsg]
	} else {
		qlsstate = qlsAct[qlsj]
		if qlsChk[qlsstate] != -qlsn {
			qlsstate = qlsAct[qlsg]
		}
	}
	// dummy call; replaced with literal code
	switch qlsnt {

	case 1:
		//line parser.y:34
		{
			spew.Dump("top", qlsVAL, qlsS[qlspt-4], qlsS[qlspt-3], qlsS[qlspt-1])
		}
	case 3:
		//line parser.y:40
		{
			spew.Dump("stack", qlsVAL, qlsS[qlspt-1], qlsS[qlspt-0])
		}
	case 4:
		//line parser.y:47
		{
			spew.Dump("defaultSetting", qlsVAL, qlsS[qlspt-2], qlsS[qlspt-1])
		}
	}
	goto qlsstack /* stack new state and value */
}
