package tdm.miniproject.data;

import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;

/**
 * Created by Dell on 30/04/2016.
 */
public class ProductData {

    private ArrayList<Category> categoriesList = new ArrayList<Category>();

    public ProductData() {
        //Creation of some product categories
        Category categorie1 = new Category("Pulls", R.drawable.ic_shirt_icon);
        Category categorie2 = new Category("Chaussures", R.drawable.ic_shoes_icon);
        Category categorie3 = new Category("Vestes", R.drawable.ic_coat_icon);
        Category categorie4 = new Category("Pantalons", R.drawable.ic_pants_icon);
        Category categorie5 = new Category("Chemises", R.drawable.ic_hat_icon);
        //Creation of 10 products for each categorie
        //Categorie1
        categorie1.add(new Product("T-shirt Bleu ", 2500, "T-shirt par Adidas Originals, coupe classique taillant normalement ", R.drawable.tshirt_addidas_bleu, Consumer.MAN, "-Jersey doux au toucher\n" +
                "-Ras du cou\n" +
                "-Bandes emblématiques sur la manche\n" +
                "-Impression du logo\n" +
                "-Ourlet asymétrique plongeant au dos\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                "-Code fournisseur : B10654"));

        categorie1.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.tshirt2, Consumer.MAN, "-Jersey stretch\n" +
                "-Ras du cou\n" +
                "-Manches ajustées\n" +
                "-Coupe moulante au niveau du corps\n" +
                "-Coupe longue\n" +
                "-Plus long qu'un modèle classique\n" +
                "-Coupe skinny près du corps\n" +
                "-Lavage en machine\n" +
                "-94% coton, 6% élasthanne\n"));

        categorie1.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré manches courtes à col boutonné", R.drawable.tshirt3, Consumer.MAN, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie1.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.tshirt4, Consumer.MAN, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le mannequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

        categorie1.add(new Product("T-Shirt AF", 1950, "Abercrombie & Fitch - Essential - T-shirt cintré moulant à manches courtes et col tunisien", R.drawable.tshirt5, Consumer.MAN, "-Jersey de coton majoritaire\n" +
                "-Patte de boutonnage\n" +
                "-Logo brodé\n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester\n" +
                "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));


        categorie1.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré KIDches courtes à col boutonné", R.drawable.teshirt3, Consumer.KID, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie1.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.teshirt4, Consumer.KID, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le KIDnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

        categorie1.add(new Product("T-Shirt AF", 1950, "Abercrombie & Fitch - Essential - T-shirt cintré moulant à KIDches courtes et col tunisien", R.drawable.teshirt5, Consumer.KID, "-Jersey de coton majoritaire\n" +
                "-Patte de boutonnage\n" +
                "-Logo brodé\n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester\n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));


        categorie1.add(new Product("T-shirt Bleu ", 2500, "T-shirt par Adidas Originals, coupe classique taillant normalement ", R.drawable.teshirt1, Consumer.KID, "-Jersey doux au toucher\n" +
                "-Ras du cou\n" +
                "-Bandes emblématiques sur la KIDche\n" +
                "-Impression du logo\n" +
                "-Ourlet asymétrique plongeant au dos\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                "-Code fournisseur : B10654"));


        categorie1.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.teshirt2, Consumer.KID, "-Jersey stretch\n" +
                "-Ras du cou\n" +
                "-KIDches ajustées\n" +
                "-Coupe moulante au niveau du corps\n" +
                "-Coupe longue\n" +
                "-Plus long qu'un modèle classique\n" +
                "-Coupe skinny près du corps\n" +
                "-Lavage en machine\n" +
                "-94% coton, 6% élasthanne\n"));


        categorie1.add(new Product("T-shirt par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.tfshirt4, Consumer.WOMAN, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le WOMANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


        categorie1.add(new Product("T-shirt Bleu ", 2500, "T-shirt par Adidas Originals, coupe classique taillant normalement ", R.drawable.tfshirt1, Consumer.WOMAN, "-Jersey doux au toucher\n" +
                "-Ras du cou\n" +
                "-Bandes emblématiques sur la WOMANche\n" +
                "-Impression du logo\n" +
                "-Ourlet asymétrique plongeant au dos\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                "-Code fournisseur : B10654"));


        categorie1.add(new Product("T-shirt Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré WOMANches courtes à col boutonné", R.drawable.tfshirt3, Consumer.WOMAN, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));


        categorie1.add(new Product("T-Shirt AF", 1950, "Abercrombie & Fitch - Essential - T-shirt cintré moulant à WOMANches courtes et col tunisien", R.drawable.tfshirt5, Consumer.WOMAN, "-Jersey de coton majoritaire\n" +
                "-Patte de boutonnage\n" +
                "-Logo brodé\n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester\n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie1.add(new Product("T-Shirt long", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.tfshirt2, Consumer.WOMAN, "-Jersey stretch\n" +
                "-Ras du cou\n" +
                "-WOMANches ajustées\n" +
                "-Coupe moulante au niveau du corps\n" +
                "-Coupe longue\n" +
                "-Plus long qu'un modèle classique\n" +
                "-Coupe skinny près du corps\n" +
                "-Lavage en machine\n" +
                "-94% coton, 6% élasthanne\n"));


        //Categorie2
        categorie2.add(new Product("Chaussures par RM", 800, "River Island - Shaussure bleu marine avec bords colorés", R.drawable.shoe1, Consumer.MAN, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le MANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


        categorie2.add(new Product("Chaussures RC ", 2500, "Shaussure par Adidas Originals, coupe classique taillant normalement ", R.drawable.shoe2, Consumer.MAN, "-Jersey doux au toucher\n" +
                "-Ras du cou\n" +
                "-Bandes emblématiques sur la MANche\n" +
                "-Impression du logo\n" +
                "-Ourlet asymétrique plongeant au dos\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le MANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                "-Code fournisseur : B10654"));


        categorie2.add(new Product("Chaussures SNO", 900, "Abercrombie & SNO - Essential - Shaussure moulant cintré MANches courtes à col boutonné", R.drawable.shoe3, Consumer.MAN, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le MANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie2.add(new Product("STAN SMITH - Baskets basses", 900, "adidas Originals\n" +
                "STAN SMITH - Baskets basses - red/power red", R.drawable.stan_smith___baskets_basses, Consumer.MAN,
                "Première de propreté (semelle intérieure): textile\n" +
                        "Doublure: textile\n" +
                        "Forme du talon: plat\n" +
                        "Épaisseur de la doublure: doublure protégeant du froid\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Fermeture: laçage\n" +
                        "Bout de la chaussure: rond\n" +
                        "Semelle d'usure: matière synthétique\n" +
                        "Dessus / Tige: cuir\n" +
                        "Référence: AD112B0F1-G11"));

        categorie2.add(new Product("AIR HUARACHE UTILITY", 900, "Nike Sportswear\n" +
                "AIR HUARACHE UTILITY - Baskets basses - black/black/black", R.drawable.air_huarache_utility___baskets, Consumer.MAN, "Première de propreté (semelle intérieure): textile\n" +
                "Doublure: textile\n" +
                "Épaisseur de la doublure: doublure protégeant du froid\n" +
                "Motif / Couleur: à pois\n" +
                "Fermeture: laçage\n" +
                "Bout de la chaussure: rond\n" +
                "Semelle d'usure: matière synthétique\n" +
                "Dessus / Tige: tissu / matière synthétique\n" +
                "Référence: NI112B0BJ-Q11"));

        categorie2.add(new Product("AIR MAX 90 ESSENTIAL", 900, "Nike Sportswear\n" +
                "AIR MAX 90 ESSENTIAL - Baskets basses - white", R.drawable.air_max_90_essential___baskets, Consumer.MAN, "Première de propreté (semelle intérieure): textile\n" +
                "Doublure: textile\n" +
                "Épaisseur de la doublure: doublure protégeant du froid\n" +
                "Fermeture: laçage\n" +
                "Bout de la chaussure: rond\n" +
                "Semelle d'usure: matière synthétique\n" +
                "Dessus / Tige: cuir / matière synthétique\n" +
                "Référence: NI112A094-A18"));


        categorie2.add(new Product("Chaussure Nv ", 2500, "Chaussure par Adidas Originals, coupe classique taillant normalement ", R.drawable.shoee1, Consumer.KID, "-Jersey doux au toucher\n" +
                "-Ras du cou\n" +
                "-Bandes emblématiques sur la KIDche\n" +
                "-Impression du logo\n" +
                "-Ourlet asymétrique plongeant au dos\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                "-Code fournisseur : B10654"));

        categorie2.add(new Product("Chaussure long", 2200, "ASOS - Chaussure long moulant avec motif militaire estampé sur l'épaule", R.drawable.shoee2, Consumer.KID, "-Jersey stretch\n" +
                "-Ras du cou\n" +
                "-KIDches ajustées\n" +
                "-Coupe moulante au niveau du corps\n" +
                "-Coupe longue\n" +
                "-Plus long qu'un modèle classique\n" +
                "-Coupe skinny près du corps\n" +
                "-Lavage en machine\n" +
                "-94% coton, 6% élasthanne\n"));

        categorie2.add(new Product("Chaussure Fitch", 900, "Abercrombie & Fitch - Essential - Chaussure moulant cintré KIDches courtes à col boutonné", R.drawable.shoee3, Consumer.KID, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));


        categorie2.add(new Product("BABYFRESH - Chaussures premiers pas", 900, "Kickers\n" +
                "BABYFRESH - Chaussures premiers pas - marron, bleu", R.drawable.babyfresh___chaussures_premiers_pas, Consumer.KID, "Première de propreté (semelle intérieure): cuir\n" +
                "Doublure: cuir\n" +
                "Épaisseur de la doublure: doublure protégeant du froid\n" +
                "Détails: surpiqûres\n" +
                "Fermeture: fermeture à scratch\n" +
                "Bout de la chaussure: rond\n" +
                "Semelle d'usure: matière synthétique\n" +
                "Dessus / Tige: nubuck\n" +
                "Référence: KI114F00E-B11"));

        categorie2.add(new Product("BABY SUN - Chaussures premiers pas", 900, "Kickers\n" +
                "BABY SUN - Chaussures premiers pas - marine/bleu", R.drawable.baby_sun___chaussures_premiers_pas, Consumer.KID,
                "Première de propreté (semelle intérieure): cuir\n" +
                        "Doublure: cuir\n" +
                        "Épaisseur de la doublure: doublure protégeant du froid\n" +
                        "Détails: surpiqûres\n" +
                        "Fermeture: fermeture à scratch\n" +
                        "Bout de la chaussure: rond\n" +
                        "Semelle d'usure: matière synthétique\n" +
                        "Dessus / Tige: cuir suédé\n" +
                        "Référence: KI114G006-K11"));


        categorie2.add(new Product("chaussure Fitch", 900, "Abercrombie & Fitch - Essential - chaussure moulant cintré WOMANches courtes à col boutonné", R.drawable.shoef1, Consumer.WOMAN, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie2.add(new Product("chaussure par RI", 800, "River Island - chaussure bleu marine avec bords colorés", R.drawable.shoef2, Consumer.WOMAN, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le WOMANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

        categorie2.add(new Product("chaussure AF", 1950, "Abercrombie & Fitch - Essential - chaussure cintré moulant à WOMANches courtes et col tunisien", R.drawable.shoef3, Consumer.WOMAN, "-Jersey de coton majoritaire\n" +
                "-Patte de boutonnage\n" +
                "-Logo brodé\n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester\n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie2.add(new Product("Santiags - rust", 1950, "Bronx\n" +
                "Santiags - rust", R.drawable.santiags___rust, Consumer.WOMAN, "Première de propreté (semelle intérieure): cuir\n" +
                "Doublure: doublure en cuir / textile\n" +
                "Forme du talon: bloc\n" +
                "Hauteur du talon: 4 cm en taille 39\n" +
                "Épaisseur de la doublure: doublure protégeant du froid\n" +
                "Motif / Couleur: couleur unie\n" +
                "Hauteur de la tige: 11 cm en taille 39\n" +
                "Largeur de la tige: 22 cm en taille 39\n" +
                "Détails: ganse élastique\n" +
                "Fermeture: sans lacets\n" +
                "Bout de la chaussure: pointu\n" +
                "Semelle d'usure: matière synthétique\n" +
                "Dessus / Tige: cuir\n" +
                "Référence: BR111N00U-H11"));

        categorie2.add(new Product("FREE TRANSFORM FLYKNIT", 1950, "Nike Performance\n" +
                "FREE TRANSFORM FLYKNIT - Chaussures d'entraînement et de fitness - grand purple/white/hyper violet/total crimson",
                R.drawable.free_transform_flyknit, Consumer.WOMAN, "Première de propreté (semelle intérieure): textile\n" +
                "Doublure: textile\n" +
                "Forme du talon: plat\n" +
                "Motif / Couleur: rayures\n" +
                "Fermeture: laçage\n" +
                "Bout de la chaussure: rond\n" +
                "Semelle d'usure: matière synthétique\n" +
                "Propriétés: respirant\n" +
                "Extras: tirant sur le talon\n" +
                "Semelle intérieure: amovible, préformée, rembourrée\n" +
                "Informations sur la semelle d'usure: encoches de flexion\n" +
                "Sport: fitness\n" +
                "Dessus / Tige: textile\n" +
                "Référence: N1241A0FC-I11"));
        // categorie2.add(new Product("chaussu", 1950, "Abercrounisien", R.drawable.shoef3, Consumer.WOMAN,"-Jerse"));

        //Categorie3
        categorie3.add(new Product("T-Veste longue", 2200, "ASOS - T-shirt long moulant avec motif militaire estampé sur l'épaule", R.drawable.jacket1, Consumer.MAN, "-Jersey stretch\n" +
                "-Ras du cou\n" +
                "-Manches ajustées\n" +
                "-Coupe moulante au niveau du corps\n" +
                "-Coupe longue\n" +
                "-Plus long qu'un modèle classique\n" +
                "-Coupe skinny près du corps\n" +
                "-Lavage en machine\n" +
                "-94% coton, 6% élasthanne\n"));

        categorie3.add(new Product("T-Veste Fitch", 900, "Abercrombie & Fitch - Essential - T-shirt moulant cintré manches courtes à col boutonné", R.drawable.jacket2, Consumer.MAN, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le mannequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie3.add(new Product("T-Veste par RI", 800, "River Island - T-shirt bleu marine avec bords colorés", R.drawable.jacket3, Consumer.MAN, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le mannequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

        categorie3.add(new Product("LONGHORN - Veste légère", 800, "Superdry\n" +
                "LONGHORN - Veste légère - army", R.drawable.longhorn___veste_lgre___army, Consumer.MAN,
                "Composition de la doublure des manches: 100% polyester\n" +
                        "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: fermeture éclair\n" +
                        "Doublure: 100% coton\n" +
                        "Poches: poches à rabat\n" +
                        "Largeur de dos: 45.8 cm en taille M\n" +
                        "Taille du mannequin: Notre mannequin mesure 185 cm et porte une taille M\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Longueur totale: 70 cm en taille M\n" +
                        "Col: col officier\n" +
                        "Conseil choix de pointure / taille: chausse / taille petit\n" +
                        "Longueur des manches: 68 cm en taille M\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                        "Référence: SU222H03T-M11"));

        categorie3.add(new Product("BOBBY - Veste légère", 800, "Hilfiger Denim\n" +
                "BOBBY - Veste légère - blue", R.drawable.bobby___veste_lgre___blue, Consumer.MAN, "Longueur: normale\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Doublure: 100% polyester\n" +
                "Largeur de dos: 43 cm en taille M\n" +
                "Taille du mannequin: Notre mannequin mesure 186 cm et porte une taille M\n" +
                "Motif / Couleur: couleur unie\n" +
                "Longueur totale: 68 cm en taille M\n" +
                "Col: col droit\n" +
                "Informations additionnelles: poches\n" +
                "Longueur des manches: 67 cm en taille M\n" +
                "Type de manche: manches longues\n" +
                "Composition: 100% nylon\n" +
                "Conseils d'entretien: lavage en machine à 30°C\n" +
                "Référence: HI122H00P-K11"));


        categorie3.add(new Product("ROVIC-Z 3D HDD OVERSHIRT L", 800, "G-Star\n" +
                "ROVIC-Z 3D HDD OVERSHIRT L - Veste légère - lever", R.drawable.rovic_z_3d_hdd_overshirt_l___veste, Consumer.MAN, "Longueur: normale\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Doublure: 100% coton\n" +
                "Capuche: capuche avec cordon de serrage\n" +
                "Poches: poche sur la manche, poches à rabat\n" +
                "Largeur de dos: 52 cm en taille L\n" +
                "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille L\n" +
                "Motif / Couleur: couleur unie\n" +
                "Longueur totale: 69 cm en taille L\n" +
                "Col: capuche\n" +
                "Informations additionnelles: poches\n" +
                "Longueur des manches: 66 cm en taille L\n" +
                "Type de manche: manches longues\n" +
                "Composition: 100% coton\n" +
                "Conseils d'entretien: lavage en machine à 40°C\n" +
                "Référence: GS122H02L-N11"));

        categorie3.add(new Product("WINDRUNNER - Veste légère", 800, "Nike Sportswear\n" +
                "WINDRUNNER - Veste légère - obsidian/university red/white", R.drawable.windrunner___veste_lgre, Consumer.MAN, "Longueur: normale\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Doublure: 100% polyester\n" +
                "Capuche: capuche avec cordon de serrage\n" +
                "Poches: poches refermables avec fermeture éclair\n" +
                "Matière: Mesh\n" +
                "Largeur de dos: 44 cm en taille M\n" +
                "Taille du mannequin: Notre mannequin mesure 188 cm et porte une taille M\n" +
                "Longueur totale: 70 cm en taille M\n" +
                "Col: capuche\n" +
                "Longueur des manches: 69 cm en taille M\n" +
                "Type de manche: manches longues\n" +
                "Composition: 100% polyester\n" +
                "Conseils d'entretien: lavage en machine à 30°C\n" +
                "Référence: NI122H019-K12"));
        categorie3.add(new Product("COLORADO - Veste de survêtement", 800, "adidas Originals\n" +
                "COLORADO - Veste de survêtement - green/black", R.drawable.colorado___veste_de_survtement, Consumer.MAN, "Longueur: normale\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Doublure: 100% polyester\n" +
                "Capuche: capuche avec cordon de serrage\n" +
                "Poches: poches refermables avec fermeture éclair\n" +
                "Largeur de dos: 45 cm en taille M\n" +
                "Taille du mannequin: Notre mannequin mesure 187 cm et porte une taille M\n" +
                "Longueur totale: 74 cm en taille M\n" +
                "Longueur des manches: 66 cm en taille M\n" +
                "Type de manche: manches longues\n" +
                "Composition: 100% polyester\n" +
                "Référence: AD122H02E-M11"));

        categorie3.add(new Product("Veste imperméable - khaki", 800, "Pier One\n" +
                "Veste imperméable - khaki", R.drawable.veste_impermable___khaki, Consumer.MAN, "Longueur: jusqu'aux cuisses\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Capuche: capuche avec cordon de serrage\n" +
                "Poches: poches à rabat, poches intérieures\n" +
                "Largeur de dos: 37 cm en taille M\n" +
                "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille M\n" +
                "Motif / Couleur: couleur unie\n" +
                "Longueur totale: 74 cm en taille M\n" +
                "Col: capuche\n" +
                "Longueur des manches: 66 cm en taille M\n" +
                "Type de manche: manches longues\n" +
                "Propriétés: imperméable\n" +
                "Composition: 58% polyester, 31% coton, 11% polyamide\n" +
                "Conseils d'entretien: lavage à la main, nettoyage chimique possible\n" +
                "Temps: pluie\n" +
                "Référence: PI922HA06-N11"));


        categorie3.add(new Product("Veste par FT", 800, "River Island - Veste bleu marine avec bords colorés", R.drawable.jackete1, Consumer.KID, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant noFTalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le KIDnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));


        categorie3.add(new Product("Veste RC ", 2500, "Veste par Adidas Originals, coupe classique taillant noFTalement ", R.drawable.jackete2, Consumer.KID, "-Jersey doux au toucher\n" +
                "-Ras du cou\n" +
                "-Bandes emblématiques sur la KIDche\n" +
                "-Impression du logo\n" +
                "-Ourlet asymétrique plongeant au dos\n" +
                "-Coupe classique taillant noFTalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")\n" +
                "-Code fournisseur : B10654"));


        categorie3.add(new Product("Veste SNO", 900, "Abercrombie & SNO - Essential - Veste moulant cintré KIDches courtes à col boutonné", R.drawable.jackete3, Consumer.KID, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le KIDnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie3.add(new Product("Veste mi-saison - marine", 900, "Absorba\n" +
                "Veste mi-saison - marine", R.drawable.veste_mi_saison___marine, Consumer.KID, "Longueur: normale\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Matériau de rembourrage: 100% polyester\n" +
                "Doublure: 100% coton\n" +
                "Capuche: capuche fourrée\n" +
                "Largeur de dos: 24 cm en taille 80\n" +
                "Épaisseur de la doublure: doublure légère\n" +
                "Longueur totale: 34 cm en taille 80\n" +
                "Col: capuche\n" +
                "Longueur des manches: 26 cm en taille 80\n" +
                "Type de manche: manches longues\n" +
                "Composition: 100% polyester\n" +
                "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                "Référence: AB324K01T-K11"));

        categorie3.add(new Product("Gilet - dark blue", 900, "Chicco\n" +
                "Gilet - dark blue", R.drawable.gilet___dark_blue, Consumer.KID, "Longueur: normale\n" +
                "Coupe: normale\n" +
                "Fermeture: boutons\n" +
                "Motif / Couleur: imprimé\n" +
                "Longueur totale: 34 cm en taille 86\n" +
                "Col: capuche\n" +
                "Longueur des manches: 30 cm en taille 86\n" +
                "Type de manche: manches longues\n" +
                "Composition: 100% coton\n" +
                "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge\n" +
                "Référence: CI024K003-K11"));
        // categorie3.add(new Product("VestO", 900, "Abercrombiutonné", R.drawable.jackete3, Consumer.KID,"Jer"));
        //   categorie3.add(new Product("VestO", 900, "Abercrombiutonné", R.drawable.jackete3, Consumer.KID,"Jer"));


        categorie3.add(new Product("Veste Ram", 900, "Abercrombie & Ram - Essential - Veste moulant cintré WOMANches courtes à col boutonné", R.drawable.jacketf1, Consumer.WOMAN, "-Jersey doux au toucher \n" +
                "-Encolure ronde \n" +
                "-Patte de boutonnage \n" +
                "-Logo brodé \n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester \n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie3.add(new Product("Veste par RI", 800, "River Island - Veste bleu marine avec bords colorés", R.drawable.jacketf2, Consumer.WOMAN, "-Article fabriqué en maille douce\n" +
                "-Modèle léger \n" +
                "-Rayures contrastées\n" +
                "-Ras du cou\n" +
                "-Coupe classique taillant normalement\n" +
                "-Lavage en machine\n" +
                "-100% coton\n" +
                "-Le WOMANnequin mesure 185,5 cm (6'1\") et porte l'article en taille M."));

        categorie3.add(new Product("Veste AF", 1950, "Abercrombie & Ram - Essential - Veste cintré moulant à WOMANches courtes et col tunisien", R.drawable.jacketf3, Consumer.WOMAN, "-Jersey de coton majoritaire\n" +
                "-Patte de boutonnage\n" +
                "-Logo brodé\n" +
                "-Coupe cintrée près du corps.\n" +
                "-Lavage en machine\n" +
                "-60% coton, 40% polyester\n" +
                "-Le WOMANnequin porte l'article en taille Medium et mesure 188 cm (6'2\")"));

        categorie3.add(new Product("ONLAVA - Veste en similicuir", 900, "ONLY\n" +
                "ONLAVA - Veste en similicuir - black", R.drawable.onlava___veste_en_similicuir___black, Consumer.WOMAN, "Longueur: normale\n" +
                "Coupe: cintrée\n" +
                "Fermeture: fermeture éclair\n" +
                "Doublure: 100% polyester\n" +
                "Poches: poches refermables avec fermeture éclair\n" +
                "Matière: cuir synthétique\n" +
                "Largeur de dos: 37 cm en taille 36\n" +
                "Taille du mannequin: Notre mannequin mesure 180 cm et porte une taille 36\n" +
                "Motif / Couleur: couleur unie\n" +
                "Longueur totale: 58 cm en taille 36\n" +
                "Col: col revers\n" +
                "Longueur des manches: 63 cm en taille 36\n" +
                "Type de manche: manches longues\n" +
                "Composition: 50% viscose, 50% polyuréthane\n" +
                "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C, possibilité de rétrécissement limitée à 5%\n" +
                "Référence: ON321G0AK-Q11"));

        categorie3.add(new Product("ONLAVA - Veste en similicuir", 900, "ONLY\n" +
                "ONLAVA - Veste en similicuir - falcon", R.drawable.onlava___veste_en_similicuir___falcon, Consumer.WOMAN, "Longueur: moyenne\n" +
                "Coupe: normale\n" +
                "Fermeture: fermeture éclair\n" +
                "Doublure: 100% polyester\n" +
                "Poches: poches refermables avec fermeture éclair\n" +
                "Matière: cuir synthétique\n" +
                "Largeur de dos: 37 cm en taille 36\n" +
                "Taille du mannequin: Notre mannequin mesure 178 cm et porte une taille 36\n" +
                "Motif / Couleur: couleur unie\n" +
                "Longueur totale: 57 cm en taille 36\n" +
                "Col: col revers\n" +
                "Longueur des manches: 64 cm en taille 36\n" +
                "Type de manche: manches longues\n" +
                "Composition: 50% viscose, 50% polyuréthane\n" +
                "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C, possibilité de rétrécissement limitée à 5%\n" +
                "Référence: ON321G0AK-B11"));

        //Categorie4
        categorie4.add(new Product("Jean droit - blue", 1400, "CHAD - Jean droit - blue", R.drawable.chad___jean_droit___blue, Consumer.MAN,
                "Longueur: longue\n" +
                        "Coupe: droite\n" +
                        "Longueur intérieure de jambe: 86 cm en taille 31\n" +
                        "Matière: denim\n" +
                        "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille 31\n" +
                        "Longueur extérieure de jambe: 112 cm en taille 31\n" +
                        "Fermeture: braguette à boutons\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Taille: normale\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: lavage en machine à 30°C\n" +
                        "Référence: 7F122G01Y-K11"));
        categorie4.add(new Product("501 ORIGINAL FIT", 1500, "501 ORIGINAL FIT - Jean droit - nero", R.drawable._501_original_fit___jean_droit___nero, Consumer.MAN, "Contient des parties non textiles d’origine animale\n" +
                "Longueur: normale\n" +
                "Coupe: droite\n" +
                "Longueur intérieure de jambe: 80 cm en taille 32x32\n" +
                "Matière: denim\n" +
                "Taille du mannequin: Notre mannequin mesure 186 cm et porte une taille 32x32\n" +
                "Longueur extérieure de jambe: 106 cm en taille 32x32\n" +
                "Fermeture: braguette à boutons\n" +
                "Poches: poches arrière, poches latérales\n" +
                "Motif / Couleur: couleur unie\n" +
                "Taille: normale\n" +
                "Composition: 100% coton\n" +
                "Conseils d'entretien: lavage en machine à 40°C\n" +
                "Référence: LE222B007-K11"));
        categorie4.add(new Product("514 SLIM STRAIGHT", 1350, "514 SLIM STRAIGHT - Jean droit - sunset copper", R.drawable._514_slim_straight___jean_droit___sunset_copper,
                Consumer.MAN, "Contient des parties non textiles d’origine animale\n" +
                "Longueur: longue\n" +
                "Coupe: droite\n" +
                "Longueur intérieure de jambe: 84 cm en taille 32x32\n" +
                "Matière: denim\n" +
                "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille 32x32\n" +
                "Longueur extérieure de jambe: 109 cm en taille 32x32\n" +
                "Fermeture: braguette à fermeture éclair cachée\n" +
                "Poches: poches arrière, poches latérales\n" +
                "Taille: normale\n" +
                "Composition: 94% coton, 4% polyester, 2% elasthanne\n" +
                "Conseils d'entretien: lavage en machine à 30°C\n" +
                "Référence: LE222G03L-K14"));
        categorie4.add(new Product("501 LEVIS ORIGINAL FIT", 800, "501 LEVIS ORIGINAL FIT - Jean droit - state",
                R.drawable._501_levis_original_fit___jean_droit___state, Consumer.MAN, "Contient des parties non textiles d’origine animale\n" +
                "Longueur: longue\n" +
                "Coupe: droite\n" +
                "Longueur intérieure de jambe: 80 cm en taille 32x32\n" +
                " Matière: denim\n" +
                "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille 32x32\n" +
                "Longueur extérieure de jambe: 105 cm en taille 32x32\n" +
                "Fermeture: braguette à boutons\n" +
                "Poches: poches arrière, poches latérales\n" +
                "Motif / Couleur: couleur unie\n" +
                "Taille: normale\n" +
                "Composition: 100% coton\n" +
                "Conseils d'entretien: lavage en machine à 30°C\n" +
                "Référence: LE222G03S-K16"));
        categorie4.add(new Product("501 LEVIS ORIGINAL FIT", 900, "501 LEVIS ORIGINAL FIT - Jean droit - spring light", R.drawable._501_levis_original_fit___jean_droit___spring_light,
                Consumer.MAN, "Longueur: longue\n" +
                "Coupe: droite\n" +
                "Longueur intérieure de jambe: 80 cm en taille 32x32\n" +
                "Matière: denim\n" +
                "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille 32x32\n" +
                "Longueur extérieure de jambe: 103 cm en taille 32x32\n" +
                "Fermeture: braguette à boutons\n" +
                "Poches: poches arrière, poches latérales\n" +
                "Motif / Couleur: couleur unie\n" +
                "Taille: normale\n" +
                "Composition: 100% coton\n" +
                "Conseils d'entretien: lavage en machine à 30°C\n" +
                "Référence: LE222G03S-K15"));


        categorie4.add(new Product("Jean slim - medium vintage blue", 1400, "Mango\n" +
                "JOSEPH - Jean slim - medium vintage blue", R.drawable.joseph___jean_slim___medium_vintage, Consumer.KID,
                "Longueur: longue\n" +
                        "Coupe: Skinny\n" +
                        "Matière: denim\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Taille: normale\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                        "Référence: M9124A00M-K12"));
        categorie4.add(new Product("Pantalon de survêtement - nickele", 1500, "3 Pommes\n" +
                "Pantalon de survêtement - nickele", R.drawable.pantalon_de_survtement___nickele, Consumer.KID,
                "Longueur: longue\n" +
                        "Coupe: normale\n" +
                        "Longueur intérieure de jambe: 23 cm en taille 74\n" +
                        "Matière: sweat\n" +
                        "Longueur extérieure de jambe: 41 cm en taille 74\n" +
                        "Poches: poches latérales\n" +
                        "Motif / Couleur: chiné\n" +
                        "Informations additionnelles: ceinture élastique\n" +
                        "Taille: normale\n" +
                        "Composition: 65% coton, 35% polyester\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                        "Référence: PO924B00B-C11"));
        categorie4.add(new Product("JOSEPH - Jean slim - bleach blue", 1350, "Mango\n" +
                "JOSEPH - Jean slim - bleach blue", R.drawable.joseph___jean_slim___bleach_blue, Consumer.KID,
                "Longueur: longue\n" +
                        "Coupe: Skinny\n" +
                        "Matière: denim\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Taille: normale\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                        "Référence: M9124A00M-K11"));
        categorie4.add(new Product("JIM - Jean slim - ink blue", 800, "Mango\n" +
                "JIM - Jean slim - ink blue", R.drawable.jim___jean_slim___ink_blue, Consumer.KID,
                "Détails déchirés\n" +
                        "Longueur: longue\n" +
                        "Coupe: Slim\n" +
                        "Matière: denim\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Taille: normale\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                        "Référence: M9124A00Q-K11"));
        categorie4.add(new Product("BARNAM - Pantalon classique - white", 900, "Mango\n" +
                "BARNAM - Pantalon classique - white", R.drawable.barnam___pantalon_classique___white, Consumer.KID,
                "Longueur: socquettes\n" +
                        "Coupe: Slim\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Taille: normale\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: lavage à la main\n" +
                        "Référence: M9124B00I-A11"));
        // categorie4.add(new Product("pantalon6", 670, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
        // categorie4.add(new Product("pantalon7", 392, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
        //  categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
        //  categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
        //  categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));

        categorie4.add(new Product("LINE 8 THE REVOLVER", 1400, "Levi's\n" +
                "LINE 8 THE REVOLVER - Jean slim - l8 dark indigo", R.drawable.line_8_the_revolver___jean_slim___l8, Consumer.WOMAN,
                "Contient des parties non textiles d’origine animale\n" +
                        "Longueur: longue\n" +
                        "Coupe: Skinny\n" +
                        "Longueur intérieure de jambe: 74 cm en taille 27x32\n" +
                        "Matière: denim\n" +
                        "Taille du mannequin: Notre mannequin mesure 175 cm et porte une taille 27x32\n" +
                        "Longueur extérieure de jambe: 94 cm en taille 27x32\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Taille: normale\n" +
                        "Composition: 70% coton, 28% polyester, 2% elasthanne\n" +
                        "Référence: LE221N01G-K11"));
        categorie4.add(new Product("VENUS - Jean droit - d60", 1500, "Pepe Jeans\n" +
                "VENUS - Jean droit - d60", R.drawable.venus___jean_droit___d60, Consumer.WOMAN,
                "Contient des parties non textiles d’origine animale\n" +
                        "Longueur: longue\n" +
                        "Coupe: droite\n" +
                        "Longueur intérieure de jambe: 75 cm en taille 27x34\n" +
                        "Matière: denim\n" +
                        "Taille du mannequin: Notre mannequin mesure 180 cm et porte une taille 27x34\n" +
                        "Longueur extérieure de jambe: 95 cm en taille 27x34\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Taille: basse\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: lavage en machine à 40°C\n" +
                        "Référence: PE121N028-K17"));
        categorie4.add(new Product("ONLCORAL - Jeans Skinny", 1350, "ONLY\n" +
                "ONLCORAL - Jeans Skinny - dark blue denim", R.drawable.onlcoral___jeans_skinny___dark_blue, Consumer.WOMAN,
                "Contient des parties non textiles d’origine animale\n" +
                        "Longueur: longue\n" +
                        "Coupe: Skinny\n" +
                        "Longueur intérieure de jambe: 84 cm en taille 27x34\n" +
                        "Matière: denim\n" +
                        "Taille du mannequin: Notre mannequin mesure 180 cm et porte une taille 27x34\n" +
                        "Longueur extérieure de jambe: 96 cm en taille 27x34\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Taille: basse\n" +
                        "Composition: 98% coton, 2% elasthanne\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge, possibilité de rétrécissement limitée à 5%\n" +
                        "Référence: ON321N07M-K11"));
        categorie4.add(new Product("715 BOOTCUT - Jean bootcut", 800, "Levi's\n" +
                "715 BOOTCUT - Jean bootcut - daytrip", R.drawable._715_bootcut___jean_bootcut___daytrip, Consumer.WOMAN,
                "Contient des parties non textiles d’origine animale\n" +
                        "Longueur: longue\n" +
                        "Coupe: Bootcut\n" +
                        "Longueur intérieure de jambe: 81 cm en taille 27x32\n" +
                        "Matière: denim\n" +
                        "Taille du mannequin: Notre mannequin mesure 175 cm et porte une taille 27x32\n" +
                        "Longueur extérieure de jambe: 105 cm en taille 27x32\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière, poches latérales\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Taille: normale\n" +
                        "Composition: 87% coton, 12% polyester, 1% elasthanne\n" +
                        "Conseils d'entretien: lavage en machine à 30°C\n" +
                        "Référence: LE221N01D-K14"));
        categorie4.add(new Product("AMY - Jeans Skinny", 900, "2ndOne\n" +
                "AMY - Jeans Skinny - starless", R.drawable.amy___jeans_skinny___starless, Consumer.WOMAN,
                "Contient des parties non textiles d’origine animale\n" +
                        "Longueur: longue\n" +
                        "Coupe: Skinny\n" +
                        "Longueur intérieure de jambe: 82 cm en taille 27\n" +
                        "Matière: denim\n" +
                        "Taille du mannequin: Notre mannequin mesure 181 cm et porte une taille 27\n" +
                        "Longueur extérieure de jambe: 107 cm en taille 27\n" +
                        "Fermeture: braguette à fermeture éclair cachée\n" +
                        "Poches: poches arrière\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Taille: haute\n" +
                        "Composition: 66% coton, 20% polyester, 11% viscose, 3% elasthanne\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C\n" +
                        "Référence: ON721N010-K11"));

        //Categorie5
        categorie5.add(new Product("ORIGINAL SLIM FIT", 1400, "ORIGINAL SLIM FIT - Chemise classique - white", R.drawable.original_slim_fit___chemise_classique___white,
                Consumer.MAN,
                "Longueur: normale\n" +
                        "Coupe: Slim\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 44 cm en taille M\n" +
                        "Taille du mannequin: Notre mannequin mesure 188 cm et porte une taille M\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Longueur totale: 77 cm en taille M\n" +
                        "Col: col Kent\n" +
                        "Transparence: légère\n" +
                        "Longueur des manches: 67 cm en taille M\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 97% coton, 3% elasthanne\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C, lavage textiles délicats\n" +
                        "Référence: HI122D08S-A11"));
        categorie5.add(new Product("Chemise - dark blue/red", 1500, "Pier One\n" +
                "Chemise - dark blue/red", R.drawable.pier_one_chemise_dark_blue_red, Consumer.MAN,
                "Longueur: normale\n" +
                        "Coupe: Slim\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 41 cm en taille M\n" +
                        "Taille du mannequin: Notre mannequin mesure 188 cm et porte une taille M\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Longueur totale: 70 cm en taille M\n" +
                        "Col: col Kent\n" +
                        "Longueur des manches: 69 cm en taille M\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge\n" +
                        "Référence: PI922D02W-K12"));
        categorie5.add(new Product("JJVSEAN SLIM FIT", 1350, "Jack & Jones\n" +
                "JJVSEAN SLIM FIT - Chemise - medium blue denim", R.drawable.jjvsean_slim_fit___chemise___medium_blue_denim, Consumer.MAN,
                "Longueur: normale\n" +
                        "Coupe: Slim\n" +
                        "Fermeture: boutons\n" +
                        "Matière: denim\n" +
                        "Largeur de dos: 43 cm en taille M\n" +
                        "Taille du mannequin: Notre mannequin mesure 185 cm et porte une taille M\n" +
                        "Longueur totale: 76 cm en taille M\n" +
                        "Col: col Kent\n" +
                        "Longueur des manches: 66 cm en taille M\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge, possibilité de rétrécissement limitée à 5%\n" +
                        "Référence: JA222D11M-K11"));
        categorie5.add(new Product("SHONEOAK SLIM FIT", 800, "Selected Homme\n" +
                "SHONEOAK SLIM FIT - Chemise - vintage indigo", R.drawable.shoneoak_slim_fit___chemise___vintage, Consumer.MAN,
                "Longueur: normale\n" +
                        "Coupe: Slim\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 446 cm en taille M\n" +
                        "Taille du mannequin: Notre mannequin mesure 187 cm et porte une taille M\n" +
                        "Motif / Couleur: carreaux\n" +
                        "Longueur totale: 75 cm en taille M\n" +
                        "Col: col à boutons\n" +
                        "Longueur des manches: 64 cm en taille M\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge, possibilité de rétrécissement limitée à 5%\n" +
                        "Référence: SE622D0GE-K16"));
        categorie5.add(new Product("Chemise - cosmos blue", 900, "TOM TAILOR DENIM\n" +
                "Chemise - cosmos blue", R.drawable.chemise___cosmos_blue, Consumer.MAN,
                "Longueur: normale\n" +
                        "Coupe: Slim\n" +
                        "Largeur de dos: 46 cm en taille M\n" +
                        "Taille du mannequin: Notre mannequin mesure 189 cm et porte une taille M\n" +
                        "Motif / Couleur: carreaux\n" +
                        "Longueur totale: 75 cm en taille M\n" +
                        "Col: col Kent\n" +
                        "Longueur des manches: 67 cm en taille M\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge\n" +
                        "Référence: TO722D0BG-K11"));

        categorie5.add(new Product("light stone wash", 1400, "Noppies \n" +
                "BOB - Chemise - light stone wash", R.drawable.bob___chemise___light_stone_wash, Consumer.KID,
                "Détails du produit\n" +
                        "\n" +
                        "Manches à retrousser\n" +
                        "Boutons-pressions\n" +
                        "Poches poitrine appliquées\n" +
                        "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Matière: denim\n" +
                        "Col: col à boutons\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C\n" +
                        "Référence: N1424I015-K11"));
        categorie5.add(new Product("DAVE - Chemise - bleach blue", 1500, "Mango\n" +
                "DAVE - Chemise - bleach blue", R.drawable.dave___chemise___bleach_blue, Consumer.KID,
                "Bas de manches boutonnés\n" +
                        "Poches: deux poches poitrine à rabat boutonné\n" +
                        "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Matière: denim\n" +
                        "Col: col Kent\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 30°C\n" +
                        "Référence: M9124I00N-K12"));
        categorie5.add(new Product("PALMERA - Chemise - dark blue", 1350, "Mango\n" +
                "PALMERA - Chemise - dark blue", R.drawable.palmera___chemise___dark_blue, Consumer.KID,
                "Manches à retrousser sous patte\n" +
                        "Poches: poche poitrine appliquée à bouton\n" +
                        "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Matière: denim\n" +
                        "Motif / Couleur: floral\n" +
                        "Col: col évasé\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 30°C\n" +
                        "Référence: M9124I00O-K11"));
        categorie5.add(new Product("RAYAS - Chemise - white", 800, "Mango\n" +
                "RAYAS - Chemise - white", R.drawable.rayas___chemise___white, Consumer.KID,
                "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Motif / Couleur: rayures\n" +
                        "Col: col officier\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 30°C\n" +
                        "Référence: M9124I00S-A11"));
        categorie5.add(new Product("RAY - Chemise - sky blue", 900, "UMango\n" +
                "RAY - Chemise - sky blue", R.drawable.ray___chemise___sky_blue, Consumer.KID,
                "Poche poitrine appliquée\n" +
                        "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Motif / Couleur: rayures\n" +
                        "Col: col Kent\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 30°C\n" +
                        "Référence: M9124I00R-K11"));


        categorie5.add(new Product("HARPER - Chemisier - blue", 1400, "Polo Ralph Lauren\n" +
                "HARPER - Chemisier - blue", R.drawable.harper___chemisier___blue, Consumer.WOMAN,
                "Longueur: normale\n" +
                        "Coupe: cintrée\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 46 cm\n" +
                        "Taille du mannequin: 180 cm\n" +
                        "Motif / Couleur: rayures\n" +
                        "Longueur totale: 70 cm en taille S\n" +
                        "Col: col à boutons\n" +
                        "Longueur des manches: 60 cm en taille S\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, nettoyage chimique possible\n" +
                        "Référence: PO221E002-K11"));
        categorie5.add(new Product("Chemisier - white", 1500, "120% Lino\n" +
                "Chemisier - white", R.drawable.chemisier___white, Consumer.WOMAN,
                "Contient des parties non textiles d’origine animale\n" +
                        "Longueur: normale\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 37 cm en taille 36\n" +
                        "Taille du mannequin: Notre mannequin mesure 180 cm et porte une taille 36\n" +
                        "Forme du col: col en V profond\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Longueur totale: 64 cm en taille 36\n" +
                        "Col: col chemisier\n" +
                        "Transparence: légère\n" +
                        "Informations additionnelles: pince de poitrine\n" +
                        "Longueur des manches: 58 cm en taille 36\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% lin\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge\n" +
                        "Référence: L1921E00P-A11"));
        categorie5.add(new Product("HARPER - Chemisier - medium blue", 1350, "Polo Ralph Lauren\n" +
                "HARPER - Chemisier - medium blue", R.drawable.harper___chemisier___medium_blue, Consumer.WOMAN,
                "Longueur: normale\n" +
                        "Coupe: cintrée\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 38 cm en taille 34\n" +
                        "Taille du mannequin: Notre mannequin mesure 179 cm et porte une taille 34\n" +
                        "Motif / Couleur: carreaux\n" +
                        "Longueur totale: 70 cm en taille 34\n" +
                        "Col: col à boutons\n" +
                        "Longueur des manches: 62 cm en taille 34\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: lavage en machine à 40°C\n" +
                        "Référence: PO221E00S-K11"));
        categorie5.add(new Product("ETRIXE - Chemisier", 800, "HUGO\n" +
                "ETRIXE - Chemisier - light pastel blue", R.drawable.etrixe___chemisier___light_pastel_blue, Consumer.WOMAN,
                "Longueur: normale\n" +
                        "Coupe: cintrée\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 38 cm en taille 36\n" +
                        "Taille du mannequin: Notre mannequin mesure 180 cm et porte une taille 36\n" +
                        "Motif / Couleur: rayures\n" +
                        "Longueur totale: 63 cm en taille 36\n" +
                        "Col: col chemisier\n" +
                        "Longueur des manches: 61 cm en taille 36\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 73% coton, 24% polyamide, 3% elasthanne\n" +
                        "Conseils d'entretien: lavage en machine à 40°C, ne pas mettre au sèche-linge\n" +
                        "Référence: HU721E02D-K12"));
        categorie5.add(new Product("NMCANA - Chemisier", 900, "Noisy May\n" +
                "NMCANA - Chemisier - snow white", R.drawable.nmcana___chemisier___snow_white, Consumer.WOMAN,
                "Longueur: longue\n" +
                        "Coupe: normale\n" +
                        "Fermeture: boutons\n" +
                        "Largeur de dos: 37 cm en taille 36\n" +
                        "Taille du mannequin: Notre mannequin mesure 175 cm et porte une taille 36\n" +
                        "Motif / Couleur: couleur unie\n" +
                        "Longueur totale: 78 cm en taille 36\n" +
                        "Col: col chemisier\n" +
                        "Transparence: légère\n" +
                        "Informations additionnelles: patte de boutonnage\n" +
                        "Longueur des manches: 63 cm en taille 36\n" +
                        "Type de manche: manches longues\n" +
                        "Composition: 100% coton\n" +
                        "Conseils d'entretien: ne pas mettre au sèche-linge, lavage en machine à 30°C, possibilité de rétrécissement limitée à 5%\n" +
                        "Référence: NM321E01P-A11"));


        //Adding categories to the categories list
        categoriesList.add(categorie1);
        categoriesList.add(categorie2);
        categoriesList.add(categorie3);
        categoriesList.add(categorie4);
        categoriesList.add(categorie5);
    }

    public ArrayList<Category> getCategoriesList() {
        return categoriesList;
    }
}
