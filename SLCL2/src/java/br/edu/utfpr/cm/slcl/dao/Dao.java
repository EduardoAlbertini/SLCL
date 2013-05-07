package br.com.dao;

import java.util.List;

public interface Dao<T> {
    
    public void persistir(T entidade);
    public void remover(T entidade);
    public T obterPorId(int id);
    public List<T> listar(String filtro);
    
}