let app = require("express")()
app.get("/palin/:word", (req,res) => {
    let word = req.params.word.trim()
    let output = word == word.split('').reverse().join('')
    res.end(output+'')
})
app.listen(3000);
console.log("server running on 3000")