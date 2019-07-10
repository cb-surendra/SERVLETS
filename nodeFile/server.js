const http = require('http');

const app = require('./app');//import the app.js

//hello
const port = 3000;//setup port number 

const server = http.createServer(app);//create server with app
//make some change
server.listen(port);
