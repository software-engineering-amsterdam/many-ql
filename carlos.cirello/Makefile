all:
	go generate ./...
	go build
	echo "Build successful"
	./carlos.cirello -h || echo

test:
	go test -v ./...

cover:
	go test -coverprofile=./questionaire/coverage.out ./questionaire
	go tool cover -html=./questionaire/coverage.out

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
