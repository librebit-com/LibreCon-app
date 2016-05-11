package librecon;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import librecon.LastModified;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table LAST_MODIFIED.
*/
public class LastModifiedDao extends AbstractDao<LastModified, Long> {

    public static final String TABLENAME = "LAST_MODIFIED";

    /**
     * Properties of entity LastModified.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Assistants = new Property(1, String.class, "assistants", false, "ASSISTANTS");
        public final static Property Expositors = new Property(2, String.class, "expositors", false, "EXPOSITORS");
        public final static Property Schedules = new Property(3, String.class, "schedules", false, "SCHEDULES");
        public final static Property Meetings = new Property(4, String.class, "meetings", false, "MEETINGS");
        public final static Property Txokos = new Property(5, String.class, "txokos", false, "TXOKOS");
        public final static Property Sponsors = new Property(6, String.class, "sponsors", false, "SPONSORS");
    }


    public LastModifiedDao(DaoConfig config) {
        super(config);
    }
    
    public LastModifiedDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LAST_MODIFIED' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'ASSISTANTS' TEXT," + // 1: assistants
                "'EXPOSITORS' TEXT," + // 2: expositors
                "'SCHEDULES' TEXT," + // 3: schedules
                "'MEETINGS' TEXT," + // 4: meetings
                "'TXOKOS' TEXT," + // 5: txokos
                "'SPONSORS' TEXT);"); // 6: sponsors
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LAST_MODIFIED'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, LastModified entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String assistants = entity.getAssistants();
        if (assistants != null) {
            stmt.bindString(2, assistants);
        }
 
        String expositors = entity.getExpositors();
        if (expositors != null) {
            stmt.bindString(3, expositors);
        }
 
        String schedules = entity.getSchedules();
        if (schedules != null) {
            stmt.bindString(4, schedules);
        }
 
        String meetings = entity.getMeetings();
        if (meetings != null) {
            stmt.bindString(5, meetings);
        }
 
        String txokos = entity.getTxokos();
        if (txokos != null) {
            stmt.bindString(6, txokos);
        }
 
        String sponsors = entity.getSponsors();
        if (sponsors != null) {
            stmt.bindString(7, sponsors);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset) ? null : cursor.getLong(offset);
    }    

    /** @inheritdoc */
    @Override
    public LastModified readEntity(Cursor cursor, int offset) {
        return new LastModified( //
            cursor.isNull(offset) ? null : cursor.getLong(offset), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // assistants
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // expositors
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // schedules
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // meetings
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // txokos
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // sponsors
        );
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, LastModified entity, int offset) {
        entity.setId(cursor.isNull(offset) ? null : cursor.getLong(offset));
        entity.setAssistants(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setExpositors(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSchedules(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMeetings(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTxokos(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSponsors(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(LastModified entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(LastModified entity) {
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
    
}