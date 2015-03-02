package symboltable

type StringParser interface {
	From(str string) error
}

// ValueLoader describes the interface to be used against symboltables pointers,
// that returns their values.
type ValueLoader interface {
	Value() interface{}
}
