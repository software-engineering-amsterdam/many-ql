package interpreter

import (
	"time"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast/typechecker"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/symboltable"
)

func typecheck(q *ast.QuestionaireNode) {
	tc, symboltable := typechecker.New()
	symboltable.SetWatchError(true)

	tc.QuestionaireNode(q)

	symboltable.ShowWarn()
	symboltable.PanicErr()
}

func openChannels() (toFrontend, fromFrontend chan *event.Frontend) {
	toFrontend = make(chan *event.Frontend)
	fromFrontend = make(chan *event.Frontend)
	return toFrontend, fromFrontend
}

func (v *interpreter) drawLoop(redraw bool) bool {
	v.send <- &event.Frontend{
		Type: event.ReadyP,
	}

drawLoop:
	for {
		select {
		case r := <-v.receive:
			switch r.Type {
			case event.ReadyT:
				v.draw.QuestionaireNode(v.questionaire)
				v.send <- &event.Frontend{Type: event.Flush}
				break drawLoop
			}
		}
	}

	if redraw {
		redraw = false
		go func(receive chan *event.Frontend) {
			receive <- &event.Frontend{Type: event.ReadyT}
		}(v.receive)
	}
	v.execute.QuestionaireNode(v.questionaire)
	v.send <- &event.Frontend{Type: event.Flush}
	return redraw
}

func (v *interpreter) mainLoop(redraw bool) {
	ticker := time.Tick(100 * time.Millisecond)
mainLoop:
	for {
		select {
		case r := <-v.receive:
			switch r.Type {

			case event.Answers:
				for identifier, answer := range r.Answers {
					q := v.symbols.Read(identifier)
					q.(symboltable.StringParser).From(answer)
					v.symbols.Update(identifier, q)
					v.execute.QuestionaireNode(v.questionaire)
					v.send <- &event.Frontend{Type: event.Flush}
				}

			case event.ReadyT:
				v.execute.QuestionaireNode(v.questionaire)
				v.send <- &event.Frontend{Type: event.Flush}

			case event.Redraw:
				redraw = true
				break mainLoop

			}

		case <-ticker:
			v.send <- &event.Frontend{Type: event.FetchAnswers}
		}
	}
}
