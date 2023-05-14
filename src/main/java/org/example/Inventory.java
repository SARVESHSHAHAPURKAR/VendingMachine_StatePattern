package org.example;

public class Inventory {

    ItemShelf[] inventory = null;

    Inventory(int count){
        inventory = new ItemShelf[count];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    private void initialEmptyInventory() {
        int startCode=101;
        for(int i=0; i<inventory.length;i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            startCode++;
            space.setSoldOut(true); //because initially there is no item, so it is empty.. as good as soldout

            inventory[i] = space;
        }
    }

    public void addItem(Item item, int code) throws Exception {

        for(ItemShelf shelf : inventory){
            if(shelf.getCode()==code){
                if(shelf.isSoldOut()){
                    shelf.setItem(item);
                    shelf.setSoldOut(false);
                }
                else {
                    throw new Exception("already item is present, you can not add item here");
                }

            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {

        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {

                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }



}
