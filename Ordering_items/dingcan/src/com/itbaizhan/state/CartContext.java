package com.itbaizhan.state;

import com.itbaizhan.orm.TorderItem;

import java.util.Map;

/**
 * @Author: lcp
 * @Date: 2019/12/2 15:14
 */
public class CartContext {
    private AbstractState state;

    public CartContext(AbstractState state) {
        this.state = state;
    }

    public void setState(AbstractState state)
    {
        this.state=state;
    }
    public AbstractState getState()
    {
        return state;
    }
    public void operCart(String  oper, Map<String, TorderItem> map,String goodsId,TorderItem _orderitem
    )
    {
        state.operCart(oper,map,goodsId,_orderitem);
    }
}
