import ql.ast.{Type, Value}

import scalafx.collections.ObservableMap

// Type aliases for QL.
package object types {

  type VariableName = String

  type Label = String

  // Note that we require variables to be declared before being used.
  type TypeEnvironment = Map[VariableName, Type]

  type EvalEnvironment = ObservableMap[VariableName, Value]

  type Dependencies = List[VariableName]
}
