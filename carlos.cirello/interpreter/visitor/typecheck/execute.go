package typecheck

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/execute"
)

// New is the factory for Execute struct
func New(symbolChan chan *event.Symbol) *visitor.Visitor {
	toFrontend := make(chan *event.Frontend)

	go func(toFrontend chan *event.Frontend) {
		for {
			<-toFrontend
		}
	}(toFrontend)

	return visitor.NewVisitor(execute.NewExecute(toFrontend, symbolChan))
}
