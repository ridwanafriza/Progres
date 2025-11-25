package com.example.daftarhadir3a

data class Mahasiswa(
    val fullname: String,
    val nim: String,
    var statusKehadiran: StatusKehadiran,
)

//pakai enum class untuk status kehadiran

//nanti git objeknya atau manggil kehadirannya menggunakan:
// (val budi = Mahasiswa("budi", "123", StatusKehadiran.HADIR))
enum class StatusKehadiran{
    HADIR,
    ALFA,
    SAKIT,
    IZIN
}
