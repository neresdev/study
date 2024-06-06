function Poroduct(name, price, stock){
    this.name = name;
    this.price = price;

    Object.defineProperty(this, 'stock', {
        enumerable: false, // set this key visible
        value: stock, // value to set this property
        writable: false, // can it mutable?
        configurable: true, // this key can be deleted? (With 'delete' command, for example)
    });

    Object.defineProperties(this, {
        name: {
            enumerable: false,
            value: stock,
            writable: false,
            configurable: true
        },
        price: {
            enumerable: false,
            value: stock,
            writable: false,
            configurable: true
        }
    })
}

const product1 = new Poroduct('T-Shirt', 20, 3);
console.log(product1);

product1.stock = 1;
console.log(product1);

console.log(Object.keys(product1));
