package com.henrique.shared.data.database.configuration;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.henrique.shared.data.database.dao.BreweryDao;
import com.henrique.shared.data.database.dao.BreweryDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile BreweryDao _breweryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `breweries` (`id` TEXT NOT NULL, `name` TEXT, `brewery_type` TEXT, `street` TEXT, `address_2` TEXT, `address_3` TEXT, `city` TEXT, `state` TEXT, `county_province` TEXT, `postal_code` TEXT, `country` TEXT, `longitude` TEXT, `latitude` TEXT, `phone` TEXT, `website_url` TEXT, `updated_at` TEXT, `created_at` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '97f18b7c7c9d550b234cf3cc97baa5be')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `breweries`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBreweries = new HashMap<String, TableInfo.Column>(17);
        _columnsBreweries.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("brewery_type", new TableInfo.Column("brewery_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("street", new TableInfo.Column("street", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("address_2", new TableInfo.Column("address_2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("address_3", new TableInfo.Column("address_3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("city", new TableInfo.Column("city", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("state", new TableInfo.Column("state", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("county_province", new TableInfo.Column("county_province", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("postal_code", new TableInfo.Column("postal_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("longitude", new TableInfo.Column("longitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("latitude", new TableInfo.Column("latitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("website_url", new TableInfo.Column("website_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("updated_at", new TableInfo.Column("updated_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBreweries.put("created_at", new TableInfo.Column("created_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBreweries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBreweries = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBreweries = new TableInfo("breweries", _columnsBreweries, _foreignKeysBreweries, _indicesBreweries);
        final TableInfo _existingBreweries = TableInfo.read(_db, "breweries");
        if (! _infoBreweries.equals(_existingBreweries)) {
          return new RoomOpenHelper.ValidationResult(false, "breweries(com.henrique.shared.data.database.entity.BreweryEntity).\n"
                  + " Expected:\n" + _infoBreweries + "\n"
                  + " Found:\n" + _existingBreweries);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "97f18b7c7c9d550b234cf3cc97baa5be", "9c77364aebd941181d2ec8d2bbbfba77");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "breweries");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `breweries`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(BreweryDao.class, BreweryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public BreweryDao breweryDao() {
    if (_breweryDao != null) {
      return _breweryDao;
    } else {
      synchronized(this) {
        if(_breweryDao == null) {
          _breweryDao = new BreweryDao_Impl(this);
        }
        return _breweryDao;
      }
    }
  }
}
