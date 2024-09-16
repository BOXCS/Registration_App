package com.zaky.thestudent;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText namaLengkap, nim, email, tglLahir, alamat, noHp, username, password;
    private Spinner genderSpinner;
    private Button registerButton;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi semua input
        namaLengkap = findViewById(R.id.input_nama_lengkap);
        nim = findViewById(R.id.input_nim);
        email = findViewById(R.id.input_email);
        tglLahir = findViewById(R.id.input_tanggal_lahir);
        genderSpinner = findViewById(R.id.input_gender);
        alamat = findViewById(R.id.input_alamat);
        noHp = findViewById(R.id.input_no_hp);
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        registerButton = findViewById(R.id.button_register);

        // Inisialisasi Calendar untuk DatePicker
        calendar = Calendar.getInstance();

        // Menampilkan DatePickerDialog saat EditText Tanggal Lahir di-klik
        tglLahir.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view, year1, monthOfYear, dayOfMonth) -> {
                        String date = year1 + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        tglLahir.setText(date);
                    }, year, month, day);
            datePickerDialog.show();
        });

        // Set Gender Spinner (Dropdown)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        // Button Register OnClickListener
        registerButton.setOnClickListener(v -> {
            // Mengambil nilai dari inputan
            String nama = namaLengkap.getText().toString();
            String nimVal = nim.getText().toString();
            String emailVal = email.getText().toString();
            String tanggalLahir = tglLahir.getText().toString();
            String gender = genderSpinner.getSelectedItem().toString();
            String alamatVal = alamat.getText().toString();
            String noHpVal = noHp.getText().toString();
            String userName = username.getText().toString();
            String pass = password.getText().toString();

            // Validasi sederhana
            if (nama.isEmpty() || nimVal.isEmpty() || emailVal.isEmpty() || tanggalLahir.isEmpty() ||
                    alamatVal.isEmpty() || noHpVal.isEmpty() || userName.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                // Tampilkan data jika berhasil (dapat disesuaikan untuk disimpan ke database)
                String result = "Nama: " + nama + "\nNIM: " + nimVal + "\nEmail: " + emailVal +
                        "\nTanggal Lahir: " + tanggalLahir + "\nGender: " + gender +
                        "\nAlamat: " + alamatVal + "\nNomor HP: " + noHpVal +
                        "\nUsername: " + userName;

//                String formattedData = "Data:" +
//                        "\nNama: " + nama +
//                        "\nNIM: " + nimVal +
//                        "\nEmail: " + emailVal +
//                        "\nTanggal Lahir: " + tanggalLahir +
//                        "\nGender: " + gender +
//                        "\nUsername: " + userName +
//                        "\nAlamat: " + alamatVal +
//                        "\nNomor HP: " + noHpVal +
//                        "\nUsername: " + userName ;
//
//                Toast.makeText(MainActivity.this, formattedData, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
