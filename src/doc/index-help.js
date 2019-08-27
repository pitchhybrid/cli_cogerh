module.exports = {
    help(){
        return `
Para ajuda:
    
    Ex:. outside --h <tipo da ajuda>   
ou
    Ex:. outside --help <tipo da ajuda>
ou
    Ex:. outside --ajuda <tipo da ajuda>
    
    os tipos de ajuda sao projeto, componente, tudo
    OBS :. Se <tipo da ajuda> omitido ele mostrará todos
        `
    },
    all(){
        var x = this.help()
        var y = this.novo.all()
        var z = this.deletar.all()
        return x + y + z
    },
    apresentacao(){
        return `

Criado por messias

Ferramenta para criar e auxiliar os projetos da cogerh
            
    `
    },
    novo:require('./novo-help'),
    deletar:require('./deletar-help')
}