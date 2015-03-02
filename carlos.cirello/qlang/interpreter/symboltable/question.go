package symboltable

// StringParser describes the interface to be used when reading the input from
// frontend. It follows the Unix principle that pipe between computations are
// strings.
type StringParser interface {
	From(str string) error
}

// ValueLoader describes the interface to be used against symboltables pointers,
// that returns their values.
type ValueLoader interface {
	Value() interface{}
}
