//go:generate -command yacc go tool yacc
//go:generate yacc -o parser.go -p "ql" parser.y

package compiler
