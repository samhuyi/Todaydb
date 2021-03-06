package dao;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table "DATE".
 */
public class date {

    private Long id;
    private String frequency;
    private Integer longest;
    private Long dateId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient dateDao myDao;

    private habbit habbit;
    private Long habbit__resolvedKey;


    public date() {
    }

    public date(Long id) {
        this.id = id;
    }

    public date(Long id, String frequency, Integer longest, Long dateId) {
        this.id = id;
        this.frequency = frequency;
        this.longest = longest;
        this.dateId = dateId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDateDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getLongest() {
        return longest;
    }

    public void setLongest(Integer longest) {
        this.longest = longest;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    /** To-one relationship, resolved on first access. */
    public habbit getHabbit() {
        Long __key = this.dateId;
        if (habbit__resolvedKey == null || !habbit__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            habbitDao targetDao = daoSession.getHabbitDao();
            habbit habbitNew = targetDao.load(__key);
            synchronized (this) {
                habbit = habbitNew;
            	habbit__resolvedKey = __key;
            }
        }
        return habbit;
    }

    public void setHabbit(habbit habbit) {
        synchronized (this) {
            this.habbit = habbit;
            dateId = habbit == null ? null : habbit.getId();
            habbit__resolvedKey = dateId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
