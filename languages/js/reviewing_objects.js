// using literal mode 
const people = {
// body of object

//  key    value
    name: 'David',
    lastName: 'Neres'
}


// console.log(people.name);
// console.log(people.lastName);

// or

const keyToSearch = 'name'
// console.log(people[keyToSearch]);
// console.log(people['lastName']);


// using constructor

const otherPeople = new Object();
otherPeople.name = 'David'
otherPeople.lastName = 'Neres'
otherPeople.age = 18

const otherKeyToSearch = 'lastName'

// console.log(otherPeople.name);
// console.log(otherPeople[otherKeyToSearch]);

// delete a key
delete otherPeople.name;

// console.log(otherPeople);

otherPeople.printLastName = function(){
    return `the lastName is ${this.lastName}`;
}

// console.log(otherPeople.printLastName());

otherPeople.getLastName = function(){
    return this.lastName;
}

// console.log(otherPeople.getLastName());

// console.log("************ keys and values ************");
for (let key in otherPeople){
    // console.log(`key: ${key}, value ${otherPeople[key]}`);
}

/* factory functions and constructor functions */

// factory function
function factoryCreatePeople(name, lastName, age){
    // Object.freeze(this);
    return {
        name,
        lastName,
        age,
        get completeName() {
            return `${this.name} ${this.lastName}`;
        }
    }
}

const peopleCreated1 = factoryCreatePeople('David', 'Neres', 21)
console.log(peopleCreated1.completeName);

// Constructor function
function ConstructorPeople(name, lastName){
    this.name = name;
    this.lastName = lastName;
    // Object.freeze(this); // "block" the object, make it immutable
}

const buildPeople = new ConstructorPeople('David', 'Neres');
console.log(buildPeople);

buildPeople.name = 'Deivao';

console.log(buildPeople);

// Object.freeze(buildPeople); // "block" the object, make it immutable

buildPeople.name = 'Deivas';

console.log(buildPeople);
