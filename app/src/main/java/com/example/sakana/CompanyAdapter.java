package com.example.sakana;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {

    private List<Company> companyList; // リスト

    public CompanyAdapter(List<Company> companyList) {
        this.companyList = companyList;
    }

    @NonNull //kesukamo
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_company, parent, false);
        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {

        holder.nameText.setText(companyList.get(position).getName());
        holder.statusText.setText(companyList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }

    static class CompanyViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView statusText;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.companyName);
            statusText = itemView.findViewById(R.id.companyStatus);
        }
    }
}