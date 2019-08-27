module.exports = function(args){
    nome = String(args.nome);
    pacote = String(args.pacote)
    classe = nome[0].toUpperCase() + nome.substring(1);
    service = `
package ${pacote}.service;

import java.util.List;

import ${pacote}.model.${classe};

public interface ${classe}Service {
    
    public ${classe} salvar${classe}(${classe} ${nome}) throws Exception;
    public ${classe} alterar${classe}(${classe} ${nome}) throws Exception;
    public void remover${classe}(${classe} ${nome}) throws Exception;
    public ${classe} buscarPorId(Integer id) throws Exception;
    public List<${classe}> listar(String pesquisa) throws Exception;

}`

    serviceImpl = `
package ${pacote}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${pacote}.dao.${classe}DAO;
import ${pacote}.model.${classe};
import ${pacote}.service.${classe}Service;

@Service
public class ${classe}ServiceImpl implements ${classe}Service{
    
    private ${classe}DAO dao;

    @Autowired
    public ${classe}ServiceImpl(${classe}DAO dao)
    {
        this.dao = dao;
    }

    @Transactional
    public ${classe} salvar${classe}(${classe} ${nome}) throws Exception
    {
        return this.dao.save(${nome});
    }

    @Transactional
    public ${classe} alterar${classe}(${classe} ${nome}) throws Exception
    {
        return this.dao.update(${nome});
    }

    @Transactional
    public void remover${classe}(${classe} ${nome}) throws Exception
    {
        this.dao.delete(${nome});
    }

    @Transactional
    public List<${classe}> listar(${classe} ${nome}) throws Exception
    {
        List<${classe}> ${nome}List = dao.listar(pesquisa);

        return ${nome}List;
    }

    @Transactional
    public ${classe} buscarPorId(Integer id) throws Exception
    {
        ${classe} ${nome} = dao.buscarPorId(id);

        return ${nome};
    }

}`

    return [service,serviceImpl];
}