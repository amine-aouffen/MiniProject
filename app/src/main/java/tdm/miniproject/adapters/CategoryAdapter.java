package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import tdm.miniproject.R;

public class CategoryAdapter extends BaseAdapter {
    private Context context;
    public CategoryAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null ;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view ==null||!view.getTag().toString().equals("NON_DROPDOWN")){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view =inflater.inflate(R.layout.item_categorie_list, null);
            view.setTag("NON_DROPDOWN");
        }

        TextView categoryTextView=(TextView) view.findViewById(R.id.categoryListItemText) ;
        ImageView categoryIcon=(ImageView) view.findViewById(R.id.categoryListItemIcon);
        switch (position){
            case 0:
                categoryTextView.setText("T-Shirts");
                categoryIcon.setImageResource(R.drawable.ic_shirt_icon);
                break;
            case 1:
                categoryTextView.setText("Chaussures");
                categoryIcon.setImageResource(R.drawable.ic_shoes_icon);
                break;
            case 2:
                categoryTextView.setText("Vestes");
                categoryIcon.setImageResource(R.drawable.ic_coat_icon);
                break;
            case 3:
                categoryTextView.setText("Jeans");
                categoryIcon.setImageResource(R.drawable.ic_pants_icon);
                break;
            case 4:
                categoryTextView.setText("Shirts");
                categoryIcon.setImageResource(R.drawable.ic_hat_icon);
                break;
            default:
                categoryTextView.setText("T-Shirts");
                categoryIcon.setImageResource(R.drawable.ic_shirt_icon);
                break;
        }
        return view;
    }



}
