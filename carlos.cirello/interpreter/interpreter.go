// Package interpreter is the runtime which executes the AST created from the
// compiler.
package interpreter

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast/draw"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast/execute"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *plumbing.Frontend
	receive      chan *plumbing.Frontend
	execute      ast.Executer
	draw         ast.Executer
	symbols      *symboltable.SymbolTable
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process.
func New(q *ast.QuestionaireNode) *plumbing.Pipes {
	typecheck(q)

	pipes := plumbing.New()
	st := symboltable.New()

	v := &interpreter{
		questionaire: q,
		send:         pipes.ToFrontend(),
		receive:      pipes.FromFrontend(),
		execute:      execute.New(pipes.ToFrontend(), st),
		draw:         draw.New(pipes.ToFrontend()),
		symbols:      st,
	}
	go v.loop()

	return pipes
}

func (v *interpreter) loop() {
	redraw := false
	for {
		redraw = v.drawLoop(redraw)
		v.mainLoop(redraw)
	}
}
