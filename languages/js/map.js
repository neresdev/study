const numbers = [1, 2, 3, 4, 5, 6]
const numbersModifyed = numbers.map(n => n * 3)

const pessoas = [
    {name: 'Zilda', years: 63},
    {name: 'David', years: 63},
    {name: 'Neres', years: 63},
    {name: 'Souza', years: 63},
    {name: 'Cida', years: 63},
    {name: 'Fabiano', years: 63},
]

/**const pessoasModificadas = pessoas.map(p => {
    p.years += 5;
    p.name += " adicionado"
    return p
})

console.log(`pessoasModificadas: ${pessoasModificadas}`);**/

const onlyNames = pessoas.map(p => {
    const newPeople = {...pessoas}
    newPeople.name = p.name + " aaaa"
    return newPeople.name
})


console.log(`onlyNames: ${onlyNames}`) 

console.log(`pessoas: ${JSON.stringify(pessoas)}`);