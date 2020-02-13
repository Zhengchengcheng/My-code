package com.itbaizhan.state;

import com.itbaizhan.orm.TorderItem;

import java.util.Map;

/**
 * @Author: lcp
 * @Date: 2019/12/2 15:18
 */
public class UpdateCart extends AbstractState {
    @Override
    public void operCart(String  oper, Map<String, TorderItem> map, String goodsId, TorderItem _orderitem) {
        map.put(goodsId, _orderitem);//数量增加
    }
}
