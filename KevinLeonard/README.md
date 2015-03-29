# QL
QL is a DSL for creating questionnaires.

## QL Language Description
- QL is block-structured, blocks are delimited by curly braces.
- QL has tree types of values: booleans, numbers (i.e. whole numbers) and strings.
- QL uses declare before use.
- QL supports boolean operations (i.e. and, or, not) on booleans.
- QL supports equality operations (i.e. ==, !=) on booleans, numbers and strings.
- QL supports relational operations (i.e. <, <=, >, >=) on numbers.
- QL supports arithmetic operations (i.e. +, -, *, /) on numbers.
- QL supports parenthesis in expressions.

## QL Example
    /*
     * Wanna throw a party?
     */
    form PartyForm {
        question comesToParty "Will you come to my party?"
        answer boolean is true

        if comesToParty {
            question numberOfFriends "How many friends will you bring with you?"
            answer number

            // Only ask if they want to crash if they come with less than 3 persons
            if numberOfFriends < 3 {
                question needPlaceToCrash "Do you need a place to crash?"
                answer boolean
            }

            question preferences "Do you have any special preferences?"
            answer string
        } else {
            question reason "Why not?"
            answer string
        }
    }

## Running QL
Start the Scala console and run: `ql.interpreter.Interpreter.main(Array("<path to *.ql file>"))`

---

# QLS
QLS is a DSL for styling QL questionnaires. However, QL can run independent of QLS.

## QLS Language Description
- QLS is block-structured, blocks are delimited by curly braces.
- QLS has six types of widgets: check boxes, drop downs, radios, sliders, texts (i.e. text fields) and text areas. Note
  that spin boxes are not available yet.
- For boolean questions radio, check box and drop down widgets are allowed.
- For number questions slider and text widgets are allowed.
- For string questions text and text area widgets are allowed.
- For each widget it is possible to set it's font, font size and font color (HEX). The width property can be set as
  well, but is currently ignored by the GUI.
- It is possible to define a default style for a widget.
- Question should be placed in sections.
- Sections should be placed inside other sections or inside pages. The pages, sections and ordering of questions is
  currently ignored by the GUI.

## QLS Example
    style PartyForm {

        default number slider {
            width: 400
            font: "Arial"
            fontSize: 14
            color: #999999
        }
        default string text {
            width: 400
            font: "Arial"
            fontSize: 14
            color: #999999
        }
        default string textBlock {
            width: 400
            font: "Arial"
            fontSize: 14
            color: #999999
        }

        page page1 {
            // Number Questions
            section "Number Questions" {
                section "Number Questions" {
                    numberOfFriends slider
                }
            }
        }

        page page2 {
            // String Questions
            section "String Questions" {
                reason text
                preferences textBlock
            }
        }

        page page3 {
            // Boolean Questions
            section "Boolean Questions" {
                comesToParty checkbox
                needPlaceToCrash dropdown {
                    width: 400
                    font: "Arial"
                    fontSize: 14
                    color: #999999
                }
            }
        }
    }

## Running QLS
Start the Scala console and run: `qls.interpreter.Interpreter.main(Array("<path to *.ql file>", "<path to *.qls file>"))`
