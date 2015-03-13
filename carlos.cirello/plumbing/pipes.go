package plumbing

type Pipes struct {
	toFrontend   chan *Frontend
	fromFrontend chan *Frontend
}

func New() *Pipes {
	return &Pipes{
		toFrontend:   make(chan *Frontend),
		fromFrontend: make(chan *Frontend),
	}
}

func (p *Pipes) ToFrontend() chan *Frontend {
	return p.toFrontend
}

func (p *Pipes) FromFrontend() chan *Frontend {
	return p.fromFrontend
}

func (p *Pipes) FromInterpreter() chan *Frontend {
	return p.toFrontend
}

func (p *Pipes) ToInterpreter() chan *Frontend {
	return p.fromFrontend
}
