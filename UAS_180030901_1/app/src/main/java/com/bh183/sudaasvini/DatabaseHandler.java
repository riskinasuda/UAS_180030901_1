package com.bh183.sudaasvini;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DatabaseHandler extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME = "db_obatku";
    private final static String TABLE_OBAT = "t_obat";
    private final static String KEY_ID_OBAT = "ID_obat";
    private final static String KEY_NAMA_OBAT = "Nama";
    private final static String KEY_TGL_KADALUARSA = "Kadaluarsa";
    private final static String KEY_GAMBAR = "Gambar";
    private final static String KEY_EFEK = "Efek";
    private final static String KEY_HARGA = "Harga";
    private final static String KEY_KOMPOSISI = "Komposisi";
    private SimpleDateFormat sdFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    DatabaseHandler(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_BERITA = "CREATE TABLE " + TABLE_OBAT
                + "(" + KEY_ID_OBAT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAMA_OBAT + " TEXT, " + KEY_TGL_KADALUARSA + " DATE, "
                + KEY_GAMBAR + " TEXT, " + KEY_EFEK + " TEXT, "
                + KEY_HARGA + " VARCHAR, " + KEY_KOMPOSISI +" TEXT " + ")";

        db.execSQL(CREATE_TABLE_BERITA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_OBAT;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    void tambahObat(Obat dataObat) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_NAMA_OBAT, dataObat.getNamaObat());
        cv.put(KEY_TGL_KADALUARSA, sdFormat.format(dataObat.getTglKadaluarsa()));
        cv.put(KEY_GAMBAR, dataObat.getGambar());
        cv.put(KEY_EFEK, dataObat.getEfekSamping());
        cv.put(KEY_HARGA, dataObat.getHarga());
        cv.put(KEY_KOMPOSISI, dataObat.getKomposisi());
        db.insert(TABLE_OBAT, null, cv);
        db.close();
    }

    void editObat(Obat dataObat) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_NAMA_OBAT, dataObat.getNamaObat());
        cv.put(KEY_TGL_KADALUARSA, sdFormat.format(dataObat.getTglKadaluarsa()));
        cv.put(KEY_GAMBAR, dataObat.getGambar());
        cv.put(KEY_EFEK, dataObat.getEfekSamping());
        cv.put(KEY_HARGA, dataObat.getHarga());
        cv.put(KEY_KOMPOSISI, dataObat.getKomposisi());
        db.update(TABLE_OBAT, cv,KEY_ID_OBAT + "=?", new String[]{String.valueOf(dataObat.getIdObat())});
        db.close();
    }

    void hapusObat(int idObat) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_OBAT, KEY_ID_OBAT + "=?", new String[]{String.valueOf(idObat)});
        db.close();
    }

    ArrayList<Obat> getAllBerita() {
        ArrayList<Obat> dataObat = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_OBAT;
        SQLiteDatabase db = getReadableDatabase();
        Cursor csr = db.rawQuery(query, null);
        if (csr.moveToFirst()){
            do {
                Date tempDate = new Date();
                try {
                    tempDate = sdFormat.parse(csr.getString(2));
                } catch (ParseException er){
                    er.printStackTrace();
                }

                Obat tempObat = new Obat(
                        csr.getInt(0),
                        csr.getString(1),
                        tempDate,
                        csr.getString(3),
                        csr.getString(4),
                        csr.getString(5),
                        csr.getString(6)

                );

                dataObat.add(tempObat);
            } while (csr.moveToNext());
        }
        return  dataObat;
    }
}
