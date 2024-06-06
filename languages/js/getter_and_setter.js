function Product(name, price, stock){
    this.name = name;

    Object.defineProperty(this, 'stock', {
        enumerable: true,
        configurable: true,
        get: function(){
            return stock;
        },
        set: function(value){
            if(typeof value !== 'number'){
                throw new TypeError("Invalid stock");
            }
            stock = value;
        }
    })
}

const p1 = new Product('T-Shirt', 20, 3);
p1.stock = 4

function createProduct(name){
    return {
        get name(){
            return name;
        },
        set name(value){
            name = value;
        }
    }
}

const p2 = createProduct('T-shit master');

console.log(p2.name);


