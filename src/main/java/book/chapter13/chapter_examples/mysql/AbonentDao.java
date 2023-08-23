package book.chapter13.chapter_examples.mysql;

import book.chapter13.chapter_examples.mysql.entities.Abonent;

import java.util.List;
public interface AbonentDao extends BaseDao <Long, Abonent> {
    List<Abonent> findAbonentByLastname(String patternName) throws DaoException;
}