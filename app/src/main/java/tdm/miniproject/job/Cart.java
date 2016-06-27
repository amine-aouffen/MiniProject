package tdm.miniproject.job;


import java.io.Serializable;
import java.util.ArrayList;


import tdm.miniproject.support.CartElement;

public class Cart implements Serializable{
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
            if(cartElementTmp.getProduct().getName().equals(cartElement.getProduct().getName())
                    &&cartElementTmp.getProduct().getConsumer().equals(cartElement.getProduct().getConsumer())
                    &&cartElementTmp.getSize().equals(cartElement.getSize())){
                found=true;
            }
            else{
                i--;
            }
        }
        if(found){
            return elementsList.get(i).getQuantity();
        }
        else{
            elementsList.add(cartElement);
            return cartElement.getQuantity();
        }
    }

    public void removeCartElement(int position){
        elementsList.remove(position);
    }

    public void removeCartElement(String productName,String size){
        boolean found = false;
        int i = elementsList.size();
        while(i>0 && !found){
            i--;
            if (elementsList.get(i).getProduct().getName().equals(productName)
                    &&elementsList.get(i).getSize().equals(size)){
                found=true;
                elementsList.remove(i);
            }
        }
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

    public double getTotalCost(){
        double total=0;
        for(int i=0;i<elementsList.size();i++){
            total+=elementsList.get(i).getProduct().getPrice()*elementsList.get(i).getQuantity();
        }
        return total;
    }
}

