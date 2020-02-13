package com.itbaizhan.state;

import com.itbaizhan.orm.TorderItem;

import java.util.Map;

/**
 * @Author: lcp
 * @Date: 2019/12/2 15:14
 */
public abstract class AbstractState {
    public abstract void operCart(String  oper, Map<String, TorderItem> map, String goodsId, TorderItem _orderitem);
}
