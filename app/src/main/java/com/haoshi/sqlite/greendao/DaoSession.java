package com.haoshi.sqlite.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.haoshi.sqlite.greendao.Personnel;

import com.haoshi.sqlite.greendao.PersonnelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personnelDaoConfig;

    private final PersonnelDao personnelDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personnelDaoConfig = daoConfigMap.get(PersonnelDao.class).clone();
        personnelDaoConfig.initIdentityScope(type);

        personnelDao = new PersonnelDao(personnelDaoConfig, this);

        registerDao(Personnel.class, personnelDao);
    }
    
    public void clear() {
        personnelDaoConfig.clearIdentityScope();
    }

    public PersonnelDao getPersonnelDao() {
        return personnelDao;
    }

}
