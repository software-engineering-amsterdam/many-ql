// Package draw renders the form for the first time. It is uses a dumber version
// of package execute - so no condition is ever evaluated, just skipped. And
// their internals are executed no matter whether the expression is true or
// false.
//
// Later on, when package execute takes over, it will display or hide fields
// accordingly.
//
// Fields within if blocks are rendered with visibility set to hidden by
// default.
package draw
