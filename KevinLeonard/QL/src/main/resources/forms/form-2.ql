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
