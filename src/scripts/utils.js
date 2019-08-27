const  fs =  require('fs');
const _fs =  require('fs-extra');
const path = require('path');

const util = {}

util.base_path = function ( args='' ){
    return path.resolve( args );
}
util.cli_path  = function ( args='/' ){
    return path.resolve( __dirname + args )
}
util.isEmpty = function ( args ){
    for( i in args ){
        return false
    }
    return true
}

util.minimist = function ( args ){
    let x = {}
    let values = []
    for (i = 0;i<args.length;i++){
        
        if(args[i].match(/\w+\-\-\w+|\w+\-\w+/g)){
            return {};
        }

        if(args[i].includes("-")){
            key = args[i].replace(/[-]/g,"")
            values = [];

        }
        else{
            value = args[i]
            values.push(value)
        }
        x[key] = values
    }
    return x;
}

util.copyFolder = function ( origin, destiny ){
    _fs.copy( origin, destiny ).catch( e =>{
        console.log(e)
    });
}

util.copyFile = async function ( origin, destiny ){
    await fs.createReadStream( origin ).pipe( fs.createWriteStream( destiny ) );
}

util.createFolder = function( name ) {
    _fs.mkdir(this.base_path( name ) ).catch( e =>{
            console.log(e)
        })
}

util.replaceInFile = function ( file, search, replace ){
    fs.readFile( file, 'utf8', function( err, data ){
        if(err){
            return console.log(err)
        }
        var result = data.replace( new RegExp( search, "g" ), replace )
        fs.writeFile( file , result, 'utf8', function( err ){
            if(err)
            return console.log(err)
        })
    })
}

util.writeFile = function ( dado, nome ){
     _fs.outputFile( nome, dado ).catch(e =>{
         console.log("Falha ao criar :\n" + e)
     })
}

util.getJson = function ( json ){
    return require( this.base_path( `${json}.json` ) )
}

util.writeJson = function ( data, nome ){
    this.writeFile( JSON.stringify( data ), nome )
}

util.deleteFile = function ( nome ){
    fs.unlink( nome, function ( err ){
        if (err) {
            console.log("Falha ao deletar: [" + err.code + "] \n" + err.syscall + " : '" + err.path + "'")
        }
    })
}

util.deleteFolder = function ( nome ){
    _fs.remove(nome).catch(e =>{
        console.log("Falha ao deletar: \n" + e)
    })
}

util.existFolder = function ( name ){
    var ex = false;
    try{
        ex = fs.existsSync( this.base_path(name) )
    }catch (e){
        console.log(e)
    }
    return ex;
}

module.exports = util;