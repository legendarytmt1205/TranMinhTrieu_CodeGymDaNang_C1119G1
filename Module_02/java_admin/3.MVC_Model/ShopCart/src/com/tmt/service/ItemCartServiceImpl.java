package com.tmt.service;
import com.tmt.model.ItemCart;
import java.util.List;

public class ItemCartServiceImpl implements ItemCartService {
    private static List<ItemCart> itemCartList;
    @Override
    public List<ItemCart> findAll() {
        return itemCartList;
    }
}
