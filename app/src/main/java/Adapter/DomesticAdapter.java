package Adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.powercalc.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DomesticAdapter extends RecyclerView.Adapter<DomesticAdapter.DomesticViewHolder> {
    List<String> list;
    String[] domesticValue;
    int num=0;

    public DomesticAdapter(List<String> list){

        this.list=list;
        domesticValue=new String[list.size()];
        for (int i=0; i<list.size(); i++){
            domesticValue[i]=String.valueOf(num);

        }
    }

    @NonNull
    @Override
    public DomesticAdapter.DomesticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);

        return new DomesticViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DomesticAdapter.DomesticViewHolder holder, int position) {
        String value = list.get(position);
        holder.setValue(value);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public String[] getDomesticValue(){

        return domesticValue;
    }


    public class DomesticViewHolder extends RecyclerView.ViewHolder {
        EditText domesticAns;
        TextView domesticText;



        public DomesticViewHolder(@NonNull View itemView) {
            super(itemView);

            domesticAns= itemView.findViewById(R.id.domestic1Ans);
            domesticText= itemView.findViewById(R.id.domestic1);

            domesticAns.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    domesticValue[getAdapterPosition()]= s.toString();
                    Log.i("mess", String.valueOf(getAdapterPosition()));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }

        public void setValue(String s){
            domesticText.setText(s);
        }
    }
}


