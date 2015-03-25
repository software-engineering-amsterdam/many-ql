// QL.
//
// Carlos Cirello - MSc. Software Engineering - Batch 2015/2016.
// Questionaire Language is a toy project for UvA Software Construction
// Course 2014/2015 Batch.
//
// It is a DSL meant to describe forms (QL).
package main

func main() {
	defer errorHandler()

	srcFn, srcReader, inReader, outWriter := openIoStreams()
	pipes, guiAppName := startInterpreter(srcReader, srcFn)
	readInput(pipes, inReader)
	launchGUI(pipes, guiAppName)
	writeOutput(pipes, outWriter)
}
