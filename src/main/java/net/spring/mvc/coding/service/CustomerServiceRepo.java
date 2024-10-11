package net.spring.mvc.coding.service;

import net.spring.mvc.coding.model.Contact;
import net.spring.mvc.coding.repository.CustomerRepository;
import net.spring.mvc.coding.service.directsql.SqlDirect;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerServiceRepo implements CustomerRepository<Contact> {

    private JdbcTemplate jdbcTemplate;
    private SqlDirect direct;

    public CustomerServiceRepo(DriverManagerDataSource dataSource) {
        /* CDI */
        jdbcTemplate = new JdbcTemplate(dataSource);
        direct = new SqlDirect();
    }
    @Override
    public HashMap<?,?> create(Contact object) {
        HashMap<String, Contact> newCustomer = new HashMap<>();
        int rows = jdbcTemplate.update(direct.getCREATE() , object.getFirstname() ,object.getAge() , object.getEmail(),object.getAddress());
        if(rows > 0) {
            newCustomer.put("create was done",object);
        }
        else {
            newCustomer.put("create was failed",new Contact());
        }
        return newCustomer;
    }

    @Override
    public HashMap<?, ?> edite(Contact object) {
        HashMap<String, Contact> newCustomer = new HashMap<>();
        int rows = jdbcTemplate.update(direct.getUPDATE(), object.getFirstname() ,object.getAge() , object.getEmail(),object.getAddress() ,object.getId());
        if(rows > 0) {
            newCustomer.put("update was done",object);
        }
        else {
            newCustomer.put("update was failed",new Contact());
        }
        return newCustomer;
    }

    @Override
    public List<Contact> views() {
        List<Contact> contactList = jdbcTemplate.query(direct.getREADS(), (rs , rows) -> {
            /* reduce code  mapper */
            Contact contactSet =  new Contact();
            contactSet.setId(rs.getLong("id"));
            contactSet.setFirstname(rs.getString("firstname"));
            contactSet.setAge(rs.getShort("age"));
            contactSet.setEmail(rs.getString("email"));
            contactSet.setAddress(rs.getString("Address"));
            return contactSet;
        });

        if (contactList != null) {
            return contactList;
        }
        return null;
    }

    @Override
    public Contact view(Long id) {
        Object []arg = {id};
        Contact contact = jdbcTemplate.queryForObject(direct.getREAD(),arg,(rs, rows) -> {
            Contact contactSet =  new Contact();
            contactSet.setId(rs.getLong("id"));
            contactSet.setFirstname(rs.getString("firstname"));
            contactSet.setAge(rs.getShort("age"));
            contactSet.setEmail(rs.getString("email"));
            contactSet.setAddress(rs.getString("Address"));
            return contactSet;
        });
        if (contact != null) {
            return contact;
        }
        else {
            return new Contact();
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
