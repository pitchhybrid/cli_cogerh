const util = require('./scripts/utils')
const glob = require('glob')

module.exports = class Index{
    constructor ( pacote='' ){
        this.pacote = pacote;
    }
    
    set setPacote ( pacote ){
        this.pacote = pacote;
    }
    
    get getPacote (){
        return this.pacote;
    }

    projetoResolve ( path='' ){
        return util.base_path( path + ( path ? '/':'' ) + 'src/' + this.pacote.replace(/\./g,"/") )
    }

    gerarProjeto ( path='' ){
        
        util.copyFolder(
            util.cli_path('/../template-base'),
            util.base_path ( path ) )
       
        util.copyFolder(
            util.cli_path("/../template-src"),
            this.projetoResolve(path))

        var pac = this.getPacote

        setTimeout(function(){
        
            glob(path + "/**/*.java", function (er, files) {
                for(i of files){
                    util.replaceInFile(i,"br.com.cogerh.template",pac)
                    console.log(`Criado: ["${i}"]`)
                }
            })
        },3000);
    }

    gerarComponente( nome, tipo='all'){
        
        var { model, dao, service, controller} = require(util.cli_path("/../template-componente/all-template"))

        var config = {
            nome:nome,
            pacote:this.getPacote
        }

        var files = []

        switch (tipo.toLowerCase()) {
            case 'model':
                files.push({model:model(config)})
                break;
            case 'dao':
                files.push({dao:dao(config)})
                break;
            case 'service':
                files.push({service:service(config)})            
                break;
            case 'controller':
                files.push({controller:controller(config)})
                break;
            case 'all':
                files.push({model:model(config)})
                files.push({dao:dao(config)})
                files.push({service:service(config)})
                files.push({controller:controller(config)})
                break;
            default:
                console.log("Ocerreu algum erro")
        }
        if (files.length > 0){
            var classe = nome[0].toUpperCase() + nome.substring(1)
        
            console.log(`Classe: ${classe}`)
            
            for(let i of files){
                if(i.model){
                    let m = i.model[0]
                    let log = `${this.projetoResolve()}/model/${classe}.java`
                    util.writeFile(m,log)
                    console.log(`Criando: ${log}`)
                }
                if(i.dao){
                    let [d, impl] = i.dao
                    let log = `${this.projetoResolve()}/dao/${classe}DAO.java`
                    console.log(`Criando: ${log}`)
                    util.writeFile(d,log)
                    let logimpl = `${this.projetoResolve()}/dao/impl/${classe}DAOImpl.java`
                    console.log(`Criando: ${logimpl}`)
                    util.writeFile(impl,logimpl)

                }
                if(i.service){
                    let [s, impl] = i.service
                    let log = `${this.projetoResolve()}/service/${classe}Service.java`
                    console.log(`Criando: ${log}`)
                    util.writeFile(s,log)
                    let logimpl = `${this.projetoResolve()}/service/impl/${classe}ServiceImpl.java`
                    console.log(`Criando: ${logimpl}`)
                    util.writeFile(impl,logimpl)
                }
                if(i.controller){
                    let c = i.controller[0]
                    let log = `${this.projetoResolve()}/controller/${classe}Bean.java`
                    console.log(`Criando: ${log}`)
                    util.writeFile(c,log)
                }
            }
        
        }else{
            console.log("Ocerreu algum erro")
        }
    }

    deletarComponente(nome,tipo='all'){

        var classe = nome[0].toUpperCase() + nome.substring(1)
        
        console.log(`Classe: ${classe}`)

        switch (tipo.toLowerCase()) {
            case 'model':
                var log = `${this.projetoResolve()}/model/${classe}.java`
                console.log(`Deletando: ${log}`)
                util.deleteFile(log)
                break;
            case 'dao':
                var log = `${this.projetoResolve()}/dao/${classe}DAO.java`
                console.log(`Deletando: ${log}`)
                util.deleteFile(log)
                var logimpl = `${this.projetoResolve()}/dao/impl/${classe}DAOImpl.java`
                console.log(`Deletando: ${logimpl}`)
                util.deleteFile(logimpl)
                break;
            case 'service':
                var log = `${this.projetoResolve()}/service/${classe}Service.java`
                console.log(`Deletando: ${log}`)
                util.deleteFile(log)
                var logimpl = `${this.projetoResolve()}/service/impl/${classe}ServiceImpl.java`
                console.log(`Deletando: ${logimpl}`)
                util.deleteFile(logimpl)        
                break;
            case 'controller':
                var log = `${this.projetoResolve()}/controller/${classe}Bean.java`
                console.log(`Deletando: ${log}`)
                util.deleteFile(log)
                break;
            case 'all':
                var log = `${this.projetoResolve()}/model/${classe}.java`
                console.log(`Deletando: ${log}`)
                util.deleteFile(log)
                var log2 = `${this.projetoResolve()}/dao/${classe}DAO.java`
                console.log(`Deletando: ${log2}`)
                util.deleteFile(log2)
                var log3 = `${this.projetoResolve()}/dao/impl/${classe}DAOImpl.java`
                console.log(`Deletando: ${log3}`)
                util.deleteFile(log3)
                var log4 = `${this.projetoResolve()}/service/${classe}Service.java`
                console.log(`Deletando: ${log4}`)
                util.deleteFile(log4)
                var log5 = `${this.projetoResolve()}/service/impl/${classe}ServiceImpl.java`
                console.log(`Deletando: ${log5}`)
                util.deleteFile(log5)  
                var log6 = `${this.projetoResolve()}/controller/${classe}Bean.java`
                console.log(`Deletando: ${log6}`)
                util.deleteFile(log6)
                break;
            default:
                console.log("Ocerreu algum erro")
                break;
        }

    }
}
