var names = ["Lars" ,"Jan", "Peter", "Bo", "Frederik", "Emil", "Dan"];

var filterNames = names.filter(x=>x.length<=3);
names.forEach(x=>console.log(x));
filterNames.forEach(x=>console.log(x));

var upNames = names.map(x=>x.toUpperCase());

console.log(upNames);

let html = names.map(n=>'li' + n + '</li>');
console.log('<ul>' + html.join('') + '</ul>');

var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

console.log("Cars newer than 1999: ")
console.log(cars.filter(x=>x.year > 1999));

console.log("All Volvo: ");
console.log(cars.filter(x=>x.make === 'Volvo'));

console.log("All cars below 5000: ")
console.log(cars.filter(x=>x.price < 5000));

sql = cars.map(x=>'INSERT INTO cars (id,year,make,model,price) VALUES (' + x.id + ',' + x.year + ',' + x.make + ',' + x.model + ',' + x.price +');');
console.log(sql);

var msgPrinter = function(msg,delay){
  setTimeout(function(){
    console.log(msg);
  },delay);
};
console.log("aaaaaaaaaa");
msgPrinter ("bbbbbbbbbb",2000);
console.log("dddddddddd");
msgPrinter ("eeeeeeeeee",1000);
console.log("ffffffffff");
