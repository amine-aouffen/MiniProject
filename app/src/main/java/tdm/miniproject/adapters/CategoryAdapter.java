package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import tdm.miniproject.R;
import tdm.miniproject.job.Category;

/**
 * Created by Home on 23/03/2016.
 */
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
        if(view==null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_categorie_list,null);
        }
        TextView categoryTextView=(TextView)view.findViewById(R.id.categoryListItem) ;
        Category category = categoriesList.get(position);
        categoryTextView.setText(category.getName());
        return view;
    }
}
