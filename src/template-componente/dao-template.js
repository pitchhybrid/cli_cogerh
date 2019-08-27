module.exports = function(args){
    nome = String(args.nome);
    pacote = String(args.nome);
    classe = nome[0].toUpperCase()+nome.substring(1)
    dao = `
package ${pacote}.dao;

import java.util.List;

import ${pacote}.model.${classe};

public interface ${classe}DAO extends GenericDAO<${classe}, Integer> {
    public List<${classe}> listar(String pesquisa); 
    
}`
    daoImpl = `
package ${pacote}.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ${pacote}.dao.${classe}DAO;
import ${pacote}.model.${classe};
import ${pacote}.util.HasValue;

@Transactional
@Repository
public class ${classe}DAOImpl extends GenericDAOImpl<${classe}, Integer> implements ${classe}DAO {
    
    public List<${classe}> listar(String pesquisa) {

        final StringBuilder sb = new StringBuilder();
        final StringBuilder cond = new StringBuilder();

        if (HasValue.execute(pesquisa))
            cond.append(" and ()");

        if (cond.length() > 4)
            cond.replace(0, 5, " where ");
        
        sb.append("");


        final TypedQuery<${classe}> query = entityManager.createQuery(sb.toString(), ${classe}.class);

        if (HasValue.execute(pesquisa)){
            
        }

        return query.getResultList();
    }
    
}`

return [dao,daoImpl];
}