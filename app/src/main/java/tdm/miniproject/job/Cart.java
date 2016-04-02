package tdm.miniproject.job;


import java.util.ArrayList;


import tdm.miniproject.support.CartElement;

public class Cart{
    private ArrayList<CartElement> elementsList;

    public Cart() {
        this.elementsList = new ArrayList<CartElement>();
    }

    public int add(CartElement cartElement){
        //If the element exists already, the quantity will be incremented with +1
        //Else, a new element will be added to the cart
        boolean found =false;
        int i=elementsList.size()-1;
        CartElement cartElementTmp;
        while(!found && i>-1 ){
            cartElementTmp = elementsList.get(i);
            if(cartElementTmp.getProduct().getName().equals(cartElement.getProduct().getName())){
                found=true;
            }
            else{
                i--;
            }
        }
        if(found){
            elementsList.get(i).incQunatity();
            return elementsList.get(i).getQuantity();
        }
        else{
            elementsList.add(cartElement);
            return 1;
        }
    }

    public void removeCartElement(int position){
        elementsList.remove(position);
    }

    public CartElement getCartElement(int position){
        return elementsList.get(position);
    }

    public ArrayList<CartElement> getElementsList() {
        return elementsList;
    }

    public void setElementsList(ArrayList<CartElement> elementsList) {
        this.elementsList = elementsList;
    }

    public float getTotalCost(){
        float total=0;
        for(int i=0;i<elementsList.size();i++){
            total+=elementsList.get(i).getProduct().getPrice();
        }
        return total;
    }
}

