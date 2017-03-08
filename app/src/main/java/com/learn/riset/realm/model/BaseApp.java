package com.learn.riset.realm.model;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Riset on 08/03/2017.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration configuration = new RealmConfiguration.Builder(this)
                .schemaVersion(0)
                .migration(new DataMigration())
                .build();
    }

    private class DataMigration implements RealmMigration {

        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
            RealmSchema schema = realm.getSchema();
                schema.create("siswa")
                        .addField("id", int.class)
                        .addField("nama", String.class)
                        .addField("alamat", String.class);
                oldVersion++;
        }
    }
}
