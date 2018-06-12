package ayds.dictionary.alpha.View;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ayds.dictionary.alpha.Model.Term;
import ayds.dictionary.alpha.R;

public class AdapterTerm extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Term> listTerm;

    public AdapterTerm(Activity activity, ArrayList<Term> listTerm){

        this.activity = activity;
        this.listTerm = listTerm;
    }

    @Override
    public int getCount() {
        return listTerm.size();
    }

    @Override
    public Object getItem(int position) {
        return listTerm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.services_main, null);
        }

        Term term = listTerm.get(position);

        TextView source = v.findViewById(R.id.source);
        source.setText(term.getSource());

        TextView serviceResponse = v.findViewById(R.id.serviceResponse);
        serviceResponse.setText(term.getDefinition());

        return v;
    }
}
