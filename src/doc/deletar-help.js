module.exports = {
    all(){
        var x = this.componente();
        return x 
    },
    componente(){
        return  `

    Para deletar um componente:
    
    Ex:. outside --d <componente ou c> <nome do componente> <tipo_do_componente>   
ou
    Ex:. outside --del <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --deletar <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --delete <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --remover <componente ou c> <nome do componente> <tipo_do_componente>
ou
    Ex:. outside --r <componente ou c> <nome do componente> <tipo_do_componente>
    
    os tipos de componentes sao model, dao, service e controller
    OBS :. Se <tipo do componente> omitido ele deletará todos do respectivo nome   
    `;
    }
}