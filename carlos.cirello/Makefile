all:
	go generate ./...
	go build
	echo "Build successful"
	./carlos.cirello -h || echo

test:
	go generate ./...
	go test -v ./...

coverage:
	mkdir cover || echo "cover/ already exists. Mkdir skipped."

	go test -coverprofile=./cli/coverage.out ./cli
	go test -coverprofile=./cli/iostream/coverage.out ./cli/iostream

	go tool cover -html=./cli/coverage.out -o cover/cli.html || echo Skipped
	go tool cover -html=./cli/iostream/coverage.out -o cover/cli_iostream.html || echo Skipped

	rm -f ./cli/coverage.out
	rm -f ./cli/iostream/coverage.out

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

lint:
	clear
	golint ./... | head -n 20

.FORCE:
