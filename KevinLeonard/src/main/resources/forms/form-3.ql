/*
 * Wanna throw a party?
 */
form PartyForm {
    question comesToParty "Will you come to my party?"
    answer boolean

    if (comesToParty) {
        question reallySure "Are you really sure?"
        answer boolean
    }

    if (comesToParty and reallySure) {
        question numberOfFriends "How many friends will you bring with you?"
        answer number

        question numberOfPresents "How many presents will you bring with you?"
        answer number

        question preferences "Do you have any special preferences?"
        answer string

        question aLotOfPreferences "A lot of preferences?"
        answer string
    }
}
