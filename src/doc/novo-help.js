module.exports = {
    all(){
        var x = this.projeto();
        var y = this.componente();
        return x + y
    },
    projeto(){
        return `

Para novo projeto:

    Ex:. outside --n <projeto ou p>  <nome do projeto>    
ou
    Ex:. outside --new <projeto ou p>  <nome do projeto>
ou
    Ex:. outside --novo <projeto ou p>  <nome do projeto>
ou
    Ex:. outside --criar <projeto ou p>  <nome do projeto>
ou
    Ex:. outside --create <projeto ou p>  <nome do projeto>

    OBS :. <nome do projeto> pode ser omitido
        `;
    },
    componente(){
        return `
        
Para um novo componente:
        
    Ex:. outside --n <componente ou c> <nome do componente> <tipo_do_componente>   
ou
    Ex:. outside --new <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --novo <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --criar <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --create <componente ou c> <nome do componente> <tipo_do_componente>
    
    os tipos de componentes sao model, dao, service e controller
    OBS :. Se <tipo do componente> omitido ele gerará todos
        `;
    }
}