package ir.omidashouri.springbatchone.item;

import ir.omidashouri.springbatchone.entity.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderRowMapper implements RowMapper<OrderItem> {


    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(rs.getLong("order_id"));
        orderItem.setFirstName(rs.getString("first_name"));
        orderItem.setLastName(rs.getString("last_name"));
        orderItem.setEmail(rs.getString("email"));
        orderItem.setCost(rs.getFloat("cost"));
        orderItem.setItemId(rs.getString("item_id"));
        orderItem.setItemName(rs.getString("item_name"));
        orderItem.setShipDate(rs.getDate("ship_date"));
        return orderItem;
    }
}
