const express = require("express")
const app  = express()
let names = ["Pedro","Juan","Lucas"]

app.get("/",(req,res)=> {
    position = req.query.size
    result = names[position];
    res.send("En la posicion " + position 
    + " se encuentra el usuario " + result)
    console.log(result)
})

app.get("/",(req,res)=> {
    res.send("Raiz")
})

app.listen(5000,()=>{
    console.log("Recibido en el puerto 5000")
})


