package ir.omidashouri.springbatchone.item;

import ir.omidashouri.springbatchone.entity.OrderItem;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class OrderFieldSetMapper implements FieldSetMapper<OrderItem> {
    @Override
    public OrderItem mapFieldSet(FieldSet fieldSet) throws BindException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(fieldSet.readLong("order_id"));
        orderItem.setFirstName(fieldSet.readString("first_name"));
        orderItem.setLastName(fieldSet.readString("last_name"));
        orderItem.setEmail(fieldSet.readString("email"));
        orderItem.setCost(fieldSet.readFloat("cost"));
        orderItem.setItemId(fieldSet.readString("item_id"));
        orderItem.setItemName(fieldSet.readString("item_name"));
        orderItem.setShipDate(fieldSet.readDate("ship_date"));
        return orderItem;
    }
}


//10:34
