package plumbing

// Pipes define the basic plumbing between Interpreter and Frontend
type Pipes struct {
	toFrontend   chan *Frontend
	fromFrontend chan *Frontend
}

// New is the constructor for Pipes
func New() *Pipes {
	return &Pipes{
		toFrontend:   make(chan *Frontend),
		fromFrontend: make(chan *Frontend),
	}
}

// ToFrontend returns the channel from interpreter to frontend flow
func (p *Pipes) ToFrontend() chan *Frontend {
	return p.toFrontend
}

// FromFrontend returns the channel from frontend to interpreter flow
func (p *Pipes) FromFrontend() chan *Frontend {
	return p.fromFrontend
}

// FromInterpreter returns the channel from interpreter to frontend flow
func (p *Pipes) FromInterpreter() chan *Frontend {
	return p.toFrontend
}

// ToInterpreter returns the channel from frontend to interpreter flow
func (p *Pipes) ToInterpreter() chan *Frontend {
	return p.fromFrontend
}
