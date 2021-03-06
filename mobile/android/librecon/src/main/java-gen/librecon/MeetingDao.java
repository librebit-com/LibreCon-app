package librecon;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import librecon.Meeting;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MEETING.
*/
public class MeetingDao extends AbstractDao<Meeting, Long> {

    public static final String TABLENAME = "MEETING";

    /**
     * Properties of entity Meeting.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property SendedByMe = new Property(1, Boolean.class, "sendedByMe", false, "SENDED_BY_ME");
        public final static Property CreatedAt = new Property(2, String.class, "createdAt", false, "CREATED_AT");
        public final static Property Status = new Property(3, Integer.class, "status", false, "STATUS");
        public final static Property EmailShare = new Property(4, Boolean.class, "emailShare", false, "EMAIL_SHARE");
        public final static Property CellphoneShare = new Property(5, Boolean.class, "cellphoneShare", false, "CELLPHONE_SHARE");
        public final static Property Moment = new Property(6, String.class, "moment", false, "MOMENT");
        public final static Property ResponseDate = new Property(7, String.class, "responseDate", false, "RESPONSE_DATE");
    }


    public MeetingDao(DaoConfig config) {
        super(config);
    }
    
    public MeetingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MEETING' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'SENDED_BY_ME' INTEGER," + // 1: sendedByMe
                "'CREATED_AT' TEXT," + // 2: createdAt
                "'STATUS' INTEGER," + // 3: status
                "'EMAIL_SHARE' INTEGER," + // 4: emailShare
                "'CELLPHONE_SHARE' INTEGER," + // 5: cellphoneShare
                "'MOMENT' TEXT," + // 6: moment
                "'RESPONSE_DATE' TEXT);"); // 7: responseDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MEETING'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Meeting entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Boolean sendedByMe = entity.getSendedByMe();
        if (sendedByMe != null) {
            stmt.bindLong(2, sendedByMe ? 1l: 0l);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(3, createdAt);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(4, status);
        }
 
        Boolean emailShare = entity.getEmailShare();
        if (emailShare != null) {
            stmt.bindLong(5, emailShare ? 1l: 0l);
        }
 
        Boolean cellphoneShare = entity.getCellphoneShare();
        if (cellphoneShare != null) {
            stmt.bindLong(6, cellphoneShare ? 1l: 0l);
        }
 
        String moment = entity.getMoment();
        if (moment != null) {
            stmt.bindString(7, moment);
        }
 
        String responseDate = entity.getResponseDate();
        if (responseDate != null) {
            stmt.bindString(8, responseDate);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset) ? null : cursor.getLong(offset);
    }    

    /** @inheritdoc */
    @Override
    public Meeting readEntity(Cursor cursor, int offset) {
        return new Meeting( //
            cursor.isNull(offset) ? null : cursor.getLong(offset), // id
            cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0, // sendedByMe
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // createdAt
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // status
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // emailShare
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // cellphoneShare
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // moment
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // responseDate
        );
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Meeting entity, int offset) {
        entity.setId(cursor.isNull(offset) ? null : cursor.getLong(offset));
        entity.setSendedByMe(cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0);
        entity.setCreatedAt(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStatus(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setEmailShare(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setCellphoneShare(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setMoment(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setResponseDate(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Meeting entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Meeting entity) {
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
