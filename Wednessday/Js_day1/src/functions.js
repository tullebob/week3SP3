//Function Declaration
//Observe: no return type, no type on parameters
function add(n1, n2) {
    return n1 + n2;
}

//Function Expression
var sub = function (n1, n2) {
    return n1 - n2;
}

//Callback example
var cb = function (n1,n2, callback) {
    if (typeof n1 !== "number" || typeof n1 === "undefined")
        throw new Error("Error: n1 is not a number!");

    else
    if (typeof n2 !== "number" || typeof n2 === "undefined")
        throw new Error("Error: n2 is not a number")
    else
    if (typeof callback !== "function" || typeof callback === "undefined")
        throw new Error("Error: callback is not a function!")
    else
        return "Result from the two numbers: " + n1 + "+" + n2 + "=" + callback(n1, n2);
}

console.log("1: " + add(1, 2));     // What will this print?
console.log("2: " + add);          // What will it print and what does add represent?
console.log("3: " + add(1, 2, 3)); // What will it print
console.log("4: " + add(1));	  // What will it print 	
/*console.log("5: " + cb(3, 3, add)); // What will it print
console.log("6: " + cb(4, 3, sub)); // What will it print
console.log("7: " + cb(3, 3, add())); // What will it print (and what was the problem)
console.log("8: " + cb(3, "hh", add));// What will it print*/

var mul = function(n1,n2){
    return n1/n2;
}

console.log(cb(6,2, mul));
