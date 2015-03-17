package graphic

type stacks struct {
	drawStack   []render
	renderStack []render
	answerStack map[string]string
	sweepStack  map[string]bool
}

func newStack() *stacks {
	return &stacks{
		answerStack: make(map[string]string),
		sweepStack:  make(map[string]bool),
	}
}

func (s *stacks) pushDraw(identifier string, r render) {
	s.drawStack = append(s.drawStack, r)
	s.sweepStack[identifier] = true
}

func (s *stacks) pushRender(identifier string, r render) {
	s.renderStack = append(s.renderStack, r)
	s.sweepStack[identifier] = true
}

func (s *stacks) pushAnswer(k, v string) {
	s.answerStack[k] = v
}

func (s *stacks) allRender() []render {
	allRender := append(s.drawStack, s.renderStack...)
	s.drawStack = []render{}
	s.renderStack = []render{}
	return allRender
}

func (s *stacks) allSweep() map[string]bool {
	return s.sweepStack
}

func (s *stacks) allAnswers() map[string]string {
	a := s.answerStack
	s.answerStack = make(map[string]string)
	return a
}

func (s *stacks) sweep(k string) {
	delete(s.sweepStack, k)
}

func (s *stacks) markToSweep(k string) {
	s.sweepStack[k] = false
}
