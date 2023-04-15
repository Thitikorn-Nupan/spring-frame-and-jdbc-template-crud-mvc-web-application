package net.spring.mvc.coding.repository;

import java.util.HashMap;
import java.util.List;

public interface CustomerRepository <T> {
    public HashMap<?,?> create(T object);
    public HashMap<?,?> edite(T object);
    public List<T> views();
    public T view(Long id);
    public HashMap<?,?> delete(Long id);
}
