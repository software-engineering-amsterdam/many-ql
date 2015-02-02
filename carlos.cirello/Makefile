test:
	go test -v ./...

cover:
	go test -coverprofile=./questionaire/coverage.out ./questionaire
	go tool cover -html=./questionaire/coverage.out

autotest:
	./autotest.sh '.' 'clear; make test; go run ql.go'

todos:
	grep -RHin "// todo" *

doc:
	godoc -http=:8080 &
	sleep 1
	open 'http://localhost:8080/pkg/github.com/software-engineering-amsterdam/many-ql/carlos.cirello/'
