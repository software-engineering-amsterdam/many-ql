# Software construction

Hi there, thank you for traveling with KevinRene. During your flight you're free to enjoy our delicious recycled beverages, meals made of roadkill, and some weird ass games.

In case of emergency please headbutt your neighbor, take a chill pill, and drop dat beat.

We hope you have a pleasant flight.

~ Jesus and Buddha

![Our plane](http://www.studentsoftheworld.info/sites/misc/img/28740_weird-plane[1].jpg)


## Example forms

You can load these from KevinRene/forms/, which includes several QL forms and one QLS form.

## QL

### Examples

```
	form emptyForm {

	}
```

```
	form noAssignmentsForm {
		hasSoldHouse: boolean {
			"Did you sell a house in 2010?"
		}
	}
```

```
	form withAssignmentForm {
		valueOfHouse: money {
			"The value of your house is"
			assign(100000)
		}
	}
```

```
	form withConditionForm {
		hasSoldHouse: boolean {
			"Did you sell a house in 2010?"
		}

		if (hasSoldHouse) {
			sellingPrice: money {
				"What was the selling price?"
			}
		}
	}
```

```
form taxOfficeExample { 
	hasSoldHouse: boolean {
		"Did you sell a house in 2010?"
	}
	hasBoughtHouse: boolean {
		"Did you buy a house in 2010?"
	}
	hasMaintLoan: boolean {
		"Did you enter a loan?"
	}
	

	if (hasSoldHouse) {
		sellingPrice: money {
			"What was the selling price?"
		}
		privateDebt: money {
			"Private debts for the sold house:"	
		}

		valueResidue: money {
			"Value residue:"
			assign(sellingPrice - privateDebt)
		}
	}
}
```