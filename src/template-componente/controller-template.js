module.exports = function(args){
    nome = String(args.nome);
    pacote = String(args.pacote);
    classe = nome[0].toUpperCase() + nome.substring(1);
    controller = `
package ${pacote}.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ${pacote}.model.${classe};
import ${pacote}.service.${classe}Service;

@Controller
@Scope("view")
public class ${classe}Bean extends AbstractBean
{
    private ${classe} ${nome} = new ${classe}();
    private String pesquisa; 

    @Autowired
    private ${classe}Service ${nome}Service;

    private List<${classe}> ${nome}List = new ArrayList<${classe}>();

    @PostConstruct
    public void init()
    {
        try
        {
            this.${nome}List = ${classe}Service.listar(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void initForm(Integer ${nome}Id) {
    
        
    }

    public void salvar(){
        
    }

    public void listar() {
        
    }

    public void remover(${classe} ${nome}){
        
    }

    public void alterar()
    {
        
    }

    public String showFormNovo() 
    {
        return "novo.xhtml?faces-redirect=true";
    }

    public String showFormListar() 
    {
        return "lista.xhtml?faces-redirect=true";
    }

    public String showFormEditar(Integer ${nome}Id) 
    {
        return "novo.xhtml?faces-redirect=true&${nome}Id=" + ${nome}Id;
    }

    public ${classe} get${classe}() {return ${nome};}
    public void set${classe}(${classe} ${nome}) {this.${nome} = ${nome};}

    public List<${classe}> get${classe}List() {return ${nome}List;}
    public void set${classe}List(List<${classe}> ${nome}List) {this.${nome}List = ${nome}List;}

    public String getPesquisa() {return pesquisa;}
    public void setPesquisa(String pesquisa) {this.pesquisa = pesquisa;}
}`
return [controller];
}