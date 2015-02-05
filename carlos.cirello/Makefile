all:
	go generate ./...
	go build
	echo "Build successful"
	./carlos.cirello -h || echo

test:
	go test -v ./...

coverage:
	mkdir cover || echo "cover/ already exists. Mkdir skipped."

	go test -coverprofile=./compiler/coverage.out ./compiler
	go test -coverprofile=./frontend/graphic/coverage.out ./frontend/graphic
	go test -coverprofile=./frontend/text/coverage.out ./frontend/text
	go test -coverprofile=./frontend/coverage.out ./frontend
	go test -coverprofile=./question/coverage.out ./question
	go test -coverprofile=./questionaire/coverage.out ./questionaire
	go test -coverprofile=./vm/coverage.out ./vm

	go tool cover -html=./compiler/coverage.out -o cover/compiler.html || echo Skipped
	go tool cover -html=./frontend/graphic/coverage.out -o cover/frontend/graphic.html || echo Skipped
	go tool cover -html=./frontend/text/coverage.out -o cover/frontend/text.html || echo Skipped
	go tool cover -html=./question/coverage.out -o cover/question.html || echo Skipped
	go tool cover -html=./questionaire/coverage.out -o cover/questionaire.html || echo Skipped
	go tool cover -html=./questionaire/coverage.out -o cover/questionaire.html || echo Skipped
	go tool cover -html=./vm/coverage.out -o cover/vm.html || echo Skipped

	rm -f ./compiler/coverage.out
	rm -f ./frontend/graphic/coverage.out
	rm -f ./frontend/text/coverage.out
	rm -f ./frontend/coverage.out
	rm -f ./question/coverage.out
	rm -f ./questionaire/coverage.out
	rm -f ./vm/coverage.out

autotest:
	./autotest.sh '.' 'clear; make test; go run ql.go'

todos:
	grep -RHin "// todo" *

doc: .FORCE
	godoc -http=:8080 &
	sleep 2
	open 'http://localhost:8080/pkg/github.com/software-engineering-amsterdam/many-ql/carlos.cirello/'

talk:
	cd doc
	present -play=true &
	sleep 2
	open 'http://127.0.0.1:3999/doc/carlos.cirello.ql.qls.slide'

.FORCE:
