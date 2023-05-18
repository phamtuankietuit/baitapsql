package com.example.sqlite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LopHocAdapter extends RecyclerView.Adapter<LopHocAdapter.LopHocViewHolder>{
    private List<LopHoc> mListLopHoc;
    private Context context;

    private Callback callback;

    public LopHocAdapter(List<LopHoc> mListLopHoc, Context context, Callback callback) {
        this.mListLopHoc = mListLopHoc;
        this.context = context;
        this.callback = callback;
    }

    @NonNull
    @Override
    public LopHocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);
        return new LopHocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopHocViewHolder holder, int position) {
        LopHoc lopHoc = mListLopHoc.get(position);
        if (lopHoc == null) {
            return;
        }
        holder.tvIdClass.setText(lopHoc.getId().toString());
        holder.tvNameClass.setText(lopHoc.getName());
        holder.tvStudentsClass.setText(lopHoc.getStudent().toString());
        Integer stt = position + 1;
        holder.tvSttClass.setText(stt.toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DSSinhVien.class);
                intent.putExtra("id",lopHoc.getId().toString());
                intent.putExtra("name", lopHoc.getName());
                intent.putExtra("students", lopHoc.getStudent().toString());
                callback.callback(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListLopHoc != null) {
            return mListLopHoc.size();
        }
        return 0;
    }

    public class LopHocViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIdClass, tvNameClass, tvStudentsClass, tvSttClass;
        public LopHocViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdClass = itemView.findViewById(R.id.tv_id);
            tvNameClass = itemView.findViewById(R.id.tv_name);
            tvStudentsClass = itemView.findViewById(R.id.tv_students);
            tvSttClass = itemView.findViewById(R.id.tv_stt);
        }
    }
}
