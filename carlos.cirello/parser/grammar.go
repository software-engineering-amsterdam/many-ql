//line grammar.y:2
package main

import __yyfmt__ "fmt"

//line grammar.y:3
//line grammar.y:7
type grammarSymType struct {
	yys int
	typ int
	val string
}

const FormToken = 57346
const TextToken = 57347
const BlockBeginToken = 57348
const BlockEndToken = 57349
const IfToken = 57350
const ParenBeginToken = 57351
const ParenEndToken = 57352

var grammarToknames = []string{
	"FormToken",
	"TextToken",
	"BlockBeginToken",
	"BlockEndToken",
	"IfToken",
	"ParenBeginToken",
	"ParenEndToken",
}
var grammarStatenames = []string{}

const grammarEofCode = 1
const grammarErrCode = 2
const grammarMaxDepth = 200

//line yacctab:1
var grammarExca = []int{
	-1, 1,
	1, -1,
	-2, 0,
}

const grammarNprod = 6
const grammarPrivate = 57344

var grammarTokenNames []string
var grammarStates []string

const grammarLast = 7

var grammarAct = []int{

	7, 6, 5, 3, 2, 4, 1,
}
var grammarPact = []int{

	0, -1000, -3, -1000, -5, -1000, -1000, -1000,
}
var grammarPgo = []int{

	0, 6, 5, 1,
}
var grammarR1 = []int{

	0, 1, 1, 2, 2, 3,
}
var grammarR2 = []int{

	0, 0, 4, 0, 2, 1,
}
var grammarChk = []int{

	-1000, -1, 4, 6, -2, 7, -3, 5,
}
var grammarDef = []int{

	1, -2, 0, 3, 0, 2, 4, 5,
}
var grammarTok1 = []int{

	1,
}
var grammarTok2 = []int{

	2, 3, 4, 5, 6, 7, 8, 9, 10,
}
var grammarTok3 = []int{
	0,
}

//line yaccpar:1

/*	parser for yacc output	*/

var grammarDebug = 0

type grammarLexer interface {
	Lex(lval *grammarSymType) int
	Error(s string)
}

const grammarFlag = -1000

func grammarTokname(c int) string {
	// 4 is TOKSTART above
	if c >= 4 && c-4 < len(grammarToknames) {
		if grammarToknames[c-4] != "" {
			return grammarToknames[c-4]
		}
	}
	return __yyfmt__.Sprintf("tok-%v", c)
}

func grammarStatname(s int) string {
	if s >= 0 && s < len(grammarStatenames) {
		if grammarStatenames[s] != "" {
			return grammarStatenames[s]
		}
	}
	return __yyfmt__.Sprintf("state-%v", s)
}

func grammarlex1(lex grammarLexer, lval *grammarSymType) int {
	c := 0
	char := lex.Lex(lval)
	if char <= 0 {
		c = grammarTok1[0]
		goto out
	}
	if char < len(grammarTok1) {
		c = grammarTok1[char]
		goto out
	}
	if char >= grammarPrivate {
		if char < grammarPrivate+len(grammarTok2) {
			c = grammarTok2[char-grammarPrivate]
			goto out
		}
	}
	for i := 0; i < len(grammarTok3); i += 2 {
		c = grammarTok3[i+0]
		if c == char {
			c = grammarTok3[i+1]
			goto out
		}
	}

out:
	if c == 0 {
		c = grammarTok2[1] /* unknown char */
	}
	if grammarDebug >= 3 {
		__yyfmt__.Printf("lex %s(%d)\n", grammarTokname(c), uint(char))
	}
	return c
}

