package tdm.miniproject.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CategoryAdapter;
import tdm.miniproject.adapters.PagerAdapter;
import tdm.miniproject.fragments.ChartFragment;
import tdm.miniproject.fragments.ProductDetailFragment;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.ProductListFragmentListener;

public class MainActivity extends AppCompatActivity implements ProductListFragmentListener{
    private ArrayList<Category> categoriesList;
    private static Cart cart;
    private static boolean notification=true;
    private static boolean connected;
    private static ArrayList<Order> orders;
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private Spinner categorySpinner;
    private static  int spinnerIndex=-1;
    private static int tabIndex=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateExamples();
        initialiseToolBar();
        initialiseSpinner();
        initialiseTabNavigation();
    }

    public void initialiseToolBar(){
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.mainToolBar);
        setSupportActionBar(mainToolbar);
    }

    public void initialiseTabNavigation(){
        if(spinnerIndex!=-1)  pagerAdapter = new PagerAdapter(getSupportFragmentManager(),categoriesList.get(spinnerIndex),this);
        else pagerAdapter = new PagerAdapter(getSupportFragmentManager(),categoriesList.get(categorySpinner.getSelectedItemPosition()),this);
        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        if(tabIndex!=-1) viewPager.setCurrentItem(tabIndex);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initialiseSpinner() {
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoriesList);
        categorySpinner.setAdapter(categoryAdapter);
        if(spinnerIndex!=-1) categorySpinner.setSelection(spinnerIndex);
        if(spinnerIndex==-1&&isTwoPanes()) showProductDetailsInFrag(categoriesList.get(0).get(0));
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pagerAdapter.dispatchCategoryToLists(categoriesList.get(position));
                //pagerAdapter.updateFraments();
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void generateExamples(){
        if (cart==null){
            cart = new Cart();
        }
        if(orders==null){
            orders=new ArrayList<Order>();
        }
        if(categoriesList==null){
            //Creation of product categories list
            categoriesList = new ArrayList<Category>();
            //Creation of some product categories
            Category categorie1 = new Category("Pulls",R.drawable.ic_shirt_icon);
            Category categorie2 = new Category("Chaussures",R.drawable.ic_shoes_icon);
            Category categorie3 = new Category("Vestes",R.drawable.ic_coat_icon);
            Category categorie4 = new Category("Pantalons",R.drawable.ic_pants_icon);
            Category categorie5 = new Category("Accessoires",R.drawable.ic_hat_icon);
            //Creation of 10 products for each categorie
            //Categorie1
            categorie1.add(new Product("T-shirt Bleu ", 2500, "T-shirt par Adidas Originals, coupe classique taillant normalement ", R.drawable.tshirt_addidas_bleu, Consumer.MAN,"-Jersey doux au toucher\n" +
                    "-Ras du cou\n" +
                    "-Bandes emblématiques sur la manche\n" +
                    "-Impression du logo\n" +
                    "-Ourlet asymétrique plongeant au dos\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                    "-Code fournisseur : B10654"));

            categorie1.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.tshirt2, Consumer.MAN,"-Jersey stretch\n" +
                    "-Ras du cou\n" +
                    "-Manches ajustées\n" +
                    "-Coupe moulante au niveau du corps\n" +
                    "-Coupe longue\n" +
                    "-Plus long qu'un modèle classique\n" +
                    "-Coupe skinny près du corps\n" +
                    "-Lavage en machine\n" +
                    "-94% coton, 6% élasthanne\n"));

            categorie1.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré manches courtes à col boutonné", R.drawable.tshirt3, Consumer.MAN,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            categorie1.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.tshirt4, Consumer.MAN,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le mannequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

            categorie1.add(new Product("T-Shirt AF", 1950, "Abercrombie & Fitch - Essential - T-shirt cintré moulant à manches courtes et col tunisien", R.drawable.tshirt5, Consumer.MAN,"-Jersey de coton majoritaire\n" +
                    "-Patte de boutonnage\n" +
                    "-Logo brodé\n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester\n" +
                    "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));



            categorie1.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré KIDches courtes à col boutonné", R.drawable.teshirt3, Consumer.KID,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            categorie1.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.teshirt4, Consumer.KID,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le KIDnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

            categorie1.add(new Product("T-Shirt AF", 1950, "Abercrombie & Fitch - Essential - T-shirt cintré moulant à KIDches courtes et col tunisien", R.drawable.teshirt5, Consumer.KID,"-Jersey de coton majoritaire\n" +
                    "-Patte de boutonnage\n" +
                    "-Logo brodé\n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester\n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));







            categorie1.add(new Product("T-shirt Bleu ", 2500, "T-shirt par Adidas Originals, coupe classique taillant normalement ", R.drawable.teshirt1, Consumer.KID,"-Jersey doux au toucher\n" +
                    "-Ras du cou\n" +
                    "-Bandes emblématiques sur la KIDche\n" +
                    "-Impression du logo\n" +
                    "-Ourlet asymétrique plongeant au dos\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                    "-Code fournisseur : B10654"));


            categorie1.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.teshirt2, Consumer.KID,"-Jersey stretch\n" +
                    "-Ras du cou\n" +
                    "-KIDches ajustées\n" +
                    "-Coupe moulante au niveau du corps\n" +
                    "-Coupe longue\n" +
                    "-Plus long qu'un modèle classique\n" +
                    "-Coupe skinny près du corps\n" +
                    "-Lavage en machine\n" +
                    "-94% coton, 6% élasthanne\n"));






            categorie1.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.tfshirt4, Consumer.WOMAN,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le WOMANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


            categorie1.add(new Product("T-shirt Bleu ", 2500, "T-shirt par Adidas Originals, coupe classique taillant normalement ", R.drawable.tfshirt1, Consumer.WOMAN,"-Jersey doux au toucher\n" +
                    "-Ras du cou\n" +
                    "-Bandes emblématiques sur la WOMANche\n" +
                    "-Impression du logo\n" +
                    "-Ourlet asymétrique plongeant au dos\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                    "-Code fournisseur : B10654"));



            categorie1.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré WOMANches courtes à col boutonné", R.drawable.tfshirt3, Consumer.WOMAN,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));


            categorie1.add(new Product("T-Shirt AF", 1950, "Abercrombie & Fitch - Essential - T-shirt cintré moulant à WOMANches courtes et col tunisien", R.drawable.tfshirt5, Consumer.WOMAN,"-Jersey de coton majoritaire\n" +
                    "-Patte de boutonnage\n" +
                    "-Logo brodé\n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester\n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            categorie1.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.tfshirt2, Consumer.WOMAN,"-Jersey stretch\n" +
                    "-Ras du cou\n" +
                    "-WOMANches ajustées\n" +
                    "-Coupe moulante au niveau du corps\n" +
                    "-Coupe longue\n" +
                    "-Plus long qu'un modèle classique\n" +
                    "-Coupe skinny près du corps\n" +
                    "-Lavage en machine\n" +
                    "-94% coton, 6% élasthanne\n"));




            //Categorie2
            categorie2.add(new Product("Shaussure par RM", 800, "River Island - Shaussure bleu marine avec bords colorés", R.drawable.shoe1, Consumer.MAN,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le MANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


            categorie2.add(new Product("Shaussure RC ", 2500, "Shaussure par Adidas Originals, coupe classique taillant normalement ", R.drawable.shoe2, Consumer.MAN,"-Jersey doux au toucher\n" +
                    "-Ras du cou\n" +
                    "-Bandes emblématiques sur la MANche\n" +
                    "-Impression du logo\n" +
                    "-Ourlet asymétrique plongeant au dos\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le MANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                    "-Code fournisseur : B10654"));



            categorie2.add(new Product("Shaussure SNO", 900, "Abercrombie & SNO - Essential - Shaussure moulant cintré MANches courtes à col boutonné", R.drawable.shoe3, Consumer.MAN,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le MANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));


            categorie2.add(new Product("Chaussure Nv ", 2500, "Chaussure par Adidas Originals, coupe classique taillant normalement ", R.drawable.shoee1, Consumer.KID,"-Jersey doux au toucher\n" +
                    "-Ras du cou\n" +
                    "-Bandes emblématiques sur la KIDche\n" +
                    "-Impression du logo\n" +
                    "-Ourlet asymétrique plongeant au dos\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                    "-Code fournisseur : B10654"));

            categorie2.add(new Product("Chaussure long", 2200, "ASOS - Chaussure long moulant avec motif militaire estampé sur l'épaule", R.drawable.shoee2, Consumer.KID,"-Jersey stretch\n" +
                    "-Ras du cou\n" +
                    "-KIDches ajustées\n" +
                    "-Coupe moulante au niveau du corps\n" +
                    "-Coupe longue\n" +
                    "-Plus long qu'un modèle classique\n" +
                    "-Coupe skinny près du corps\n" +
                    "-Lavage en machine\n" +
                    "-94% coton, 6% élasthanne\n"));

            categorie2.add(new Product("Chaussure Fitch", 900, "Abercrombie & Fitch - Essential - Chaussure moulant cintré KIDches courtes à col boutonné", R.drawable.shoee3, Consumer.KID,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));






            categorie2.add(new Product("chaussure Fitch", 900, "Abercrombie & Fitch - Essential - chaussure moulant cintré WOMANches courtes à col boutonné", R.drawable.shoef1, Consumer.WOMAN,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            categorie2.add(new Product("chaussure par RI", 800, "River Island - chaussure bleu marine avec bords colorés", R.drawable.shoef2, Consumer.WOMAN,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le WOMANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

            categorie2.add(new Product("chaussure AF", 1950, "Abercrombie & Fitch - Essential - chaussure cintré moulant à WOMANches courtes et col tunisien", R.drawable.shoef3, Consumer.WOMAN,"-Jersey de coton majoritaire\n" +
                    "-Patte de boutonnage\n" +
                    "-Logo brodé\n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester\n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));



            //Categorie3
            categorie3.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.jacket1, Consumer.MAN,"-Jersey stretch\n" +
                    "-Ras du cou\n" +
                    "-Manches ajustées\n" +
                    "-Coupe moulante au niveau du corps\n" +
                    "-Coupe longue\n" +
                    "-Plus long qu'un modèle classique\n" +
                    "-Coupe skinny près du corps\n" +
                    "-Lavage en machine\n" +
                    "-94% coton, 6% élasthanne\n"));

            categorie3.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré manches courtes à col boutonné", R.drawable.jacket2, Consumer.MAN,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            categorie3.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.jacket3, Consumer.MAN,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le mannequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


            categorie3.add(new Product("Veste par FT", 800, "River Island - Veste bleu marine avec bords colorés", R.drawable.jackete1, Consumer.KID,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant noFTalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le KIDnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


            categorie3.add(new Product("Veste RC ", 2500, "Veste par Adidas Originals, coupe classique taillant noFTalement ", R.drawable.jackete2, Consumer.KID,"-Jersey doux au toucher\n" +
                    "-Ras du cou\n" +
                    "-Bandes emblématiques sur la KIDche\n" +
                    "-Impression du logo\n" +
                    "-Ourlet asymétrique plongeant au dos\n" +
                    "-Coupe classique taillant noFTalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                    "-Code fournisseur : B10654"));



            categorie3.add(new Product("Veste SNO", 900, "Abercrombie & SNO - Essential - Veste moulant cintré KIDches courtes à col boutonné", R.drawable.jackete3, Consumer.KID,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));



            categorie3.add(new Product("Veste Ram", 900, "Abercrombie & Ram - Essential - Veste moulant cintré WOMANches courtes à col boutonné", R.drawable.jacketf1, Consumer.WOMAN,"-Jersey doux au toucher \n" +
                    "-Encolure ronde \n" +
                    "-Patte de boutonnage \n" +
                    "-Logo brodé \n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester \n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            categorie3.add(new Product("Veste par RI", 800, "River Island - Veste bleu marine avec bords colorés", R.drawable.jacketf2, Consumer.WOMAN,"-Article fabriqué en maille douce\n" +
                    "-Modèle léger \n" +
                    "-Rayures contrastées\n" +
                    "-Ras du cou\n" +
                    "-Coupe classique taillant normalement\n" +
                    "-Lavage en machine\n" +
                    "-100% coton\n" +
                    "-Le WOMANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

            categorie3.add(new Product("Veste AF", 1950, "Abercrombie & Ram - Essential - Veste cintré moulant à WOMANches courtes et col tunisien", R.drawable.jacketf3, Consumer.WOMAN,"-Jersey de coton majoritaire\n" +
                    "-Patte de boutonnage\n" +
                    "-Logo brodé\n" +
                    "-Coupe cintrée près du corps.\n" +
                    "-Lavage en machine\n" +
                    "-60% coton, 40% polyester\n" +
                    "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

            //Categorie4
            categorie4.add(new Product("pantalon1", 1400, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon2", 1500, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon3", 1350, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon4", 800, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon5", 900, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon6", 670, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon7", 392, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie4.add(new Product("pantalon1", 1400, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon2", 1500, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon3", 1350, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon4", 800, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon5", 900, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon6", 670, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon7", 392, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));

            categorie4.add(new Product("pantalon1", 1400, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon2", 1500, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon3", 1350, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon4", 800, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon5", 900, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon6", 670, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon7", 392, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            //Categorie5
            categorie5.add(new Product("accessoire1", 1400, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire2", 1500, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire3", 1350, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire4", 800, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire5", 900, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire6", 670, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire7", 392, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire8", 1400, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire9", 1600, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire10", 1090, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie5.add(new Product("accessoire1", 1400, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire2", 1500, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire3", 1350, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire4", 800, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire5", 900, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire6", 670, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire7", 392, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire8", 1400, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire9", 1600, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire10", 1090, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));

            categorie5.add(new Product("accessoire1", 1400, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire2", 1500, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire3", 1350, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire4", 800, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire5", 900, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire6", 670, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire7", 392, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire8", 1400, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire9", 1600, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire10", 1090, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));

            //Adding categories to the categories list
            categoriesList.add(categorie1);
            categoriesList.add(categorie2);
            categoriesList.add(categorie3);
            categoriesList.add(categorie4);
            categoriesList.add(categorie5);
        }
    }

    public void showChartActivity(MenuItem item) {
            Intent intent = new Intent(this,CartActivity.class);
            startActivity(intent);
    }


    @Override
    public void showProductDetails(Product product) {
        if(!isTwoPanes()) {
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        }else{
            showProductDetailsInFrag(product);
        }
    }

    private void showProductDetailsInFrag(Product product) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.twoPanesFragment,fragment);
        fragTransaction.commit();
    }

    @Override
    public void addProductToCart(Product product) {
       addProductToSCart(MainActivity.this, product);
    }
    public static void addProductToSCart(Context context,Product product) {
        CartElement cartElement = new CartElement(product);
        int q = cart.add(cartElement);
        if (q==1){
            Toast.makeText(context, "Produit ajouté au chariot", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Produit existant, quantité incrémentée "+q, Toast.LENGTH_SHORT).show();
        }
    }

    public static Cart getCart() {
        return cart;
    }

    public static void setCart(Cart cart) {
        MainActivity.cart = cart;
    }

    public static boolean connect(String user,String password){
        if(user.equals("admin")&&password.equals("admin")){
            setConnected(true);
        }
        else{
            setConnected(false);
        }
        return connected;
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        MainActivity.connected = connected;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public void showOrdersActivity(MenuItem item) {
        Intent intent = new Intent(this,OrdersActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("spinnerIndex", categorySpinner.getSelectedItemPosition());
        outState.putInt("tabIndex", viewPager.getCurrentItem());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int i = savedInstanceState.getInt("spinnerIndex",-1);
        if(i!=-1){
            spinnerIndex = i;
        }

        int j = savedInstanceState.getInt("tabIndex",-1);
        if(j!=-1){
            tabIndex=j;
        }
        if (isTwoPanes()){
            int l = spinnerIndex;
            switch (tabIndex){
                case 0:

                    for(int k = 0;k<=categoriesList.get(l).size();k++){
                        if (categoriesList.get(l).get(k).getConsumer()==Consumer.MAN){
                            showProductDetailsInFrag(categoriesList.get(l).get(k));
                            break;
                        }
                    }
                    break;
                case 1:
                    for(int k = 0;k<=categoriesList.get(l).size();k++){
                        if (categoriesList.get(l).get(k).getConsumer()==Consumer.WOMAN){
                            showProductDetailsInFrag(categoriesList.get(l).get(k));
                            break;
                        }
                    }
                    break;
                case 2:
                    for(int k = 0;k<=categoriesList.get(l).size();k++){
                        if (categoriesList.get(l).get(k).getConsumer()==Consumer.KID){
                            showProductDetailsInFrag(categoriesList.get(l).get(k));
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.notificationToggle:
                if(notification==true){
                    notification=false;
                    Toast.makeText(MainActivity.this, "Les notifications sont désactivées. ", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_notifications_off_white_24dp);
                }
                else{
                    notification=true;
                    Toast.makeText(MainActivity.this, "Les notifications sont activées. ", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_notifications_white_24dp);
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    boolean isTwoPanes(){
        if(findViewById(R.id.twoPanesFragment)==null){
            return false;
        }
        return true;
    }
}