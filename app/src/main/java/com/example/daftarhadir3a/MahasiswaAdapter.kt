    package com.example.daftarhadir3a

    import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class MahasiswaAdapter (
        val list_mahasiswa: List<Mahasiswa>,
        val onClickItemMahasiswa: (Mahasiswa) -> Unit,
        val onCLickButtonDetail: (Mahasiswa) -> Unit
    ):
        RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): MahasiswaViewHolder {
                val layout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mahasiswa_copy, parent, false)

                return MahasiswaViewHolder(layout)
            }


        //proses mapping, data yang ada
        override fun onBindViewHolder(
            holder: MahasiswaViewHolder,
            //parameter untuk melakukan iterasi 0,1-12
            position: Int
        ) {
            //ini boleh pakai get boleh pakai position
            val mahasiswa: Mahasiswa = list_mahasiswa.get(position) //untuk mendapatkan mahasiswa di list posisi berapa

            holder.row.setOnClickListener {
                onClickItemMahasiswa(mahasiswa)
            }
            holder.textViewName.text = mahasiswa.fullname
            holder.textViewNIM.text = mahasiswa.nim
            //status kita konversi ke string
            holder.textViewStatus.text = mahasiswa.statusKehadiran.toString()

            //kirim ke MainActivity
            holder.buttonDetail.setOnClickListener {
                onCLickButtonDetail(mahasiswa)

            }

        }


        override fun getItemCount(): Int = list_mahasiswa.size

        class  MahasiswaViewHolder(val row: View): RecyclerView.ViewHolder(row){
            val textViewName: TextView = row.findViewById(R.id.textViewName)
            val textViewNIM: TextView = row.findViewById(R.id.textViewNIM)
            val textViewStatus: TextView = row.findViewById(R.id.textViewStatus)
            val buttonDetail: Button = row.findViewById(R.id.buttonDetail)
        }
    }