package interpreter

import (
	"time"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast/typechecker"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

func typecheck(q *ast.QuestionaireNode) {
	tc, symboltable := typechecker.New()
	symboltable.SetWatchError(true)

	tc.QuestionaireNode(q)

	symboltable.ShowWarn()
	symboltable.PanicErr()
}

func (v *interpreter) drawLoop(redraw bool) bool {
	v.handshake()
	v.drawAndFlush()
	if redraw {
		redraw = false
		go v.confirmRedraw()
	}
	v.renderAndFlush(v.execute)
	return redraw
}

func (v *interpreter) mainLoop() {
	ticker := time.Tick(100 * time.Millisecond)
mainLoop:
	for {
		select {
		case r := <-v.receive:
			switch r.Type {

			case plumbing.Answers:
				v.flushAnswers(r.Answers)

			case plumbing.ReadyT:
				v.renderAndFlush(v.execute)

			case plumbing.Redraw:
				break mainLoop

			}

		case <-ticker:
			v.fetchAnswers()
		}
	}
}

func (v *interpreter) renderAndFlush(exec ast.Executer) {
	exec.QuestionaireNode(v.questionaire)
	v.send <- &plumbing.Frontend{Type: plumbing.Flush}
}

func (v *interpreter) fetchAnswers() {
	v.send <- &plumbing.Frontend{Type: plumbing.FetchAnswers}
}

func (v *interpreter) confirmRedraw() {
	v.receive <- &plumbing.Frontend{Type: plumbing.ReadyT}
}

func (v *interpreter) handshake() {
	v.send <- &plumbing.Frontend{Type: plumbing.ReadyP}
}

func (v *interpreter) drawAndFlush() {
drawLoop:
	for {
		select {
		case r := <-v.receive:
			switch r.Type {
			case plumbing.ReadyT:
				v.renderAndFlush(v.draw)
				break drawLoop
			}
		}
	}
}

func (v *interpreter) flushAnswers(answers map[string]string) {
	for identifier, answer := range answers {
		q := v.symbols.Read(identifier)
		q.(symboltable.StringParser).From(answer)
		v.symbols.Update(identifier, q)
		v.renderAndFlush(v.execute)
	}
}
