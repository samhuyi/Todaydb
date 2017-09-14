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
 * DAO for table "SIGNED_DAYS".
*/
public class signedDaysDao extends AbstractDao<signedDays, Long> {

    public static final String TABLENAME = "SIGNED_DAYS";

    /**
     * Properties of entity signedDays.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Day = new Property(1, java.util.Date.class, "day", false, "DAY");
        public final static Property HabbitId = new Property(2, Long.class, "habbitId", false, "HABBIT_ID");
    };

    private DaoSession daoSession;

    private Query<signedDays> habbit_SignedDaysQuery;

    public signedDaysDao(DaoConfig config) {
        super(config);
    }
    
    public signedDaysDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SIGNED_DAYS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"DAY\" INTEGER," + // 1: day
                "\"HABBIT_ID\" INTEGER);"); // 2: habbitId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SIGNED_DAYS\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, signedDays entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date day = entity.getDay();
        if (day != null) {
            stmt.bindLong(2, day.getTime());
        }
 
        Long habbitId = entity.getHabbitId();
        if (habbitId != null) {
            stmt.bindLong(3, habbitId);
        }
    }

    @Override
    protected void attachEntity(signedDays entity) {
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
    public signedDays readEntity(Cursor cursor, int offset) {
        signedDays entity = new signedDays( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // day
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // habbitId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, signedDays entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDay(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setHabbitId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(signedDays entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(signedDays entity) {
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
    
    /** Internal query to resolve the "signedDays" to-many relationship of habbit. */
    public List<signedDays> _queryHabbit_SignedDays(Long habbitId) {
        synchronized (this) {
            if (habbit_SignedDaysQuery == null) {
                QueryBuilder<signedDays> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.HabbitId.eq(null));
                habbit_SignedDaysQuery = queryBuilder.build();
            }
        }
        Query<signedDays> query = habbit_SignedDaysQuery.forCurrentThread();
        query.setParameter(0, habbitId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getHabbitDao().getAllColumns());
            builder.append(" FROM SIGNED_DAYS T");
            builder.append(" LEFT JOIN HABBIT T0 ON T.\"HABBIT_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected signedDays loadCurrentDeep(Cursor cursor, boolean lock) {
        signedDays entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        habbit habbit = loadCurrentOther(daoSession.getHabbitDao(), cursor, offset);
        entity.setHabbit(habbit);

        return entity;    
    }

    public signedDays loadDeep(Long key) {
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
    public List<signedDays> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<signedDays> list = new ArrayList<signedDays>(count);
        
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
    
    protected List<signedDays> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<signedDays> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}