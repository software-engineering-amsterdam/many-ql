package symboltable

import (
	"fmt"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
)

func scalarQuestionFactory(primitive string) fmt.Stringer {
	switch primitive {
	case ast.ScalarStringPrimitive:
		return new(StringQuestion)
	case ast.ScalarNumericPrimitive:
		return new(NumericQuestion)
	case ast.ScalarBoolPrimitive:
		return new(BoolQuestion)
	}
	log.Println(primitive)
	return nil
}
