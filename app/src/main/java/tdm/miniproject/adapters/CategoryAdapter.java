package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tdm.miniproject.R;
import tdm.miniproject.job.Category;

public class CategoryAdapter extends BaseAdapter {
    private List<Category> categoriesList;
    private Context context;
    public CategoryAdapter(Context context,List<Category> categoriesList) {
        this.categoriesList=categoriesList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoriesList.get(position);
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
        Category category = categoriesList.get(position);
        TextView categoryTextView=(TextView) view.findViewById(R.id.categoryListItemText) ;
        ImageView categoryIcon=(ImageView) view.findViewById(R.id.categoryListItemIcon);
        categoryTextView.setText(category.getName());
        categoryIcon.setImageResource(categoriesList.get(position).getCategoryIcon());
        return view;
    }


    private void showCategoryAsItem( View view,int position) {
        Category category = categoriesList.get(position);
        TextView categoryTextView=(TextView)view.findViewById(R.id.categoryListItemText) ;
        ImageView categoryIcon=(ImageView) view.findViewById(R.id.categoryListItemIcon);
        categoryTextView.setText(category.getName());
        categoryIcon.setImageResource(categoriesList.get(position).getCategoryIcon());
    }

}
