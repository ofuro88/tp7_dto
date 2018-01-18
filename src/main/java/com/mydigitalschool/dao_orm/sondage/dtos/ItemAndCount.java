package com.mydigitalschool.dao_orm.sondage.dtos;

public class ItemAndCount {
	Integer nbItem;
	Integer itemId;

	public ItemAndCount(Integer nbItem, Integer itemId) {
		this.nbItem = nbItem;
		this.itemId = itemId;
	}
	public ItemAndCount() {	}

	public int getNbItem() {
		return nbItem;
	}
	public void setNbItem(int nbItem) {
		this.nbItem = nbItem;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
