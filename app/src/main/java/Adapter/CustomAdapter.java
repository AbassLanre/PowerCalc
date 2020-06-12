


package Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.powercalc.R;

import java.util.ArrayList;
import java.util.List;

import Model.EditModel;
import Model.EditName;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    public static ArrayList<EditModel> editModelArrayList;
    private List<EditName> editNames;


    public CustomAdapter(Context ctx, ArrayList<EditModel> editModelArrayList, List<EditName> editNames){

        inflater = LayoutInflater.from(ctx);
        this.editModelArrayList = editModelArrayList;
        this.editNames=editNames;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomAdapter.MyViewHolder holder, final int position) {


        holder.domesticAns.setText(editModelArrayList.get(position).getDomesticAns());
        Log.d("print","yes");
        holder.domesticName.setText(editNames.get(position).getDomesticName());

    }

    @Override
    public int getItemCount() {
        return editModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        protected EditText domesticAns;
        protected TextView domesticName;


        public MyViewHolder(View itemView) {
            super(itemView);

            domesticAns =  itemView.findViewById(R.id.domestic1Ans);
            domesticName= itemView.findViewById(R.id.domestic1);

            domesticAns.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    editModelArrayList.get(getAdapterPosition()).setDomesticAns(domesticAns.getText().toString());

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        }

    }
}
