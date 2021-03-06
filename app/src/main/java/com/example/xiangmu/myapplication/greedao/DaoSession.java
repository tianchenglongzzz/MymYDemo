package com.example.xiangmu.myapplication.greedao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.xiangmu.myapplication.greendao.dataBean;
import com.example.xiangmu.myapplication.greendao.ScBean;

import com.example.xiangmu.myapplication.greedao.dataBeanDao;
import com.example.xiangmu.myapplication.greedao.ScBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dataBeanDaoConfig;
    private final DaoConfig scBeanDaoConfig;

    private final dataBeanDao dataBeanDao;
    private final ScBeanDao scBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dataBeanDaoConfig = daoConfigMap.get(dataBeanDao.class).clone();
        dataBeanDaoConfig.initIdentityScope(type);

        scBeanDaoConfig = daoConfigMap.get(ScBeanDao.class).clone();
        scBeanDaoConfig.initIdentityScope(type);

        dataBeanDao = new dataBeanDao(dataBeanDaoConfig, this);
        scBeanDao = new ScBeanDao(scBeanDaoConfig, this);

        registerDao(dataBean.class, dataBeanDao);
        registerDao(ScBean.class, scBeanDao);
    }
    
    public void clear() {
        dataBeanDaoConfig.clearIdentityScope();
        scBeanDaoConfig.clearIdentityScope();
    }

    public dataBeanDao getDataBeanDao() {
        return dataBeanDao;
    }

    public ScBeanDao getScBeanDao() {
        return scBeanDao;
    }

}
