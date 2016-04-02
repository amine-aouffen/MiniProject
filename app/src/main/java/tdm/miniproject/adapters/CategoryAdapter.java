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
        View view = inflateView(convertView);
        showCategoryAsItem(view,position);
        return view;
    }

    private void showCategoryAsItem( View view,int position) {
        Category category = categoriesList.get(position);
        TextView categoryTextView=(TextView)view.findViewById(R.id.categoryListItem) ;
        categoryTextView.setText(category.getName());
    }

    private View inflateView(View convertView) {
        View view = convertView;
        if(view==null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_categorie_list,null);
        }
        return view;
    }
}
