// filter -> always returns an array, with same quantity of elements or less

// Return numbers greater than 10
const numbers = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27]
const numbersGreaterThanTen = numbers.filter(n => n > 10)
console.log(`Numbers greater than 10: ${numbersGreaterThanTen} \n`) //returns -> 50,80,11,15,22,27


// Return people which the name have 5 letters or more
// Return people with more than 50 years
// Return people which name ends with 'a'
const people = [
    {name: 'Luiz', years: 62},
    {name: 'Maria', years: 23},
    {name: 'Eduardo', years: 55},
    {name: 'Letícia', years: 19},
    {name: 'Rosana', years: 32},
    {name: 'Wallace', years: 47}
]

const peopleWithBigName = people.filter(p => p.name.length >= 5)
const peopleWithMoreThanFifty = people.filter(p => p.years > 50)
const peopleWithNameEndsWithA = people.filter(p => p.name.endsWith('a'))

console.log(`peopleWithBigName: ${JSON.stringify(peopleWithBigName)} \n`)
console.log(`peopleWithMoreThanFifty: ${JSON.stringify(peopleWithMoreThanFifty)} \n`)
console.log(`peopleWithNameEndsWithA: ${JSON.stringify(peopleWithNameEndsWithA)} \n`)