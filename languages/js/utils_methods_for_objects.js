// spred operator
const product = {name : "Key", price: 1.3}
const otherProduct = product;
const car = {...product, isSale : true}
const book = Object.assign({}, product)

otherProduct.name = "Other Name"
car.name = "car"
book.name = "book"

Object.freeze(car);
car.name = "ASODUHOEFHNOH"

console.log(product.name); // Other Name
console.log(otherProduct.name); // Other Name
console.log(car.name); // car
console.log(book.name); // book

console.log(Object.keys(otherProduct)); // [ 'name', 'price' ]

Object.defineProperty(book, 'name', {
    writable: true
})

console.log(Object.getOwnPropertyDescriptor(book, "name")); // { value: 'book', writable: true, enumerable: true, configurable: true }

console.log(Object.keys(book)); // [ 'name', 'price' ]
console.log(Object.values(book)); //[ 'book', 1.3 ]
console.log(Object.entries(book)); // [ [ 'name', 'book' ], [ 'price', 1.3 ] ]

for(let [key, value] of Object.entries(book)){
    console.log(b);
}
