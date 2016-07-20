package com.softdesign.devintensive.data.storage.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "REPOSITORIES".
*/
public class RepositoryDao extends AbstractDao<Repository, Long> {

    public static final String TABLENAME = "REPOSITORIES";

    /**
     * Properties of entity Repository.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property RemoteId = new Property(1, String.class, "remoteId", false, "REMOTE_ID");
        public final static Property RepositoryName = new Property(2, String.class, "repositoryName", false, "REPOSITORY_NAME");
        public final static Property UserRemoteId = new Property(3, String.class, "userRemoteId", false, "USER_REMOTE_ID");
        public final static Property Photo = new Property(4, String.class, "photo", false, "PHOTO");
        public final static Property FullName = new Property(5, String.class, "fullName", false, "FULL_NAME");
        public final static Property SearchName = new Property(6, String.class, "searchName", false, "SEARCH_NAME");
        public final static Property Rating = new Property(7, int.class, "rating", false, "RATING");
        public final static Property CodeLines = new Property(8, int.class, "codeLines", false, "CODE_LINES");
        public final static Property Projects = new Property(9, int.class, "projects", false, "PROJECTS");
        public final static Property Bio = new Property(10, String.class, "bio", false, "BIO");
    };

    private DaoSession daoSession;

    private Query<Repository> user_RepositoriesQuery;

    public RepositoryDao(DaoConfig config) {
        super(config);
    }
    
    public RepositoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"REPOSITORIES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"REMOTE_ID\" TEXT NOT NULL UNIQUE ," + // 1: remoteId
                "\"REPOSITORY_NAME\" TEXT," + // 2: repositoryName
                "\"USER_REMOTE_ID\" TEXT," + // 3: userRemoteId
                "\"PHOTO\" TEXT," + // 4: photo
                "\"FULL_NAME\" TEXT NOT NULL UNIQUE ," + // 5: fullName
                "\"SEARCH_NAME\" TEXT NOT NULL UNIQUE ," + // 6: searchName
                "\"RATING\" INTEGER NOT NULL ," + // 7: rating
                "\"CODE_LINES\" INTEGER NOT NULL ," + // 8: codeLines
                "\"PROJECTS\" INTEGER NOT NULL ," + // 9: projects
                "\"BIO\" TEXT);"); // 10: bio
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"REPOSITORIES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Repository entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getRemoteId());
 
        String repositoryName = entity.getRepositoryName();
        if (repositoryName != null) {
            stmt.bindString(3, repositoryName);
        }
 
        String userRemoteId = entity.getUserRemoteId();
        if (userRemoteId != null) {
            stmt.bindString(4, userRemoteId);
        }
 
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(5, photo);
        }
        stmt.bindString(6, entity.getFullName());
        stmt.bindString(7, entity.getSearchName());
        stmt.bindLong(8, entity.getRating());
        stmt.bindLong(9, entity.getCodeLines());
        stmt.bindLong(10, entity.getProjects());
 
        String bio = entity.getBio();
        if (bio != null) {
            stmt.bindString(11, bio);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Repository entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getRemoteId());
 
        String repositoryName = entity.getRepositoryName();
        if (repositoryName != null) {
            stmt.bindString(3, repositoryName);
        }
 
        String userRemoteId = entity.getUserRemoteId();
        if (userRemoteId != null) {
            stmt.bindString(4, userRemoteId);
        }
 
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(5, photo);
        }
        stmt.bindString(6, entity.getFullName());
        stmt.bindString(7, entity.getSearchName());
        stmt.bindLong(8, entity.getRating());
        stmt.bindLong(9, entity.getCodeLines());
        stmt.bindLong(10, entity.getProjects());
 
        String bio = entity.getBio();
        if (bio != null) {
            stmt.bindString(11, bio);
        }
    }

    @Override
    protected final void attachEntity(Repository entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Repository readEntity(Cursor cursor, int offset) {
        Repository entity = new Repository( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // remoteId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // repositoryName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userRemoteId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // photo
            cursor.getString(offset + 5), // fullName
            cursor.getString(offset + 6), // searchName
            cursor.getInt(offset + 7), // rating
            cursor.getInt(offset + 8), // codeLines
            cursor.getInt(offset + 9), // projects
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // bio
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Repository entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setRemoteId(cursor.getString(offset + 1));
        entity.setRepositoryName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserRemoteId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhoto(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFullName(cursor.getString(offset + 5));
        entity.setSearchName(cursor.getString(offset + 6));
        entity.setRating(cursor.getInt(offset + 7));
        entity.setCodeLines(cursor.getInt(offset + 8));
        entity.setProjects(cursor.getInt(offset + 9));
        entity.setBio(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Repository entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Repository entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "repositories" to-many relationship of User. */
    public List<Repository> _queryUser_Repositories(String userRemoteId) {
        synchronized (this) {
            if (user_RepositoriesQuery == null) {
                QueryBuilder<Repository> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UserRemoteId.eq(null));
                user_RepositoriesQuery = queryBuilder.build();
            }
        }
        Query<Repository> query = user_RepositoriesQuery.forCurrentThread();
        query.setParameter(0, userRemoteId);
        return query.list();
    }

}