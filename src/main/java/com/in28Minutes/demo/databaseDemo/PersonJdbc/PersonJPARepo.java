package com.in28Minutes.demo.databaseDemo.PersonJdbc;

import com.in28Minutes.demo.databaseDemo.entity.PersonForJDBC;
import com.in28Minutes.demo.databaseDemo.entity.PersonForJPA;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class PersonJPARepo {
    @Autowired
    EntityManager entityManager;
//    class PersonMapper implements RowMapper<PersonForJDBC>{
//
//        @Override
//        public PersonForJDBC mapRow(ResultSet rs, int rowNum) throws SQLException {
//            PersonForJDBC personForJDBC = new PersonForJDBC();
//            personForJDBC.setId(rs.getInt("id"));
//            personForJDBC.setName(rs.getString("name"));
//            personForJDBC.setLocation(rs.getString("location"));
//            personForJDBC.setBirthDate(rs.getTimestamp("birth_date"));
//            return personForJDBC;
//        }
//    }
    //select * form person
//    public List<PersonForJPA> findAll(){
//        //we can use Spring Jdbc mapper --> new BeanPropertyRowMapper<>(Person.class)
////       return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
//        //or we can use an arbitrary Mapper that ourselves wrote that like PersonMapper()
//        return jdbcTemplate.query("select * from person", new PersonMapper());
//    }
    public PersonForJPA findById(int id){
//        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] {id},
//                new BeanPropertyRowMapper<>(PersonForJDBC.class));
        return entityManager.find(PersonForJPA.class, id);
    }
//    public int deleteById(int id){
//        return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
//    }
//
    public int insert(PersonForJPA personForJPA){
        //in Spring jdbc
//        return jdbcTemplate.update(
//                "INSERT INTO PERSON (id, name, location, birth_date) VALUES (?, ?, ?, ?)" ,
//                        new Object[] {personForJDBC.getId(), personForJDBC.getName(), personForJDBC.getLocation(),
//                        new Timestamp(personForJDBC.getBirthDate().getTime())});
        //in JPA Just one line of code!
        entityManager.merge(personForJPA);
        return 0;
    }

    public int update(PersonForJPA personForJPA){
        //in Spring jdbc
//        return jdbcTemplate.update(
//                "update person set name = ?, location = ?, birth_date = ? where id = ?" ,
//                new Object[] {personForJDBC.getName(), personForJDBC.getLocation(),
//                        new Timestamp(personForJDBC.getBirthDate().getTime()), personForJDBC.getId()});
        //in JPA Just one line of code!
        entityManager.merge(personForJPA);
        return 0;
    }

    public void deleteById(int id){
        var person = findById(id);
        entityManager.remove(person);
//        return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
    }

    public List<PersonForJPA> findAll(){
      return entityManager.createNamedQuery("all persons", PersonForJPA.class).getResultList();
    }
}
