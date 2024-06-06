// sum all numbers
// return a array with even numbers (Filter)
// return a array with double of numbers (Map)

const numbers = [5, 50, 80, 1, 2, 3, 4, 12, 542, 22, 34]
const evenNumbers = numbers.reduce((acumulator, value, index, array) => {
    if(value % 2 === 0) acumulator.push(value);
    return acumulator;
}, []);
// console.log(`total: ${evenNumbers}`);

const doubleNumbers = numbers.reduce((acumulator, value, index, array) => {
    acumulator.push(value * 2);
    return acumulator; 
}, []);
// console.log(`total: ${doubleNumbers}`);

// Return most old people

const people = [
    {name: 'Luiz', years: 62},
    {name: 'Maria', years: 23},
    {name: 'Eduardo', years: 55},
    {name: 'Letícia', years: 19},
    {name: 'Rosana', years: 64},
    {name: 'Wallace', years: 1000}
]

const mostOld = people.reduce(function(acumulator, value){
    console.log();
    if(acumulator !== undefined && (acumulator.years > value.years)) return acumulator;
    return value;
});

console.log(mostOld);

