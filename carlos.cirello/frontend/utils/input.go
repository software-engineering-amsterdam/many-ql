package utils

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"

type inputUtil struct {
	receive, send chan *plumbing.Frontend
}

func DispatchReadAnswers(answers map[string]string,
	receive, send chan *plumbing.Frontend) {

	i := &inputUtil{receive, send}
	i.handshake()
	i.sendAnswers(answers)
	i.handoverAndRedraw()
}

func (i *inputUtil) handshake() {
	i.sendHandshake()
	i.unlockInterpreter()
}

func (i *inputUtil) sendHandshake() {
	<-i.receive
	i.send <- &plumbing.Frontend{
		Type: plumbing.ReadyT,
	}
}

func (i *inputUtil) unlockInterpreter() {
renderingSkipLoop:
	for {
		select {
		case r := <-i.receive:
			if r.Type == plumbing.Flush {
				break renderingSkipLoop
			}
		}
	}

}

func (i *inputUtil) sendAnswers(answers map[string]string) {
	answerEvent := &plumbing.Frontend{
		Type:    plumbing.Answers,
		Answers: answers,
	}
commLoop:
	for {
		select {
		case <-i.receive:
		case i.send <- answerEvent:
			break commLoop

		default:

		}
	}
}

func (i *inputUtil) handoverAndRedraw() {
	redrawEvent := &plumbing.Frontend{Type: plumbing.Redraw}
redrawLoop:
	for {
		select {
		case <-i.receive:

		case i.send <- redrawEvent:
			break redrawLoop

		default:

		}
	}
}
