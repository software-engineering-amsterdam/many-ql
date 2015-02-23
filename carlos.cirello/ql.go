package main

import (
	"log"
	"os"
	"runtime/pprof"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/iostream"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvinput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvoutput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
)

func main() {
	defer func() {
		if r := recover(); r != nil {
			log.Println("error:", r)
		}
	}()
	srcFn, inFn, outFn, cpuProfileFn := cli.Args()
	if cpuProfileFn != "" {
		f, err := os.Create(cpuProfileFn)
		if err != nil {
			log.Fatal(err)
		}
		pprof.StartCPUProfile(f)
		defer pprof.StopCPUProfile()
	}

	srcReader, inReader, outWriter := iostream.New(srcFn, inFn, outFn)
	aQuestionaire := parser.ReadQL(srcReader, srcFn)
	fromInterpreter, toInterpreter := interpreter.New(aQuestionaire)

	if inReader != nil {
		csvReader := csvinput.New(fromInterpreter, toInterpreter, inReader)
		csvReader.Read()
	}

	driver := graphic.GUI(aQuestionaire.Label())
	frontend.New(fromInterpreter, toInterpreter, driver)
	driver.Loop()

	csvWriter := csvoutput.New(fromInterpreter, toInterpreter, outWriter)
	csvWriter.Write()
}
