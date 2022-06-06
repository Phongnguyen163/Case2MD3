package service.impl;

import model.TempItem;

import java.util.List;

public class TempOrder {
    public void addToTemp (TempItem tempItem, List<TempItem> tempOrder) {
        boolean flag = false;
        if (tempOrder.size() == 0) {
            tempItem.setId(1);
            tempOrder.add(tempItem);
        } else {
            for (TempItem item : tempOrder) {
                if ((item.getProduct().getId() == tempItem.getProduct().getId())) {
                    item.setQuantity(item.getQuantity() + tempItem.getQuantity());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                tempItem.setId(tempOrder.size()+1);
                tempOrder.add(tempItem);
            }
        }
    }
}
