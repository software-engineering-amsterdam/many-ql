#KLQ (Kennedy Langlotz Questionnaires)
##Usage
KLQ is executed by running the Main class. It takes one argument which is the input file. The argument should be given like this: --file=input.klq

##Syntax
###Questions
In KLQ questions are defined by the 'question' statement. This opens a block where different of properties of the question can be added. The block is then closed with an 'end' statement. 
Each question requires the 'id', 'text' and 'type' properties to be defined.

####Properties
#####id
The 'id' property is the unique identifier of the question. With this you can refer to certains questions in for example if statements.
#####text
The 'text' property is the label that the question will have.
#####type
The 'type' property defines the type of the question. This can be string, numeral, date or boolean.
#####value
The 'value' property allows a question the have a predefined value. It can either be a primitive value like a string or a numeral, or it can be a calculated value that uses other questions. In the last case the value of the question will only be shown when the all required questions are answered.

A question block could for example look like this:
question
  id: age
  text: "You are this old"
  type: numeral
  value: currentDate - dateOfBirth
end

note that the indentation is not required.
###If statements
It is possible to have a conditional question. This is done by using the 'if' statement. The statement is used like this: 'if condition then', after which a block with questions or more if statements follow. The block is once again closed with an 'end' statement. The condition statement needs to be a boolean statement (so it needs something like a '>', '==' etc).
For example:
if age > 5 then
  ask more questions
end

##Architecture
The KLQ architecture is depicted in the diagram below:
![Architecture](https://github.com/software-engineering-amsterdam/many-ql/blob/master/kennedy-langlotz/KLQ/architecture.png "KLQ Architecture")
