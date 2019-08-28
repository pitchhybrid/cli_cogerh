const util  = require("./src/scripts/utils");
const Index  = require("./src/index");
const inquirer = require('inquirer');
const ajuda = require('./src/doc/index-help');

module.exports = function cli(argv){

    var args = util.minimist(argv)
    
    var novo = args.n || args.new  || args.novo || args.criar || args.create
    var deletar = args.d || args.del || args.deletar || args.delete || args.remover || args.r
    var help = args.h || args.help || args.ajuda || util.isEmpty(args) || util.isEmpty(novo) || util.isEmpty(deletar) 

    if (novo || deletar || help){
        const projeto = new Index();
        if(novo) {
               
            if(novo[0] == "projeto" || novo[0] == "p"){
                let questions = [
                    {
                      type: 'input',
                      name: 'nome_projeto',
                      message: "Qual o nome do projeto:",
                      default:function(){
                          return novo[1] || ""
                      }
                    },
                    {
                      type: 'input',
                      name: 'nome_pacote',
                      message: "Qual o nome do pacote (ex: br.com ...):"
                    },
                    {
                        type: 'input',
                        name: 'versao_projeto',
                        message: "Qual a versao do projeto:",
                        default:function(){
                            return "1.0.0";
                        }
                    },
                    {
                        type: 'input',
                        name: 'descricao',
                        message: "Qual a descricao do projeto:",
                        default:function(){
                            return "nenhuma"
                        }
                    }
                  ];
                  
                  inquirer.prompt(questions).then(answers => {
                      console.log('\n\n')
                    var nome = answers.nome_projeto;
                    util.writeJson(answers,util.base_path(`${nome}/package.json`))
                    projeto.pacote = answers.nome_pacote
                    projeto.gerarProjeto(nome)
                    
                });
                  
            }else if(novo[0] == "componente" || novo[0] == "c"){
                util.getJson("package").then(function (json){
                    projeto.pacote = json.nome_pacote
                    projeto.gerarComponente(novo[1],novo[2] || "all")
                })
                
            }else{
                console.log( ajuda.novo.all())
            }
        }else if(deletar){
            if (deletar[0] == "componente" || deletar[0] == "c"){
                util.getJson("package").then(function(json){
                    projeto.pacote = json.nome_pacote
                    projeto.deletarComponente(deletar[1], deletar[2] || "all")
                })
                
            }else{
                console.log( ajuda.deletar.all())
            }
        }else if(help){
            if(help[0] == "projeto"){
                console.log( ajuda.novo.projeto())
            }
            else if(help[0] == "componente"){
                console.log( ajuda.novo.componente()) 
                console.log( ajuda.deletar.componente())
            }
            else{
                console.log( ajuda.apresentacao() )
                console.log( ajuda.all() ) 
            }
            
        }
    }

}

