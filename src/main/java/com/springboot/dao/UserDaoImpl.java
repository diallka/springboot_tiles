package com.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springboot.model.User;

@Repository
//On definit la classe comme Repo
public class UserDaoImpl implements UserDao {

    //@Autowired
    private SqlSession m_SqlSession;

    @Override
    public List< User > findAll() {
        final List< User > utilisateurs = this.m_SqlSession.selectList( "login-mapper.listerUtilisateurs" );
        return utilisateurs;
    }

    @Override
    public User findOne( final Integer id ) {
        final User u = this.m_SqlSession.selectOne( "login-mapper.recupererUtilisateur", id );
        return u;
    }

    @Override
    public void update( final User util ) {
        this.m_SqlSession.update( "login-mapper.modifierUtilisateur", util );

    }

    @Override
    public void delete( final Integer id ) {
        this.m_SqlSession.delete( "login-mapper.supprimerUtilisateur", id );

    }

    @Override
    public void insert( final User u ) {
        this.m_SqlSession.insert( "login-mapper.inserrerUtilisateur", u );

    }

}
