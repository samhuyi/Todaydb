package dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig achievementDaoConfig;
    private final DaoConfig habbitDaoConfig;
    private final DaoConfig signedDaysDaoConfig;
    private final DaoConfig dateDaoConfig;

    private final userDao userDao;
    private final achievementDao achievementDao;
    private final habbitDao habbitDao;
    private final signedDaysDao signedDaysDao;
    private final dateDao dateDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(userDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        achievementDaoConfig = daoConfigMap.get(achievementDao.class).clone();
        achievementDaoConfig.initIdentityScope(type);

        habbitDaoConfig = daoConfigMap.get(habbitDao.class).clone();
        habbitDaoConfig.initIdentityScope(type);

        signedDaysDaoConfig = daoConfigMap.get(signedDaysDao.class).clone();
        signedDaysDaoConfig.initIdentityScope(type);

        dateDaoConfig = daoConfigMap.get(dateDao.class).clone();
        dateDaoConfig.initIdentityScope(type);

        userDao = new userDao(userDaoConfig, this);
        achievementDao = new achievementDao(achievementDaoConfig, this);
        habbitDao = new habbitDao(habbitDaoConfig, this);
        signedDaysDao = new signedDaysDao(signedDaysDaoConfig, this);
        dateDao = new dateDao(dateDaoConfig, this);

        registerDao(user.class, userDao);
        registerDao(achievement.class, achievementDao);
        registerDao(habbit.class, habbitDao);
        registerDao(signedDays.class, signedDaysDao);
        registerDao(date.class, dateDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        achievementDaoConfig.getIdentityScope().clear();
        habbitDaoConfig.getIdentityScope().clear();
        signedDaysDaoConfig.getIdentityScope().clear();
        dateDaoConfig.getIdentityScope().clear();
    }

    public userDao getUserDao() {
        return userDao;
    }

    public achievementDao getAchievementDao() {
        return achievementDao;
    }

    public habbitDao getHabbitDao() {
        return habbitDao;
    }

    public signedDaysDao getSignedDaysDao() {
        return signedDaysDao;
    }

    public dateDao getDateDao() {
        return dateDao;
    }

}