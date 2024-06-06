"use strict";

function _slicedToArray(arr, i) { return _arrayWithHoles(arr) || _iterableToArrayLimit(arr, i) || _nonIterableRest(); }

function _nonIterableRest() { throw new TypeError("Invalid attempt to destructure non-iterable instance"); }

function _iterableToArrayLimit(arr, i) { if (!(Symbol.iterator in Object(arr) || Object.prototype.toString.call(arr) === "[object Arguments]")) { return; } var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"] != null) _i["return"](); } finally { if (_d) throw _e; } } return _arr; }

function _arrayWithHoles(arr) { if (Array.isArray(arr)) return arr; }

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(source, true).forEach(function (key) { _defineProperty(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(source).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

// spred operator
var product = {
  name: "Key",
  price: 1.3
};
var otherProduct = product;

var car = _objectSpread({}, product, {
  isSale: true
});

var book = Object.assign({}, product);
otherProduct.name = "Other Name";
car.name = "car";
book.name = "book";
Object.freeze(car);
car.name = "ASODUHOEFHNOH";
console.log(product.name); // Other Name

console.log(otherProduct.name); // Other Name

console.log(car.name); // car

console.log(book.name); // book

console.log(Object.keys(otherProduct)); // [ 'name', 'price' ]

Object.defineProperty(book, 'name', {
  writable: true
});
console.log(Object.getOwnPropertyDescriptor(book, "name")); // { value: 'book', writable: true, enumerable: true, configurable: true }

console.log(Object.keys(book)); // [ 'name', 'price' ]

console.log(Object.values(book)); //[ 'book', 1.3 ]

console.log(Object.entries(book)); // [ [ 'name', 'book' ], [ 'price', 1.3 ] ]

for (var _i = 0, _Object$entries = Object.entries(book); _i < _Object$entries.length; _i++) {
  var _Object$entries$_i = _slicedToArray(_Object$entries[_i], 2),
      key = _Object$entries$_i[0],
      value = _Object$entries$_i[1];

  console.log(b);
}