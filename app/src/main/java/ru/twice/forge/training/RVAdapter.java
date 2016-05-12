package ru.twice.forge.training;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by twice on 12.05.16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonHolder> {


    ArrayList<Person>persons;

    public RVAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }



    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        PersonHolder ph= new PersonHolder(v);
        return ph;
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        holder.et1.setText(persons.get(position).name);
        holder.et2.setText(persons.get(position).surname);

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


    public static class PersonHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        EditText et1,et2;

        public PersonHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cv);
            et1=(EditText)itemView.findViewById(R.id.et1);
            et2=(EditText)itemView.findViewById(R.id.et2);
        }
    }
}
