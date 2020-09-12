console.log("Opgaver om Javascript flow 1, week 3, 09/09");
console.log("Opgave b");

var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];

let all = boys.concat(girls);
console.log(all);

console.log("Opgave c1 ");
let a = all.join();
console.log(a);

console.log("Opgave c2");
let b = all.join(delimiter = '-');
console.log(b);

console.log("Opgave d");
all.push('Lone','Gitte');
console.log(all);

console.log("Opgave e");
all.unshift('Hans','Kurt');
console.log(all);

console.log("Opgave f");
all.shift();
console.log(all);

console.log("Opgave g");
all.pop();
console.log(all);

console.log("Opgave h");
all.splice(3,2);
console.log(all);

console.log("Opgave i");
all.reverse();
console.log(all);

console.log("Opgave j");
all.sort();
console.log(all);

console.log("Opgave l");
let all2 = all.map(function(item) { return item.toUpperCase() });
console.log(all2);

console.log("Opgave m");
let all3 = all2.filter(function(item) {return item.valueOf('i','l') });
console.log(all3);
