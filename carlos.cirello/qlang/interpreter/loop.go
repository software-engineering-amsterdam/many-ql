/*
Package interpreter is the runtime which executes the AST created from the compiler.
*/
package interpreter

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast/draw"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast/execute"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/symboltable"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *event.Frontend
	receive      chan *event.Frontend
	execute      ast.Executer
	draw         ast.Executer
	symbols      *symboltable.SymbolTable
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *event.Frontend, chan *event.Frontend) {
	typecheck(q)

	toFrontend, fromFrontend := openChannels()
	st := symboltable.New()

	v := &interpreter{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
		execute:      execute.New(toFrontend, st),
		draw:         draw.New(toFrontend),
		symbols:      st,
	}
	go v.loop()

	return toFrontend, fromFrontend
}

func (v *interpreter) loop() {
	redraw := false
	for {
		redraw = v.drawLoop(redraw)
		v.mainLoop(redraw)
	}
}
