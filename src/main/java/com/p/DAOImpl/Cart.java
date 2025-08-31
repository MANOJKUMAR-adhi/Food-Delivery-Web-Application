package com.p.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import com.p.models.CartItem;

public class Cart { //Implementation class having add,update ,remove methods

	
	 private Map<Integer,CartItem> items;
	 
	 public Cart() {
		 this.items=new HashMap<>();
	 }

    public void addItem(CartItem item) {
    	
    	int itemId= item.getItemId();  // itemId from user
    	
    	if(items.containsKey(itemId)) {
    		
    		CartItem existingItem = items.get(itemId);
    		existingItem.setQuantity(existingItem.getQuantity()+ item.getQuantity());
    	}
    	else {
    		items.put(itemId, item);  //.put(key,value)
    	}	
    }

	public void updateItem(int itemId,int quantity) {
		
		
		if(items.containsKey(itemId)) {
			
			if(quantity <= 0) {
				items.remove(itemId); // when quantity becomes 0 it removes the item 
			}
			else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}
	
	
	public void removeitem(int itemId) {
		items.remove(itemId);
		
	}
	
	public Map<Integer,CartItem> getItems(){
		return items;
		
	}
	
	
	
	public void clear() {
		items.clear();
	}
	
}