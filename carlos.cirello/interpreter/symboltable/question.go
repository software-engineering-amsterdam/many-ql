package symboltable

type StringParser interface {
	From(str string) error
}

type ValueLoader interface {
	Value() interface{}
}
