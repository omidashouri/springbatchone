package ir.omidashouri.springbatchone.item;

import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;


public class JdbcPagingQueryProvider {

    public PagingQueryProvider getPagingQueryProvider(DataSource dataSource) {

        PagingQueryProvider returnObject = null;
        try {
            SqlPagingQueryProviderFactoryBean factory = new SqlPagingQueryProviderFactoryBean();
            factory.setDataSource(dataSource);
            factory.setSelectClause(" SELECT order_id, first_name, last_name, email, cost, item_id, item_name, ship_date ");
            factory.setFromClause(" from SHIPPED_ORDER ");
            Map<String, Order> sortKeys = new LinkedHashMap<>();
            sortKeys.put("order_id", Order.ASCENDING);
            factory.setSortKeys(sortKeys);
            returnObject =  factory.getObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnObject;
    }
}
