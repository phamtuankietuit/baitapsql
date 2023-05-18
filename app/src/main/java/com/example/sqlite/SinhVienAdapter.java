package com.example.sqlite;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

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

        holder.editIdStudent.setText(sinhVien.getId());
        holder.editNameStudent.setText(sinhVien.getName());
        holder.editDobStudent.setText(sinhVien.getDob());
        holder.imgAvtStudent.setImageResource(sinhVien.getResourceId());


    }

    @Override
    public int getItemCount() {
        if (mListSinhVien != null) {
            return mListSinhVien.size();
        }
        return 0;
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder {
        EditText editIdStudent, editNameStudent, editDobStudent;
        ImageView imgAvtStudent;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            editIdStudent = itemView.findViewById(R.id.tv_idstudent);
            editNameStudent = itemView.findViewById(R.id.tv_namestudent);
            editDobStudent = itemView.findViewById(R.id.tv_dobstudent);
            imgAvtStudent = itemView.findViewById(R.id.img_avtstudent);
        }
    }
}
