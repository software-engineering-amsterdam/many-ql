package symboltable

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
)

func scalarQuestionFactory(primitive string) (fmt.Stringer, error) {
	switch primitive {
	case ast.ScalarStringPrimitive:
		return new(StringQuestion), nil
	case ast.ScalarNumericPrimitive:
		return new(NumericQuestion), nil
	case ast.ScalarBoolPrimitive:
		return new(BoolQuestion), nil
	}
	return nil, fmt.Errorf("Invalid question type. Got %s", primitive)
}
