package com.henrique.shared.data.database.configuration;

import java.lang.System;

@androidx.room.Database(entities = {com.henrique.shared.data.database.entity.BreweryEntity.class}, version = 3, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/henrique/shared/data/database/configuration/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "breweryDao", "Lcom/henrique/shared/data/database/dao/BreweryDao;", "Companion", "shared_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    public static final int VERSION = 3;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILE_NAME = "brewery.db";
    @org.jetbrains.annotations.NotNull()
    public static final com.henrique.shared.data.database.configuration.AppDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.henrique.shared.data.database.dao.BreweryDao breweryDao();
    
    public AppDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/henrique/shared/data/database/configuration/AppDatabase$Companion;", "", "()V", "FILE_NAME", "", "VERSION", "", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}