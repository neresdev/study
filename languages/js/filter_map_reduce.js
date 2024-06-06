// Return the sum of double of all even numbers
// -> Filter even numbers
// -> Double this numbers
// -> Reduce (sum all)
const numbers = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27]
const evenNumbers = numbers
    .filter(n => n%2 === 0) // get only even numbers
    .map(n => n * 2) // double all numbers
    .reduce((a, v) => a+v);

console.log(evenNumbers);

