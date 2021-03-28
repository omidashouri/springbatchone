package ir.omidashouri.springbatchone.item;

import ir.omidashouri.springbatchone.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderRowMapper implements RowMapper<Order> {


    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getLong("order_id"));
        order.setFirstName(rs.getString("first_name"));
        order.setLastName(rs.getString("last_name"));
        order.setEmail(rs.getString("email"));
        order.setCost(rs.getFloat("cost"));
        order.setItemId(rs.getString("item_id"));
        order.setItemName(rs.getString("item_name"));
        order.setShipDate(rs.getDate("ship_date"));
        return order;
    }
}
