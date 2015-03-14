// Package typechecker reuses package executer, but set package symboltable into
// watchful mode. Any invalid action in symbol table, or invalid action from
// the package execute, it traps the errors and force QL abortion displaying
// error messages.
package typechecker
