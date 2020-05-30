package com.bh183.sudaasvini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TampilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        ImageView imgObat = findViewById(R.id.iv_obat);
        TextView tvNama = findViewById(R.id.tv_nama_obat);
        TextView tvTanggal = findViewById(R.id.tv_tanggal_kadaluarsa);
        TextView tvEfek = findViewById(R.id.tv_efek);
        TextView tvHarga = findViewById(R.id.tv_harga);
        TextView tvKomposisi = findViewById(R.id.tv_komposisi);

        Intent terimaData = getIntent();
        tvNama.setText(terimaData.getStringExtra("NAMA"));
        tvTanggal.setText(terimaData.getStringExtra("TANGGAL"));
        tvEfek.setText(terimaData.getStringExtra("EFEK"));
        tvHarga.setText(terimaData.getStringExtra("HARGA"));
        tvKomposisi.setText(terimaData.getStringExtra("KOMPOSISI"));
        String imgLocation = terimaData.getStringExtra("GAMBAR");

        try {
            assert imgLocation != null;
            File file = new File(imgLocation);
            Bitmap bitmap =  BitmapFactory.decodeStream((new FileInputStream(file)));
            imgObat.setImageBitmap(bitmap);
            imgObat.setContentDescription(imgLocation);
        } catch (FileNotFoundException er) {
            er.printStackTrace();
            Toast.makeText(this, "Gagal mengambil gambar dari media penyimpanan", Toast.LENGTH_SHORT).show();
        }
    }
}
