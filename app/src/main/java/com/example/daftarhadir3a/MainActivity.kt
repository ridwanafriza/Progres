    package com.example.daftarhadir3a

    import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
                                                            //mengakses variabel yang sama
            val email: String = intent.getStringExtra(  LoginActivity.KEY_USERNAME) ?: ""

            val textViewWelcomeMessage = findViewById<TextView>(R.id.textViewWelcomeMessage)
            textViewWelcomeMessage.text = "Hello $email"


            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMahasiswa)
            //untuk
            recyclerView.layoutManager = GridLayoutManager(this, 2)

            //untuk filter nama yang awalan A
//            val listMahasiswa :List<Mahasiswa> = getData().filter {
//                it.fullname[0] == 'A'
//            }

            val listMahasiswa :List<Mahasiswa> = getData()
            //higher order func
            recyclerView.adapter = MahasiswaAdapter(
                listMahasiswa,
                onClickItemMahasiswa = { goToProfileActivity(it) },
                onCLickButtonDetail = { mahasiswa ->
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("fullname", mahasiswa.fullname)
                    intent.putExtra("nim", mahasiswa.nim)
                    intent.putExtra("status", mahasiswa.statusKehadiran.toString())
                    startActivity(intent)
                }
            )
        }

        fun goToProfileActivity(mahasiswa: Mahasiswa) : Unit {

            val explicitIntent = Intent(this, ProfileActivity::class.java)
            explicitIntent.putExtra("fullname: ", mahasiswa.fullname)
            explicitIntent.putExtra("nim", mahasiswa.nim)
            explicitIntent.putExtra("status", mahasiswa.statusKehadiran.toString())

            startActivity(explicitIntent)
//
////        explicit / tersurat
//        val explicitIntent = Intent(
//            this,
//            ProfileActivity::class.java)
//
//        startActivity(explicitIntent)
//
//        Toast.makeText(
//            this,
//            mahasiswa.fullname,
//            Toast.LENGTH_SHORT
//        ).show()
////
////        val implicitIntent = Intent(Intent.ACTION_SEND)
////        implicitIntent.type = "text/plain"
////        implicitIntent.putExtra(Intent.EXTRA_EMAIL, "${mahasiswa.fullName}@gmail.com")
////        implicitIntent.putExtra(Intent.EXTRA_TEXT, "blablabla")
////
////        if (implicitIntent.resolveActivity(packageManager) != null) {
////            startActivity(implicitIntent)
////        }
//
//
//            //////////////////////////////////////////////////////
//
//            //explisit: tersurat karena tujuannya jelas
////            val explicitIntent = Intent(
////                this,
////                ProfileActivity::class.java
////            )
////
////            //inten kecil itu berarti sudah default bawaannya beda dengan intent dengan penulisan dengan huruf depan Besar
////
////            //implicit:
////            val implicitIntent = Intent(Intent.ACTION_SEND)
////            implicitIntent.type = "text/plain"
////            implicitIntent.putExtra(Intent.EXTRA_EMAIL, "${mahasiswa.fullname}@pnm.ac.id")
////            implicitIntent.putExtra(Intent.EXTRA_TEXT, "Selamat Pagi")
////            implicitIntent.putExtra()
////
////            if (implicitIntent.resolveActivity(packageManager)
////                startActivity(implicitIntent)
//
//            val implicitWhatsapp =
//                Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse("https://wa.me/62083873330735"))
//            startActivity(implicitWhatsapp)
        }



        //fungsi untuk get data return valuenya nya list mahasiswa
        fun getData(): List<Mahasiswa> {
            //pakai ini agar bisa nge add, mutabel agar kosong dulu
            val ListMahasiswa = mutableListOf<Mahasiswa>()
            ListMahasiswa.add(Mahasiswa("Arif Syafarian", "243307005", StatusKehadiran.HADIR))
            ListMahasiswa.add(Mahasiswa("Alfian", "243307004", StatusKehadiran.HADIR))
            ListMahasiswa.add(Mahasiswa("Arifin", "243307001", StatusKehadiran.HADIR))
            ListMahasiswa.add(Mahasiswa("Syafarian", "243307002", StatusKehadiran.HADIR))

            return ListMahasiswa
        }

    }

//    hello world