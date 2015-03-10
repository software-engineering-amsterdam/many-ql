import ql.ast.Value

import scalafx.collections.ObservableMap

package object types {
  // type and value aliases for ql

  type VariableName = String

  type EvalEnvironment = ObservableMap[VariableName, Value]

  type Dependencies = List[VariableName]

  type Label = String
}
