package net.spring.mvc.coding.service;

import net.spring.mvc.coding.model.Customer;
import net.spring.mvc.coding.repository.CustomerRepository;
import net.spring.mvc.coding.service.directsql.SqlDirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerServiceRepo implements CustomerRepository<Customer> {
    private JdbcTemplate jdbcTemplate;
    private SqlDirect direct;

    public CustomerServiceRepo(DriverManagerDataSource dataSource) {
        /* CDI */
        jdbcTemplate = new JdbcTemplate(dataSource);
        direct = new SqlDirect();
    }
    @Override
    public HashMap<?,?> create(Customer object) {
        HashMap<String,Customer> newCustomer = new HashMap<>();
        int rows = jdbcTemplate.update(direct.getCREATE() , object.getFirstname() ,object.getAge() , object.getEmail(),object.getAddress());
        if(rows > 0) {
            newCustomer.put("create was done",object);
        }
        else {
            newCustomer.put("create was failed",new Customer());
        }
        return newCustomer;
    }

    @Override
    public HashMap<?, ?> edite(Customer object) {
        HashMap<String,Customer> newCustomer = new HashMap<>();
        int rows = jdbcTemplate.update(direct.getUPDATE(), object.getFirstname() ,object.getAge() , object.getEmail(),object.getAddress() ,object.getId());
        if(rows > 0) {
            newCustomer.put("update was done",object);
        }
        else {
            newCustomer.put("update was failed",new Customer());
        }
        return newCustomer;
    }

    @Override
    public List<Customer> views() {
        List<Customer> customerList = jdbcTemplate.query(direct.getREADS(), (rs , rows) -> {
            /* reduce code  mapper */
            Customer customerSet  =  new Customer();
            customerSet.setId(rs.getLong("id"));
            customerSet.setFirstname(rs.getString("firstname"));
            customerSet.setAge(rs.getShort("age"));
            customerSet.setEmail(rs.getString("email"));
            customerSet.setAddress(rs.getString("Address"));
            return customerSet;
        });
        if (customerList != null) {
            return customerList;
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public Customer view(Long id) {
        Object []arg = {id};
        Customer customer = jdbcTemplate.queryForObject(direct.getREAD(),arg,(rs,rows) -> {
            Customer customerSet  =  new Customer();
            customerSet.setId(rs.getLong("id"));
            customerSet.setFirstname(rs.getString("firstname"));
            customerSet.setAge(rs.getShort("age"));
            customerSet.setEmail(rs.getString("email"));
            customerSet.setAddress(rs.getString("Address"));
            return customerSet;
        });
        if (customer != null) {
            return customer;
        }
        else {
            return new Customer();
        }
    }

    @Override
    public HashMap<?, ?> delete(Long id) {
        HashMap<String,Long> newCustomer = new HashMap<>();
        int rows = jdbcTemplate.update(direct.getDELETE(),id);
        if(rows > 0) {
            newCustomer.put("delete was done",id);
        }
        else {
            newCustomer.put("delete was failed",null);
        }
        return newCustomer;
    }
}
