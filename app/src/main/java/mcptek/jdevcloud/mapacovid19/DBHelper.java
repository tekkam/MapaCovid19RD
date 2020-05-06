package mcptek.jdevcloud.mapacovid19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("drop table if exists Casos;");

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS Casos \n" +
                        "(\n" +
                        "	[IdCaso] integer primary key autoincrement not null\n" +
                        "	, [Provincia] varchar(50) unique not null\n" +
                        "	, [TotalProvincial] integer default(0) not null\n" +
                        "	, [lat] numeric(10,8) not null\n" +
                        "	, [lng] numeric(18,15) not null\n" +
                        ");"
        );

        db.execSQL(
                "INSERT INTO Casos VALUES\n" +
                        "(1,'Azua',82,18.46,-70.74000000000001),\n"+
                        "(2,'Bahoruco',5,18.4752899,-71.33493220000003),\n"+
                        "(3,'Barahona',41,18.2,-71.10000000000002),\n"+
                        "(4,'Dajabón',4,19.5499241,-71.70865140000001),\n"+
                        "(5,'Distrito Nacional',1932,18.466667,-69.94999999999999),\n"+
                        "(6,'Duarte',643,19.260,-70.000),\n"+
                        "(7,'El Seibo',10,18.763,-69.04200000000003),\n"+
                        "(8,'Elias Piña',5,19.0524685,-71.61986860000002),\n"+
                        "(9,'Espaillat',249,19.5788064,-70.3598758),\n"+
                        "(10,'Hato Mayor',13,18.766667,-69.25),\n"+
                        "(11,'Hermanas Mirabal',198,19.3966586,-70.3598758),\n"+
                        "(12,'Independencia',1,18.4126807,-71.61986860000002),\n"+
                        "(13,'La Altagracia',129,18.5850236,-68.6201072),\n"+
                        "(14,'La Romana',186,18.43,-68.97000000000003),\n"+
                        "(15,'La Vega',538,19.22,-70.52999999999997),\n"+
                        "(16,'Maria Trinidad Sanchez',104,19.4245445,-70.00267559999998),\n"+
                        "(17,'Monseñor Nouel',201,18.9215234,-70.38368149999997),\n"+
                        "(18,'Monte Cristi',18,19.7647958,-71.42993639999997),\n"+
                        "(19,'Monte Plata',20,18.81,-69.78999999999996),\n"+
                        "(20,'Pedernales',3,18.033333,-71.75),\n"+
                        "(21,'Peravia',56,18.2855033,-70.38368149999997),\n"+
                        "(22,'Puerto Plata',239,19.7807686,-70.68710909999999),\n"+
                        "(23,'Samana',25,19.2080704,-69.3324518),\n"+
                        "(24,'San Cristobal',270,18.416667,-70.133333),\n"+
                        "(25,'San Jose de Ocoa',9,18.55,-70.5),\n"+
                        "(26,'San Juan',79,18.8810919,-71.28742090000003),\n"+
                        "(27,'San Pedro de Macoris',78,18.45,-69.30000000000001),\n"+
                        "(28,'Sánchez Ram¡rez',191,18.9808932,-70.0979491),\n"+
                        "(29,'Santiago de los Caballeros',916,19.466667,-70.69999999999999),\n"+
                        "(30,'Santiago Rodr¡guez',33,19.471979,-71.341339),\n"+
                        "(31,'Santo Domingo',1638,18.466667,-69.949999),\n"+
                        "(32,'Valverde',38,19.6323442,-71.04977680000002);\n"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
