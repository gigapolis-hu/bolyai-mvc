package hu.bolyaitechnikum.bolyaimvc.persistence.repository;

import hu.bolyaitechnikum.bolyaimvc.persistence.model.Message;
import org.springframework.data.repository.CrudRepository;

// Spring Data JPA automatikusan generál egy implementációt
// Lekérdezésekért felel (select, insert, update, delete)
// Spring Data JPA + Hibernate: ORM keretrendszerek (Spring Data JPA automatizálja a Hibernatetet.)
// ORM: Object Relational Mapping: Java Objektum (RAM) <-> Rekord (DB)
public interface MessageRepository extends CrudRepository<Message, Long> {


}
