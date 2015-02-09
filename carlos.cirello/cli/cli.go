package cli

import "flag"

func Args() (inFn, outFn string) {
	inFnPtr := flag.String("in", "-", `QL code filename or "-" to read from stdin`)
	outFnPtr := flag.String("out", "-", `csv output filename or "-" to output to stdout`)
	flag.Parse()

	inFn = *inFnPtr
	outFn = *outFnPtr
	return inFn, outFn
}
