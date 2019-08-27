package br.com.cogerh.template.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cogerh.template.dao.UsuarioDAO;
import br.com.cogerh.template.model.Usuario;
import br.com.cogerh.template.util.HasValue;

@Transactional
@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO
{
	public List<Usuario> listar(String pesquisa) 
	{
		final StringBuilder sb = new StringBuilder();
		final StringBuilder cond = new StringBuilder();

		if (HasValue.execute(pesquisa))
			cond.append(" and (upper(nome) like :nome or upper(login) like :login) ");

		if (cond.length() > 4)
			cond.replace(0, 5, " where ");

		sb.append(" select ");
		sb.append("		usu ");
		sb.append(" from ");
		sb.append(" 	Usuario usu ");
		sb.append(  cond );
		sb.append(" order by ");
		sb.append(" 	usu.nome "); 

		final TypedQuery<Usuario> query = entityManager.createQuery(sb.toString(), Usuario.class);

		if (HasValue.execute(pesquisa))
		{
			query.setParameter("nome", "%" + pesquisa.toUpperCase() + "%");
			query.setParameter("login", "%" + pesquisa.toUpperCase() + "%");
		}

		return query.getResultList();
	}
	
	public List<Usuario> buscarUsuarios(Usuario usuario){
		final StringBuilder sb = new StringBuilder();
		final StringBuilder cond = new StringBuilder();

		if (HasValue.execute(usuario)){
			if (HasValue.execute(usuario.getNome())){
				cond.append(" and (upper(nome) like :nome) ");		
			}
			
			if (HasValue.execute(usuario.getLogin())){
				cond.append(" and (login = :login) ");		
			}
			
			if (HasValue.execute(usuario.getEmail())){
				cond.append(" and (upper(email) like :email) ");		
				
			}
			
			if (HasValue.execute(usuario.getGrupo())){
				cond.append(" and (grupo.id = :grupo) ");		
			}
			
			if (HasValue.execute(usuario.getAtivo())){
				cond.append(" and (ativo = :ativo) ");		
				
			}
			
		}
			

		if (cond.length() > 4)
			cond.replace(0, 5, " where ");

		sb.append(" select ");
		sb.append("		usu ");
		sb.append(" from ");
		sb.append(" 	Usuario usu ");
		sb.append(  cond );
		sb.append(" order by ");
		sb.append(" 	usu.nome "); 

		final TypedQuery<Usuario> query = entityManager.createQuery(sb.toString(), Usuario.class);

		if (HasValue.execute(usuario)){
			if (HasValue.execute(usuario.getNome())){
				query.setParameter("nome", "%" + usuario.getNome().toUpperCase() + "%");	
			}	
			
			if (HasValue.execute(usuario.getLogin())){
				query.setParameter("login", usuario.getLogin());
			}
			
			if (HasValue.execute(usuario.getEmail())){
				query.setParameter("email", "%" + usuario.getEmail().toUpperCase() + "%");	
			}
			
			if (HasValue.execute(usuario.getGrupo())){
				query.setParameter("grupo", usuario.getGrupo().getId());
			}
			
			if (HasValue.execute(usuario.getAtivo())){
				query.setParameter("ativo", usuario.getAtivo());		
			}
			
			
		}

		return query.getResultList();
	}

	public Usuario buscaPor(String login, String senha)
	{
		try 
		{
//			return entityManager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha and u.ativo =:ativo", Usuario.class).setParameter("login", login).setParameter("senha", senha).setParameter("ativo", EnumAtivo.SIM).getSingleResult();
			return entityManager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class).setParameter("login", login).setParameter("senha", senha).getSingleResult();
		}
		catch (NoResultException e) 
		{
			e.printStackTrace();

			return null;
		} 
	}

	@Override
	public Usuario buscarPorCpf(String cpf) throws Exception {

		final StringBuilder sb = new StringBuilder();
		final StringBuilder cond = new StringBuilder();

			cond.append(" and (login = :cpf) ");

		if (cond.length() > 4)
			cond.replace(0, 5, " where ");

		sb.append(" select ");
		sb.append("		usu ");
		sb.append(" from ");
		sb.append(" 	Usuario usu ");
		sb.append(  cond );
		sb.append(" order by ");
		sb.append(" 	usu.nome "); 

		final TypedQuery<Usuario> query = entityManager.createQuery(sb.toString(), Usuario.class);

		
			query.setParameter("cpf", cpf );
		

		return query.getSingleResult();
	}
}