package com.henrique.shared.data.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.henrique.shared.data.database.entity.BreweryEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BreweryDao_Impl implements BreweryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BreweryEntity> __insertionAdapterOfBreweryEntity;

  public BreweryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBreweryEntity = new EntityInsertionAdapter<BreweryEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `breweries` (`id`,`name`,`brewery_type`,`street`,`address_2`,`address_3`,`city`,`state`,`county_province`,`postal_code`,`country`,`longitude`,`latitude`,`phone`,`website_url`,`updated_at`,`created_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BreweryEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getBreweryType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBreweryType());
        }
        if (value.getStreet() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStreet());
        }
        if (value.getAddress2() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddress2());
        }
        if (value.getAddress3() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAddress3());
        }
        if (value.getCity() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getState());
        }
        if (value.getCountyProvince() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCountyProvince());
        }
        if (value.getPostalCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPostalCode());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCountry());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLongitude());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLatitude());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPhone());
        }
        if (value.getWebsiteUrl() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getWebsiteUrl());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getUpdatedAt());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getCreatedAt());
        }
      }
    };
  }

  @Override
  public Object insertBreweryList(final List<BreweryEntity> breweryList,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBreweryEntity.insert(breweryList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getBreweryList(final Continuation<? super List<BreweryEntity>> p0) {
    final String _sql = "SELECT * FROM breweries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<BreweryEntity>>() {
      @Override
      public List<BreweryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBreweryType = CursorUtil.getColumnIndexOrThrow(_cursor, "brewery_type");
          final int _cursorIndexOfStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "street");
          final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "address_2");
          final int _cursorIndexOfAddress3 = CursorUtil.getColumnIndexOrThrow(_cursor, "address_3");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCountyProvince = CursorUtil.getColumnIndexOrThrow(_cursor, "county_province");
          final int _cursorIndexOfPostalCode = CursorUtil.getColumnIndexOrThrow(_cursor, "postal_code");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfWebsiteUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "website_url");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final List<BreweryEntity> _result = new ArrayList<BreweryEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BreweryEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpBreweryType;
            if (_cursor.isNull(_cursorIndexOfBreweryType)) {
              _tmpBreweryType = null;
            } else {
              _tmpBreweryType = _cursor.getString(_cursorIndexOfBreweryType);
            }
            final String _tmpStreet;
            if (_cursor.isNull(_cursorIndexOfStreet)) {
              _tmpStreet = null;
            } else {
              _tmpStreet = _cursor.getString(_cursorIndexOfStreet);
            }
            final String _tmpAddress2;
            if (_cursor.isNull(_cursorIndexOfAddress2)) {
              _tmpAddress2 = null;
            } else {
              _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
            }
            final String _tmpAddress3;
            if (_cursor.isNull(_cursorIndexOfAddress3)) {
              _tmpAddress3 = null;
            } else {
              _tmpAddress3 = _cursor.getString(_cursorIndexOfAddress3);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCountyProvince;
            if (_cursor.isNull(_cursorIndexOfCountyProvince)) {
              _tmpCountyProvince = null;
            } else {
              _tmpCountyProvince = _cursor.getString(_cursorIndexOfCountyProvince);
            }
            final String _tmpPostalCode;
            if (_cursor.isNull(_cursorIndexOfPostalCode)) {
              _tmpPostalCode = null;
            } else {
              _tmpPostalCode = _cursor.getString(_cursorIndexOfPostalCode);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getString(_cursorIndexOfLongitude);
            }
            final String _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpWebsiteUrl;
            if (_cursor.isNull(_cursorIndexOfWebsiteUrl)) {
              _tmpWebsiteUrl = null;
            } else {
              _tmpWebsiteUrl = _cursor.getString(_cursorIndexOfWebsiteUrl);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new BreweryEntity(_tmpId,_tmpName,_tmpBreweryType,_tmpStreet,_tmpAddress2,_tmpAddress3,_tmpCity,_tmpState,_tmpCountyProvince,_tmpPostalCode,_tmpCountry,_tmpLongitude,_tmpLatitude,_tmpPhone,_tmpWebsiteUrl,_tmpUpdatedAt,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getBreweryById(final String id, final Continuation<? super BreweryEntity> p1) {
    final String _sql = "SELECT * FROM breweries WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<BreweryEntity>() {
      @Override
      public BreweryEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBreweryType = CursorUtil.getColumnIndexOrThrow(_cursor, "brewery_type");
          final int _cursorIndexOfStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "street");
          final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "address_2");
          final int _cursorIndexOfAddress3 = CursorUtil.getColumnIndexOrThrow(_cursor, "address_3");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCountyProvince = CursorUtil.getColumnIndexOrThrow(_cursor, "county_province");
          final int _cursorIndexOfPostalCode = CursorUtil.getColumnIndexOrThrow(_cursor, "postal_code");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfWebsiteUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "website_url");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final BreweryEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpBreweryType;
            if (_cursor.isNull(_cursorIndexOfBreweryType)) {
              _tmpBreweryType = null;
            } else {
              _tmpBreweryType = _cursor.getString(_cursorIndexOfBreweryType);
            }
            final String _tmpStreet;
            if (_cursor.isNull(_cursorIndexOfStreet)) {
              _tmpStreet = null;
            } else {
              _tmpStreet = _cursor.getString(_cursorIndexOfStreet);
            }
            final String _tmpAddress2;
            if (_cursor.isNull(_cursorIndexOfAddress2)) {
              _tmpAddress2 = null;
            } else {
              _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
            }
            final String _tmpAddress3;
            if (_cursor.isNull(_cursorIndexOfAddress3)) {
              _tmpAddress3 = null;
            } else {
              _tmpAddress3 = _cursor.getString(_cursorIndexOfAddress3);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCountyProvince;
            if (_cursor.isNull(_cursorIndexOfCountyProvince)) {
              _tmpCountyProvince = null;
            } else {
              _tmpCountyProvince = _cursor.getString(_cursorIndexOfCountyProvince);
            }
            final String _tmpPostalCode;
            if (_cursor.isNull(_cursorIndexOfPostalCode)) {
              _tmpPostalCode = null;
            } else {
              _tmpPostalCode = _cursor.getString(_cursorIndexOfPostalCode);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getString(_cursorIndexOfLongitude);
            }
            final String _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpWebsiteUrl;
            if (_cursor.isNull(_cursorIndexOfWebsiteUrl)) {
              _tmpWebsiteUrl = null;
            } else {
              _tmpWebsiteUrl = _cursor.getString(_cursorIndexOfWebsiteUrl);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _result = new BreweryEntity(_tmpId,_tmpName,_tmpBreweryType,_tmpStreet,_tmpAddress2,_tmpAddress3,_tmpCity,_tmpState,_tmpCountyProvince,_tmpPostalCode,_tmpCountry,_tmpLongitude,_tmpLatitude,_tmpPhone,_tmpWebsiteUrl,_tmpUpdatedAt,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
