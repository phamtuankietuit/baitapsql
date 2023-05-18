package com.example.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder>{

    private List<SinhVien> mListSinhVien;

    public SinhVienAdapter(List<SinhVien> mListSinhVien) {
        this.mListSinhVien = mListSinhVien;
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new SinhVienAdapter.SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        SinhVien sinhVien = mListSinhVien.get(position);
        if (sinhVien == null) {
            return;
        }

        holder.tvIdStudent.setText(sinhVien.getId().toString());
        holder.tvNameStudent.setText(sinhVien.getName());
        holder.tvDobStudent.setText(sinhVien.getDob());

        switch (sinhVien.getResourceId())
        {
            case 1:
                holder.imgAvtStudent.setImageResource(R.drawable.img_avt_1);
                break;
            case 2:
                holder.imgAvtStudent.setBackgroundResource(R.drawable.img_avt_2);
                break;
            case 3:
                holder.imgAvtStudent.setBackgroundResource(R.drawable.img_avt_3);
                break;
            case 4:
                holder.imgAvtStudent.setBackgroundResource(R.drawable.img_avt_4);
                break;
        }

    }

    @Override
    public int getItemCount() {
        if (mListSinhVien != null) {
            return mListSinhVien.size();
        }
        return 0;
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdStudent, tvNameStudent, tvDobStudent;
        ImageView imgAvtStudent;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdStudent = itemView.findViewById(R.id.tv_idstudent);
            tvNameStudent = itemView.findViewById(R.id.tv_namestudent);
            tvDobStudent = itemView.findViewById(R.id.tv_dobstudent);
            imgAvtStudent = itemView.findViewById(R.id.img_avtstudent);
        }
    }
}
