package dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "HABBIT".
*/
public class habbitDao extends AbstractDao<habbit, Long> {

    public static final String TABLENAME = "HABBIT";

    /**
     * Properties of entity habbit.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property HabbitName = new Property(1, String.class, "habbitName", false, "HABBIT_NAME");
        public final static Property IsPrivated = new Property(2, Integer.class, "isPrivated", false, "IS_PRIVATED");
        public final static Property Cover = new Property(3, String.class, "cover", false, "COVER");
        public final static Property HabbitOrder = new Property(4, Integer.class, "habbitOrder", false, "HABBIT_ORDER");
        public final static Property UserId = new Property(5, Long.class, "userId", false, "USER_ID");
        public final static Property HabbitId = new Property(6, Long.class, "habbitId", false, "HABBIT_ID");
    };

    private DaoSession daoSession;

    private Query<habbit> user_HabbitsQuery;

    public habbitDao(DaoConfig config) {
        super(config);
    }
    
    public habbitDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HABBIT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"HABBIT_NAME\" TEXT," + // 1: habbitName
                "\"IS_PRIVATED\" INTEGER," + // 2: isPrivated
                "\"COVER\" TEXT," + // 3: cover
                "\"HABBIT_ORDER\" INTEGER," + // 4: habbitOrder
                "\"USER_ID\" INTEGER," + // 5: userId
                "\"HABBIT_ID\" INTEGER);"); // 6: habbitId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HABBIT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, habbit entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String habbitName = entity.getHabbitName();
        if (habbitName != null) {
            stmt.bindString(2, habbitName);
        }
 
        Integer isPrivated = entity.getIsPrivated();
        if (isPrivated != null) {
            stmt.bindLong(3, isPrivated);
        }
 
        String cover = entity.getCover();
        if (cover != null) {
            stmt.bindString(4, cover);
        }
 
        Integer habbitOrder = entity.getHabbitOrder();
        if (habbitOrder != null) {
            stmt.bindLong(5, habbitOrder);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(6, userId);
        }
 
        Long habbitId = entity.getHabbitId();
        if (habbitId != null) {
            stmt.bindLong(7, habbitId);
        }
    }

    @Override
    protected void attachEntity(habbit entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public habbit readEntity(Cursor cursor, int offset) {
        habbit entity = new habbit( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // habbitName
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // isPrivated
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // cover
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // habbitOrder
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // userId
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6) // habbitId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, habbit entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setHabbitName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIsPrivated(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setCover(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setHabbitOrder(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setUserId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setHabbitId(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(habbit entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(habbit entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "habbits" to-many relationship of user. */
    public List<habbit> _queryUser_Habbits(Long userId) {
        synchronized (this) {
            if (user_HabbitsQuery == null) {
                QueryBuilder<habbit> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UserId.eq(null));
                user_HabbitsQuery = queryBuilder.build();
            }
        }
        Query<habbit> query = user_HabbitsQuery.forCurrentThread();
        query.setParameter(0, userId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getDateDao().getAllColumns());
            builder.append(" FROM HABBIT T");
            builder.append(" LEFT JOIN USER T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN DATE T1 ON T.\"HABBIT_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected habbit loadCurrentDeep(Cursor cursor, boolean lock) {
        habbit entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        user user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);
        offset += daoSession.getUserDao().getAllColumns().length;

        date date = loadCurrentOther(daoSession.getDateDao(), cursor, offset);
        entity.setDate(date);

        return entity;    
    }

    public habbit loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<habbit> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<habbit> list = new ArrayList<habbit>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<habbit> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<habbit> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
