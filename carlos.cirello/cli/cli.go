package cli

import (
	"flag"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/iostream"
)

// Args reads the CLI arguments seeking for parameters relevant to stream
// instantiation.
func Args() (srcFn, inFn, outFn string) {
	srcFnPtr := flag.String("src", iostream.Stdio, `QL code filename or `+iostream.Stdio+` to read from stdin`)
	inFnPtr := flag.String("in", "", `CSV filename`)
	outFnPtr := flag.String("out", iostream.Stdio, `csv output filename or `+iostream.Stdio+` to output to stdout`)
	flag.Parse()

	srcFn = *srcFnPtr
	inFn = *inFnPtr
	outFn = *outFnPtr
	return srcFn, inFn, outFn
}