func grammarParse(grammarlex grammarLexer) int {
	var grammarn int
	var grammarlval grammarSymType
	var grammarVAL grammarSymType
	grammarS := make([]grammarSymType, grammarMaxDepth)

	Nerrs := 0   /* number of errors */
	Errflag := 0 /* error recovery flag */
	grammarstate := 0
	grammarchar := -1
	grammarp := -1
	goto grammarstack

ret0:
	return 0

ret1:
	return 1

grammarstack:
	/* put a state and value onto the stack */
	if grammarDebug >= 4 {
		__yyfmt__.Printf("char %v in %v\n", grammarTokname(grammarchar), grammarStatname(grammarstate))
	}

	grammarp++
	if grammarp >= len(grammarS) {
		nyys := make([]grammarSymType, len(grammarS)*2)
		copy(nyys, grammarS)
		grammarS = nyys
	}
	grammarS[grammarp] = grammarVAL
	grammarS[grammarp].yys = grammarstate

grammarnewstate:
	grammarn = grammarPact[grammarstate]
	if grammarn <= grammarFlag {
		goto grammardefault /* simple state */
	}
	if grammarchar < 0 {
		grammarchar = grammarlex1(grammarlex, &grammarlval)
	}
	grammarn += grammarchar
	if grammarn < 0 || grammarn >= grammarLast {
		goto grammardefault
	}
	grammarn = grammarAct[grammarn]
	if grammarChk[grammarn] == grammarchar { /* valid shift */
		grammarchar = -1
		grammarVAL = grammarlval
		grammarstate = grammarn
		if Errflag > 0 {
			Errflag--
		}
		goto grammarstack
	}

grammardefault:
	/* default state action */
	grammarn = grammarDef[grammarstate]
	if grammarn == -2 {
		if grammarchar < 0 {
			grammarchar = grammarlex1(grammarlex, &grammarlval)
		}

		/* look through exception table */
		xi := 0
		for {
			if grammarExca[xi+0] == -1 && grammarExca[xi+1] == grammarstate {
				break
			}
			xi += 2
		}
		for xi += 2; ; xi += 2 {
			grammarn = grammarExca[xi+0]
			if grammarn < 0 || grammarn == grammarchar {
				break
			}
		}
		grammarn = grammarExca[xi+1]
		if grammarn < 0 {
			goto ret0
		}
	}
	if grammarn == 0 {
		/* error ... attempt to resume parsing */
		switch Errflag {
		case 0: /* brand new error */
			grammarlex.Error("syntax error")
			Nerrs++
			if grammarDebug >= 1 {
				__yyfmt__.Printf("%s", grammarStatname(grammarstate))
				__yyfmt__.Printf(" saw %s\n", grammarTokname(grammarchar))
			}
			fallthrough

		case 1, 2: /* incompletely recovered error ... try again */
			Errflag = 3

			/* find a state where "error" is a legal shift action */
			for grammarp >= 0 {
				grammarn = grammarPact[grammarS[grammarp].yys] + grammarErrCode
				if grammarn >= 0 && grammarn < grammarLast {
					grammarstate = grammarAct[grammarn] /* simulate a shift of "error" */
					if grammarChk[grammarstate] == grammarErrCode {
						goto grammarstack
					}
				}

				/* the current p has no shift on "error", pop stack */
				if grammarDebug >= 2 {
					__yyfmt__.Printf("error recovery pops state %d\n", grammarS[grammarp].yys)
				}
				grammarp--
			}
			/* there is no state on the stack with an error shift ... abort */
			goto ret1

		case 3: /* no shift yet; clobber input char */
			if grammarDebug >= 2 {
				__yyfmt__.Printf("error recovery discards %s\n", grammarTokname(grammarchar))
			}
			if grammarchar == grammarEofCode {
				goto ret1
			}
			grammarchar = -1
			goto grammarnewstate /* try again in the same state */
		}
	}

	/* reduction by production grammarn */
	if grammarDebug >= 2 {
		__yyfmt__.Printf("reduce %v in:\n\t%v\n", grammarn, grammarStatname(grammarstate))
	}

	grammarnt := grammarn
	grammarpt := grammarp
	_ = grammarpt // guard against "declared and not used"

	grammarp -= grammarR2[grammarn]
	grammarVAL = grammarS[grammarp+1]

	/* consult goto table to find next state */
	grammarn = grammarR1[grammarn]
	grammarg := grammarPgo[grammarn]
	grammarj := grammarg + grammarS[grammarp].yys + 1

	if grammarj >= grammarLast {
		grammarstate = grammarAct[grammarg]
	} else {
		grammarstate = grammarAct[grammarj]
		if grammarChk[grammarstate] != -grammarn {
			grammarstate = grammarAct[grammarg]
		}
	}
	// dummy call; replaced with literal code
	switch grammarnt {

	}
	goto grammarstack /* stack new state and value */
}
